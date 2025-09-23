package ComunicacionEntreProcesos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GeneradorProcesos {

	public void ejecutar(String ruta) {

		Runtime rt = Runtime.getRuntime(); // hace lo mismo que el processbuilder, pero processbuilder tiene mas metodos
		Process proceso = null; // clase hijo
		String linea;

		try {
			proceso = rt.exec(ruta); // ejecuta el programa del tiron
			BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

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
