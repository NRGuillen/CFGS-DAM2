package tema1.ejercicios;

import java.io.*;
import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce el directorio");
		File directorio = new File(scanner.nextLine());

		if (directorio.exists()) {
			String[] ficheros = directorio.list();

			for (int i = 0; i < ficheros.length; i++) {

				System.out.println(ficheros[i]);

			}

		} else {
			directorio.mkdir();
			System.out.println("El directorio no existe");
		}

	}

}
