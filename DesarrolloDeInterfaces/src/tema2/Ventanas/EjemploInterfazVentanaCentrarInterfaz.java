package tema2.Ventanas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class EjemploInterfazVentanaCentrarInterfaz {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploInterfazVentanaCentrarInterfaz window = new EjemploInterfazVentanaCentrarInterfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EjemploInterfazVentanaCentrarInterfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension monitor = Toolkit.getDefaultToolkit().getScreenSize(); // Sirve para saber la resolucion de la
																			// pantalla, ..
		int widthX = (int) monitor.getWidth() / 2;
		int heightY = (int) monitor.getHeight() / 2;
		System.out.println(widthX);
		System.out.println(heightY);

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocation((widthX - frame.getWidth() / 2), ((heightY - frame.getHeight() / 2))); // Centra la pantalla
																									// tambien, pero mas
																									// lioso
		frame.setLocationRelativeTo(null); // Centra la ventana al medio, tiene que estar debajo de setbounds
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
