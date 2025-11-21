package tema1.apuntes.ApuntesJavaNIO.ApuntesCopiaDeArchivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class EjemploCopiasDeArchivos {

	public static void main(String[] args) {

		Path rutaOrigen = Paths.get("EjemploNIOEscritura.txt");
		Path rutaDestino = Paths.get("FicheroNIOCopia.txt");

		try {

			Files.copy(rutaOrigen, rutaDestino, StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
