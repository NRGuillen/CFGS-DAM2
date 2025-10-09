package ejercicioHilosMultiples;

public class mainHilosMultiples {

	private static final int ZONAS = 4;
	private static final int NUM_HILOS = ZONAS;
	private static final int VOTOS = 1000;

	public static void main(String[] args) {

		ResultadosEncuesta cont = new ResultadosEncuesta();
		Thread[] hilos = new Thread[NUM_HILOS];

		for (int i = 0; i < NUM_HILOS; i++) {
			Thread th = new Thread(new Hilos(i + 1, VOTOS / NUM_HILOS, cont));
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
		System.out.println("\nVotos globales contados: " +cont.votosGlobales+"/"+VOTOS);
	}

}
