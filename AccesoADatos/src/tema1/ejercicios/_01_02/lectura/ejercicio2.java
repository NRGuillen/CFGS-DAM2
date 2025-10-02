package tema1.ejercicios._01_02.lectura;

import java.io.*;

public class ejercicio2 {

	public static void main(String[] args) {

		File archivo = new File("RubenHEHEHE.txt");

		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			try {
				BufferedReader buffer = new BufferedReader(new FileReader(archivo));
				String linea;
				int totalCaracteres = 0, totalVocales = 0;
				while ((linea = buffer.readLine()) != null) {
					System.out.println("Contenido: " + linea);

					for (int i = 0; i < linea.length(); i++) {

						if (linea.charAt(i) != ' ') {
							totalCaracteres++;
						}

						if (linea.toLowerCase().charAt(i) == 'a' || linea.toLowerCase().charAt(i) == 'e'
								|| linea.toLowerCase().charAt(i) == 'i' || linea.toLowerCase().charAt(i) == 'o'
								|| linea.toLowerCase().charAt(i) == 'u') {
							totalVocales++;
						}
					}
				}

				buffer.close();
				System.out.println("Numero total de caracteres: " + totalCaracteres);
				System.out.println("Numero total de vocales: " + totalVocales);

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

}
