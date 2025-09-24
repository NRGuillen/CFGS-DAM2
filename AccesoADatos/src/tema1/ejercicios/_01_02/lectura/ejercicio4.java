package tema1.ejercicios._01_02.lectura;

import java.io.*;
import java.util.ArrayList; 

public class ejercicio4 {

	public static void main(String[] args) {

		ArrayList<String> palabra = new ArrayList<>();
		ArrayList<Integer> veces = new ArrayList<>();

		try {
			File archivo = new File("frutas.txt");
			FileReader abrirArhivo = new FileReader(archivo);
			BufferedReader buffer = new BufferedReader(abrirArhivo);
			String linea;
			while ((linea = buffer.readLine()) != null) {

				String fruta = linea.trim().toLowerCase();
				// Si existe devuelve la posicion sino devuelve -1
				int indice = palabra.indexOf(fruta);

				if (indice == -1) {
					palabra.add(fruta);
					veces.add(1);
				} else {
					// Palabra esta en el array e incremento las veces que se repita
					int cantidad = veces.get(indice) + 1;
					veces.set(indice, cantidad);

				}
			}

			for (int i = 0; i < palabra.size(); i++) {

				System.out.println(palabra.get(i) + " Se repite: " + veces.get(i));

			}

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		/*
		 * FileReader lector = new FileReader(archivo); BufferedReader buffer = new
		 * BufferedReader(lector);
		 * 
		 * String linea = buffer.readLine();
		 * 
		 * int contador = 0;
		 * 
		 * while (linea != null) { contador++; linea = buffer.readLine();
		 * 
		 * }
		 * 
		 * buffer.close(); lector.close();
		 * 
		 * lector = new FileReader(archivo); buffer = new BufferedReader(lector);
		 * 
		 * String[] palabras = new String[contador];
		 * 
		 * int indice = 0; while ((linea = buffer.readLine()) != null) { linea =
		 * linea.replaceAll(" ", ""); palabras[indice] = linea; indice++; }
		 * 
		 * buffer.close(); lector.close(); int rep = 0; for (int i = 0; i <
		 * palabras.length; i++) { for (int j = i + 1; j < palabras.length; j++) {
		 * 
		 * if (palabras[i].equals(palabras[j])) { rep++; palabras[i] += " Se repite:" +
		 * rep;
		 * 
		 * } }
		 * 
		 * }
		 * 
		 * for (int i = 0; i < palabras.length; i++) {
		 * 
		 * System.out.println(palabras[i]); }
		 * 
		 * } catch (IOException e) { // TODO: handle exception e.printStackTrace(); }
		 */

	}

}
