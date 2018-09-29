package br.pucminas.servico.vendas.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPedido;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCliente", nullable=true)
	private Cliente cliente;	

	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="codSituacaoPedido", nullable=false)
	private SituacaoPedido situacaoPedido;

	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="codFormaPagamento", nullable=false)
	private FormaPagamento formaPagamento;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idEndereco", nullable=false)
	private Endereco endereco;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraCriacao;
	
	private Double vlrTotal;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="pedido")	
	private List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public SituacaoPedido getSituacaoPedido() {
		return situacaoPedido;
	}

	public void setSituacaoPedido(SituacaoPedido situacaoPedido) {
		this.situacaoPedido = situacaoPedido;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Date getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(Date dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}
	
	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Double getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(Double vlrTotal) {
		this.vlrTotal = vlrTotal;
	}
	
	

}
