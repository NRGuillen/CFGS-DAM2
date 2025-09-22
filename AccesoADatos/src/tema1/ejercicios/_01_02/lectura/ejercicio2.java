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
				FileReader lector = new FileReader(archivo);
				BufferedReader buffer = new BufferedReader(lector);
				String linea = buffer.readLine();
				int totalCaracteres = 0;
				int totalVocales = 0;
				while (linea != null) {
					System.out.println("Contenido: " + linea);
					totalCaracteres += linea.length();

					for (int i = 0; i < linea.length(); i++) {

						if (linea.charAt(i) == 'a' || linea.charAt(i) == 'A' || linea.charAt(i) == 'e'
							|| linea.charAt(i) == 'E' || linea.charAt(i) == 'i' || linea.charAt(i) == 'I'
							|| linea.charAt(i) == 'o' || linea.charAt(i) == 'O' || linea.charAt(i) == 'u'
							|| linea.charAt(i) == 'U') {
							totalVocales++;
						}

					}

					linea = buffer.readLine();
				}
				System.out.println("Numero total de caracteres: " + totalCaracteres);
				System.out.println("Numero total de vocales: " + totalVocales);

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

}
