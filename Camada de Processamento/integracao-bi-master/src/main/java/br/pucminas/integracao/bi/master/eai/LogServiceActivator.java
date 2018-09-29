package br.pucminas.integracao.bi.master.eai;

import org.apache.log4j.Logger;

public class LogServiceActivator {
	
	private static final Logger logger = Logger.getLogger(LogServiceActivator.class);
	
	public String logar(String mensagem) {
		logger.info("**** " + mensagem + " ****");
		return mensagem;
	}

}
