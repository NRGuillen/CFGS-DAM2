package practicandoprocesos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LanzarProceso5 {

	public void lanzarProceso(String[] args) {

		ArrayList<String> argumentos = new ArrayList<>();

		for (String object : args) {
			argumentos.add(object);
		}

		try {
			ProcessBuilder pb = new ProcessBuilder(argumentos);
			Process proceso = pb.start();

			BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
