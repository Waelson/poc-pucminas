package br.pucminas.servico.autenticacao.repository;

import java.util.Optional; 

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.servico.autenticacao.model.Usuario;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{

	
	public Optional<Usuario> findOptionalByEmail(String email);
	
}
