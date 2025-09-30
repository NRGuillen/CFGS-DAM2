package tema1.ejercicios._01_02.lectura;

import java.io.*;
import java.util.ArrayList;

public class ejercicio3 {

	public static void main(String[] args) {

		ArrayList<String> separarComillas = new ArrayList<>();
		ArrayList<String> separarComas = new ArrayList<>();

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
				boolean separar = false;
				while ((linea = buffer.readLine()) != null) {

					if (linea.contains("\"")) {
						separar = true;
					} else {
						separar = false;
					}

					if (!separar) {
						String[] comas = linea.split(",");

						for (int i = 0; i < comas.length; i++) {

							System.out.print(" Campo: " + comas[i]);
							separarComas.add(comas[i]);
						}
						System.out.println();

					}

					if (separar) {

						int contador = 0;
						String[] comillas = linea.split(",");
						boolean comillasBolean = false;
						for (int i = 0; i < comillas.length; i++) {

							if (comillas[i].contains("\"")) {
								contador++;
								comillasBolean = true;
							} else {
								comillasBolean = false;

							}

							if (!comillasBolean && contador == 1 || contador == 0) {
								comillasBolean = false;
								comillas = linea.split(",");
								System.out.print(/* " contador" + contador + */" Campo: " + comillas[i]);
							}

							if (contador == 1 && comillasBolean) {
								comillas = linea.split("\"");
								System.out.print(" Campo: \"" + comillas[i] + "\""/* " contador" + contador + */);
								contador++;
							}

							if (contador == 2 && !comillasBolean) {
								comillas = linea.split(",");
								comillas[2] = "";

								System.out.print(comillas[i]);
								if (i < comillas.length - 1) { // hasta el penultimo
									System.out.print(" ,Campo: ");
								}
							}

						}
						System.out.println();
					}

				}

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

}
