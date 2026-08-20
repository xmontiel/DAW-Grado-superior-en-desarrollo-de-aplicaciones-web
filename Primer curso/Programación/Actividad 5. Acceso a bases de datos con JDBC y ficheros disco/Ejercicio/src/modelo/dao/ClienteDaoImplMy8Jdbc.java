package modelo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principales.Cliente;

public class ClienteDaoImplMy8Jdbc extends AbsGenericoDaoImpl implements ClienteDao {

	public ClienteDaoImplMy8Jdbc() {
		super();
	}
	
	@Override
	public int insertOne(Cliente cliente) {
		sql = "insert into clientes (cif, nombre, apellidos, domicilio, facturacion_anual, numero_empleados) values (?,?,?,?,?,?)";
		filas=0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getCif());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setString(4, cliente.getDomicilio());
			ps.setDouble(5, cliente.getFacturacionAnual());
			ps.setInt(6, cliente.getNumeroEmpleados());
			filas = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			filas = 0;
		}		
		return filas;
	}

	@Override
	public Cliente findById(String cif) {
		sql = "select * from clientes where cif = ?";
		Cliente cliente = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cif);
			rs = ps.executeQuery();		
			if(rs.next()) {
				cliente = new Cliente();
				cliente.setCif(rs.getString("cif"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellidos(rs.getString("apellidos"));
				cliente.setDomicilio(rs.getString("domicilio"));
				cliente.setFacturacionAnual(rs.getDouble("facturacion_anual"));
				cliente.setNumeroEmpleados(rs.getInt("numero_empleados"));				
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return cliente;
	}

	@Override
	public List<Cliente> findAll() {
		sql = "select * from clientes";
		List<Cliente> aux = new ArrayList<Cliente>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCif(rs.getString("cif"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellidos(rs.getString("apellidos"));
				cliente.setDomicilio(rs.getString("domicilio"));
				cliente.setFacturacionAnual(rs.getDouble("facturacion_anual"));
				cliente.setNumeroEmpleados(rs.getInt("numero_empleados"));	
				aux.add(cliente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
		
	}

	@Override
	public int deleteOne(String cif) {
		sql = "delete from clientes where cif = ?";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cif);
			filas = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			filas = -1;
		}
		return filas;
	}
	
	@Override
	public String exportar(String nombreFichero) {
		
		File fichero = new File("d:/" + nombreFichero);
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		
		try {
			fos = new FileOutputStream(fichero);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(findAll());
			return "Clientes bien exportados. Fichero creado en d:/";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "Fichero no existe";
		} finally {
			try {
				if (oos != null)
				oos.close();
				if (fos != null)
				fos.close();				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	@Override
	public List<Cliente> importar(String nombreFichero) {
		
	    File fichero = new File("d:/" + nombreFichero);
	    List<Cliente> aux = new ArrayList<>();
	    FileInputStream fis=null;
	    ObjectInputStream ois=null;
		try {
			fis = new FileInputStream(fichero);
			ois = new ObjectInputStream(fis);
			aux = (List<Cliente>) ois.readObject(); //¿Posible fallo de seguridad?
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				fis.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	    return aux;
	}

}

