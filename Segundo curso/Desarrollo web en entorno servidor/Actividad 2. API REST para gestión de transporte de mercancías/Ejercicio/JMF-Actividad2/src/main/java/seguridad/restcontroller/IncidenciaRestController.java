package seguridad.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

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

import seguridad.model.dtos.IncidenciaDto;
import seguridad.model.entity.Camion;
import seguridad.model.entity.Incidencia;
import seguridad.model.service.CamionService;
import seguridad.model.service.IncidenciaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/incidencias")
public class IncidenciaRestController {
	
	@Autowired
	private IncidenciaService incidenciaService;
	
	@Autowired
	private CamionService camionService;
	
	@GetMapping
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<?> obtenerTodas(Authentication auth) {
		String conductorId = auth.getName();
		List<String> camionesIds = camionService.obtenerPorConductor(conductorId)
				.stream()
				.map(Camion::getId)
				.collect(Collectors.toList());
		
		List<Incidencia> incidencias = incidenciaService.obtenerTodas()
				.stream()
				.filter(inc -> camionesIds.contains(inc.getCamionId()))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(incidencias);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<?> obtenerPorId(@PathVariable String id, Authentication auth) {
		Incidencia incidencia = incidenciaService.obtenerPorId(id);
		if (incidencia != null) {
			Camion camion = camionService.obtenerPorId(incidencia.getCamionId());
			String conductorId = auth.getName();
			
			if (camion == null || !camion.getConductorId().equals(conductorId)) {
				return ResponseEntity.status(403).body("No tienes permiso para ver esta incidencia");
			}
			
			return ResponseEntity.ok(incidencia);
		} else {
			return ResponseEntity.status(404).body("Incidencia no encontrada");
		}
	}
	
	@PostMapping
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<?> crear(@RequestBody IncidenciaDto incidenciaDto, Authentication auth) {
		Camion camion = camionService.obtenerPorId(incidenciaDto.getCamionId());
		String conductorId = auth.getName();
		
		if (camion == null) {
			return ResponseEntity.status(404).body("Camión no encontrado");
		}
		
		if (!camion.getConductorId().equals(conductorId)) {
			return ResponseEntity.status(403).body("No puedes reportar incidencias en camiones que no son tuyos");
		}
		
		Incidencia incidencia = Incidencia.builder()
			.camionId(incidenciaDto.getCamionId())
			.descripcion(incidenciaDto.getDescripcion())
			.tipo(incidenciaDto.getTipo())
			.estado(incidenciaDto.getEstado())
			.build();
		
		Incidencia incidenciaGuardada = incidenciaService.crear(incidencia);
		return ResponseEntity.ok(incidenciaGuardada);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<?> actualizar(@PathVariable String id, @RequestBody IncidenciaDto incidenciaDto, Authentication auth) {
		Incidencia incidenciaExistente = incidenciaService.obtenerPorId(id);
		
		if (incidenciaExistente == null) {
			return ResponseEntity.status(404).body("Incidencia no encontrada");
		}
		
		Camion camion = camionService.obtenerPorId(incidenciaExistente.getCamionId());
		String conductorId = auth.getName();
		
		if (camion == null || !camion.getConductorId().equals(conductorId)) {
			return ResponseEntity.status(403).body("No tienes permiso para modificar esta incidencia");
		}
		
		Incidencia incidencia = Incidencia.builder()
			.camionId(incidenciaDto.getCamionId())
			.descripcion(incidenciaDto.getDescripcion())
			.tipo(incidenciaDto.getTipo())
			.estado(incidenciaDto.getEstado())
			.build();
		
		Incidencia incidenciaActualizada = incidenciaService.actualizar(id, incidencia);
		return ResponseEntity.ok(incidenciaActualizada);
	}
	
	@GetMapping("/camion/{camionId}")
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<?> obtenerPorCamion(@PathVariable String camionId, Authentication auth) {
		Camion camion = camionService.obtenerPorId(camionId);
		String conductorId = auth.getName();
		
		if (camion == null) {
			return ResponseEntity.status(404).body("Camión no encontrado");
		}
		
		if (!camion.getConductorId().equals(conductorId)) {
			return ResponseEntity.status(403).body("No tienes permiso para ver incidencias de este camión");
		}
		
		List<Incidencia> incidencias = incidenciaService.obtenerPorCamion(camionId);
		return ResponseEntity.ok(incidencias);
	}
	
	@GetMapping("/camion/{camionId}/activas-ultimo-mes")
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<?> obtenerIncidenciasActivasUltimoMes(@PathVariable String camionId, Authentication auth) {
		Camion camion = camionService.obtenerPorId(camionId);
		String conductorId = auth.getName();
		
		if (camion == null) {
			return ResponseEntity.status(404).body("Camión no encontrado");
		}
		
		if (!camion.getConductorId().equals(conductorId)) {
			return ResponseEntity.status(403).body("No tienes permiso para ver incidencias de este camión");
		}
		
		List<Incidencia> incidencias = incidenciaService.obtenerIncidenciasActivasUltimoMes(camionId);
		return ResponseEntity.ok(incidencias);
	}
	
	@GetMapping("/mis-incidencias-activas-ultimo-mes")
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<?> obtenerMisIncidenciasActivasUltimoMes(Authentication auth) {
		String conductorId = auth.getName();
		List<String> camionesIds = camionService.obtenerPorConductor(conductorId)
				.stream()
				.map(Camion::getId)
				.collect(Collectors.toList());
		
		List<Incidencia> todasIncidencias = camionesIds.stream()
				.flatMap(camionId -> incidenciaService.obtenerIncidenciasActivasUltimoMes(camionId).stream())
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(todasIncidencias);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<?> eliminar(@PathVariable String id, Authentication auth) {
		Incidencia incidencia = incidenciaService.obtenerPorId(id);
		
		if (incidencia == null) {
			return ResponseEntity.status(404).body("Incidencia no encontrada");
		}
		
		Camion camion = camionService.obtenerPorId(incidencia.getCamionId());
		String conductorId = auth.getName();
		
		if (camion == null || !camion.getConductorId().equals(conductorId)) {
			return ResponseEntity.status(403).body("No tienes permiso para eliminar esta incidencia");
		}
		
		incidenciaService.eliminar(id);
		return ResponseEntity.ok("Incidencia eliminada correctamente");
	}
}