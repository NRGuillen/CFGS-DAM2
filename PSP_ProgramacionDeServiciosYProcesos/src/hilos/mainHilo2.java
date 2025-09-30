package hilos;

public class mainHilo2 {

	public static void main(String[] args) {

		Thread hilo1 = new Thread(new hilo2("h1"));
		Thread hilo2 = new Thread(new hilo2("h2"));

		hilo1.start();
		hilo2.start();

		try {
			hilo1.join();
			hilo2.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Interrupcion de hilo jeje");
		}
		
		System.out.println("Hilo principal terminado");
	}

}
