package tema1.ejerciciosIO._01_02.lectura;

import java.io.*;
import java.util.ArrayList;

public class ejercicio5 {

	public static void main(String[] args) {

		File archivo = new File("planetas.txt");

		if (archivo.exists()) {
			try {
				ArrayList<String> orden = new ArrayList<>();

				BufferedReader br = new BufferedReader(new FileReader("planetas.txt"));

				String linea;
				while ((linea = br.readLine()) != null) {
					orden.add(linea);
				}

				br.close();

				for (int i = 0; i < orden.size(); i++) {
					for (int j = 0; j < orden.size(); j++) {

						if (orden.get(i).compareTo(orden.get(j)) < 0) {

							String temp = orden.get(i);
							orden.set(i, orden.get(j));
							orden.set(j, temp);

						}
					}
				}

				for (String string : orden) {
					System.out.println(string);
				}

				//BufferedWriter bw = new BufferedWriter(new FileWriter("planetas.txt"));

				//for (String string : orden) {
				//	bw.write(string);
				//	bw.newLine();
				//}

				//bw.close();

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}

	}
}
