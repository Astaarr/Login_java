package vista;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import controlador.LoginControlador;

import java.awt.Color;
import java.awt.Font;

public class Login extends JFrame {
    private JLabel usuarioLabel, contrasenaLabel, mensajeLabel;
    private JTextField usuarioField;
    private JButton loginButton;
    private JPasswordField contrasenaPassword;
    private LoginControlador loginControlador;

    public Login(String titulo) {
        super(titulo);
        setBackground(new Color(242, 242, 242));
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
    	//Adaptar la apariencia del SO donde se ejecuta
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Añadir titulo a la ventana
		setTitle("Ventana Login");
		
		//Añadir operación de cierre de las ventanas
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//layout absoluto
		getContentPane().setLayout(null);
		
		//Tamaño y posicion de ventana
		setSize(400, 200);
		//setLocation(null);
		
		
		/* COMPONENTES */

        // JLabel usuario
		usuarioLabel = new JLabel("Usuario:");
		usuarioLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usuarioLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		usuarioLabel.setBounds(61, 16, 68, 19);
		getContentPane().add(usuarioLabel);


        // JLabel contraseña
		contrasenaLabel = new JLabel("Contraseña:");
		contrasenaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		contrasenaLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		contrasenaLabel.setBounds(61, 57, 97, 19);
		getContentPane().add(contrasenaLabel);


        // JTextField usuario
		usuarioField = new JTextField();
		usuarioField.setFont(new Font("Verdana", Font.PLAIN, 14));
		usuarioField.setBackground(new Color(242, 242, 242));
		usuarioField.setBounds(158, 16, 146, 20);
		usuarioField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(29, 29, 27)));
		usuarioField.setColumns(10);
		getContentPane().add(usuarioField);

		
        // JPasswordField contraseña
		contrasenaPassword = new JPasswordField();
		contrasenaPassword.setFont(new Font("Verdana", Font.PLAIN, 14));
		contrasenaPassword.setBounds(158, 57, 146, 20);
		contrasenaPassword.setBackground(new Color(242, 242, 242));
		contrasenaPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(29, 29, 27)));
		getContentPane().add(contrasenaPassword);

		
        // JButton loginButton
		loginButton = new JButton("Entrar");
		loginButton.setBounds(158, 111, 97, 32);
		loginButton.setForeground(new Color(242, 242, 242));
		loginButton.setBorderPainted(false);
		loginButton.setBackground(new Color(29, 29, 27));
		getContentPane().add(loginButton);


    }

    public void setLoginControlador(LoginControlador loginControlador) {
        this.loginControlador = loginControlador;
    }
}
