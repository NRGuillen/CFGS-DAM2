package tema1.ejercicios.ejerciciosIO._01_02.lectura;

import java.io.*;

public class ejercicio1 {

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

				String linea = buffer.readLine().replaceAll(" ", "");
				while (linea != null) {
					System.out.println("Contenido: " + linea);
					linea = buffer.readLine();
				}

				buffer.close();

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

}
