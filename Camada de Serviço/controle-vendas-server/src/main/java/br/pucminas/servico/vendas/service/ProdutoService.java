package br.pucminas.servico.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.pucminas.servico.vendas.model.Produto;
import br.pucminas.servico.vendas.repository.ProdutoRepository;

@Service
@Transactional
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> findAll(){
		List<Produto> resultado = produtoRepository.findAll();
		return resultado;
	}
	
	public List<Produto> findByIdCategoria(Long idCategoria){
		List<Produto> resultado = produtoRepository.findByIdCategoriaOrderByNomeAsc(idCategoria);
		return resultado;
	}
	
}
