package tema1.ejercicios._01_02.escritura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ejercicio4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayList<String> juntarArchivo = new ArrayList<>();

		System.out.println("Introduce la ruta del primer archivo con su extension .txt");
		String ruta1 = scanner.nextLine();

		System.out.println("Introduce la ruta del segundo archivo con su extension .txt");
		String ruta2 = scanner.nextLine();

		System.out.println("Introduce la ruta final para guardar los 2 ficheros anteriores en un directorio");
		String rutaFinal = scanner.nextLine();

		try {

			File archivo1 = new File(ruta1);
			File archivo2 = new File(ruta2);

			String[] nombreSinTxt = archivo1.getName().split("\\.");
			String archivoFinal = nombreSinTxt[0] + "_" + archivo2.getName();

			if (archivo1.exists() && archivo2.exists() && archivo1.isFile() && archivo2.isFile()) {

				BufferedReader br = new BufferedReader(new FileReader(archivo1));
				String linea;
				while ((linea = br.readLine()) != null) {
					juntarArchivo.add(linea);
				}
				br.close();

				br = new BufferedReader(new FileReader(archivo2));
				while ((linea = br.readLine()) != null) {
					juntarArchivo.add(linea);
				}
				br.close();

				File nuevoArchivoRuta = new File(rutaFinal, archivoFinal);
				BufferedWriter bw = new BufferedWriter(new FileWriter(nuevoArchivoRuta));

				for (String string : juntarArchivo) {
					bw.write(string);
					bw.newLine();
				}
				bw.close();

			} else {
				System.out.println("Ha introducido erroneamente la ruta de los archivos");
			}

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		scanner.close();
	}

}