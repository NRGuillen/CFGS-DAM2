package tema1.apuntes.ComunicacionEntreProcesos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GeneradorProcesos {

	public void ejecutar(String ruta) {

		Runtime rt = Runtime.getRuntime();
		Process proceso = null; 
		String linea;

		try {
			proceso = rt.exec(ruta); //Ejecuta el programa que le hayamos puesto en la ruta
			BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream())); //lector de buffer que permite leer la salida del proceso

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(1);
		}

		if (proceso != null) {
			proceso.destroy();
		}

		try {
			proceso.waitFor();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.getStackTrace();
			System.exit(2);
		}
		System.exit(0);
	}

}
