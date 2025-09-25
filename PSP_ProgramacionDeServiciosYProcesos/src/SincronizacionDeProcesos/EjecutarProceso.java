package SincronizacionDeProcesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EjecutarProceso {

	public void ejecutar(String[] args) {

		ArrayList<String> procesos = new ArrayList<String>();

		for (int i = 0; i < args.length; i++) {

			procesos.add(args[i]);

		}

		ProcessBuilder pb = new ProcessBuilder(procesos);
		Process proceso = null;
		try {
			proceso = pb.start(); //Se ejecuta el proceso hijo

			System.out.println("Se ha lanzado el proceso");
			System.out.println("El proceso padre esperara a que el hijo termine su ejecucion");

			BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream())); //lee la salida del hijo

			String linea;

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			System.out.println("Ejecucion correcta");

		} catch (IOException e) {

			e.getStackTrace();
			System.out.println("Error de ejecucion");
		}

		try {
			proceso.waitFor(); //el proceso padre espera a que el hijo termine
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
