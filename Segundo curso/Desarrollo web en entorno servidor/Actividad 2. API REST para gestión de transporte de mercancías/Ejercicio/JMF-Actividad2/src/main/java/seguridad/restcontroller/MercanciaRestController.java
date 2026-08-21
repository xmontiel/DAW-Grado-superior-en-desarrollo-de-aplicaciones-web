package seguridad.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import seguridad.model.dtos.MercanciaDto;
import seguridad.model.entity.Mercancia;
import seguridad.model.service.MercanciaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mercancias")
public class MercanciaRestController {
	
	@Autowired
	private MercanciaService mercanciaService;
	
	@GetMapping
	@PreAuthorize("hasRole('EMPRESA')")
	public ResponseEntity<?> obtenerTodas() {
		List<Mercancia> mercancias = mercanciaService.obtenerTodas();
		return ResponseEntity.ok(mercancias);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable String id) {
		Mercancia mercancia = mercanciaService.obtenerPorId(id);
		if (mercancia != null) {
			return ResponseEntity.ok(mercancia);
		} else {
			return ResponseEntity.status(404).body("Mercancía no encontrada");
		}
	}
	
	@PostMapping
	@PreAuthorize("hasRole('EMPRESA')")
	public ResponseEntity<?> crear(@RequestBody MercanciaDto mercanciaDto) {
		Mercancia mercancia = Mercancia.builder()
			.descripcion(mercanciaDto.getDescripcion())
			.origen(mercanciaDto.getOrigen())
			.destino(mercanciaDto.getDestino())
			.pesoKg(mercanciaDto.getPesoKg())
			.fechaEntregaEstimada(mercanciaDto.getFechaEntregaEstimada())
			.estado(mercanciaDto.getEstado())
			.build();
		
		Mercancia mercanciaGuardada = mercanciaService.crear(mercancia);
		return ResponseEntity.ok(mercanciaGuardada);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('EMPRESA')")
	public ResponseEntity<?> actualizar(@PathVariable String id, @RequestBody MercanciaDto mercanciaDto) {
		Mercancia mercancia = Mercancia.builder()
			.descripcion(mercanciaDto.getDescripcion())
			.origen(mercanciaDto.getOrigen())
			.destino(mercanciaDto.getDestino())
			.pesoKg(mercanciaDto.getPesoKg())
			.fechaEntregaEstimada(mercanciaDto.getFechaEntregaEstimada())
			.estado(mercanciaDto.getEstado())
			.build();
		
		Mercancia mercanciaActualizada = mercanciaService.actualizar(id, mercancia);
		if (mercanciaActualizada != null) {
			return ResponseEntity.ok(mercanciaActualizada);
		} else {
			return ResponseEntity.status(404).body("Mercancía no encontrada");
		}
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('EMPRESA')")
	public ResponseEntity<?> eliminar(@PathVariable String id) {
		Mercancia mercancia = mercanciaService.obtenerPorId(id);
		if (mercancia != null) {
			mercanciaService.eliminar(id);
			return ResponseEntity.ok("Mercancía eliminada correctamente");
		} else {
			return ResponseEntity.status(404).body("Mercancía no encontrada");
		}
	}
	
	@GetMapping("/disponibles")
	public ResponseEntity<?> obtenerDisponibles() {
		List<Mercancia> mercancias = mercanciaService.obtenerDisponibles();
		return ResponseEntity.ok(mercancias);
	}
	
	@GetMapping("/mis-mercancias")
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<?> obtenerMisMercancias(Authentication auth) {
		String conductorId = auth.getName();
		List<Mercancia> mercancias = mercanciaService.obtenerMercanciasPorConductor(conductorId);
		return ResponseEntity.ok(mercancias);
	}
	
	@GetMapping("/buscar/origen/{origen}")
	public ResponseEntity<?> buscarPorOrigen(@PathVariable String origen) {
		List<Mercancia> mercancias = mercanciaService.buscarPorOrigen(origen);
		return ResponseEntity.ok(mercancias);
	}
	
	@GetMapping("/buscar/destino/{destino}")
	public ResponseEntity<?> buscarPorDestino(@PathVariable String destino) {
		List<Mercancia> mercancias = mercanciaService.buscarPorDestino(destino);
		return ResponseEntity.ok(mercancias);
	}
	
	@GetMapping("/buscar/peso-maximo/{pesoMaximo}")
	public ResponseEntity<?> buscarPorPesoMaximo(@PathVariable Double pesoMaximo) {
		List<Mercancia> mercancias = mercanciaService.buscarPorPesoMaximo(pesoMaximo);
		return ResponseEntity.ok(mercancias);
	}
}