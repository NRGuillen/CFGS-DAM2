package tema1.apuntes.ApuntesJavaNIO.ApuntesBorradoArchivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EjemploBorradoArchivoNIO {

	public static void main(String[] args) {

		Path ruta = Paths.get("frutas.txt");

		try {

			Files.deleteIfExists(ruta);

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
