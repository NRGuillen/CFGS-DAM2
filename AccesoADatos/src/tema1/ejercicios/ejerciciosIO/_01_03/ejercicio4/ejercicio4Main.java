package tema1.ejercicios.ejerciciosIO._01_03.ejercicio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ejercicio4Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Libros libro = new Libros();
		int bandera = 0;
		try {
			File fichero = new File("almacenLibreria.dat");
			RandomAccessFile raf = new RandomAccessFile(fichero, "rw");

			do {

				System.out.println("1. Añadir libro");
				System.out.println("2. Visualizar lista de libros");
				System.out.println("3. Ordenar libros por precios");
				System.out.println("4. Filtrar libros por rangos de precio");
				System.out.println("5. Salir");

				int opcion = scanner.nextInt();

				switch (opcion) {

				case 1:
					scanner.nextLine();
					System.out.println("Introduce el titulo del libro:");
					String tituloLibro = scanner.nextLine();
					libro.setTitulo(tituloLibro);
					raf.writeUTF(libro.getTitulo());

					System.out.println("Introduce el autor del libro:");
					String autorLibro = scanner.nextLine();
					libro.setAutor(autorLibro);
					raf.writeUTF(libro.getAutor());

					System.out.println("Introduce el precio del libro:");
					double precioLibro = scanner.nextDouble();
					libro.setPrecio(precioLibro);
					raf.writeDouble(libro.getPrecio());

					break;
				case 2:

					raf.seek(0);
					while (raf.getFilePointer() < raf.length()) {

						String leertitulo = raf.readUTF();
						String leerAutor = raf.readUTF();
						double leerPrecio = raf.readDouble();

						System.out.println(
								"Libro: Nombre: " + leertitulo + " | Edad: " + leerAutor + " | Precio: " + leerPrecio);

					}
					break;
				case 3:

					break;
				case 4:

					System.out.println("Introduce el precio minimo: ");
					double precioMin = scanner.nextDouble();

					System.out.println("Introduce el precio maximo: ");
					double precioMax = scanner.nextDouble();

					raf.seek(0);

					while (raf.getFilePointer() < raf.length()) {

						String leertitulo = raf.readUTF();
						String leerAutor = raf.readUTF();
						double leerPrecio = raf.readDouble();

						if (leerPrecio > precioMin && leerPrecio < precioMax) {

							System.out.println("Libro: Nombre: " + leertitulo + " | Edad: " + leerAutor + " | Precio: "
									+ leerPrecio);
						}
					}

					break;
				case 5:
					bandera = 1;
					break;
				default:
					System.out.println("Error");
					break;

				}

			} while (bandera == 0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}