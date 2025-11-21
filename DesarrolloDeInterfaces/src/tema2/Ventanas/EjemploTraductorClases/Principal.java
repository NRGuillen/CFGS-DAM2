package tema2.Ventanas.EjemploTraductorClases;

import java.awt.EventQueue;

public class Principal {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {
					VentanaTraductor miVentana = new VentanaTraductor();

				} catch (Exception e) {
					// TODO: handle exception
				}

			}

		});

	}

}
