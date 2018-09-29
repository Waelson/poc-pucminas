package br.pucminas.servico.vendas.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.pucminas.servico.vendas.model.Cliente;
import br.pucminas.servico.vendas.model.Endereco;
import br.pucminas.servico.vendas.model.Fornecedor;
import br.pucminas.servico.vendas.model.ItemPedido;
import br.pucminas.servico.vendas.model.Pedido;
import br.pucminas.servico.vendas.model.Produto;
import br.pucminas.servico.vendas.model.SituacaoPedido;
import br.pucminas.servico.vendas.repository.ClienteRepository;
import br.pucminas.servico.vendas.repository.EnderecoRepository;
import br.pucminas.servico.vendas.repository.FornecedorRepository;
import br.pucminas.servico.vendas.repository.ItemPedidoRepository;
import br.pucminas.servico.vendas.repository.PedidoRepository;
import br.pucminas.servico.vendas.repository.ProdutoRepository;
import br.pucminas.servico.vendas.util.DateUtil;
import br.pucminas.servico.vendas.vo.ItemVo;
import br.pucminas.servico.vendas.vo.PedidoVo;

@Service
@Transactional
public class PedidoService {
	
	private static final Logger logger = Logger.getLogger(PedidoService.class.getName());
	
	private static final Long PAGAMENTO_REALIZADO = 1L;
	private static final Long AGUARDANDO_ENVIO_FORNECEDOR = 2L;
	private static final Long ERRO_ENVIO_PARA_FILA = 10L;

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${queue.envio.pedido.fornecedor}")
	private String filaEnvioPedidoFornecedor;
	
	/**
	 * Salva o pedido
	 * @param pedido Pedido
	 * @return Pedido
	 */
	public Pedido salvar(Pedido pedido) {
		logger.info("Validando pedido");
		validarPedido(pedido);
		
		logger.info("Calculado custos dos pedido");
		calcularValores(pedido);
	
		logger.info("Configurando situacao e data/hora");
		pedido.setSituacaoPedido(new SituacaoPedido(PAGAMENTO_REALIZADO));
		pedido.setDataHoraCriacao(new Date());
		
		logger.info("Salvando pedido");
		pedidoRepository.save(pedido);		
		logger.info("Pedido salvo com sucesso. #ID: " + pedido.getIdPedido());
		
		enviarMensagemParaFila(pedido);
		return pedido;
	}
	
	/**
	 * Calcula o custo total do pedido e de cada item
	 * @param pedido Pedido
	 */
	private void calcularValores(Pedido pedido) {
		double valorTotal = 0.0;
		for(ItemPedido ip : pedido.getItensPedido()) {
			valorTotal += (ip.getVlrUnitario() * ip.getQuantidade());
		}

		for(ItemPedido ip : pedido.getItensPedido()) {
			ip.setVlrTotal(ip.getVlrUnitario() * ip.getQuantidade());
			ip.setPedido(pedido);
		}	
		pedido.setVlrTotal(valorTotal);
	}
	
	/**
	 * Envia o pedido para a fila de processamento 
	 * @param pedido Pedido
	 */
	private void enviarMensagemParaFila(Pedido pedido) {
		try {
			logger.info("Enviando pedido para fila de processamento. #ID: " + pedido.getIdPedido());
			ObjectMapper mapper = new ObjectMapper();
			Collection<PedidoVo> pedidos = montarPedidos(pedido.getIdPedido());
			for(PedidoVo vo : pedidos) {				
				String json = mapper.writeValueAsString(vo);
				//jmsTemplate.convertAndSend(filaEnvioPedidoFornecedor, json);
				jmsTemplate.convertAndSend(filaEnvioPedidoFornecedor, json, m -> {
					m.setStringProperty("cnpj", vo.getCnpjFornecedor());
					return m;
				});
			}

			pedido.setSituacaoPedido(new SituacaoPedido(AGUARDANDO_ENVIO_FORNECEDOR));
			pedidoRepository.save(pedido);			

			logger.info("Pedido #ID: " + pedido.getIdPedido() + " enviado para a fila com sucesso.");			
		}catch(Exception ex) {
			ex.printStackTrace();
			pedido.setSituacaoPedido(new SituacaoPedido(ERRO_ENVIO_PARA_FILA));
			pedidoRepository.save(pedido);			

			logger.severe("Nao foi possivel enviar o pedido #ID: " + pedido.getIdPedido() + " para a fila.");
		}

	}
	
	private Collection<PedidoVo> montarPedidos(Long idPedido) {
		Optional<Pedido> pedidoOptional = pedidoRepository.findById(idPedido);
		if(!pedidoOptional.isPresent()) {
			throw new RuntimeException("Nao foi possivel montar a lista de pedido #ID: " + idPedido);
		}		
		Pedido pedidoDb = pedidoOptional.get();		
		Map<Long, PedidoVo> pedidos = new HashMap<>();		
		PedidoVo pedido;
		for(ItemPedido ip : pedidoDb.getItensPedido()) {
			Optional<Produto> produto = produtoRepository.findById(ip.getProduto().getIdProduto());
			Long idFornecedor = produto.get().getIdFornecedor();
			if(!pedidos.containsKey(idFornecedor)) {
				
				Optional<Endereco> e = enderecoRepository.findById(pedidoDb.getEndereco().getIdEndereco());
				Optional<Cliente> c = clienteRepository.findById(pedidoDb.getCliente().getIdCliente());
				Optional<Fornecedor> f = fornecedorRepository.findById(idFornecedor);
				
				PedidoVo tmp = new PedidoVo();
				tmp.setCnpjFornecedor(f.get().getCnpj());
				tmp.setNumeroPedido(pedidoDb.getIdPedido());
				tmp.setCliente(c.get());
				tmp.setEndereco(e.get());
				tmp.setData(DateUtil.date2String(pedidoDb.getDataHoraCriacao()));
				tmp.setItens(new ArrayList<>());
				pedidos.put(idFornecedor, tmp);
			}
			pedido = pedidos.get(idFornecedor);
			pedido.getItens().add(new ItemVo(produto.get().getCodProdutoFornecedor(), ip.getQuantidade()));			
		}
		return pedidos.values();
	}
	
	/**
	 * Valida se a estrutura do pedido esta integro
	 * @param pedido Pedido
	 */
	private void validarPedido(Pedido pedido) {
		if(pedido == null) {
			throw new RuntimeException("Pedido nao informado.");
		}
		
		if(pedido.getEndereco() == null) {
			throw new RuntimeException("Pedido nao possui endereco vinculado.");
		}
		
		if(pedido.getCliente() == null) {
			throw new RuntimeException("Pedido nao possui cliente vinculado.");
		}		
		
		if(pedido.getItensPedido() == null || pedido.getItensPedido().isEmpty()) {
			throw new RuntimeException("Pedido nao possui produtos vinculados.");
		}
	}
	
}
