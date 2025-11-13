package HilosNuevoProfesor;

import java.util.Random;

public class MiHilo extends Thread {

	public void run() {

		Random random = new Random();

		long ms = random.nextLong(1000); // 1ms

		// El hilo inicialmente duerme una cantidad aleatoria de ms
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Soy el hilo " + this.getName());

		//Imprimo el valor de la variable compartida CONTADOR
		EjemploHilos ejemplo = new EjemploHilos();
		System.out.println(ejemplo.contador);
		
	}

}
