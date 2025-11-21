package tema1.ejercicios.ejerciciosIO._01_01;

import java.io.File;
import java.util.Scanner;

public class ejercicio5 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce el nombre del directorio");
		File directorio = new File(scanner.nextLine());
		String permisos = "";

		if (directorio.exists()) {
			if (directorio.canRead()) {
				permisos += "r";
			} else {
				permisos += "_";
			}
			if (directorio.canWrite()) {
				permisos += "w";
			} else {
				permisos += "_";
			}
			if (directorio.canExecute()) {
				permisos += "x";
			} else {
				permisos += "_";
			}
		} else {
			System.out.println("El directorio no existe");
		}

		System.out.println(permisos);
		String permisosNuevos = "";
		if (directorio.exists()) {
			System.out.println("Introduce los nuevos permisos que quieras asignar: ");
			permisosNuevos = scanner.nextLine().toLowerCase();

			if (permisosNuevos.length() != 3) {
				System.out.println("Has introducido una configuracion erronea");
			} else {

				if (permisosNuevos.charAt(0) == 'r') {
					directorio.setReadable(true);
				} else if (permisosNuevos.charAt(0) == '_') {
					directorio.setReadable(false);
				}

				if (permisosNuevos.charAt(1) == 'w') {
					directorio.setWritable(true);
				} else if (permisosNuevos.charAt(1) == '_') {
					directorio.setWritable(false);
				}

				if (permisosNuevos.charAt(2) == 'x') {
					directorio.setExecutable(true);
				} else if (permisosNuevos.charAt(2) == '_') {
					directorio.setExecutable(false);
				}
			}
		}

		System.out.println("Nuevos permisos: " + permisosNuevos);
		System.out.println(directorio.canRead());
		System.out.println(directorio.canWrite());
		System.out.println(directorio.canExecute());

	}
}
