package EjsLanzarComando.Correccion.Profesor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneradorProceso1 {

	public void ejecutar(String rutaDirectorio, String[] parametros) {

		List<String> nombreArgumentos = new ArrayList<>();
		if (rutaDirectorio == null || rutaDirectorio.isEmpty()) {
			System.out.println("Falta el nombre del comando");
			System.exit(1);
		}
		nombreArgumentos.add(rutaDirectorio);

		for (int i = 0; i < parametros.length; i++) {

			nombreArgumentos.add(parametros[i]);

		}

		ProcessBuilder pb = new ProcessBuilder(nombreArgumentos);

		/*¿Porque se ejecuta ipconfig /all y no ipconfig y luego all por separado (ya que estan en una lista no en un string)?
		 * 
		 * new ProcessBuilder("ping", "google.com", "-n", "3")
		 * 
		 * el sistema recibe: ping google.com -n 3
		 *
		 *Conclusion: ProcessBuilder combina ambos en una unica llamada al proceso: ipconfig /all.
		 */

		pb.command(nombreArgumentos);

		pb.inheritIO(); // Hace que el rpcoeso herede la E/S estandar del proceso padre, Asi podemos ver
						// el resutado del comando

		try {
			Process proceso = pb.start();
			int codigoRetorno = proceso.waitFor();
			System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("Codigo de retorno: " + codigoRetorno); // Si devuelve 0, esque se ha ejecutado
																		// correctamente, si devuelve algo distinto a 0,
																		// es que ha habido un error
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");

			if (codigoRetorno == 0) {
				System.out.println("Ejecucion correcta");
			} else {
				System.out.println("Ejecucion con errores");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error durante la ejecucion del comando");
			System.out.println("INFORMACION ADICIONAL: ");
			e.printStackTrace();
			System.exit(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println("Proceso interrupido");
			System.exit(3);

		}

	}

}
