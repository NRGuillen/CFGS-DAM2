package practicandoprocesos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class lanzarProceso4 {

	public void ejecutar(String comando) {

		String[] comandos = comando.split(" ");
		int contadorChar = 0;
		try {
			ProcessBuilder pb = new ProcessBuilder(comandos);
			Process proceso = pb.start();

			BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			String linea;

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);

				for (int i = 0; i < linea.length(); i++) {

					if (linea.charAt(i) != ' ') {
						contadorChar++;
					}

				}

			}

			proceso.waitFor();
			System.out.println("El comando produjo " + contadorChar + " palabras en total");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
