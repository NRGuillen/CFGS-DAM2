package EjerciciosHilo;

import java.util.Random;

public class constructorHilos implements Runnable {
	private final String nombre;

	public constructorHilos(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		/*int contador = 0;
		int contadorh1 = 0;
		int contadorh2 = 0;
		int contadorh3 = 0;
		int contadorh4 = 0;
		int contadorh5 = 0;
		int contadorh6 = 0;
		int contadorh7 = 0;
		int contadorh8 = 0;
		int contadorh9 = 0;
		int contadorh10 = 0;

		for (int i = 0; i < 100; i++) {
			Random r = new Random();
			int pausa = 20 + r.nextInt(500 - 20);
			System.out.println("Hilo " + nombre + " hace un incremento en la posicion " + i);
			if (nombre.equals("h1")) {
				contadorh1++;
			} else if (nombre.equals("h2")) {
				contadorh2++;
			} else if (nombre.equals("h3")) {
				contadorh3++;
			} else if (nombre.equals("h4")) {
				contadorh4++;
			} else if (nombre.equals("h5")) {
				contadorh5++;
			} else if (nombre.equals("h6")) {
				contadorh6++;
			} else if (nombre.equals("h7")) {
				contadorh7++;
			} else if (nombre.equals("h8")) {
				contadorh8++;
			} else if (nombre.equals("h9")) {
				contadorh9++;
			} else if (nombre.equals("h10")) {
				contadorh10++;
			}
			contador++;
			System.out.println("Contador acutalizado: " + contador);

			

			try {
				Thread.sleep(pausa);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Hilo " + nombre + " se ha interrupido");
			}

		}

		System.out.println("Ejecucion de h1: " + contadorh1);
		System.out.println("Ejecucion de h2: " + contadorh2);
		System.out.println("Ejecucion de h3: " + contadorh3);
		System.out.println("Ejecucion de h4: " + contadorh4);
		System.out.println("Ejecucion de h5: " + contadorh5);
		System.out.println("Ejecucion de h6: " + contadorh6);
		System.out.println("Ejecucion de h7: " + contadorh7);
		System.out.println("Ejecucion de h8: " + contadorh8);
		System.out.println("Ejecucion de h9: " + contadorh9);
		System.out.println("Ejecucion de h10: " + contadorh10);

		System.out.println("Hilo terminado " + nombre);*/

	}

}
