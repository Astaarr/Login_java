package vista;

import java.awt.Font;

import javax.swing.*;;

public class AlertaLogin extends JFrame {
	
	private JLabel alertaLabel;
	
	public AlertaLogin (String titulo) { 
		super(titulo); 
		inicializarAlertaLogin();
	}
	
	public void inicializarAlertaLogin(){
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		alertaLabel = new JLabel("");
		alertaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		alertaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		alertaLabel.setBounds(41, 42, 297, 80);
		getContentPane().add(alertaLabel);
	}
	public void hacerVisible() {
		setVisible(true);
	}
}
