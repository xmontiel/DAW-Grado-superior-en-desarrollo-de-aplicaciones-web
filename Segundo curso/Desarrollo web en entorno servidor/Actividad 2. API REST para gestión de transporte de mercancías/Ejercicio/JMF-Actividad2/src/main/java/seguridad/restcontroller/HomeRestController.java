package seguridad.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import seguridad.model.dtos.UsuarioLoginDto;
import seguridad.model.entity.Usuario;
import seguridad.model.service.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
public class HomeRestController {
	
	@Autowired
	private UsuarioService uservice;
	
	@GetMapping("/")
	public ResponseEntity<?> home() {
		return ResponseEntity.ok("API REST Logística - Transporte de Mercancías");
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UsuarioLoginDto usuDto) {
		if (uservice.buscarUsuario(usuDto.getUsername()) != null) {
			return ResponseEntity.status(400).body("El usuario ya existe");
		}
		
		Usuario nuevoUsuario = Usuario.builder()
			.username(usuDto.getUsername())
			.password("{noop}" + usuDto.getPassword())
			.nombre(usuDto.getUsername())
			.email(usuDto.getUsername() + "@logistica.com")
			.rol("ROLE_CONDUCTOR")
			.enabled(1)
			.build();
		
		Usuario usuarioGuardado = uservice.altaUsuario(nuevoUsuario);
		
		if (usuarioGuardado != null) {
			usuarioGuardado.setPassword(null);
			return ResponseEntity.ok(usuarioGuardado);
		} else {
			return ResponseEntity.status(500).body("Error al registrar el usuario");
		}
	}
}