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
import pedidos.modelo.dto.CategoriaDto;
import pedidos.modelo.entities.Categoria;
import pedidos.modelo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaRestController {
	
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@GetMapping("")
	List<CategoriaDto> listar() {
		return categoriaRepo.findAll()
				.stream()
				.map(categoria -> CategoriaDto.convertACategoriaDto(categoria))
				.toList();
	}
	
	@GetMapping("/{id}")
	ResponseEntity<CategoriaDto> buscarPorId(@PathVariable int id) {
		return categoriaRepo.findById(id)
				.map(categoria -> ResponseEntity.ok(CategoriaDto.convertACategoriaDto(categoria)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("")
	ResponseEntity<Categoria> crear(@RequestBody Categoria categoria) {
		Categoria nuevaCategoria = categoriaRepo.save(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategoria);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Categoria> actualizar(@PathVariable int id, @RequestBody Categoria categoria) {
		return categoriaRepo.findById(id)
				.map(categoriaExistente -> {
					categoria.setIdCategoria(id);
					Categoria categoriaActualizada = categoriaRepo.save(categoria);
					return ResponseEntity.ok(categoriaActualizada);
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> eliminar(@PathVariable int id) {
		return categoriaRepo.findById(id)
				.map(categoria -> {
					categoriaRepo.deleteById(id);
					return ResponseEntity.noContent().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}