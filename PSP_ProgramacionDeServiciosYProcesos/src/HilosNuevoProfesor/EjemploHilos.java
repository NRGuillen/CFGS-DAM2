package HilosNuevoProfesor;

public class EjemploHilos {
	
	//EJERCICIO, hay una butaca(boolean) y hay varias personas intentadolo reservar, solo puede reservarlo 1
	//Mutex -> caso particular de una excepcion critica

	public static int contador = 20;

	public static void main(String[] args) {

		final int NUM_HILOS = 5;

		
		System.out.println("Soy el hilo principal");

		// Declaro un array de hilos
		MiHilo arrayHilos[] = new MiHilo[NUM_HILOS];
		for (int i = 0; i < NUM_HILOS; i++) {

			arrayHilos[i] = new MiHilo();
			arrayHilos[i].setName("h" + i);
			arrayHilos[i].start();

			/*
			 * MiHilo hiloNuevo = new MiHilo(); hiloNuevo.setName("h" + i);
			 * hiloNuevo.start();
			 */

		}

	}

}
