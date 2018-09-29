package br.pucminas.integracao.bi.master.model;

import java.util.Date;

import br.pucminas.integracao.bi.master.enums.TipoArquivoEnum;
import br.pucminas.integracao.bi.master.util.DateUtil;
import br.pucminas.integracao.bi.master.util.NetworkUtil;

public class MensagemGeracaoArquivo {
	
	private String tipoArquivo;
	private String dataReferenciaArquivo;
	private String enderecoIpOrigem;
	private String dataHoraGeracao;
	private String diretorioSaida;
	
	public MensagemGeracaoArquivo(TipoArquivoEnum tipo, Date dataReferencia, String diretorioSaida) {
		this.tipoArquivo = tipo.name();
		this.dataReferenciaArquivo = DateUtil.toString(dataReferencia, DateUtil.DAY_FORMAT);
		this.dataHoraGeracao = DateUtil.toString(new Date(), DateUtil.DEFAULT_FORMAT);
		this.enderecoIpOrigem = NetworkUtil.getIp();
		this.diretorioSaida = diretorioSaida;
	}

	public String getTipoArquivo() {
		return tipoArquivo;
	}
	
	
	public String getEnderecoIpOrigem() {
		return enderecoIpOrigem;
	}

	public String getDataHoraGeracao() {
		return dataHoraGeracao;
	}
	
	
	public String getDataReferenciaArquivo() {
		return dataReferenciaArquivo;
	}
	
	public String getDiretorioSaida() {
		return diretorioSaida;
	}

	@Override
	public String toString() {
		return "MensagemGeracaoArquivo [tipoArquivo=" + tipoArquivo + ", dataReferenciaArquivo=" + dataReferenciaArquivo
				+ ", enderecoIpOrigem=" + enderecoIpOrigem + ", dataHoraGeracao=" + dataHoraGeracao
				+ ", diretorioSaida=" + diretorioSaida + "]";
	}

	

	
}
