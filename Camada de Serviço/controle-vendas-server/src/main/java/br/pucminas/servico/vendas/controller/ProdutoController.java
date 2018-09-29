package br.pucminas.servico.vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.servico.vendas.model.Produto;
import br.pucminas.servico.vendas.service.ProdutoService;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(path="/", produces="application/json", method=RequestMethod.GET)
	public List<Produto> findAll(){
		List<Produto> resultado = produtoService.findAll();
		return resultado;
	}
	
	@RequestMapping(path="/categoria/{idCategoria}", produces="application/json", method=RequestMethod.GET)
	public List<Produto> findAll(@PathVariable("idCategoria")Long idCategoria){
		List<Produto> resultado = produtoService.findByIdCategoria(idCategoria);
		return resultado;
	}	
	
}
