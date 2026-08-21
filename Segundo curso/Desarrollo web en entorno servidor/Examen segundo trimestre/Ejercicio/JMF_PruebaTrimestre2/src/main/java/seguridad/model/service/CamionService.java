package seguridad.model.service;

import java.util.List;

import seguridad.model.entity.Camion;

public interface CamionService {
	
	List<Camion> obtenerTodos();
	Camion obtenerPorId(String id);
	Camion crear(Camion camion);
	Camion actualizar(String id, Camion camion);
	void eliminar(String id);
	List<Camion> obtenerPorConductor(String conductorId);
	List<Camion> obtenerDisponiblesPorConductor(String conductorId);
}