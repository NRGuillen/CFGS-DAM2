package tema1.ejercicios.ejerciciosIO._01_01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ejercicio6 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce el nombre del directorio");
		File fichero = new File(scanner.nextLine());

		if(fichero.exists()) {
			System.out.println("Ruta del fichero: " +fichero.getAbsolutePath());
		}else {
			try {
				fichero.createNewFile();
				fichero.setReadable(true);
				System.out.println("Ruta del fichero: " +fichero.getAbsolutePath());
				System.out.println("Permiso de lectura: "+fichero.canRead());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
