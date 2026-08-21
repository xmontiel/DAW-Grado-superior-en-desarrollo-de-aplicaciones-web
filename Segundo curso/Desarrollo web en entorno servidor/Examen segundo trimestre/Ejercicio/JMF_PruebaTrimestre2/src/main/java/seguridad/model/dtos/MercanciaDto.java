package seguridad.model.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MercanciaDto {
	private String id;
	private String descripcion;
	private String origen;
	private String destino;
	private Double pesoKg;
	private LocalDate fechaEntregaEstimada;
	private String estado;
	private Double distanciaKm;  //Añadimos kilómetros
	
}