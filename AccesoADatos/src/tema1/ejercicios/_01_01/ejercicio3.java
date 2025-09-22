package tema1.ejercicios._01_01;

import java.io.*;
import java.util.Scanner;

public class ejercicio3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce el nombre del directorio");
		File directorio = new File(scanner.nextLine());

		if (!directorio.exists()) {
			directorio.mkdir();

			if (directorio.exists() && directorio.isDirectory()) {

				System.out.println("Directorio creado con el nombre " + directorio + "\n");

				System.out.println("Introduce el nombre del fichero");
				File fichero = new File(directorio, scanner.nextLine()); // Le decimos que se cree en el directorio
																			// "directorio" es decir el padre

				try {
					fichero.createNewFile();
					System.out.println("Fichero creado correctamente en " + directorio);
				} catch (IOException e) {
					// TODO: handle exception
					e.getStackTrace();
				}
			}else {
				System.out.println("Error al crear un directorio");
			}
		} else {
			System.out.println("El directiorio con el nombre " + directorio + " ya existe");
		}

	}

}
