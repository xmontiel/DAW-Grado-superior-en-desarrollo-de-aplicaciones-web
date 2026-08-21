package pedidos.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pedidos.modelo.dto.ProductoDto;
import pedidos.modelo.entities.Producto;
import pedidos.modelo.repository.CategoriaRepository;
import pedidos.modelo.repository.ProductoRepository;

@RestController
@RequestMapping("/productos")
public class ProductoRestController {
	
	@Autowired
	private ProductoRepository productoRepo;
	
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@GetMapping("")
	List<ProductoDto> listar() {
		return productoRepo.findAll()
				.stream()
				.map(producto -> ProductoDto.convertAProductoDto(producto))
				.toList();
	}
	
	@GetMapping("/{id}")
	ResponseEntity<ProductoDto> buscarPorId(@PathVariable int id) {
		return productoRepo.findById(id)
				.map(producto -> ResponseEntity.ok(ProductoDto.convertAProductoDto(producto)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("")
	ResponseEntity<Producto> crear(@RequestBody Producto producto) {
		if (producto.getCategoria() == null || producto.getCategoria().getIdCategoria() == 0) {
			return ResponseEntity.badRequest().build();
		}
		
		return categoriaRepo.findById(producto.getCategoria().getIdCategoria())
				.map(categoria -> {
					producto.setCategoria(categoria);
					Producto nuevoProducto = productoRepo.save(producto);
					return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
				})
				.orElse(ResponseEntity.badRequest().build());
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Producto> actualizar(@PathVariable int id, @RequestBody Producto producto) {
		return productoRepo.findById(id)
				.map(productoExistente -> {
					producto.setIdProducto(id);
					if (producto.getCategoria() != null && producto.getCategoria().getIdCategoria() != 0) {
						categoriaRepo.findById(producto.getCategoria().getIdCategoria())
								.ifPresent(categoria -> producto.setCategoria(categoria));
					} else {
						producto.setCategoria(productoExistente.getCategoria());
					}
					Producto productoActualizado = productoRepo.save(producto);
					return ResponseEntity.ok(productoActualizado);
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> eliminar(@PathVariable int id) {
		return productoRepo.findById(id)
				.map(producto -> {
					productoRepo.deleteById(id);
					return ResponseEntity.noContent().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/stock-menor/{stock}")
	List<ProductoDto> buscarStockMenor(@PathVariable int stock) {
		return productoRepo.findByStockLessThan(stock)
				.stream()
				.map(producto -> ProductoDto.convertAProductoDto(producto))
				.toList();
	}
	
	@GetMapping("/por-categoria/{idCategoria}")
	List<ProductoDto> buscarPorCategoria(@PathVariable int idCategoria) {
		return productoRepo.findByCategoriaIdCategoria(idCategoria)
				.stream()
				.map(producto -> ProductoDto.convertAProductoDto(producto))
				.toList();
	}
}