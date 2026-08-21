package pedidos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pedidos.modelo.entities.LineasPedido;

public interface LineasPedidoRepository extends JpaRepository<LineasPedido, Integer>{
	
	public List<LineasPedido> findByPedidoIdPedido(int idPedido);
	
	@Query("SELECT lp.producto.idProducto, lp.producto.nombre, SUM(lp.cantidad) " +
		       "FROM LineasPedido lp GROUP BY lp.producto.idProducto, lp.producto.nombre")
		List<Object[]> findVentaProductos();
		

}
