package tema1.apuntes.HilosEstaticosSync;

public class mainEstatico {

	public static int EJECUCIONES = 100000000;
	public static int HILOS = 10;

	public static void main(String[] args) {

		Thread[] hilos = new Thread[HILOS];

		for (int i = 0; i < HILOS; i++) {
			Thread th = new Thread(new Contadores(i, EJECUCIONES / HILOS));
			th.start();
			hilos[i] = th;

		}

		for (Thread h : hilos) {
			try {
				h.join(); // Bloquea el hilo principal hasta que h termine, es decir el main
			} catch (InterruptedException e) {
				System.out.println("Interrupcion del hilo");
				e.printStackTrace();
			}
		}

	}

}
