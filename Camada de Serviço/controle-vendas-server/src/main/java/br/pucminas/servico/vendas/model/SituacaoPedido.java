package br.pucminas.servico.vendas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="situacao_pedido")
public class SituacaoPedido {
	
	@Id
	private Long codSituacaoPedido;
	
	private String nome;
	
	public SituacaoPedido() {
		super();
	}
	
	public SituacaoPedido(Long codSituacaoPedido) {
		this.codSituacaoPedido = codSituacaoPedido;
	}	

	public Long getCodSituacaoPedido() {
		return codSituacaoPedido;
	}

	public void setCodSituacaoPedido(Long codSituacaoPedido) {
		this.codSituacaoPedido = codSituacaoPedido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
