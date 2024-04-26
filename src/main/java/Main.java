import javax.swing.SwingUtilities;

import controlador.LoginControlador;
import vista.Login;
import javax.swing.JFrame;
public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {				
				Login login = new Login("Login");
				LoginControlador loginControlador = new LoginControlador(login);
				login.setLocationRelativeTo(null); // Centra el JFrame en la pantalla
				login.setLoginControlador(loginControlador);
				login.setVisible(true);
			}
		});
	}
}
