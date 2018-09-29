package br.pucminas.servico.autenticacao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.pucminas.servico.autenticacao.model.Perfil;
import br.pucminas.servico.autenticacao.model.Usuario;
import br.pucminas.servico.autenticacao.repository.UsuarioRepository;


@Service("userDetailService")
@Transactional
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;

	public Usuario findByEmail(String email) {
		Optional<Usuario> usuarioOptional = repository.findOptionalByEmail(email);
		if(!usuarioOptional.isPresent()) {
			throw new UsernameNotFoundException("Usuário e/ou senha inválida.");
		}
		return usuarioOptional.get();
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> usuarioOptional = repository.findOptionalByEmail(email);
		if(!usuarioOptional.isPresent()) {
			throw new UsernameNotFoundException("Usuário e/ou senha inválida.");
		}
		Usuario usuario = usuarioOptional.get();
		UserDetails userDetail = new User(
				usuario.getEmail(), usuario.getSenha(), conveterPerfilParaAuthority(usuario.getPerfis()));
		return userDetail;
	}
	
	private List<GrantedAuthority> conveterPerfilParaAuthority(List<Perfil> perfis){
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(perfis == null || perfis.isEmpty()) {
			return authorities;
		}
		for(Perfil perfil : perfis) {
			authorities.add(new SimpleGrantedAuthority(perfil.getNome()));
		}
		return authorities;
	}

}
