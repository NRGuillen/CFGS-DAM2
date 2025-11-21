package tema1.apuntes.EjecucionHilos;

public class hilos implements Runnable {
	private final String nombre;

	public hilos(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hola soy un hilo " + nombre);
		System.out.println("Hilo terminado " + nombre);

	}

}