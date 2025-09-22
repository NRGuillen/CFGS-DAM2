package tema1.ejercicios._01_01;

import java.io.File;
import java.util.Scanner;

/*ESTA MAL ESPERANDO A QUE SUBA CORRECCION ESTA MAL ESPERANDO A QUE SUBA CORRECCION ESTA MAL ESPERANDO A QUE SUBA CORRECCION 
 * ESTA MAL ESPERANDO A QUE SUBA CORRECCION ESTA MAL ESPERANDO A QUE SUBA CORRECCION ESTA MAL ESPERANDO A QUE SUBA CORRECCION
 * ESTA MAL ESPERANDO A QUE SUBA CORRECCIONESTA MAL ESPERANDO A QUE SUBA CORRECCIONESTA MAL ESPERANDO A QUE SUBA CORRECCION*/

public class ejercicio4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce el nombre del directorio");
		File directorio = new File(scanner.nextLine());

		if (directorio.exists() && directorio.isDirectory()) {

			String[] directorioList = directorio.list();

			for (String archivo : directorioList) {
				// Caso base seria que archivo = null
				// Caso rescursivo archivo != null

				File a = new File(directorio, archivo);

				if (a.isDirectory()) {
					String[] directorioHijo = a.list();
					if (directorioHijo != null) {

						for (String dirHijo : directorioHijo) {
							System.out.println(dirHijo);
						}
					}
				}
				System.out.println(a.getAbsolutePath());

			}

		} else {
			System.out.println("No es directorio");
		}

		/*
		 * ESTA MAL PORQUE SI EXISTE OTRA CARPETA DENTRO DE UNA CARPETA NO SIGUE LA RUTa
		 * if (directorio.exists()) {
		 * 
		 * if (directorio.isDirectory()) { String[] directorioList = directorio.list();
		 * for (String dirList : directorioList) { System.out.println(dirList);
		 * 
		 * } } else { System.out.println("El nombre dado no es un directorio"); }
		 * 
		 * } else { System.out.println("No existe ningun directorio con el nombre " +
		 * directorio); }
		 */
	}

}
