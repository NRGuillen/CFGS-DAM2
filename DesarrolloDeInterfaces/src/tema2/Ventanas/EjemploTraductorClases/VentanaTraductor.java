package tema2.Ventanas.EjemploTraductorClases;

import javax.swing.JFrame;

public class VentanaTraductor extends JFrame {

	public VentanaTraductor() {
		
		setTitle("TRADUCTOR ES-IN");
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false); //Para que el usuario no pueda estirar la ventanta
		
		Panel miPanel = new Panel();
		
		add(miPanel);
		
	}

}
