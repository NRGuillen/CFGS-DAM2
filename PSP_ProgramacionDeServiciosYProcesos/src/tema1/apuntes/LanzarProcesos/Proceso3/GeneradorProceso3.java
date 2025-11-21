package tema1.apuntes.LanzarProcesos.Proceso3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneradorProceso3 {

	public void ejecutar(String rutaDirectorio, String nombreEjecutable) {

		List<String> nombreArgumentos = new ArrayList<>();
		nombreArgumentos.add(nombreEjecutable);
		File directorio = new File(rutaDirectorio);
		ProcessBuilder pb = new ProcessBuilder(nombreArgumentos);
		//command ==> nombre del ejecutable
		pb.command(nombreEjecutable);
		//directory ==> ruta como objeto de la clase file
		pb.directory(directorio);

		try {
			//Process proceso = pb.start(); //esto es lo mismo que solo poner pb.start()
			pb.start();
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
