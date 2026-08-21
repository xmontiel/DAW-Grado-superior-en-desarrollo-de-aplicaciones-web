package pedidos.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pedidos.modelo.dto.UsuarioDto;
import pedidos.modelo.repository.UsuarioRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoRestController {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@GetMapping("/clientes")
	List<UsuarioDto> clientesConPedidos() {
		return usuarioRepo.findClientesConPedidos()
				.stream()
				.map(usuario -> UsuarioDto.convertAUsuarioDto(usuario))
				.toList();
	}
}