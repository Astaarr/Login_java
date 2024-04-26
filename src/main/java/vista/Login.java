package vista;

import javax.swing.*;

import controlador.LoginControlador;

import java.awt.Font;

public class Login extends JFrame {
    private JLabel usuarioLabel, contrasenaLabel, mensajeLabel;
    private JTextField usuarioField;
    private JButton loginButton;
    private JPasswordField contrasenaPassword;
    private LoginControlador loginControlador;

    public Login(String titulo) {
        super(titulo);
        inicializarLogin();
    }

    // GETTERS ANS SETTERS

    public JTextField getUsuarioField() {
        return usuarioField;
    }

    public JPasswordField getContrasenaPassword() {
        return contrasenaPassword;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    private void inicializarLogin() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // JLabel usuario
        usuarioLabel = new JLabel("Usuario");
        usuarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        usuarioLabel.setBounds(76, 22, 82, 26);
        getContentPane().add(usuarioLabel);


        // JLabel contraseña
        contrasenaLabel = new JLabel("Contraseña");
        contrasenaLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contrasenaLabel.setBounds(52, 70, 106, 26);
        getContentPane().add(contrasenaLabel);


        // JTextField usuario
        usuarioField = new JTextField();
        usuarioField.setBounds(158, 25, 147, 26);
        getContentPane().add(usuarioField);

        // JPasswordField contraseña
        contrasenaPassword = new JPasswordField();
        contrasenaPassword.setBounds(159, 73, 146, 26);
        getContentPane().add(contrasenaPassword);


        // JButton loginButton
        loginButton = new JButton("Login");
        loginButton.setBounds(188, 127, 82, 26);

        // Asignar el controlador al botón de login
        loginButton.addActionListener(loginControlador);

        getContentPane().add(loginButton);

        mensajeLabel = new JLabel("");
        mensajeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        mensajeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mensajeLabel.setBounds(10, 112, 159, 41);
        getContentPane().add(mensajeLabel);
    }

    // Método para establecer el controlador
    public void setLoginControlador(LoginControlador loginControlador) {
        this.loginControlador = loginControlador;
    }
}
