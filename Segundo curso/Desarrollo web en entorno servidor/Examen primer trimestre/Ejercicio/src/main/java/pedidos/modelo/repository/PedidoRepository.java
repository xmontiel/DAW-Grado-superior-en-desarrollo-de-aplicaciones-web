package pedidos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pedidos.modelo.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	//Pedidos de un cliente
	List<Pedido> findByUsuarioIdUsuario(int idUsuario);
	
	//Pedidos con más de N líneas
	@Query("SELECT p FROM Pedido p WHERE SIZE(p.lineas) > :numLineas")
	List<Pedido> findPedidosConMasDeNLineas(@Param("numLineas") int numLineas);
	
}