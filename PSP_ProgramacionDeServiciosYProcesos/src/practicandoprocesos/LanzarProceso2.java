package practicandoprocesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LanzarProceso2 {

	public void ejecutar(String comando) {

		ArrayList<String> argumentos = new ArrayList<>();
		
		argumentos.add(comando);
		argumentos.add("google.com");
		argumentos.add("-n");
		argumentos.add("3");

		
		try {
			ProcessBuilder pb = new ProcessBuilder(argumentos); // Construye el comando del arraylist  ping google.com -n 3
			Process proceso = pb.start(); // Inicia el comando del pb

			BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream())); //Traduce el mensaje de salida con inputstreamreader

			String linea = br.readLine();
			while (linea  != null) {
			    System.out.println(linea);
			    linea = br.readLine();
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
