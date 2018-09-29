package br.pucminas.servico.vendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.pucminas.servico.vendas.model.Fornecedor;

@Repository
public interface FornecedorRepository extends PagingAndSortingRepository<Fornecedor, Long>{

	@Query("SELECT f FROM Fornecedor f WHERE nome LIKE %:name%")
	List<Fornecedor> findByNome(@Param("name") String name);
	
	@Query("SELECT f FROM Fornecedor f WHERE cnpj LIKE %:cnpj% ORDER BY f.nome")
	List<Fornecedor> findByCnpj(@Param("cnpj") String cnpj);
	
	@Query("SELECT f FROM Fornecedor f WHERE nome LIKE %:name% ORDER BY f.nome")
	List<Fornecedor> findByNomeOrderByNome(@Param("name") String name);
	
}
