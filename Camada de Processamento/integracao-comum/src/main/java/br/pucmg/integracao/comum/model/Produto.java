package br.pucmg.integracao.comum.model;

import java.util.ArrayList;
import java.util.List;

public class Produto {
	
	private Long identificadorFornecedor;
	private String nome;
	private String descricao;
	private Integer quantidadeEstoque;
	private Integer prazoEntrega;
	private List<String> urlImagens = new ArrayList<String>();
	public Long getIdentificadorFornecedor() {
		return identificadorFornecedor;
	}
	public void setIdentificadorFornecedor(Long identificadorFornecedor) {
		this.identificadorFornecedor = identificadorFornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public Integer getPrazoEntrega() {
		return prazoEntrega;
	}
	public void setPrazoEntrega(Integer prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}
	public List<String> getUrlImagens() {
		return urlImagens;
	}
	public void setUrlImagens(List<String> urlImagens) {
		this.urlImagens = urlImagens;
	}
	
	
	

}
