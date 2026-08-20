package modelo.dao;

import java.util.List;

import principales.Cliente;

public interface ClienteDao {
	
	int insertOne(Cliente cliente);
	Cliente findById(String cif);
	List<Cliente> findAll();
	int deleteOne(String cif);
	String exportar(String nombreFichero);
	List<Cliente> importar(String nombreFichero);
	
}
