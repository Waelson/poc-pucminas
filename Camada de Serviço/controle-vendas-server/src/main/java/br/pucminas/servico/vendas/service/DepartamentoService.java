package br.pucminas.servico.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.pucminas.servico.vendas.model.Departamento;
import br.pucminas.servico.vendas.repository.DepartamentoRepository;

@Service
public class DepartamentoService{
	
	//@Autowired
	//private RestTemplate restTemplate;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;	
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public List<Departamento> findAll(){
		return departamentoRepository.findAll();
		/*
		Optional<List<Departamento>> retornoCache = findAllInCache();
		if(retornoCache.isPresent()) {
			return retornoCache.get();
		}else {
			return departamentoRepository.findAll();
		}
		*/
	}
	/*
	private Optional<List<Departamento>> findAllInCache(){
		final String url = "http://localhost:8003/departamentos";
		ResponseEntity<List<Departamento>> response = restTemplate.exchange(
				url, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<List<Departamento>>(){});
		if(response.getStatusCode() == HttpStatus.OK) {
			return Optional.of(response.getBody());
		}
		return Optional.empty();
	}
	*/
	
}
