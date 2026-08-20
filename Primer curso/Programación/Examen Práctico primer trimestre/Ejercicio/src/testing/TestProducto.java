package testing;

import javabean.Producto;

public class TestProducto {
	public static void main(String[] args) {
		
		Producto producto1 = new Producto();
		
		producto1.setCodigoDeBarras(66638424);
		producto1.setDescripcion("Camiseta");
		producto1.setPrecioUnitario(20);
		producto1.setCantidadStock(200);
		producto1.setTalla("S");
		producto1.setColor("Amarilla");
		
		Producto producto2 = new Producto(44412335, "Chaqueta", 50, 100, "M", "Negra");
		
		//Prueba aumentarStock
		System.out.println("Prueba aumentarStock");
		System.out.println(producto1.getCantidadStock());
		System.out.println(producto2.getCantidadStock());
		
		producto1.aumentarStock(50);
		producto2.aumentarStock(50);
		
		System.out.println(producto1.getCantidadStock());
		System.out.println(producto2.getCantidadStock());
		
		//Prueba disminuirStock
		System.out.println("Prueba disminuirStock");
		
		System.out.println(producto1.getCantidadStock());
		System.out.println(producto2.getCantidadStock());
		
		producto1.disminuirStock(50);
		producto2.disminuirStock(50);
		
		System.out.println(producto1.getCantidadStock());
		System.out.println(producto2.getCantidadStock());
		
		System.out.println("Prueba disminuirStock por debajo de 0");
		System.out.println(producto1.getCantidadStock());
		System.out.println(producto2.getCantidadStock());
		
		producto1.disminuirStock(500);
		producto2.disminuirStock(500);
		
		System.out.println(producto1.getCantidadStock());
		System.out.println(producto2.getCantidadStock());
		
		//Prueba IVA
		System.out.println("Prueba IVA");

		System.out.println(producto1.getPrecioUnitario());
		System.out.println(producto2.getPrecioUnitario());
		
		producto1.precioConIva(4);
		producto2.precioConIva(20);
		
		System.out.println(producto1.getPrecioUnitario());
		System.out.println(producto2.getPrecioUnitario());

		
		
		
		
		
		
		
		
		
	}

}
