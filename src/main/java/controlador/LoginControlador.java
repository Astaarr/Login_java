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
        this.alertaLogin = new AlertaLogin("Alerta de Login");
        this.accesoBD = new AccesoBD();

        // Asignar este controlador al botón de login
        login.getLoginButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        usuario = login.getUsuarioField().getText();
        contraIntroducida = new String(login.getContrasenaPassword().getPassword());

        try {
            hacerConsulta();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void hacerConsulta() throws SQLException {
        Connection conexion = accesoBD.getConexion();
        String consulta = "SELECT * FROM usuarios WHERE usuario = ?";

        PreparedStatement statement = conexion.prepareStatement(consulta);
        statement.setString(1, usuario);

        ResultSet resultSet = statement.executeQuery();

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
                    alertaLogin.hacerVisible();
                    login.dispose();
                }
            }
        } else {
            usuarioEncontrado = false;
            contraCorrecta = false;
            nIntentos--;
            if (nIntentos == 0) {
                alertaLogin.hacerVisible();
                login.dispose();
            }
        }

        resultSet.close();
        statement.close();
    }
}
