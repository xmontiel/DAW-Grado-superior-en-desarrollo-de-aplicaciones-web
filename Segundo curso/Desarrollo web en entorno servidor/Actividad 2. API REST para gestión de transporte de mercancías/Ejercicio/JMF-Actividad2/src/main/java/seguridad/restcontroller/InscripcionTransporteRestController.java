package seguridad.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import seguridad.model.dtos.InscripcionTransporteDto;
import seguridad.model.entity.InscripcionTransporte;
import seguridad.model.service.InscripcionTransporteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/inscripciones")
public class InscripcionTransporteRestController {
	
	@Autowired
	private InscripcionTransporteService inscripcionService;
	
	@GetMapping
	public ResponseEntity<?> obtenerTodas() {
		List<InscripcionTransporte> inscripciones = inscripcionService.obtenerTodas();
		return ResponseEntity.ok(inscripciones);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable String id) {
		InscripcionTransporte inscripcion = inscripcionService.obtenerPorId(id);
		if (inscripcion != null) {
			return ResponseEntity.ok(inscripcion);
		} else {
			return ResponseEntity.status(404).body("Inscripción no encontrada");
		}
	}
	
	@PostMapping
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<?> crear(@RequestBody InscripcionTransporteDto inscripcionDto) {
		InscripcionTransporte inscripcion = InscripcionTransporte.builder()
			.camionId(inscripcionDto.getCamionId())
			.mercanciaId(inscripcionDto.getMercanciaId())
			.build();
		
		InscripcionTransporte inscripcionGuardada = inscripcionService.crear(inscripcion);
		return ResponseEntity.ok(inscripcionGuardada);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('EMPRESA')")
	public ResponseEntity<?> actualizar(@PathVariable String id, @RequestBody InscripcionTransporteDto inscripcionDto) {
		InscripcionTransporte inscripcion = InscripcionTransporte.builder()
			.camionId(inscripcionDto.getCamionId())
			.mercanciaId(inscripcionDto.getMercanciaId())
			.estado(inscripcionDto.getEstado())
			.build();
		
		InscripcionTransporte inscripcionActualizada = inscripcionService.actualizar(id, inscripcion);
		if (inscripcionActualizada != null) {
			return ResponseEntity.ok(inscripcionActualizada);
		} else {
			return ResponseEntity.status(404).body("Inscripción no encontrada");
		}
	}
	
	@GetMapping("/mercancia/{mercanciaId}")
	public ResponseEntity<?> obtenerPorMercancia(@PathVariable String mercanciaId) {
		List<InscripcionTransporte> inscripciones = inscripcionService.obtenerPorMercancia(mercanciaId);
		return ResponseEntity.ok(inscripciones);
	}
	
	@GetMapping("/camion/{camionId}")
	public ResponseEntity<?> obtenerPorCamion(@PathVariable String camionId) {
		List<InscripcionTransporte> inscripciones = inscripcionService.obtenerPorCamion(camionId);
		return ResponseEntity.ok(inscripciones);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('EMPRESA')")
	public ResponseEntity<?> eliminar(@PathVariable String id) {
		InscripcionTransporte inscripcion = inscripcionService.obtenerPorId(id);
		if (inscripcion != null) {
			inscripcionService.eliminar(id);
			return ResponseEntity.ok("Inscripción eliminada correctamente");
		} else {
			return ResponseEntity.status(404).body("Inscripción no encontrada");
		}
	}
	
}