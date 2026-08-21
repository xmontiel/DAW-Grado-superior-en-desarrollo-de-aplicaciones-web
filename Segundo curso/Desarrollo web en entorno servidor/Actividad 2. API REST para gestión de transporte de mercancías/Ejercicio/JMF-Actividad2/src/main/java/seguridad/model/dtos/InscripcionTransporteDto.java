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
public class InscripcionTransporteDto {
	private String id;
	private String camionId;
	private String mercanciaId;
	private LocalDateTime fechaInscripcion;
	private String estado;
}