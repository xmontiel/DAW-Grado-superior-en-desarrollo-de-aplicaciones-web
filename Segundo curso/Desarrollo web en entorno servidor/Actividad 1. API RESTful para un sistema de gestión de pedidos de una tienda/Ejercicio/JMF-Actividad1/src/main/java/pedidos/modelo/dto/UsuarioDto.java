package pedidos.modelo.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pedidos.modelo.entities.Usuario;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioDto {
	private int idUsuario;
	private String nombre;
	private String email;
	private int enabled;
	private String rol;
	private LocalDate fechaRegistro;
	
	public static UsuarioDto convertAUsuarioDto(Usuario usuario) {
		UsuarioDto dto = new UsuarioDto();
		dto.setIdUsuario(usuario.getIdUsuario());
		dto.setNombre(usuario.getNombre());
		dto.setEmail(usuario.getEmail());
		dto.setEnabled(usuario.getEnabled());
		dto.setRol(usuario.getRol());
		dto.setFechaRegistro(usuario.getFechaRegistro());
		return dto;
	}
}