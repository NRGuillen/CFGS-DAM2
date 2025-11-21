package tema1.apuntes.ApuntesJavaNIO.ApuntesLectura;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class EjemploPathLectura {

	public static void main(String[] args) {

		Path ruta = Paths.get("planetas.txt");

		try {

			// Lee el contenido completo del archivo
			System.out.println("==Lectura del archivo completo==");
			String contenido = Files.readString(ruta);
			System.out.println(contenido);

			// Lee el contenido del archivo linea por linea
			System.out.println("\n==Lectura del archivo linea por linea==");
			List<String> lecturaLineaPorLinea = Files.readAllLines(ruta);
			for (int i = 0; i < lecturaLineaPorLinea.size(); i++) {
				System.out.println("Linea " + i + ": " + lecturaLineaPorLinea.get(i));
			}

			// Lista los contenidos de un directorio
			System.out.println("\n==Lectura de los contenidos de una ruta==");
			Path directorio = Paths.get("");

			try {
				Files.list(directorio);
				Stream<Path> flujo = Files.list(directorio);
				flujo.forEach(archivo -> System.out.println(archivo.getFileName()));
			} catch (Exception e) {
				// TODO: handle exception
			}

			// Lee las propiedades del archivo
			System.out.println("\n==Propiedades de un archivo==");

			Path ruta2 = Paths.get("primos.txt");

			System.out.println("Fichero existe: " + Files.exists(ruta2));
			System.out.println("Fichero es un directorio: " + Files.isDirectory(ruta2));

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
