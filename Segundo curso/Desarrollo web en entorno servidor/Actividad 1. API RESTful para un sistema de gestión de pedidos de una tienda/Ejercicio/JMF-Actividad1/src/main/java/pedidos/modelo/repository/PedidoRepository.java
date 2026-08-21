package pedidos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedidos.modelo.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
}