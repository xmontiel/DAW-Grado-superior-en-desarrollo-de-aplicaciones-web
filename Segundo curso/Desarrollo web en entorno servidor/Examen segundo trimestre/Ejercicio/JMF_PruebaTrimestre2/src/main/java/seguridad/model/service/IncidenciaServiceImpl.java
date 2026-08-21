package seguridad.model.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seguridad.model.entity.Incidencia;
import seguridad.model.repository.IncidenciaRepository;

@Service
public class IncidenciaServiceImpl implements IncidenciaService {
	
	@Autowired
	private IncidenciaRepository incidenciaRepository;
	
	@Override
	public List<Incidencia> obtenerTodas() {
		return incidenciaRepository.findAll();
	}
	
	@Override
	public Incidencia obtenerPorId(String id) {
		return incidenciaRepository.findById(id).orElse(null);
	}
	
	@Override
	public Incidencia crear(Incidencia incidencia) {
		incidencia.setFecha(LocalDateTime.now());
		return incidenciaRepository.save(incidencia);
	}
	
	@Override
	public Incidencia actualizar(String id, Incidencia incidencia) {
		Incidencia incidenciaExistente = incidenciaRepository.findById(id).orElse(null);
		if (incidenciaExistente != null) {
			incidenciaExistente.setCamionId(incidencia.getCamionId());
			incidenciaExistente.setDescripcion(incidencia.getDescripcion());
			incidenciaExistente.setTipo(incidencia.getTipo());
			incidenciaExistente.setEstado(incidencia.getEstado());
			return incidenciaRepository.save(incidenciaExistente);
		}
		return null;
	}
	
	@Override
	public List<Incidencia> obtenerPorCamion(String camionId) {
		return incidenciaRepository.findByCamionId(camionId);
	}
	
	@Override
	public List<Incidencia> obtenerIncidenciasActivasUltimoMes(String camionId) {
		LocalDateTime fechaInicio = LocalDateTime.now().minusMonths(1);
		return incidenciaRepository.findIncidenciasActivasUltimoMes(camionId, fechaInicio);
	}
	
	@Override
	public void eliminar(String id) {
		incidenciaRepository.deleteById(id);
	}
}