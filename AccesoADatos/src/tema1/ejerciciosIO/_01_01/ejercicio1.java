package tema1.ejerciciosIO._01_01;

import java.io.*;
import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce el directorio");
		File directorio = new File(scanner.nextLine());

		if (directorio.exists() && directorio.isDirectory()) {
			String[] ficheros = directorio.list();

			if (ficheros != null) {

				for (int i = 0; i < ficheros.length; i++) {

					System.out.println(ficheros[i]);

				}
			}else {
				System.out.println("No hay contenido en el directorio dado");
			}

		} else {
			directorio.mkdir();
			System.out.println("El directorio no existe");
		}

	}

}
