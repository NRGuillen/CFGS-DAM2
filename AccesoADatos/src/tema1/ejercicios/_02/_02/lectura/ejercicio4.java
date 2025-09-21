package tema1.ejercicios._02._02.lectura;

import java.io.*;

//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 
//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 
//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 
//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 
//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 
//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 
//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 
//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 
//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 
//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 
//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 
//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 
//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 
//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 
//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 
//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 
//ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL ESTA MAL 

public class ejercicio4 {

	public static void main(String[] args) {

		File archivo = new File("frutas.txt");

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

				String linea = buffer.readLine();
				;
				int contador = 0;

				while (linea != null) {
					contador++;
					linea = buffer.readLine();

				}

				buffer.close();
				lector.close();

				lector = new FileReader(archivo);
				buffer = new BufferedReader(lector);

				String[] palabras = new String[contador];

				int indice = 0;
				while ((linea = buffer.readLine()) != null) {
					linea = linea.replaceAll(" ", "");
					palabras[indice] = linea;
					indice++;
				}

				buffer.close();
				lector.close();
				int rep = 0;
				for (int i = 0; i < palabras.length; i++) {
					for (int j = i + 1; j < palabras.length; j++) {

						if (palabras[i].equals(palabras[j])) {
							rep++;
							palabras[i] += " Se repite:" + rep;

						}
					}

				}

				for (int i = 0; i < palabras.length; i++) {

					System.out.println(palabras[i]);
				}

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}

	}

}
