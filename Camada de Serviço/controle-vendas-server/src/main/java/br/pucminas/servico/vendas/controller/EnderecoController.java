package br.pucminas.servico.vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.servico.vendas.model.Endereco;
import br.pucminas.servico.vendas.service.EnderecoService;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;


	
	@RequestMapping(path="/cliente/{idCliente}", produces="application/json", method=RequestMethod.GET)
	public List<Endereco> findAll(@PathVariable("idCliente")Long idCliente){
		List<Endereco> resultado = enderecoService.findAllByCliente(idCliente);
		return resultado;
	}	
	
}
