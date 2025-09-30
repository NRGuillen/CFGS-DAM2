package hilos;

import java.util.Random;

public class hilo2 implements Runnable { // Runnable define un método run() que se ejecutará cuando el hilo comience.
	private final String nombre;

	public hilo2(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hola soy el hilo " + nombre);

		for (int i = 0; i < 4; i++) {
			Random r = new Random();
			int pausa = 20 + r.nextInt(500 - 20);
			System.out.println("Hilo " + nombre + " hace pausa " + pausa + " ms");

			try {
				Thread.sleep(pausa); // hace que solo este hilo se detenga por pausa milisegundos.

				/*
				 * hilo1 puede imprimir algo y luego entrar en pausa. Mientras hilo1 duerme, el
				 * scheduler puede ejecutar hilo2.
				 */

				/*
				 * Con sleep Hilos se intercalan porque uno duerme y otro puede ejecutarse. Sin
				 * sleep Hilos siguen “del tirón” según el CPU; puede que un hilo termine antes
				 * de que otro imprima algo.
				 */

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Hilo " + nombre + " se ha interrupido");
			}

		}

		System.out.println("Hilo terminado " + nombre);

	}

}