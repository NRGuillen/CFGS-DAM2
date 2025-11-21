package tema1.ejercicios.EjerciciosHilo;

public class mainHilos {

	private static final int NUM_HILOS = 10;
	private static final int CUENTA_TOTAL = 100000;

	public static void main(String[] args) {

		/*cuenta++ NO es atómico.

		Internamente se hace en tres pasos:

		 - Leer el valor actual de cuenta
		 - Sumar 1
		 - Guardar el nuevo valor en cuenta

		Si dos hilos ejecutan cuenta++ al mismo tiempo, pueden pisarse mutuamente, y algunos incrementos se pierden.
		
		| Paso | Hilo A               | Hilo B               | Cuenta (valor real en memoria) |
		| ---- | -------------------- | -------------------- | ------------------------------ |
		| 1    | Lee `cuenta = 10000` |                      | 10000                          |
		| 2    |                      | Lee `cuenta = 10000` | 10000                          |
		| 3    | Suma 1 → 10001       |                      | 10000 (todavía no escribe)     |
		| 4    |                      | Suma 1 → 10001       | 10000                          |
		| 5    | Escribe 10001        |                      | 10001                          |
		| 6    |                      | Escribe 10001        | 10001                          |

		Hilo A calcula 10000 + 1 = 10001 y lo escribe.
		Hilo B también calculó 10000 + 1 = 10001 y lo escribe.
		El incremento de B sobrescribe el de A, así que solo se incrementa 1 vez, no dos.
		
		Como Hilo A tiene cuenta = 10000 y suma 1: 10001 pero como Hilo B tiene lo mismo, Cuenta se sobreescribe, ya que los hilos
		no hacen un cuenta++, si no cuenta + 1 y por ende cuenta se sobreecribe con el mismo valor

		*/
		
		Contador cont = new Contador();
		Thread[] hilos = new Thread[NUM_HILOS];

		for (int i = 0; i < NUM_HILOS; i++) {
			Thread th = new Thread(new Hilo(i + 1, CUENTA_TOTAL / NUM_HILOS, cont));
			th.start(); // Inicia la ejecucion de un nuevo hilo, y llama al metodo de run() de la clase Hilo del Runnable

			/*
			 * ##############################################################################
			 * Importante: start() y run() NO son lo mismo									#
			 * 																				#
			 * start() → crea un hilo nuevo y llama a run() dentro de ese hilo.				#
			 * run() → solo ejecuta el código en el hilo actual; no crea un hilo nuevo.		#
			 * ##############################################################################
			 */

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

		/*
		 * Thread hilo1 = new Thread(new constructorHilos("h1")); Thread hilo2 = new
		 * Thread(new constructorHilos("h2")); 
		 * Thread hilo3 = new Thread(newconstructorHilos("h3")); Thread hilo4 = new Thread(new
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