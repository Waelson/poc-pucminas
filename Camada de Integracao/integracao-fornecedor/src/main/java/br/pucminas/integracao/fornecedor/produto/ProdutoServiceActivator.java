package br.pucminas.integracao.fornecedor.produto;

import org.springframework.messaging.Message;

import br.pucmg.integracao.comum.protocolo.Mensagem;
import br.pucmg.integracao.comum.protocolo.MensagemBuilder;
import br.pucmg.integracao.comum.util.JsonUtil;
import br.pucminas.integracao.fornecedor.converter.ByteArrayParaStringConverter;
import br.pucminas.integracao.fornecedor.jms.JmsGateway;

public class ProdutoServiceActivator {
	
	private JmsGateway gateway;
	private ByteArrayParaStringConverter converter;
	
	public ProdutoServiceActivator(JmsGateway gateway, ByteArrayParaStringConverter converter) {
		this.gateway = gateway;
		this.converter = converter;
	}
	
	public String incluirHttp(Message<?> message) {
		String id = message.getHeaders().getId().toString();		
		Mensagem mensagem = new MensagemBuilder().setIdCorrelacao(id).comPayload(message.getPayload()).build();		
		String json = JsonUtil.getInstance().objetoParaJson(mensagem);		
		gateway.enviar(json);		
		return montarJsonRetornoInclusao(id);
	}
	
	public String incluirTcp(Message<?> message) {
		String id = message.getHeaders().getId().toString();		
		String payload =  converter.convert((byte[])message.getPayload());
		Mensagem mensagem = new MensagemBuilder().setIdCorrelacao(id).comPayload(payload).build();		
		String json = JsonUtil.getInstance().objetoParaJson(mensagem);		
		gateway.enviar(json);
		return montarJsonRetornoInclusao(id);
	}	
	
	private String montarJsonRetornoInclusao(String id) {
		return "<stx>{\"protocolo\": \""+ id + "\", \"resultado\": \"SUCESSO\"}<etx>";
	}

}
