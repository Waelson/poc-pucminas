package br.pucminas.servico.vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.servico.vendas.model.Categoria;
import br.pucminas.servico.vendas.service.CategoriaService;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(path="/", produces="application/json", method=RequestMethod.GET)
	public List<Categoria> findAll(){
		List<Categoria> resultado = categoriaService.findAll();
		return resultado;
	}
	
	@RequestMapping(path="/departamento/{idDepartamento}", produces="application/json", method=RequestMethod.GET)
	public List<Categoria> findAll(@PathVariable("idDepartamento")Long idDepartamento){
		List<Categoria> resultado = categoriaService.findAllByDepartamento(idDepartamento);
		return resultado;
	}	
	
}
