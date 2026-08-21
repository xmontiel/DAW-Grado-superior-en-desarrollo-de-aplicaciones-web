package pedidos.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pedidos.modelo.entities.Producto;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductoDto {
	private long idProducto;
	private String nombre;
	private double precio;
	private int stock;
	private int idCategoria;
	private String nombreCategoria;
	
	public static ProductoDto convertAProductoDto(Producto producto) {
		ProductoDto dto = new ProductoDto();
		dto.setIdProducto(producto.getIdProducto());
		dto.setNombre(producto.getNombre());
		dto.setPrecio(producto.getPrecio());
		dto.setStock(producto.getStock());
		dto.setIdCategoria(producto.getCategoria().getIdCategoria());
		dto.setNombreCategoria(producto.getCategoria().getNombre());
		return dto;
	}
}