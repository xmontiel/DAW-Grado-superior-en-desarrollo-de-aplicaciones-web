package seguridad.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import seguridad.model.entity.InscripcionTransporte;

public interface InscripcionTransporteRepository extends MongoRepository<InscripcionTransporte, String> {
	
	List<InscripcionTransporte> findByMercanciaId(String mercanciaId);
	List<InscripcionTransporte> findByCamionId(String camionId);
}