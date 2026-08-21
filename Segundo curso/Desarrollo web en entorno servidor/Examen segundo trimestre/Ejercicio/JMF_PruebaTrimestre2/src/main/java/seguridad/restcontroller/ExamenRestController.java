package seguridad.restcontroller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import seguridad.model.entity.Camion;
import seguridad.model.entity.Mercancia;
import seguridad.model.entity.Usuario;
import seguridad.model.service.CamionService;
import seguridad.model.service.MercanciaService;
import seguridad.model.service.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/examen")
public class ExamenRestController {
	
	@Autowired
	private MercanciaService mercanciaService;
	
	@Autowired
	private CamionService camionService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	//▸	Buscar mercancías por origen, destino o peso máximo.
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
	
	//▸	Asignar camión a conductor
	@PutMapping("/asignar-camion/{camionId}/conductor/{conductorId}")
	@PreAuthorize("hasRole('EMPRESA')")
	public ResponseEntity<?> asignarCamionAConductor(
			@PathVariable String camionId, 
			@PathVariable String conductorId) {
		
		Usuario conductor = usuarioService.buscarUsuario(conductorId);
		if (conductor == null || !"ROLE_CONDUCTOR".equals(conductor.getRol())) {
			return ResponseEntity.status(404).body("No existe este conductor");
		}
		
		Camion camion = camionService.obtenerPorId(camionId);
		if (camion == null) {
			return ResponseEntity.status(404).body("No existe este camion");
		}
		
		camion.setConductorId(conductorId);
		Camion camionActualizado = camionService.actualizar(camionId, camion);
		
		return ResponseEntity.ok(camionActualizado);
	}
	
	//▸	Obtener el número total de mercancías agrupadas por estado (pendiente, asignada, entregada).
	@GetMapping("/mercancias-por-estado")
	@PreAuthorize("hasRole('EMPRESA')")
	public ResponseEntity<?> obtenerMercanciasAgrupadasPorEstado() {
		List<Mercancia> todasMercancias = mercanciaService.obtenerTodas();
		
		Map<String, Long> estadisticas = todasMercancias.stream()
			.collect(Collectors.groupingBy(
				Mercancia::getEstado,
				Collectors.counting()
			));
		
		return ResponseEntity.ok(estadisticas);
	}
	
	//▸	Calcular la capacidad total en kilogramos de los camiones activos por conductor.
	@GetMapping("/capacidad-camiones-por-conductor")
	@PreAuthorize("hasRole('EMPRESA')")
	public ResponseEntity<?> calcularCapacidadCamionesPorConductor() {
		List<Camion> todosCamiones = camionService.obtenerTodos();
		
		Map<String, Double> capacidadPorConductor = todosCamiones.stream()
			.filter(camion -> "ACTIVO".equals(camion.getEstado()))
			.collect(Collectors.groupingBy(
				Camion::getConductorId,
				Collectors.summingDouble(Camion::getCapacidadKg)
			));
		
		return ResponseEntity.ok(capacidadPorConductor);
	}
	
	//▸	Listar todas las mercancías cuya ruta total supera los 500 kilómetros.
	@GetMapping("/mercancias-ruta-larga")
	@PreAuthorize("hasAnyRole('EMPRESA', 'CONDUCTOR')")
	public ResponseEntity<?> obtenerMercanciasRutaLarga() {
		List<Mercancia> todasMercancias = mercanciaService.obtenerTodas();
		
		List<Mercancia> mercanciasRutaLarga = todasMercancias.stream()
			.filter(m -> m.getDistanciaKm() != null && m.getDistanciaKm() > 500)
			.collect(Collectors.toList());
		
		return ResponseEntity.ok(mercanciasRutaLarga);
	}
	
}