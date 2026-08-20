package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.javabeans.Conexion;

public class AbsGenericoDaoImpl {
	
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected String sql;
	protected int filas;
	
	public AbsGenericoDaoImpl() {
		conn = Conexion.getConexion();
	}

}
