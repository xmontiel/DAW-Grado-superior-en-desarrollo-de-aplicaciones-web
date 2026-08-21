package pedidos.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pedidos.modelo.entities.Categoria;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoriaDto {
	private int idCategoria;
	private String nombre;
	private String descripcion;
	
	public static CategoriaDto convertACategoriaDto(Categoria categoria) {
		CategoriaDto dto = new CategoriaDto();
		dto.setIdCategoria(categoria.getIdCategoria());
		dto.setNombre(categoria.getNombre());
		dto.setDescripcion(categoria.getDescripcion());
		return dto;
	}
}