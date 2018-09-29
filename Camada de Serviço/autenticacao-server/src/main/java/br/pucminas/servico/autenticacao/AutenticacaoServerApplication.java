package br.pucminas.servico.autenticacao;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.servico.autenticacao.model.Usuario;
import br.pucminas.servico.autenticacao.service.UsuarioService;

@SpringBootApplication
@RestController
@EnableResourceServer
@EnableAuthorizationServer
@EnableEurekaClient
public class AutenticacaoServerApplication implements CommandLineRunner{
	
	private static final Logger logger = Logger.getLogger(AutenticacaoServerApplication.class.getName());
	
	@Resource(name = "userDetailService")
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(AutenticacaoServerApplication.class, args);
	}
	
	@RequestMapping(value="/user", produces="application/json")
	public Map<String, Object> user(OAuth2Authentication user){
		logger.info("Estou passando por aqui.");
		User principal = (User) user.getUserAuthentication().getPrincipal();
		Usuario usuario = usuarioService.findByEmail(principal.getUsername());
		usuario.setSenha(null);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user.getUserAuthentication().getPrincipal());
		map.put("usuario", usuario);
		map.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
		return map;
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Senha (): ");
		
	}
}
