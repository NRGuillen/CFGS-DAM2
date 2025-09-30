package hilos;

public class mainHilo implements Runnable {
	private final String nombre;

	public mainHilo(String nombre) {
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
