package pedidos.modelo.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pedidos.modelo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	List<Usuario> findByEmailContaining(String texto);

	@Query("SELECT DISTINCT u FROM Usuario u JOIN Pedido p ON u.idUsuario = p.usuario.idUsuario")
	List<Usuario> findClientesConPedidos();
	
	List<Usuario> findByFechaRegistroAfter(LocalDate fecha);
	
	List<Usuario> findByFechaRegistro(LocalDate fecha);
}