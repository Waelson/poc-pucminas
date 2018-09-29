package br.pucminas.servico.vendas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="forma_pagamento")
public class FormaPagamento {
	
	@Id
	private Long codFormaPagamento;
	
	private String nome;

	public Long getCodFormaPagamento() {
		return codFormaPagamento;
	}

	public void setCodFormaPagamento(Long codFormaPagamento) {
		this.codFormaPagamento = codFormaPagamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
