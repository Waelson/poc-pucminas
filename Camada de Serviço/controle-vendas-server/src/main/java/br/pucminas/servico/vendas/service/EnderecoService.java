package br.pucminas.servico.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.pucminas.servico.vendas.model.Endereco;
import br.pucminas.servico.vendas.repository.EnderecoRepository;

@Service
@Transactional
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public List<Endereco> findAllByCliente(Long idCliente){

		List<Endereco> resultado = 
				enderecoRepository.findAllByIdCliente(idCliente);
		return resultado;		
	}
	

	
}
