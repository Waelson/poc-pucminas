package br.pucminas.integracao.bi.worker.model;

public class MensagemGeracaoArquivo {

	private String tipoArquivo;
	private String dataReferenciaArquivo;
	private String enderecoIpOrigem;
	private String dataHoraGeracao;
	private String diretorioSaida;

	public String getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	public String getDataReferenciaArquivo() {
		return dataReferenciaArquivo;
	}

	public void setDataReferenciaArquivo(String dataReferenciaArquivo) {
		this.dataReferenciaArquivo = dataReferenciaArquivo;
	}

	public String getEnderecoIpOrigem() {
		return enderecoIpOrigem;
	}

	public void setEnderecoIpOrigem(String enderecoIpOrigem) {
		this.enderecoIpOrigem = enderecoIpOrigem;
	}

	public String getDataHoraGeracao() {
		return dataHoraGeracao;
	}

	public void setDataHoraGeracao(String dataHoraGeracao) {
		this.dataHoraGeracao = dataHoraGeracao;
	}

	public String getDiretorioSaida() {
		return diretorioSaida;
	}

	public void setDiretorioSaida(String diretorioSaida) {
		this.diretorioSaida = diretorioSaida;
	}

	
}
