package br.pucmg.integracao.comum.protocolo;

import java.util.Map;

public class Mensagem {

	private Map<String, String> cabecalhos;
	private String payload;

	public Mensagem() {
		super();
	}

	public Map<String, String> getCabecalhos() {
		return cabecalhos;
	}

	public void setCabecalhos(Map<String, String> cabecalhos) {
		this.cabecalhos = cabecalhos;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}	

}
