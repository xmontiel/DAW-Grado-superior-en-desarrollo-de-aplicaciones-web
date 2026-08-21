package seguridad.model.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class IncidenciaDto {
	private String id;
	private String camionId;
	private String descripcion;
	private LocalDateTime fecha;
	private String tipo;
	private String estado;
}