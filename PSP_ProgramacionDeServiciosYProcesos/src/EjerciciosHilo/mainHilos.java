package EjerciciosHilo;

public class mainHilos {

	private static final int NUM_HILOS = 10;
	private static final int CUENTA_TOTAL = 100000;

	public static void main(String[] args) {

		Contador cont = new Contador();
		Thread[] hilos = new Thread[NUM_HILOS];

		for (int i = 0; i < NUM_HILOS; i++) {
			Thread th = new Thread(new Hilo(i + 1, CUENTA_TOTAL / NUM_HILOS, cont));
			th.start();
			hilos[i] = th;
		}
		for (Thread h : hilos) {
			try {
				h.join();
			} catch (InterruptedException e) {
				System.out.println("Interrupcion del hilo");
				e.printStackTrace();
			}
		}
		
		System.out.println("Cuenta global: " + cont.getCuenta());

		/*
		 * Thread hilo1 = new Thread(new constructorHilos("h1")); Thread hilo2 = new
		 * Thread(new constructorHilos("h2")); Thread hilo3 = new Thread(new
		 * constructorHilos("h3")); Thread hilo4 = new Thread(new
		 * constructorHilos("h4")); Thread hilo5 = new Thread(new
		 * constructorHilos("h5")); Thread hilo6 = new Thread(new
		 * constructorHilos("h6")); Thread hilo7 = new Thread(new
		 * constructorHilos("h7")); Thread hilo8 = new Thread(new
		 * constructorHilos("h8")); Thread hilo9 = new Thread(new
		 * constructorHilos("h9")); Thread hilo10 = new Thread(new
		 * constructorHilos("h10"));
		 * 
		 * hilo1.start(); hilo2.start(); hilo3.start(); hilo4.start(); hilo5.start();
		 * hilo6.start(); hilo7.start(); hilo8.start(); hilo9.start(); hilo10.start();
		 * 
		 * try {
		 * 
		 * hilo1.join(); hilo2.join(); hilo3.join(); hilo4.join(); hilo5.join();
		 * hilo6.join(); hilo7.join(); hilo8.join(); hilo9.join(); hilo10.join();
		 * 
		 * } catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); System.out.println("Interrupcion de hilo jeje"); }
		 * 
		 * System.out.println("Hilo principal terminado");
		 */
	}

}