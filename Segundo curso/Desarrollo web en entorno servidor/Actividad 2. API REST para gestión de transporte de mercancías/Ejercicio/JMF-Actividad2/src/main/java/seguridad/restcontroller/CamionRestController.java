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

import seguridad.model.dtos.CamionDto;
import seguridad.model.entity.Camion;
import seguridad.model.service.CamionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/camiones")
public class CamionRestController {
	
	@Autowired
	private CamionService camionService;
	
	@GetMapping
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<?> obtenerTodos(Authentication auth) {
		String username = auth.getName();
		List<Camion> camiones = camionService.obtenerPorConductor(username);
		return ResponseEntity.ok(camiones);
	}
	
	@GetMapping("/disponibles")
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<?> obtenerDisponibles(Authentication auth) {
		String username = auth.getName();
		List<Camion> camiones = camionService.obtenerDisponiblesPorConductor(username);
		return ResponseEntity.ok(camiones);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<?> obtenerPorId(@PathVariable String id, Authentication auth) {
		Camion camion = camionService.obtenerPorId(id);
		if (camion != null) {
			String username = auth.getName();
			if (!camion.getConductorId().equals(username)) {
				return ResponseEntity.status(403).body("No tienes permiso para ver este camión");
			}
			return ResponseEntity.ok(camion);
		} else {
			return ResponseEntity.status(404).body("Camión no encontrado");
		}
	}
	
	@PostMapping
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<?> crear(@RequestBody CamionDto camionDto, Authentication auth) {
		String username = auth.getName();
		
		Camion camion = Camion.builder()
			.conductorId(username)
			.matricula(camionDto.getMatricula())
			.modelo(camionDto.getModelo())
			.capacidadKg(camionDto.getCapacidadKg())
			.estado(camionDto.getEstado())
			.build();
		
		Camion camionGuardado = camionService.crear(camion);
		return ResponseEntity.ok(camionGuardado);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<?> actualizar(@PathVariable String id, @RequestBody CamionDto camionDto, Authentication auth) {
		Camion camionExistente = camionService.obtenerPorId(id);
		
		if (camionExistente == null) {
			return ResponseEntity.status(404).body("Camión no encontrado");
		}
		
		String username = auth.getName();
		if (!camionExistente.getConductorId().equals(username)) {
			return ResponseEntity.status(403).body("No tienes permiso para modificar este camión");
		}
		
		Camion camion = Camion.builder()
			.conductorId(username)
			.matricula(camionDto.getMatricula())
			.modelo(camionDto.getModelo())
			.capacidadKg(camionDto.getCapacidadKg())
			.estado(camionDto.getEstado())
			.build();
		
		Camion camionActualizado = camionService.actualizar(id, camion);
		return ResponseEntity.ok(camionActualizado);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<?> eliminar(@PathVariable String id, Authentication auth) {
		Camion camion = camionService.obtenerPorId(id);
		
		if (camion == null) {
			return ResponseEntity.status(404).body("Camión no encontrado");
		}
		
		String username = auth.getName();
		if (!camion.getConductorId().equals(username)) {
			return ResponseEntity.status(403).body("No tienes permiso para eliminar este camión");
		}
		
		camionService.eliminar(id);
		return ResponseEntity.ok("Camión eliminado correctamente");
	}
}