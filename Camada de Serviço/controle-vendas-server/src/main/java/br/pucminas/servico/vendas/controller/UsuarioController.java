package br.pucminas.servico.vendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.servico.vendas.model.Usuario;
import br.pucminas.servico.vendas.service.UsuarioService;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/search/findByEmail/{email}")
	public Usuario findByEmail(@PathVariable("email") String email) {
		Usuario usuario = usuarioService.findByEmail(email);
		usuario.setSenha(null);
		return usuario;
	}

}
