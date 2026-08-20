package test.daos;

import modelo.dao.ClienteDaoImplMy8Jdbc;
import principales.Cliente;
import modelo.dao.ClienteDao;

public class TestClienteDao {
	public static void main(String[] args) {
		
		ClienteDao cdao = new ClienteDaoImplMy8Jdbc();
		
		//Crea uno
		Cliente cliente1 = new Cliente("C44444444", "Mario", "Duplantier Ondres", "Paris", 1000000, 4);
		System.out.println("Crea uno: " + cdao.insertOne(cliente1) + " fila creada");
		
		//Busca Uno
		System.out.println("Busca uno: " + cdao.findById("C44444444"));
		
		//Busca todos
		System.out.println("Busca todos: " + cdao.findAll());

		//Borra uno
		System.out.println("Borra uno: " + cdao.deleteOne("C44444444") + " fila borrada");
		System.out.println("Busqueda devuelve null: " + cdao.findById("C44444444"));
		
		//Exporta fichero
		System.out.println("Nombre de fichero correcto: " + cdao.exportar("hola.txt"));
		System.out.println("Nombre de fichero incorrecto: " + cdao.exportar(""));
		
		//Importa fichero
		System.out.println("Clientes importados: " + cdao.importar("hola.txt"));		
		
	}

}
