package tema1.ejercicios._02._02.lectura;

import java.io.*;
import java.util.Arrays;

public class ejercicio5 {

	public static void main(String[] args) {

		File archivo = new File("planetas.txt");

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
				BufferedReader buffer = new BufferedReader(lector); // lee la linea completa de texto

				String linea = buffer.readLine(); // readLine() lee hasta el final de la linea hasta que encuentra un \n
				int contador = 0;

				// Cuento las lineas del archivo en total(no los caracteres)
				while (linea != null) {
					contador++;
					linea = buffer.readLine(); // Este llama a la siguiente linea, siempre que ponga un readLine() salta
												// a la siguente linea del txt
				}

				buffer.close(); // No pasaria nada por no cerrarlos, pero ocupa memoria
				lector.close(); // No pasaria nada por no cerrarlos, pero ocupa memoria

				// Como ya he contado las lineas del archivo, necesito volver al inicio para
				// empezar desde la primera linea, entonces vuelvo
				// a crear otro objeto
				lector = new FileReader(archivo);
				buffer = new BufferedReader(lector);

				String[] palabras = new String[contador];
				String linea2 = buffer.readLine();

				int indice = 0;
				while (linea2 != null) {
					palabras[indice] = linea2; // Guardo el contenido de la linea entera del archivo en mi array
					indice++;
					linea2 = buffer.readLine();
				}

				buffer.close(); // No pasaria nada por no cerrarlos, pero ocupa memoria
				lector.close(); // No pasaria nada por no cerrarlos, pero ocupa memoria

				for (int i = 0; i < palabras.length; i++) {
					for (int j = i; j < palabras.length; j++) {

						if (palabras[i].toLowerCase().charAt(0) < palabras[j].toLowerCase().charAt(0) == false) {

							String temp = palabras[i];
							palabras[i] = palabras[j];
							palabras[j] = temp;

						}

					}

					System.out.println("\nDespués de la pasada " + i + ": ");
					for (int j = 0; j < palabras.length; j++) {
						System.out.println(palabras[j]);
					}

				}
				System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$\n");

				for (int i = 0; i < palabras.length; i++) {

					System.out.println(palabras[i]);

				}

				FileWriter escribirOrdenado = new FileWriter(archivo); // Abre el archivo para escribir o sobreescribir
																		// el nuevo texto, Si el archivo existe
																		// sobreescribe
				BufferedWriter bufferEscritura = new BufferedWriter(escribirOrdenado); // Escribe los datos en bloque y
																						// no caracter a caracter

				for (int i = 0; i < palabras.length; i++) {
					bufferEscritura.write(palabras[i]); // escribe el texto de cada palabra en el archivo.
					bufferEscritura.newLine();// agrega un salto de linea para que cada palabra quede en una linea
												// separada.
				}

				bufferEscritura.close(); // Si no se cierra no se escribira el contenido en el txt
				escribirOrdenado.close(); // No pasaria nada por no cerrarlos, pero ocupa memoria

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}

	}
}
