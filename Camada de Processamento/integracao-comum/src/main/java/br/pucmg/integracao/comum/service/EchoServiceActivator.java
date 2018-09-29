package br.pucmg.integracao.comum.service;

import org.apache.log4j.Logger;

public class EchoServiceActivator {
	
	private static final Logger logger = Logger.getLogger(EchoServiceActivator.class);
	
	public void echoSemRetorno(String mensagem) {
		logger.info("ECHO: " + mensagem);
	}
	
	public String echo(String mensagem) {
		logger.info("ECHO: " + mensagem);
		return mensagem;
	}	

}
