package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vista.AccesoPermitido;
import vista.AlertaLogin;
import vista.Login;
import modelo.AccesoBD;

public class LoginControlador implements ActionListener {

	Login login;
	AccesoPermitido accesopermitido;
	AlertaLogin alertalogin;
	
	public String usuario;
	public String contraIntroducida;
	public String contraBD;
	public int nIntentos = 3;
	public boolean usuarioEncontrado = false;
	public boolean contraCorrecta = false;

	AccesoBD c = new AccesoBD();

	public LoginControlador(Login l, AccesoPermitido ap, AlertaLogin al) {
	    this.login = l;
	    this.accesopermitido = ap;
	    this.alertalogin = al;
	}

	@Override
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		usuario = login.getUsuarioField().getText();
		System.out.println(usuario);

		contraIntroducida = login.getContrasenaPassword().getText();
		System.out.println(contraIntroducida);

		try {
			hacerConsulta();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void hacerConsulta() throws SQLException {
		
		Connection conexion = c.getConexion();
		
		String consulta = "SELECT * FROM usuarios WHERE usuario = ?";

		PreparedStatement statement = conexion.prepareStatement(consulta);

		statement.setString(1, usuario);
		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			usuarioEncontrado = true;
			System.out.println("Usuario encontrado.");
			contraBD = resultSet.getString("contra");
			if(contraIntroducida.equals(contraBD)) {
				contraCorrecta = true;
				System.out.println("Contraseña Correcta");
				login.dispose();
				accesopermitido.hacerVisible();
			} else {
				contraCorrecta = false;
				System.out.println("Contraseña Incorrecta");
				nIntentos --;
			}
		} else {
			System.out.println("Usuario no encontrado.");
			usuarioEncontrado = false;
			contraCorrecta = false;
		}

		resultSet.close();
		statement.close();
	}

}
