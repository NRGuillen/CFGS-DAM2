package tema1.apuntes.LanzarProcesoCMD;

import java.util.ArrayList;
import java.util.List;

public class GeneradorProceso1 {

	public void ejecutar(String rutaDirectorio) {

		List<String> nombreArgumentos = new ArrayList<>();
		nombreArgumentos.add(rutaDirectorio);
		ProcessBuilder pb = new ProcessBuilder(nombreArgumentos);
		pb.command(nombreArgumentos);

		try {
			//Process proceso = pb.start(); //esto es lo mismo que solo poner pb.start()
			pb.inheritIO().start();
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
