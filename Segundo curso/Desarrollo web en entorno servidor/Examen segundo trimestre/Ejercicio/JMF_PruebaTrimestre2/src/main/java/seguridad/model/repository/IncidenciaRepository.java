package seguridad.model.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import seguridad.model.entity.Incidencia;

public interface IncidenciaRepository extends MongoRepository<Incidencia, String> {
	
	List<Incidencia> findByCamionId(String camionId);
	
	@Query("{ 'camionId': ?0, 'estado': 'ABIERTA', 'fecha': { $gte: ?1 } }")
	List<Incidencia> findIncidenciasActivasUltimoMes(String camionId, LocalDateTime fechaInicio);
}