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
		//Adaptar la apariencia del SO donde se ejecuta
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Añadir titulo a la ventana
		setTitle("Ventana Login");
		
		//Añadir operación de cierre de la ventana
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		//layout absoluto
		getContentPane().setLayout(null);
		
		//Tamaño y posicion de ventana
		setSize(400, 200);
		//setLocation(null);


		/* COMPONENTES */
		
		// JLabel alertaLabel
		alertaLabel = new JLabel();
		alertaLabel.setFont(new Font("Verdana", Font.BOLD, 12));
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
