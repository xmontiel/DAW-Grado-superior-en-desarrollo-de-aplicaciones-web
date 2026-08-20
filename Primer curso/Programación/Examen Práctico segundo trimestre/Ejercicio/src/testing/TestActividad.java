package testing;

import javabean.Familia;
import javabean.Producto;
import javabean.Proveedor;
import negocio.CatalogoProductosImpl;
import negocio.ICatalogo;



public class TestActividad {
	
	private static ICatalogo idao = new CatalogoProductosImpl();

	public static void main(String[] args) {
		buscarUno();
		buscarTodos();
		productosPorFamilia();
		productosPorPrecioMayorQue();
		productosPorDescripcionLarga();
		productosPorProveedor();
	}
	
	public static void buscarUno() {
		System.out.println("buscarUno");
		Producto producto = idao.buscarUno(4);
		System.out.println(producto);		
	System.out.println();	
	}
	
	public static void buscarTodos() {
		System.out.println("buscarTodos");
		for (Producto producto: idao.buscarTodos()) {
			System.out.println(producto);
		}	
	System.out.println();
	}
	
	public static void productosPorFamilia() {
		System.out.println("productosPorFamilia");
		System.out.println("productosPorFamilia 1");
		for (Producto producto: idao.productosPorFamilia(1)) {
			System.out.println(producto);
		}
		System.out.println("productosPorFamilia 2");
		for (Producto producto: idao.productosPorFamilia(2)) {
			System.out.println(producto);
		}
	System.out.println();
	}
	
	public static void productosPorPrecioMayorQue() {
		System.out.println("productosPorPrecioMayorQue");
		for (Producto producto: idao.productosPorPrecioMayorQue(70)) {
			System.out.println(producto);
		}
	System.out.println();	
	}
	
	public static void productosPorDescripcionLarga() {
		System.out.println("productosPorDescripcionLarga");
		for (Producto producto: idao.productosPorDescripcionLarga("mujer")) {
			System.out.println(producto);
		}
	System.out.println();		
	}
	
	public static void productosPorProveedor() {
		System.out.println("productosPorProveedor");
		System.out.println("productosPorProveedor 101");
		for (Producto producto: idao.productosPorProveedor("101")) {
			System.out.println(producto);
		}
		System.out.println("productosPorProveedor 102");
		for (Producto producto: idao.productosPorProveedor("102")) {
			System.out.println(producto);
		}
	System.out.println();	
	}
	
}
