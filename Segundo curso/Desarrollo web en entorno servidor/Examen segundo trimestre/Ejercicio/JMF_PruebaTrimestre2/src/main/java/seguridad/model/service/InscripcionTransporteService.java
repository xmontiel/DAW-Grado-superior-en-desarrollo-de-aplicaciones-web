package seguridad.model.service;

import java.util.List;

import seguridad.model.entity.InscripcionTransporte;

public interface InscripcionTransporteService {
	
	List<InscripcionTransporte> obtenerTodas();
	InscripcionTransporte obtenerPorId(String id);
	InscripcionTransporte crear(InscripcionTransporte inscripcion);
	InscripcionTransporte actualizar(String id, InscripcionTransporte inscripcion);
	void eliminar(String id);
	List<InscripcionTransporte> obtenerPorMercancia(String mercanciaId);
	List<InscripcionTransporte> obtenerPorCamion(String camionId);
}