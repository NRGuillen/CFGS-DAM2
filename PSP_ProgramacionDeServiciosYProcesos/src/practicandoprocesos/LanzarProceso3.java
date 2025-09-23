package practicandoprocesos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LanzarProceso3 {

	public void ejecutar(String host) {

		ArrayList<String> argumentos = new ArrayList<>();

		argumentos.add("ping");
		argumentos.add(host);
		argumentos.add("-n");
		argumentos.add("4");
		int contador = 0;
		try {

			ProcessBuilder pb = new ProcessBuilder(argumentos);
			Process proceso = pb.start();

			BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

			String linea;

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
				contador++;
			}

			proceso.waitFor();

			System.out.println("Comando ejecutado correctamente");
			System.out.println("Resumen:");
			System.out.println("Total de respuestas: " + contador);
			System.out.println("Respuestas recibidas: " + contador);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			System.exit(1);
		}

	}

}
