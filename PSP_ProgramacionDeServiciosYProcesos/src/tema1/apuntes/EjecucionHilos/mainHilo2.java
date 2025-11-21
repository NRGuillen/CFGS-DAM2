package tema1.apuntes.EjecucionHilos;

public class mainHilo2 {

	public static void main(String[] args) {

		Thread hilo1 = new Thread(new hilo2("h1"));
		Thread hilo2 = new Thread(new hilo2("h2"));

		hilo1.start();
		hilo2.start();

		// Esto es una ejecucion concurrente porque:
		/*
		 * Aquí los dos hilos comienzan al mismo tiempo (o casi). El sistema operativo
		 * le da al planificador de hilos (thread) la tarea de decidir que hilo se
		 * ejecuta en cada momento. Ese planificador puede:
		 * 
		 * Dejar correr un poco al hilo1, luego pasar al hilo2.
		 * 
		 * O darle más tiempo al hilo2 y luego volver al hilo1.
		 * 
		 * O incluso intercalar muchas veces entre ambos.
		 */

		try {
			/*
			 * ¿Que hace join()?
			 * El hilo principal (main) espera a que terminen hilo1 y
			 * hilo2. No interfiere en cómo se turnan entre ellos, solo asegura que el
			 * System.out.println("Hilo principal terminado"); se ejecute cuando ambos hilos
			 * ya hayan acabado.
			 */
			hilo1.join();
			hilo2.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Interrupcion de hilo jeje");
		}

		System.out.println("Hilo principal terminado");
	}

}
