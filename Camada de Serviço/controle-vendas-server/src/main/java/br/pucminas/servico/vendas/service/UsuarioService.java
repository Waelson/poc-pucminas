package br.pucminas.servico.vendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.pucminas.servico.vendas.model.Usuario;
import br.pucminas.servico.vendas.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario findByEmail(String email) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if(usuario == null) {
			return null;
		}		
		return usuario;
	}
	
}
