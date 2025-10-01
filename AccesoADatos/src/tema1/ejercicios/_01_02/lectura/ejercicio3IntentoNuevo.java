package tema1.ejercicios._01_02.lectura;

import java.io.*;

public class ejercicio3IntentoNuevo {

	public static void main(String[] args) {

		// ArrayList<String> separarComas = new ArrayList<>();

		File archivo = new File("Restaurants.csv");

		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			try {
				FileReader lector = new FileReader(archivo);
				BufferedReader buffer = new BufferedReader(lector);

				String linea;
				// Linea de encabezados
				linea = buffer.readLine();
				System.out.println(linea);
				String[] encabezado = linea.split(",");

				boolean separar = false;
				while ((linea = buffer.readLine()) != null) {

					if (linea.contains("\"")) {

						String[] comillas = linea.split("\"");

						for (String string : comillas) {
							System.out.print(string);
						}
						System.out.println();

					} else {
						String[] comas = linea.split(",");

						for (int i = 0; i < comas.length; i++) {

							// System.out.print("-" + encabezado[i] + " " + comas[i] + " ");
						}
						// System.out.println();
					}

				}

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

}
