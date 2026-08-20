package negocio;

import java.util.ArrayList;
import java.util.List;
import javabean.Familia;
import javabean.Producto;
import javabean.Proveedor;

public class CatalogoProductosImpl implements ICatalogo{
	
	private ArrayList<Producto> lista;
	
	

	public CatalogoProductosImpl() {
		lista = new ArrayList<Producto>();
		cargarDatos();
	}

	private void cargarDatos() {
		
		Familia familia = new Familia(1,"Normal");
		Proveedor proveedor = new Proveedor("101", "Carlos", "Ventas", "b@b.es", "España");
		
		lista.add(new Producto(1, "Camiseta", "Camiseta negra hombre talla M", "Nike", "Negro", 40.00, familia , proveedor));
		lista.add(new Producto(2, "Pantalón", "Pantalón de Hombre negro", "Levi's", "Azul", 60.00,familia , proveedor));
		lista.add(new Producto(3, "Zapatillas", "Zapatillas deportivas de Mujer talla 37", "Adidas", "Blanco", 80.00,familia , proveedor));
		lista.add(new Producto(4, "Sudadera", "Sudadera con capucha de mujer", "Puma", "Gris", 55.00,familia , proveedor));
		lista.add(new Producto(5, "Chaqueta", "Chaqueta de cuero de mujer talla M", "Zara", "Negro", 120.00, familia , proveedor));

	}

	@Override
	public Producto buscarUno(long idProducto) {
		for (Producto ele: lista) {
			if (ele.getIdProducto() == idProducto)
				return ele;
		}
		return null;
	}

	@Override
	public List<Producto> buscarTodos() {
		return lista;
	}

	@Override
	public List<Producto> productosPorFamilia(int idFamilia) {
		List<Producto> aux = new ArrayList<Producto>();
		for (Producto producto: lista) {
			if (producto.getFamilia().getIdFamilia() == idFamilia)
				aux.add(producto);
		}	
		return aux;
	}

	@Override
	public List<Producto> productosPorPrecioMayorQue(double precio) {
		List<Producto> aux = new ArrayList<Producto>();
		for (Producto producto: lista) {
			if (producto.getPrecio() > precio)
				aux.add(producto);
		}
		return aux;
	}

	@Override
	public List<Producto> productosPorDescripcionLarga(String subCadena) {
		List<Producto> aux = new ArrayList<Producto>();
		for (Producto producto: lista) {
			if (producto.getDescripcionLarga().contains(subCadena))
				aux.add(producto);
		}
		return aux;
	}

	@Override
	public List<Producto> productosPorProveedor(String cif) {
		List<Producto> aux = new ArrayList<Producto>();
		for (Producto producto: lista) {
			if (producto.getProveedor().getCif().equals(cif))
				aux.add(producto);
		}
		return aux;
	}
	
}


