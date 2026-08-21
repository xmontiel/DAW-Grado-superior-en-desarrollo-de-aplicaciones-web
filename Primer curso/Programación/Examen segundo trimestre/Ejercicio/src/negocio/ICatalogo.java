package negocio;


import java.util.List;

import javabean.Producto;

public interface ICatalogo {
	
	Producto buscarUno(long idProducto);
	List<Producto> buscarTodos();
	List<Producto> productosPorFamilia(int idFamilia);
	List<Producto> productosPorPrecioMayorQue(double precio);
	//busca los productos cuya descripcion Larga coincida en cualquier parate del campo con la palabra
	// que le llega en el método; por ejemplo hombre 
	List<Producto> productosPorDescripcionLarga(String subCadena);
	List<Producto> productosPorProveedor(String cif);
	

	
}
