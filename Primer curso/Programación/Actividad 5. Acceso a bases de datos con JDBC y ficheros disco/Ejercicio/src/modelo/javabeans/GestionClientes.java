package modelo.javabeans;

import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jdbc;
import principales.Cliente;

public class GestionClientes {
	private static Scanner leer = new Scanner(System.in);
	private static ClienteDao miagenda = new ClienteDaoImplMy8Jdbc();

	public static void main(String[] args) {
		int opcion = 0;
		
		do {
			opcion = pintarmenu();
			switch(opcion) {
			case 1:
				procesarInsertOne();
				break;
			case 2:
				procesarFindById();
				break;
			case 3:
				procesarFindAll();
				break;
			case 4:
				procesarDeleteOne();
				break;
			case 5:
				procesarExportar();
				break;
			case 6:
				procesarImportar();
				break;
			} 
		} while (opcion != 7);
			System.out.println("Fin de la aplicación");
			leer.close();
	}
	
		public static int pintarmenu() {
			int opcion = 0;
			System.out.println("1. Alta del Cliente");
			System.out.println("2. Buscar un Cliente");
			System.out.println("3. Mostrar Todos.");
			System.out.println("4. Eliminar un cliente");
			System.out.println("5. Exportar a fichero");
			System.out.println("6. Importar desde fichero");
			System.out.println("7. Salir");
			System.out.println("\nTeclea una opción, 7 para salir");
			opcion = leer.nextInt();
			while (opcion < 1 || opcion > 8) {
				System.out.println("Opción incorrecta, válidos del 1 al 7");
				opcion = leer.nextInt();
			}		
		return opcion;
	}
		
		public static void procesarInsertOne() {
			System.out.println("Dame el cif");
			String cif = leer.next();
			System.out.println("Dame el nombre");
			String nombre = leer.next();
			System.out.println("Dame los apellidos");
			String apellidos = leer.next();
			System.out.println("Dame el domicilio");
			String domicilio = leer.next();
			System.out.println("Dame la facturacion anual");
			double facturacionAnual = leer.nextDouble();
			System.out.println("Dame el número de empleados");
			int numeroEmpleados = leer.nextInt();
			Cliente cliente = new Cliente(cif, nombre, apellidos, domicilio, facturacionAnual, numeroEmpleados);
			if (miagenda.insertOne(cliente) == 1)
				System.out.println("Alta confirmada");
			else
				System.out.println("Este contacto ya existe");
		}
		
		public static void procesarFindById() {
			System.out.println("Dame el cif a buscar");
			String nombre = leer.next();
			Cliente cliente = miagenda.findById(nombre);
			if (cliente != null)
				System.out.println(cliente);
			else
				System.out.println("Este contacto no existe");
		}
		
		public static void procesarFindAll() {
			for (Cliente cliente: miagenda.findAll())
				System.out.println(cliente);
		}
		
		public static void procesarDeleteOne() {
			System.out.println("Dame el cif a borrar");
			String nombre = leer.next();
			Cliente cliente = miagenda.findById(nombre);
			if (cliente != null)
				System.out.println("Borrado efectuado con exito");
			else
				System.out.println("Este contacto no existe");
		}
		
		public static void procesarExportar() {
			System.out.println("Dame el nombre del archivo a exportar");
			String nombre = leer.next();
			System.out.println(miagenda.exportar(nombre));
		}
		
		public static void procesarImportar() {
			System.out.println("Dame el nombre del archivo a importar desde d:/");
			String nombre = leer.next();
			System.out.println(miagenda.importar(nombre));
		}
		
		
	
}