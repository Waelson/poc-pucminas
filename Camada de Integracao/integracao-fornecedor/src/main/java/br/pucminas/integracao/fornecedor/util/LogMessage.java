package br.pucminas.integracao.fornecedor.util;

import java.util.logging.Logger;


import org.springframework.messaging.Message;

public class LogMessage {

	private static final Logger logger = Logger.getLogger(LogMessage.class.getName());
	

	public String print(String mensagem) {
		logger.info("****************************************************************");
		logger.info("Pedido encaminhado ao fornecedor: " + mensagem);
		logger.info("****************************************************************");
		return mensagem;
	}

	
	public String print(Message<?> message){
		String msg = new String((byte[])message.getPayload());
		logger.info("****************************************************************");
		logger.info("Resposta do fornecedor: " + msg);
		logger.info("****************************************************************");
		return msg;
	}
	
	public void printConsole(Message<?> message){
		System.out.println("Message was passed to printConsole from the outboundGateway");
		System.out.println(message);
	}
	
}
