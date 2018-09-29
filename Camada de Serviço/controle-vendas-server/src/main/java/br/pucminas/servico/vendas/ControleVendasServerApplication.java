package br.pucminas.servico.vendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableJpaRepositories(basePackages = {"br.pucminas.servico.vendas.repository"})
@EntityScan(basePackages = {"br.pucminas.servico.vendas.model"})
@EnableEurekaClient
@EnableJms
public class ControleVendasServerApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ControleVendasServerApplication.class, args);
	}
	
	
}
