package ejercicioBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class mainBiblioteca {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		ArrayList<Libros> libros = new ArrayList<Libros>();
		ArrayList<Revista> revistas = new ArrayList<Revista>();

		Libros libro1 = new Libros(04131, "JEJESIU", "12 de febrero de 1998", false);
		Libros libro2 = new Libros(123430, "NOSEQUEPONER", "20 de ocutbre de 2012", false);
		libros.add(libro1);
		libros.add(libro2);

		Revista revista1 = new Revista(012332, "YOQUESETU", "05 de noviembre de 1988", false);
		Revista revista2 = new Revista(01234, "HOLAQUETAL", "12 de enero de 2020", false);
		revistas.add(revista1);
		revistas.add(revista2);
		int bandera = 0;

		do {
			System.out.println("==MENU BIBLIOTECA==");
			System.out.println("1. Mostrar catalogo de libros");
			System.out.println("2. Mostrar catalogo de revistas");
			System.out.println("3. Prestar libro");
			System.out.println("4. Devolver libro");
			System.out.println("5. Comprobar libros prestados");
			System.out.println("6. Salir");

			System.out.print("Opcion: ");
			int opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				System.out.println();
				for (Libros libro : libros) {
					System.out.println(libro.toString());
				}
				System.out.println();
				break;

			case 2:
				System.out.println();
				for (Revista revista : revistas) {
					System.out.println(revista.toString());
				}
				System.out.println();
				break;

			case 3:

				for (Libros libro : libros) {
					System.out.println(libro.toString());
				}

				System.out.print("Introduce el codigo del libro que quiera llevarse: ");
				Integer codigoPrestar = scanner.nextInt();

				for (Libros libro : libros) {
					if (codigoPrestar.equals(libro.getCodigo()) && libro.prestado() == false) {
						System.out.println("Libro con codigo " + libro.getCodigo() + " y nombre " + libro.getTitulo()
								+ " ha sido prestado correctamente");
						libro.setEsPrestado(true);
					}

				}

				System.out.println("\n Catalogo actualizado:");
				for (Libros libro : libros) {
					System.out.println(libro.toString());
				}

				break;

			case 4:

				for (Libros libro : libros) {
					System.out.println(libro.toString());
				}

				System.out.print("Introduce el codigo del libro que quiera devolver: ");
				Integer codigoDevolver = scanner.nextInt();

				for (Libros libro : libros) {
					if (codigoDevolver.equals(libro.getCodigo()) && libro.prestado() == true) {
						System.out.println("Libro con codigo " + libro.getCodigo() + " y nombre " + libro.getTitulo()
								+ " ha sido devuelto correctamente");
						libro.setEsPrestado(false);
					}
				}

				break;

			case 5:
				System.out.println();

				System.out.println("Catalogo de libros prestados: ");

				for (Libros libro : libros) {

					if (libro.isEsPrestado() == true) {
						System.out.println(libro.toString());
					}

				}
				System.out.println();

				break;

			case 6:
				bandera = 1;
				System.out.println("Saliendo...");
			}

		} while (bandera == 0);
	}

}
