package tema1.ejercicios._02._02.lectura;

import java.io.*;

public class ejercicio3 {

	public static void main(String[] args) {

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

				String linea = buffer.readLine().replaceAll(" ", "");
				while (linea != null) {
					System.out.println("Campo: " + linea);
				
					linea = buffer.readLine();
				}

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

}
