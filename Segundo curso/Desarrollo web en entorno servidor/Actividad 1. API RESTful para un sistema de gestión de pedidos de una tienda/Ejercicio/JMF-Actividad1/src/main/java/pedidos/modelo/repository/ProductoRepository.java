package pedidos.modelo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pedidos.modelo.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	List<Producto> findByStockLessThan(int stock);
	
	List<Producto> findByCategoriaIdCategoria(int idCategoria);
}