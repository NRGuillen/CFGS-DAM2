package hilos2;

public class mainHilos {

	private static final int NUM_HILOS = 10;
	private static final int CUENTA_TOTAL = 100000;

	public static void main(String[] args) {

		Contador cont = new Contador();
		Thread[] hilos = new Thread[NUM_HILOS];

		for (int i = 0; i < NUM_HILOS; i++) {
			Thread th = new Thread(new Hilo(i + 1, CUENTA_TOTAL / NUM_HILOS, cont));
			th.start(); // Inicia la ejecucion de un nuevo hilo, y llama al metodo de run() de la clase
						// Hilo del Runnable

			hilos[i] = th; // almacena la referencia de ese hilo en el array en la posición i
		}
		for (Thread h : hilos) {
			try {
				h.join(); // Bloquea el hilo principal hasta que h termine, es decir el main
			} catch (InterruptedException e) {
				System.out.println("Interrupcion del hilo");
				e.printStackTrace();
			}
		}

		System.out.println("Cuenta global: " + cont.getCuenta());

	}

}