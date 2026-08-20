package testactividad;

import negocio.ILocationDao;
import negocio.LocationDaoImplList;

public class TestActividadLocation {

	public static void main(String[] args) {

		//Test LocationDaoImplList
		System.out.println("\nTest LocationDaoImplList\n");
		
		ILocationDao iLocationDao = new LocationDaoImplList();
		
		System.out.println("Deberían salir las dos direcciones de Madrid:");
		System.out.println(iLocationDao.buscarPorCity("Madrid"));
		
		System.out.println("Debería salir solo la dirección de Gualadajara:");
		System.out.println(iLocationDao.buscarPorPostalCode("19002"));
		
		System.out.println("Deberían salir las tres direcciones:");
		System.out.println(iLocationDao.buscarPorPais("ES"));
		
		System.out.println("Debería salir vacío:");
		System.out.println(iLocationDao.buscarPorPais("CH"));
		//Podríamos implementar un syso de error en el método, pero no es buena práctica.

	}

}
