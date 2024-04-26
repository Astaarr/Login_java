package vista;

import java.awt.Font;

import javax.swing.*;

public class AlertaLogin extends JFrame {

	private JLabel alertaLabel;

	public AlertaLogin(String titulo) {
		super(titulo);
		inicializarAlertaLogin();
	}

	private void inicializarAlertaLogin() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		// JLabel alertaLabel
		alertaLabel = new JLabel();
		alertaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		alertaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		alertaLabel.setBounds(10, 10, 364, 140);
		getContentPane().add(alertaLabel);
	}

	public void setMensaje(String mensaje) {
		alertaLabel.setText(mensaje);
	}

	public void hacerVisible() {
		setVisible(true);
	}
}
