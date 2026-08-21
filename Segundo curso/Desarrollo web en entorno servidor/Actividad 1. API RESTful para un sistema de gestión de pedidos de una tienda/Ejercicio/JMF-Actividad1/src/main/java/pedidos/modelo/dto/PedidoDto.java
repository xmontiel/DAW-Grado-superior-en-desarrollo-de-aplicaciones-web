package pedidos.modelo.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pedidos.modelo.entities.Pedido;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PedidoDto {
	private int idPedido;
	private LocalDate fecha;
	private int idUsuario;
	private String nombreUsuario;
	
	public static PedidoDto convertAPedidoDto(Pedido pedido) {
		PedidoDto dto = new PedidoDto();
		dto.setIdPedido(pedido.getIdPedido());
		dto.setFecha(pedido.getFecha());
		dto.setIdUsuario(pedido.getUsuario().getIdUsuario());
		dto.setNombreUsuario(pedido.getUsuario().getNombre());
		return dto;
	}
}