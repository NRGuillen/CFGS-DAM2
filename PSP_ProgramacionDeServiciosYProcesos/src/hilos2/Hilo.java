package hilos2;

public class Hilo implements Runnable {

	int numHilo, miParte = 0, miCuenta = 0;
	private final Contador cont;

	public Hilo(int numHilo, int miParte, Contador cont) {
		super();
		this.numHilo = numHilo;
		this.miParte = miParte;
		this.cont = cont;
	}

	public int getMiCuenta() {
		return miCuenta;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < miParte; i++) {

			cont.incrementa(); // Incremento el contador compartido
			miCuenta++;
		}
		System.out.println("Hilo " + numHilo + " lo damos por terminado y la cuenta de " + getMiCuenta());
	}

}
