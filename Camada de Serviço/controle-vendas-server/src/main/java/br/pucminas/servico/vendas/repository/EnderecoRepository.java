package br.pucminas.servico.vendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.pucminas.servico.vendas.model.Endereco;

@Repository
public interface EnderecoRepository extends PagingAndSortingRepository<Endereco, Long>{

	@Query("SELECT e FROM Endereco e WHERE e.cliente.idCliente = :idCliente")
	public List<Endereco> findAllByIdCliente(@Param("idCliente") Long idCliente);
	
	@Override
	public List<Endereco> findAll();
	
}
