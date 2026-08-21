package pedidos.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pedidos.modelo.dto.LineaPedidoDto;
import pedidos.modelo.entities.LineasPedido;
import pedidos.modelo.repository.LineasPedidoRepository;

@RestController
@RequestMapping("/lp")
public class LineasPedidoRestController {
	
	@Autowired
	private LineasPedidoRepository lpRepo;
	
	@GetMapping("/")
	List<LineaPedidoDto> todas(){
		return lpRepo.findAll()
				.stream()
				.map(linea -> LineaPedidoDto.convertALineaPedidoDto(linea))
				.toList();
	
	}
	
	@GetMapping("/porPedido/{idPedido}")
	List<LineaPedidoDto> porPedido(@PathVariable int idPedido){
		return lpRepo.findByPedidoIdPedido(idPedido)
				.stream()
				.map(linea -> LineaPedidoDto.convertALineaPedidoDto(linea))
				.toList();
	}
	
	@GetMapping("/groupByPedido")
	Map<Integer, Double> groupBy(){
		return lpRepo.findAll()
				.stream()
				.collect(Collectors.groupingBy(
						lp->lp.getPedido().getIdPedido(),
						Collectors.
						summingDouble(lp-> lp.getPrecioUnitario() * lp.getCantidad())));
	}
	
	//Obtener cantidad total vendida de cada producto
	@GetMapping("/venta-productos")
	List<Map<String, Object>> ventaProductos() {
		List<Object[]> resultados = lpRepo.findVentaProductos();
		return resultados.stream()
				.map(resultado -> {
					Map<String, Object> map = new HashMap<>();
					map.put("idProducto", resultado[0]);
					map.put("nombreProducto", resultado[1]);
					map.put("cantidadVendida", resultado[2]);
					return map;
				})
				.toList();
	}

}
