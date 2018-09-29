package br.pucminas.integracao.fornecedor;

import org.apache.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value= {"integration-context.xml"})
public class IntegracaoFornecedorWsApplication implements ApplicationRunner{

	private static final Logger logger = Logger.getLogger(IntegracaoFornecedorWsApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(IntegracaoFornecedorWsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		logger.info("**** NODE INTEGRACAO FORNECEDOR WS INICIADO ****");
		
	}
}
