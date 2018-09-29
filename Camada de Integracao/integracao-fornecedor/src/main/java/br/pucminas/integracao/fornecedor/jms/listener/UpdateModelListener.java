package br.pucminas.integracao.fornecedor.jms.listener;

import java.io.IOException;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

//@Configuration
public class UpdateModelListener {
	
	private static Logger logger = Logger.getLogger(UpdateModelListener.class.getName());


	//@JmsListener(destination = "queue.envio.pedido.fornecedor")
	public void onReceiverQueue(String model) throws JsonParseException, JsonMappingException, IOException {
		logger.info("==================================");
		logger.info("=|       MENSAGEM RECEBIDA      |=");
		logger.info("==================================");
		logger.info(model);
		logger.info("==================================");
	}
	
}
