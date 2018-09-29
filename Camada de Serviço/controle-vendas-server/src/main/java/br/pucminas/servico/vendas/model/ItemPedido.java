package br.pucminas.servico.vendas.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item_pedido")
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idItemPedido;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idPedido", nullable=true)
	private Pedido pedido;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idProduto", nullable=true)	
	private Produto produto;
	
	private Double vlrUnitario;
	
	private Integer quantidade;
	
	private Double vlrTotal;

	public Long getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Long idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	

	public Double getVlrUnitario() {
		return vlrUnitario;
	}

	public void setVlrUnitario(Double vlrUnitario) {
		this.vlrUnitario = vlrUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(Double vlrTotal) {
		this.vlrTotal = vlrTotal;
	}
	
	

}
