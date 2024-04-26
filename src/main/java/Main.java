import javax.swing.SwingUtilities;

import controlador.LoginControlador;
import vista.Login;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				// Credenciales
            	// Usuario : root
            	// Contraseña : 123
				
				Login l = new Login("Login");
				LoginControlador loginControlador = new LoginControlador(l);
				l.setLoginControlador(loginControlador);
				l.setVisible(true);
			}
		});
	}
}
