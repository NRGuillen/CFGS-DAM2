package tema1.apuntes.HilosEstaticosSync;

public class Contadores implements Runnable {

	private int nombre;
	private long ejecuciones;
	private long cont1 = 0;
	private long cont2 = 0;

	private final Object lock1 = new Object();
	private final Object lock2 = new Object();

	public Contadores(int nombre, long ejecuciones) {
		super();
		this.nombre = nombre;
		this.ejecuciones = ejecuciones;
	}

	public long getCont1() {
		synchronized (lock1) {
			return cont1;
		}
	}

	public long getCont2() {
		synchronized (lock2) {
			return cont2;
		}
	}

	public void incrementar1() {
		synchronized (lock1) {
			cont1++;
		}
	}

	public void incrementar2() {
		synchronized (lock2) {
			cont2++;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < ejecuciones; i++) {
			incrementar1();
		}
		System.out.println("Hilo" + nombre + " acabado incremento primer contador " + cont1);

		for (int i = 0; i < ejecuciones; i++) {
			incrementar2();
		}
		System.out.println("Hilo" + nombre + " acabado incremento segundo contador " + cont2);
	}
}
