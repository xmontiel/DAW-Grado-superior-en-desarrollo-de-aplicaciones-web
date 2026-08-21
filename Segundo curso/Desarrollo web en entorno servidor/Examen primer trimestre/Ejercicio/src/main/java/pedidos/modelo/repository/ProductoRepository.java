package pedidos.modelo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pedidos.modelo.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	List<Producto> findByStockLessThan(int stock);
	
	//Productos de una categoría concreta (por ID o nombre)
	List<Producto> findByCategoriaIdCategoria(int idCategoria);
	
	//Buscar productos por nombre que contengan una palabra
	List<Producto> findByNombreContiene(String palabra);
	
}