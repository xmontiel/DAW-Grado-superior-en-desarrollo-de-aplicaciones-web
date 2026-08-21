package seguridad.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seguridad.model.entity.Camion;
import seguridad.model.repository.CamionRepository;

@Service
public class CamionServiceImpl implements CamionService {
	
	@Autowired
	private CamionRepository camionRepository;
	
	@Override
	public List<Camion> obtenerTodos() {
		return camionRepository.findAll();
	}
	
	@Override
	public Camion obtenerPorId(String id) {
		return camionRepository.findById(id).orElse(null);
	}
	
	@Override
	public Camion crear(Camion camion) {
		return camionRepository.save(camion);
	}
	
	@Override
	public Camion actualizar(String id, Camion camion) {
		Camion camionExistente = camionRepository.findById(id).orElse(null);
		if (camionExistente != null) {
			camionExistente.setConductorId(camion.getConductorId());
			camionExistente.setMatricula(camion.getMatricula());
			camionExistente.setModelo(camion.getModelo());
			camionExistente.setCapacidadKg(camion.getCapacidadKg());
			camionExistente.setEstado(camion.getEstado());
			return camionRepository.save(camionExistente);
		}
		return null;
	}
	
	@Override
	public void eliminar(String id) {
		camionRepository.deleteById(id);
	}
	
	@Override
	public List<Camion> obtenerPorConductor(String conductorId) {
		return camionRepository.findByConductorId(conductorId);
	}
	
	@Override
	public List<Camion> obtenerDisponiblesPorConductor(String conductorId) {
		return camionRepository.findByConductorIdAndEstado(conductorId, "ACTIVO");
	}
}