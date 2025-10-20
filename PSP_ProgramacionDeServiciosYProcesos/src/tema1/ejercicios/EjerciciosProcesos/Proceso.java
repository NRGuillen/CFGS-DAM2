package tema1.ejercicios.EjerciciosProcesos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Proceso {

	public static int MAXTIEMPO = 10;

	public void ejecutar(String nombreEjecutable, String ruta) {

		ArrayList<String> proceso = new ArrayList<String>();

		proceso.add(nombreEjecutable);
		proceso.add(ruta);

		Process proces = null;

		try {

			ProcessBuilder pb = new ProcessBuilder(proceso);
			proces = pb.start();
			try {
				proces.waitFor(MAXTIEMPO, TimeUnit.SECONDS);
				System.out.println("Se ha ejecutado 10 segundo despues de haber lanzado el proceso");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}

	}

}
