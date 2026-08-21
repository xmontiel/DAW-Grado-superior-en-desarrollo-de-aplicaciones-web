package seguridad.model.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seguridad.model.entity.InscripcionTransporte;
import seguridad.model.entity.Mercancia;
import seguridad.model.repository.InscripcionTransporteRepository;
import seguridad.model.repository.MercanciaRepository;

@Service
public class InscripcionTransporteServiceImpl implements InscripcionTransporteService {
	
	@Autowired
	private InscripcionTransporteRepository inscripcionRepository;
	
	@Autowired
	private MercanciaRepository mercanciaRepository;
	
	@Override
	public List<InscripcionTransporte> obtenerTodas() {
		return inscripcionRepository.findAll();
	}
	
	@Override
	public InscripcionTransporte obtenerPorId(String id) {
		return inscripcionRepository.findById(id).orElse(null);
	}
	
	@Override
	public InscripcionTransporte crear(InscripcionTransporte inscripcion) {
		inscripcion.setFechaInscripcion(LocalDateTime.now());
		inscripcion.setEstado("PENDIENTE");
		return inscripcionRepository.save(inscripcion);
	}
	
	@Override
	public InscripcionTransporte actualizar(String id, InscripcionTransporte inscripcion) {
		InscripcionTransporte inscripcionExistente = inscripcionRepository.findById(id).orElse(null);
		if (inscripcionExistente != null) {
			inscripcionExistente.setCamionId(inscripcion.getCamionId());
			inscripcionExistente.setMercanciaId(inscripcion.getMercanciaId());
			inscripcionExistente.setEstado(inscripcion.getEstado());
			
			if ("ACEPTADA".equals(inscripcion.getEstado())) {
				Mercancia mercancia = mercanciaRepository.findById(inscripcionExistente.getMercanciaId()).orElse(null);
				if (mercancia != null) {
					mercancia.setEstado("ASIGNADA");
					mercanciaRepository.save(mercancia);
				}
			}
			
			return inscripcionRepository.save(inscripcionExistente);
		}
		return null;
	}
	
	@Override
	public List<InscripcionTransporte> obtenerPorMercancia(String mercanciaId) {
		return inscripcionRepository.findByMercanciaId(mercanciaId);
	}
	
	@Override
	public List<InscripcionTransporte> obtenerPorCamion(String camionId) {
		return inscripcionRepository.findByCamionId(camionId);
	}
	
	@Override
	public void eliminar(String id) {
		inscripcionRepository.deleteById(id);
	}
}