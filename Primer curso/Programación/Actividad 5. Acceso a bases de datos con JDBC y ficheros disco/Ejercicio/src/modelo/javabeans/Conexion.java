package modelo.javabeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection conn;
	private String url = "jdbc:mysql://localhost:3306/proyectos_fp_2025";
	private String user = "root";
	private String password = "";
	
	private Conexion() {
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conexión establecida");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Conexión no establecida");
		}
	}
	
	//singleton
	public static Connection getConexion() {
		if (conn == null)
			new Conexion();
		return conn;
	}

}
