package seguridad.model.service;

import java.util.List;

import seguridad.model.entity.Mercancia;

public interface MercanciaService {
	
	List<Mercancia> obtenerTodas();
	Mercancia obtenerPorId(String id);
	Mercancia crear(Mercancia mercancia);
	Mercancia actualizar(String id, Mercancia mercancia);
	void eliminar(String id);
	List<Mercancia> obtenerDisponibles();
	List<Mercancia> buscarPorOrigen(String origen);
	List<Mercancia> buscarPorDestino(String destino);
	List<Mercancia> buscarPorPesoMaximo(Double pesoMaximo);
	List<Mercancia> obtenerMercanciasPorConductor(String conductorId);
}