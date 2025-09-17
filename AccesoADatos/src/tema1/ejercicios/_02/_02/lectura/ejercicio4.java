package tema1.ejercicios._02._02.lectura;

import java.io.*;

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

				String linea = buffer.readLine().replaceAll(" ", "");
				while (linea != null) {

					for (int i = 0; i < linea.length(); i++) {
						for (int j = 0; j < linea.length(); j++) {
							
							
						}
					}
					
					linea = buffer.readLine();
				}

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		
	}
	
}
