package br.pucminas.servico.vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.servico.vendas.model.Departamento;
import br.pucminas.servico.vendas.service.DepartamentoService;


@RestController
@RequestMapping("departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@CrossOrigin(origins="*")
	@RequestMapping(path="/", produces="application/json", method=RequestMethod.GET)
	public List<Departamento> findAll(){
		List<Departamento> resultado = departamentoService.findAll();
		return resultado;
	}
	
}
