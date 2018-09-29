package br.pucminas.servico.vendas.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.servico.vendas.model.Departamento;

@Repository
public interface DepartamentoRepository extends PagingAndSortingRepository<Departamento, Long>{

	@Override
	public List<Departamento> findAll();
	
	
	
}
