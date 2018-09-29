package br.pucminas.servico.vendas.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.servico.vendas.model.Produto;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long>{

	@Override
	public List<Produto> findAll();
	
	public List<Produto> findByIdCategoriaOrderByNomeAsc(Long idCategoria);
	
	
}
