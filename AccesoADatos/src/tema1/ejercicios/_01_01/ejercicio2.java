package tema1.ejercicios._01_01;

import java.io.*;
import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce el directorio");
		File directorio = new File(scanner.nextLine());

		if (directorio.exists() && directorio.isFile()) {
			System.out.println("Directorio borrado");
			directorio.delete(); // Solo lo borra si esta vacio

		} else {
			System.out.println("El directorio no existe");
		}

	}

}