package pedidos.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pedidos.modelo.dto.PedidoDto;
import pedidos.modelo.dto.UsuarioDto;
import pedidos.modelo.repository.PedidoRepository;
import pedidos.modelo.repository.UsuarioRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoRestController {
	
	@Autowired
	private PedidoRepository pedidoRepo;
	@Autowired
	private UsuarioRepository usuarioRepo;
		
	@GetMapping("/clientes")
	List<UsuarioDto> clientesConPedidos() {
		return usuarioRepo.findClientesConPedidos()
				.stream()
				.map(usuario -> UsuarioDto.convertAUsuarioDto(usuario))
				.toList();
	}
	
	//Pedidos de un cliente
	@GetMapping("/cliente/{idCliente}")
	List<PedidoDto> pedidosPorCliente(@PathVariable int idCliente) {
		return pedidoRepo.findByUsuarioIdUsuario(idCliente)
				.stream()
				.map(pedido -> PedidoDto.convertAPedidoDto(pedido))
				.toList();
	}
	
	//Pedidos con más de N líneas
	@GetMapping("/mas-de/{numLineas}/lineas")
	List<PedidoDto> pedidosConMasDeNLineas(@PathVariable int numLineas) {
		return pedidoRepo.findPedidosConMasDeNLineas(numLineas)
				.stream()
				.map(pedido -> PedidoDto.convertAPedidoDto(pedido))
				.toList();
	}
	
}