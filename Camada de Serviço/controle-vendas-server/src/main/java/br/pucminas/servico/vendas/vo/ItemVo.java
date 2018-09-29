package br.pucminas.servico.vendas.vo;

public class ItemVo {
	
	private String codProdutoFornecedor;
	private Integer quantidade;
	
	
	public ItemVo() {
		super();
	}
	
	
	
	public ItemVo(String codProdutoFornecedor, Integer quantidade) {
		super();
		this.codProdutoFornecedor = codProdutoFornecedor;
		this.quantidade = quantidade;
	}



	public String getCodProdutoFornecedor() {
		return codProdutoFornecedor;
	}
	public void setCodProdutoFornecedor(String codProdutoFornecedor) {
		this.codProdutoFornecedor = codProdutoFornecedor;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
