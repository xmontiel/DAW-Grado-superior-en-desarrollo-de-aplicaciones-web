package seguridad.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seguridad.model.entity.InscripcionTransporte;
import seguridad.model.entity.Mercancia;
import seguridad.model.repository.CamionRepository;
import seguridad.model.repository.InscripcionTransporteRepository;
import seguridad.model.repository.MercanciaRepository;

@Service
public class MercanciaServiceImpl implements MercanciaService {
	
	@Autowired
	private MercanciaRepository mercanciaRepository;
	
	@Autowired
	private CamionRepository camionRepository;
	
	@Autowired
	private InscripcionTransporteRepository inscripcionRepository;
	
	@Override
	public List<Mercancia> obtenerTodas() {
		return mercanciaRepository.findAll();
	}
	
	@Override
	public Mercancia obtenerPorId(String id) {
		return mercanciaRepository.findById(id).orElse(null);
	}
	
	@Override
	public Mercancia crear(Mercancia mercancia) {
		return mercanciaRepository.save(mercancia);
	}
	
	@Override
	public Mercancia actualizar(String id, Mercancia mercancia) {
		Mercancia mercanciaExistente = mercanciaRepository.findById(id).orElse(null);
		if (mercanciaExistente != null) {
			mercanciaExistente.setDescripcion(mercancia.getDescripcion());
			mercanciaExistente.setOrigen(mercancia.getOrigen());
			mercanciaExistente.setDestino(mercancia.getDestino());
			mercanciaExistente.setPesoKg(mercancia.getPesoKg());
			mercanciaExistente.setFechaEntregaEstimada(mercancia.getFechaEntregaEstimada());
			mercanciaExistente.setEstado(mercancia.getEstado());
			return mercanciaRepository.save(mercanciaExistente);
		}
		return null;
	}
	
	@Override
	public void eliminar(String id) {
		mercanciaRepository.deleteById(id);
	}
	
	@Override
	public List<Mercancia> obtenerDisponibles() {
		return mercanciaRepository.findByEstado("PENDIENTE");
	}
	
	@Override
	public List<Mercancia> buscarPorOrigen(String origen) {
		return mercanciaRepository.findByOrigen(origen);
	}
	
	@Override
	public List<Mercancia> buscarPorDestino(String destino) {
		return mercanciaRepository.findByDestino(destino);
	}
	
	@Override
	public List<Mercancia> buscarPorPesoMaximo(Double pesoMaximo) {
		return mercanciaRepository.findByPesoKgLessThanEqual(pesoMaximo);
	}
	
	@Override
	public List<Mercancia> obtenerMercanciasPorConductor(String conductorId) {
		// 1. Obtener todos los camiones del conductor
		List<String> camionesIds = camionRepository.findByConductorId(conductorId)
				.stream()
				.map(camion -> camion.getId())
				.collect(Collectors.toList());
		
		if (camionesIds.isEmpty()) {
			return List.of();
		}
		
		// 2. Obtener todas las inscripciones aceptadas de esos camiones
		List<String> mercanciasIds = inscripcionRepository.findAll()
				.stream()
				.filter(inscripcion -> "ACEPTADA".equals(inscripcion.getEstado()))
				.filter(inscripcion -> camionesIds.contains(inscripcion.getCamionId()))
				.map(InscripcionTransporte::getMercanciaId)
				.distinct()
				.collect(Collectors.toList());
		
		if (mercanciasIds.isEmpty()) {
			return List.of();
		}
		
		// 3. Obtener las mercancías
		return mercanciaRepository.findAllById(mercanciasIds);
	}
}