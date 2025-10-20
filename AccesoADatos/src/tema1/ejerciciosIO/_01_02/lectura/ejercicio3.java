package tema1.ejerciciosIO._01_02.lectura;

import java.io.*;

public class ejercicio3 {

	public static void main(String[] args) {

		File archivo = new File("Restaurants.csv");

		if (!archivo.exists()) {
			System.out.println("El archivo no existe");

		} else {

			try {
				FileReader lector = new FileReader(archivo);
				BufferedReader buffer = new BufferedReader(lector);

				String linea = buffer.readLine();
				System.out.println(linea);
				String[] encabezado = linea.split(",");
				while ((linea = buffer.readLine()) != null) {

					boolean comillas = false;
					StringBuilder sb = new StringBuilder(linea); // lo uso pq un string normal no puedo setearle el
																	// valor de i, con el sb si puedo

					if (linea.contains("\"")) {
						for (int i = 0; i < sb.length(); i++) {

							if (sb.charAt(i) == '"') {
								comillas = !comillas;
							}

							if (comillas && sb.charAt(i) == ',') {
								sb.setCharAt(i, '*');
							}

						}

						String[] fraseComillas = sb.toString().split(",");

						for (int i = 0; i < fraseComillas.length; i++) {
							System.out.print("#" + encabezado[i] + ":" + fraseComillas[i].replace("*", ",") + "  ");
						}
						System.out.println();

					} else {
						String[] comas = linea.split(",");

						for (int i = 0; i < comas.length; i++) {

							System.out.print("#" + encabezado[i] + ":" + comas[i] + "  ");
						}
						System.out.println();
					}

				}

				buffer.close();

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

}
