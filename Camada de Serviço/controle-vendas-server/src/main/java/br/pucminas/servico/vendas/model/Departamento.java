package br.pucminas.servico.vendas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDepartamento;
	
	private String nome;
	
	private String nomeLink;
	
	private String icone;
	
	public Departamento() {
		super();
	}
	
	public Departamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeLink() {
		return nomeLink;
	}

	public void setNomeLink(String nomeLink) {
		this.nomeLink = nomeLink;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}


	
}
