package tema1.apuntes.ApuntesJavaNIO.ApuntesEscritura;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class EjemploPathEscritura {

	public static void main(String[] args) {

		Path ruta = Paths.get("EjemploNIOEscritura.txt");

		try {

			String contenido = "Hola esta es mi primera escritura";
			Files.write(ruta, contenido.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}