package tema1.ejercicios._01_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {

		ArrayList<String> productos = new ArrayList<String>();

		Scanner scanner = new Scanner(System.in);

		int autoIncrementoId = 0;

		int id = ++autoIncrementoId, cantidadStock = 0, bandera = 0;
		double precio = 0;

		try {
			File fichero = new File("numerosFibonacci.dat");
			RandomAccessFile raf = new RandomAccessFile(fichero, "rw");

			do {

				System.out.println("1. Introducir producto: ");
				System.out.println("2. Visualizar producto");
				System.out.println("3. Visualizar los datos de un producto concreto basado en su ID");
				System.out.println("4. Borrar producto por su id");
				System.out.println("5. Modificar cantidad y precio producto");
				System.out.println("6. Salir");

				int opcion = scanner.nextInt();

				switch (opcion) {

				case 1:

					String productoEntero = "";

					id = autoIncrementoId;

					productoEntero += "Id: " + id;
					++autoIncrementoId;

					System.out.println("Introduce la cantidad de stock");
					cantidadStock = scanner.nextInt();

					productoEntero += " , Cantidad de stock: " + cantidadStock;

					System.out.println("Introduce el precio");
					precio = scanner.nextDouble();
					productoEntero += " , Precio: " + precio;

					System.out.println(productoEntero);
					productos.add(productoEntero);
					System.out.println("Producto añadido correctamente");
					break;
				case 2:

					for (String string : productos) {
						System.out.println(string);
					}

					break;
				case 3:

					System.out.println("Introduce el id del producto a visualizar");
					int idProducto = scanner.nextInt();

					for (int i = 0; i < 1; i++) {
						System.out.println(productos.get(idProducto));
					}

					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					bandera = 1;
					break;

				}

			} while (bandera == 0);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
