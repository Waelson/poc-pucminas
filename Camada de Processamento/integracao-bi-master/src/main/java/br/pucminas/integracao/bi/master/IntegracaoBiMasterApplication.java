package br.pucminas.integracao.bi.master;

import org.apache.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import br.pucminas.integracao.bi.master.util.NetworkUtil;

@SpringBootApplication
@ImportResource("integracao-bi-master-context.xml")
public class IntegracaoBiMasterApplication implements ApplicationRunner{

	private static final Logger logger = Logger.getLogger(IntegracaoBiMasterApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(IntegracaoBiMasterApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		logger.info("**** NODE MASTER INICIADO ****");
		logger.info("**** IP: " + NetworkUtil.getIp() + " ****");
	}
}
