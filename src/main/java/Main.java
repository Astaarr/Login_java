import javax.swing.SwingUtilities;

import controlador.LoginControlador;
import vista.Login;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Login l = new Login("Login");
                LoginControlador loginControlador = new LoginControlador(l);
                l.setLoginControlador(loginControlador); // Agregar este método para establecer el controlador
                l.setVisible(true);
            }
        });
    }
}

