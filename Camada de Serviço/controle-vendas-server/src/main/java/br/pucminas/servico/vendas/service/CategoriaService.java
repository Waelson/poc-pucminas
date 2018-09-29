package br.pucminas.servico.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.pucminas.servico.vendas.model.Categoria;
import br.pucminas.servico.vendas.repository.CategoriaRepository;

@Service
@Transactional
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public List<Categoria> findAllByDepartamento(Long idDepartamento){

		List<Categoria> resultado = 
				categoriaRepository.findAllByIdDepartamento(idDepartamento);
		return resultado;		
	}
	
	public List<Categoria> findAll(){
		List<Categoria> resultado = 
				categoriaRepository.findAll();
		return resultado;
	}	
	
}
