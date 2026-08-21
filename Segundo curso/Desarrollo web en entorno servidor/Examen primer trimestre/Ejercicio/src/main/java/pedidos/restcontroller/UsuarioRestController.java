package pedidos.restcontroller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pedidos.modelo.dto.UsuarioDto;
import pedidos.modelo.repository.UsuarioRepository;

@RestController
@RequestMapping("/clientes")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@GetMapping("/por-email/{texto}")
	List<UsuarioDto> buscarPorEmail(@PathVariable String texto) {
		return usuarioRepo.findByEmailContaining(texto)
				.stream()
				.map(usuario -> UsuarioDto.convertAUsuarioDto(usuario))
				.toList();
	}
	
	@GetMapping("/algun-pedido")
	List<UsuarioDto> clientesConPedidos() {
		return usuarioRepo.findClientesConPedidos()
				.stream()
				.map(usuario -> UsuarioDto.convertAUsuarioDto(usuario))
				.toList();
	}
	
	@GetMapping("/despues-fecha/{fecha}")
	List<UsuarioDto> clientesDespuesFecha(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
		return usuarioRepo.findByFechaRegistroAfter(fecha)
				.stream()
				.map(usuario -> UsuarioDto.convertAUsuarioDto(usuario))
				.toList();
	}
	
	@GetMapping("/registro/{fecha}")
	List<UsuarioDto> clientesRegistroEnFecha(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
		return usuarioRepo.findByFechaRegistro(fecha)
				.stream()
				.map(usuario -> UsuarioDto.convertAUsuarioDto(usuario))
				.toList();
	}
}