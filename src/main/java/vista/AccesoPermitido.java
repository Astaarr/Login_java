package vista;

import javax.swing.*;
import java.awt.Font;

public class AccesoPermitido extends JFrame {

	private JLabel accesoPermitidoLabel;
	
	public AccesoPermitido (String titulo) { 
		super(titulo); 
		inicializarAccesoPermitido();
	}

	private void inicializarAccesoPermitido() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		// JLabel AccesoPermitido
		accesoPermitidoLabel = new JLabel("Acceso conseguido!");
		accesoPermitidoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		accesoPermitidoLabel.setBounds(99,83,240,101);
		getContentPane().add(accesoPermitidoLabel);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}