package tema1.apuntes.ApuntesFicheros;

import java.io.*;

public class FicherosCaracteres {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File fichero = new File("FicheroEjemplo.txt"); // Entre los () se pone el nombre del archivo, y tiene que estar
														// en la carpeta donde esta el bin, src...
		File fichero2 = new File("FicheroEjemplo2.txt");

		if (fichero.exists()) {
			System.out.println("Nombre fichero: " + fichero.getName());
			System.out.println("Ruta relativa fichero: " + fichero.getPath());
			System.out.println("Ruta absoluta fichero: " + fichero.getAbsolutePath());
			System.out.println("Tamaño del fichero: " + fichero.length());
			System.out.println("Permiso lectura: " + fichero.canRead());
			System.out.println(fichero);
			try {
				FileReader lector = new FileReader(fichero); // Devuelve caracter a caracter del contenido del archivo
				BufferedReader buffer = new BufferedReader(lector); // LLeno el buffer de los caracteres y leo lineas,
																	// es decir juto el lector y lo imprimo todo junto

				String linea = buffer.readLine();
				while (linea != null) {
					System.out.println("Contenido: " + linea);
					linea = buffer.readLine(); // Si linea es no tiene contenido(null) el while no se cumpliria y se saldria
				}

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		} else {
			System.out.println("No existe el fichero");

			try {
				fichero.createNewFile(); // Si no existe lo creo

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace(); // Muestra en consola la traza del error, es decir, dónde y por qué ocurrió la
										// excepción.
			}
		}

		System.out.println();

		if (fichero2.exists()) {
			System.out.println("Nombre fichero: " + fichero2.getName());
			System.out.println("Ruta relativa fichero: " + fichero2.getPath());
			System.out.println("Ruta absoluta fichero: " + fichero2.getAbsolutePath());
			System.out.println("Tamaño del fichero: " + fichero2.length());
			System.out.println("Permiso lectura: " + fichero2.canRead());

		} else {
			System.out.println("No existe el fichero");

			try {
				fichero2.createNewFile();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}

}
