package modelo;

import java.sql.*;

public class AccesoBD {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/uf10_pantallalogin";
	private String usuario = "root";
	private String pword = "root";
	
	// Establecer conexión
	public Connection getConexion() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, usuario, pword);
			//System.out.println("Conexión establecida!");
		}
		catch(Exception e) {
			System.err.println("Error al conectar con la BD ");
			e.printStackTrace();
		}
		return con;
	}
	
	// Cerrar conexión
	public void cerrarConexion(Connection c) {
		try {
			c.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
