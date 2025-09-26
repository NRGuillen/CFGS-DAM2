package SincronizacionDeProcesos;

import java.io.IOException;
import java.util.ArrayList;

public class EjecutarProceso {

	public void ejecutar(String[] args) {

		ArrayList<String> procesos = new ArrayList<String>();

		for (int i = 0; i < args.length; i++) {

			procesos.add(args[i]);

		}

		Process proceso = null;
		ProcessBuilder pb = new ProcessBuilder(procesos);

		try {
			proceso = pb.start(); // Se ejecuta el proceso hijo

			System.out.println("Se ha lanzado el proceso");
			System.out.println("El proceso padre esperara a que el hijo termine su ejecucion");
			proceso.waitFor(); // el proceso padre espera a que el hijo termine

		} catch (IOException e) {

			e.getStackTrace();
			System.out.println("Error de ejecucion");
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try {
			System.out.println(proceso.exitValue());

		} catch (IllegalThreadStateException e) {
			// TODO: handle exception
			System.out.println(e);
		}

		if (proceso != null) {
			proceso.destroy();
			System.out.println("El proceso hijo se destruye");
		}
	}

}
