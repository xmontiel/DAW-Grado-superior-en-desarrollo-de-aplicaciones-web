package seguridad.model.entity;

import java.io.Serializable;

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
@Document(collection = "camiones")
public class Camion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String conductorId;
	private String matricula;
	private String modelo;
	private Double capacidadKg;
	private String estado;
}