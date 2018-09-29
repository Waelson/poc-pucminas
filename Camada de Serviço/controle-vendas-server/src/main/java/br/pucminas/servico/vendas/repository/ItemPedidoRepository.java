package br.pucminas.servico.vendas.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.pucminas.servico.vendas.model.ItemPedido;

@Repository
public interface ItemPedidoRepository extends PagingAndSortingRepository<ItemPedido, Long>{


	
}
