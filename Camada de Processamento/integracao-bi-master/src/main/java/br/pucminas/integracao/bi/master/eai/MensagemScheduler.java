package br.pucminas.integracao.bi.master.eai;

import java.util.Date;

import org.apache.log4j.Logger;

import br.pucminas.integracao.bi.master.enums.TipoArquivoEnum;
import br.pucminas.integracao.bi.master.model.MensagemGeracaoArquivo;

public class MensagemScheduler {
	private Logger logger = Logger.getLogger(MensagemScheduler.class);
	private MensagemGateway gateway;
	private String diretorioSaida;
	
	public MensagemScheduler(MensagemGateway gateway, String diretorioSaida) {
		this.gateway = gateway;
		this.diretorioSaida = diretorioSaida;
	}
	
	public void execute() {
		logger.info("**** Enviando mensagens de solicitacao de geracao de arquivos ****");
		TipoArquivoEnum tipos[] = TipoArquivoEnum.values();
		for(TipoArquivoEnum tipo : tipos) {
			gateway.send(new MensagemGeracaoArquivo(tipo, new Date(), diretorioSaida));
		}
	}

}
