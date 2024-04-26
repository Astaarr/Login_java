package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vista.AccesoPermitido;
import vista.AlertaLogin;
import vista.Login;
import modelo.AccesoBD;

public class LoginControlador implements ActionListener {

	private Login login;
	private AccesoPermitido accesoPermitido;
	private AlertaLogin alertaLogin;

	private String usuario;
	private String contraIntroducida;
	private String contraBD;
	private int nIntentos = 3;
	private boolean usuarioEncontrado = false;
	private boolean contraCorrecta = false;

	private AccesoBD accesoBD;

	public LoginControlador(Login login) {
		this.login = login;
		this.accesoPermitido = new AccesoPermitido("Acceso Permitido");
		accesoPermitido.setLocationRelativeTo(null); // Centra el JFrame en la pantalla
		
		this.alertaLogin = new AlertaLogin("Alerta de Login");
		alertaLogin.setLocationRelativeTo(null); // Centra el JFrame en la pantalla
		this.accesoBD = new AccesoBD();

		login.getLoginButton().addActionListener(this);
	}

	// Metodo ActionPerformed para crear un evento al pulsar el boton login
	public void actionPerformed(ActionEvent e) {

		// Guarda en variables el usuario y contraseña introducida por el usuario
		usuario = login.getUsuarioField().getText();
		contraIntroducida = new String(login.getContrasenaPassword().getPassword());

		// Intentará de hacer la consulta
		try {
			hacerConsulta();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Metodo para realizar la consulta
	public void hacerConsulta() throws SQLException {
		// Creamos el objeto que hará referencia a la conexión de la base de datos
		Connection conexion = accesoBD.getConexion();

		// Guardamos la consulta en un string
		String consulta = "SELECT * FROM usuarios WHERE usuario = ?";

		PreparedStatement statement = conexion.prepareStatement(consulta);

		// Intercambiará el usuario introducido por ? en la consulta
		statement.setString(1, usuario);

		ResultSet resultSet = statement.executeQuery();

		// EVALUO LOS RESLUTADOS:
		// Si todo es correcto, aparecerá la ventana de acceso conseguido
		// Si el usuario está mal, nos dirá que no se ha encontrado en la base de datos
		// Si la contraseña está mal, nos saldrá una ventana informandonos de los intentos
		// Si no quedan intentos, nos saldrá una ventana informandonos que hemos agotado los intentos
		if (resultSet.next()) {
			usuarioEncontrado = true;
			contraBD = resultSet.getString("contra");

			if (contraIntroducida.equals(contraBD)) {
			    contraCorrecta = true;
			    login.dispose();
			    accesoPermitido.hacerVisible();
			} else {
			    contraCorrecta = false;
			    nIntentos--;
			    if (nIntentos == 0) {
			        alertaLogin.setMensaje("Contraseña incorrecta. Se han agotado los intentos.");
			        alertaLogin.hacerVisible();
			        login.dispose();
			    } else if (nIntentos > 0) {
			        alertaLogin.setMensaje("Contraseña incorrecta. Quedan: " + nIntentos + " intentos");
			        alertaLogin.hacerVisible();
			    }
			}
			
		} else {
			usuarioEncontrado = false;
			alertaLogin.setMensaje("Usuario no encontrado en la base de datos.");
			alertaLogin.hacerVisible();
		}

		resultSet.close();
		statement.close();
	}
}
