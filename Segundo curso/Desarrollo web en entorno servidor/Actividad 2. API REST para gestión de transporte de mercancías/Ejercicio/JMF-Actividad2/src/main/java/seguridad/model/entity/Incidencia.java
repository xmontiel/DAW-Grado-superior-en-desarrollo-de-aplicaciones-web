package seguridad.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = "id")
@Document(collection = "incidencias")
public class Incidencia implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String camionId;
	private String descripcion;
	private LocalDateTime fecha;
	private String tipo;
	private String estado;
}