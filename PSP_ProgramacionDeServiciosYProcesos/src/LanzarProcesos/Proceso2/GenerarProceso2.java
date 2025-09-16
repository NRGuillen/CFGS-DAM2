package LanzarProcesos.Proceso2;

public class GenerarProceso2 {

	public void ejecutar(String ruta) {

		// Crea un objeto ProcessBuilder con la ruta del proceso o programa a ejecutar
		ProcessBuilder pb = new ProcessBuilder(ruta);

		try {
			// El bloque try se utiliza para intentar ejecutar un código que puede lanzar una excepción.
			// En este caso, se intenta iniciar un nuevo proceso con la ruta especificada.

			pb.start(); // Inicia el proceso externo. Esto puede lanzar una IOException si ocurre un error.

		} catch (Exception e) {
			// El bloque catch captura cualquier excepción que ocurra dentro del bloque try.
			// Si ocurre un error al intentar iniciar el proceso (por ejemplo, si la ruta no es válida
			// o el archivo no es ejecutable), el programa no se detiene bruscamente.

			// En su lugar, se captura la excepción y se imprime el detalle del error,
			// lo que ayuda a diagnosticar el problema.
			e.printStackTrace();
		}

	}

}