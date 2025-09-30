package hilos;

public class hilo {

	public static void main(String[] args) {

		// mainHilo hilo = new mainHilo("Ruben");
		// Thread h1 = new Thread(hilo);
		Thread miHilo1 = new Thread(new mainHilo("H1"));
		Thread miHilo2 = new Thread(new mainHilo("H2"));

		// lanzamos hilos
		miHilo1.start();
		miHilo2.start();

		System.out.println("Hilo principal terminado");

	}

}
