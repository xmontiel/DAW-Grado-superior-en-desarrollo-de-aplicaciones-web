package seguridad.model.service;

import java.util.List;

import seguridad.model.entity.Incidencia;

public interface IncidenciaService {
	
	List<Incidencia> obtenerTodas();
	Incidencia obtenerPorId(String id);
	Incidencia crear(Incidencia incidencia);
	Incidencia actualizar(String id, Incidencia incidencia);
	void eliminar(String id);
	List<Incidencia> obtenerPorCamion(String camionId);
	List<Incidencia> obtenerIncidenciasActivasUltimoMes(String camionId);
}