package br.pucminas.integracao.bi.worker;

import org.apache.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("integracao-bi-worker-context.xml")
public class IntegracaoBiWorkerApplication implements ApplicationRunner{

	private static final Logger logger = Logger.getLogger(IntegracaoBiWorkerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(IntegracaoBiWorkerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		logger.info("**** NODE WORKER INICIADO ****");		
	}
}
