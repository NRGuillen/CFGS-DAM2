package practicandoprocesos;

import java.io.IOException;
import java.util.ArrayList;

public class LanzarProceso {

	public void ejecucion(String ruta) {

		ArrayList<String> argumentos = new ArrayList<>();

		argumentos.add(ruta);

		ProcessBuilder pb = new ProcessBuilder("notepad.exe", ruta);

		try {
			pb.start();
			System.out.println("Proceso ejecutado correctamente");
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la ejecucion");
			e.printStackTrace();
			System.exit(1);
		}

	}

}
