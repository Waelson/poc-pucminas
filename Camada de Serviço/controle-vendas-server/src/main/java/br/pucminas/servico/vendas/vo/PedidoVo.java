package br.pucminas.servico.vendas.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.pucminas.servico.vendas.model.Cliente;
import br.pucminas.servico.vendas.model.Endereco;

public class PedidoVo {
	
	private Long numeroPedido;
	private String cnpjFornecedor;
	private String data;
	private Cliente cliente;
	private Endereco endereco;
	private List<ItemVo> itens = new ArrayList<>();
	
	
	public Long getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public String getCnpjFornecedor() {
		return cnpjFornecedor;
	}
	public void setCnpjFornecedor(String cnpjFornecedor) {
		this.cnpjFornecedor = cnpjFornecedor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<ItemVo> getItens() {
		return itens;
	}
	public void setItens(List<ItemVo> itens) {
		this.itens = itens;
	}
	
	
	

}
