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

		ArrayList<String> nuevoArchivotxt = new ArrayList<>();

		System.out.println("Introduce el primer archivo que quieres combinar con el segundo,  AÑADE .txt");
		String archivo1 = scanner.nextLine();

		System.out.println("Introduce el segundo archivo que quieres combinar con el primero, AÑADE .txt");
		String archivo2 = scanner.nextLine();

		File archivoCopiar1 = new File(archivo1);
		File archivoCopiar2 = new File(archivo2);

		/*
		 * NO PUEDO HACER ESTO PORQUE:
		 * 
		 * archivo1 contiene toda la ruta (C:\Users\yo\archivo1.txt en Windows).
		 * 
		 * Al hacer split("."), obtienes algo como:
		 * 
		 * ["C:\Users\yo\archivo1", "txt"]
		 *
		 * Y cuando intento concatenar, el sistema lo interpreta como ruta en vez de
		 * nombre.txt
		 * 
		 * String[] archivoSinTxT1 = archivo1.split("\\."); String nuevoArchivo =
		 * archivoSinTxT1[0];
		 * 
		 * String[] archivoSinTxT2 = archivo2.split("\\."); String nuevoArchivo2 =
		 * archivoSinTxT2[0];
		 */

		String nombre1 = archivoCopiar1.getName().split("\\.")[0]; // Sin el getName, te daria toda la ruta
																	// c:/Windows/.txt, con el getname directamente el
																	// txt
		String nombre2 = archivoCopiar2.getName().split("\\.")[0];

		String nuevoArchivo = nombre1 + "_" + nombre2 + ".txt";

		try {

			FileReader leerArchivo1 = new FileReader(archivoCopiar1);
			FileReader leerArchivo2 = new FileReader(archivoCopiar2);

			BufferedReader bufferleerArchivo1 = new BufferedReader(leerArchivo1);
			BufferedReader bufferleerArchivo2 = new BufferedReader(leerArchivo2);

			String linea = bufferleerArchivo1.readLine();
			String linea2 = bufferleerArchivo2.readLine();

			while (linea != null) {
				System.out.println(linea);
				nuevoArchivotxt.add(linea);
				linea = bufferleerArchivo1.readLine();
			}
			while (linea2 != null) {
				System.out.println(linea2);
				nuevoArchivotxt.add(linea2);
				linea2 = bufferleerArchivo2.readLine();

			}

			leerArchivo1.close();
			leerArchivo2.close();
			bufferleerArchivo1.close();
			bufferleerArchivo2.close();

			FileWriter escribirNum1 = new FileWriter(nuevoArchivo);
			BufferedWriter bufferEscrituraNuevo = new BufferedWriter(escribirNum1);

			for (int i = 0; i < nuevoArchivotxt.size(); i++) {

				bufferEscrituraNuevo.write(nuevoArchivotxt.get(i));
				bufferEscrituraNuevo.newLine();

			}

			bufferEscrituraNuevo.close();
			escribirNum1.close();

			for (int i = 0; i < nuevoArchivotxt.size(); i++) {

				System.out.println(i);

			}

			System.out.println("Archivo creado correctamente");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}