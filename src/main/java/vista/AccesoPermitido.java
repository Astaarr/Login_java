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
		
		// JLabel AccesoPermitido
		accesoPermitidoLabel = new JLabel("Acceso conseguido :)");
		accesoPermitidoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accesoPermitidoLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		accesoPermitidoLabel.setBounds(60,58,264,45);
		getContentPane().add(accesoPermitidoLabel);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}