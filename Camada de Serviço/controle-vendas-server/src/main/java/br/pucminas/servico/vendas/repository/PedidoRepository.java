package br.pucminas.servico.vendas.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.pucminas.servico.vendas.model.Pedido;

@Repository
public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Long>{

	@Query("UPDATE Pedido SET situacaoPedido.codSituacaoPedido = :codSituacaoPedido WHERE idPedido = :idPedido")
	public void atualizarSituacao(@Param("idPedido") Long idPedido, @Param("codSituacaoPedido") Long codSituacaoPedido);

	
}
