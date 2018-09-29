package br.pucminas.servico.vendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.servico.vendas.model.Pedido;
import br.pucminas.servico.vendas.service.PedidoService;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(path="/", produces="application/json", method=RequestMethod.POST)
	@ResponseBody
	public String salvar(@RequestBody Pedido pedido) {
		Pedido resultado = pedidoService.salvar(pedido);
		String response = "{\"protocolo\": " + resultado.getIdPedido() + "}";
		return response;
	}
	
}
