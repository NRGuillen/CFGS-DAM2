package tema1.ejercicios._01._01;

import java.io.*;
import java.util.Scanner;

public class ejercicio3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce el nombre del directorio");
		File directorio = new File(scanner.nextLine());

		if (!directorio.exists()) {
			directorio.mkdir();
			System.out.println("Directorio creado con el nombre " + directorio + "\n");

			System.out.println("Introduce el nombre del fichero");
			File fichero = new File(directorio, scanner.nextLine());

			try {
				directorio.createNewFile();
				fichero.createNewFile();

			} catch (IOException e) {
				// TODO: handle exception
				e.getStackTrace();
			}

		} else {
			System.out.println("El directiorio con el nombre " + directorio + " ya existe");
		}

	}

}
