package seguridad.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

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
@Document(collection = "mercancias")
public class Mercancia implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String descripcion;
	private String origen;
	private String destino;
	private Double pesoKg;
	private LocalDate fechaEntregaEstimada;
	private String estado;
	private Double distanciaKm;  //Añadimos kilómetros
	
}