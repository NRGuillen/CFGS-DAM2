package tema1.ejercicios;

import java.io.File;
import java.util.Scanner;

public class ejercicio4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce el nombre del directorio");
		File directorio = new File(scanner.nextLine());

		if (directorio.exists()) {

			if (directorio.isDirectory()) {
				String[] directorioList = directorio.list();
				for (String dirList : directorioList) {
					System.out.println(dirList);
				}
			} else {
				System.out.println("El nombre dado no es un directorio");
			}

		} else {
			System.out.println("No existe ningun directorio con el nombre " + directorio);
		}

	}

}
