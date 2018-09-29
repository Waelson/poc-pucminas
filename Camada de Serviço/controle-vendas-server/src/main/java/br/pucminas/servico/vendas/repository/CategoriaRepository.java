package br.pucminas.servico.vendas.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.servico.vendas.model.Categoria;

@Repository
public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Long>{

	
	public List<Categoria> findAllByIdDepartamento(Long idDepartamento);
	
	@Override
	public List<Categoria> findAll();
	
}
