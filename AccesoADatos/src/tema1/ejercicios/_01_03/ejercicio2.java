package tema1.ejercicios._01_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int autoIncrementoId = 0;

		int id = ++autoIncrementoId, cantidadStock = 0, bandera = 0;
		double precio = 0;

		try {
			File fichero = new File("almacen.dat");
			RandomAccessFile raf = new RandomAccessFile(fichero, "rw");

			do {

				System.out.println("1. Introducir producto");
				System.out.println("2. Visualizar todos los productos");
				System.out.println("3. Visualizar los datos de un producto concreto basado en su ID");
				System.out.println("4. Borrar producto por su id");
				System.out.println("5. Modificar cantidad y precio producto");
				System.out.println("6. Salir");

				int opcion = scanner.nextInt();

				switch (opcion) {

				case 1:

					id = autoIncrementoId;

					raf.writeInt(id); // 4b
					++autoIncrementoId;

					System.out.println("Introduce la cantidad de stock");
					cantidadStock = scanner.nextInt();
					raf.writeInt(cantidadStock); // 4b

					System.out.println("Introduce el precio");
					precio = scanner.nextDouble();
					raf.writeDouble(precio); // 8b

					System.out.println("Producto añadido correctamente");

					System.out.println(raf.getFilePointer()); // 16b
					System.out.println(raf.length());

					break;

				case 2:
					raf.seek(0); // Setea a getFilePointer a 0
					while (raf.getFilePointer() < raf.length()) { // 0 < 16 (si hay varios productos se multiplican, por
																	// ejemplo 2 * 16)
						int idLeido = raf.readInt();
						int stockLeido = raf.readInt();
						double precioLeido = raf.readDouble();

						System.out.println("ID: " + idLeido + " | Stock: " + stockLeido + " | Precio: " + precioLeido);
					}

					break;
				case 3:
					System.out.println("Introduce el id del producto que quieres buscar: ");
					int idBuscar = scanner.nextInt();

					raf.seek(16 * (idBuscar - 1));

					int idLeido = raf.readInt();
					int stockLeido = raf.readInt();
					double precioLeido = raf.readDouble();

					System.out.println("ID: " + idLeido + " | Stock: " + stockLeido + " | Precio: " + precioLeido);

					break;
				case 4:

					System.out.println("Introduce el id del producto que quieres eliminar: ");
					int idEliminar = scanner.nextInt();

					raf.seek(16 * (idEliminar - 1));

					int idLeidoElim = 0;
					raf.writeInt(idLeidoElim);
					int stockLeidoElim = 0;
					raf.writeInt(stockLeidoElim);
					double precioLeidoElim = 0;
					raf.writeDouble(precioLeidoElim);

					break;
				case 5:

					System.out.println("Introduce el id del producto que quieres modificar: ");
					int idModificar = scanner.nextInt();

					raf.seek(16 * (idModificar - 1));

					int idLeidoMod = raf.readInt();
					int stockLeidoMod = raf.readInt();
					double precioLeidoMod = raf.readDouble();

					System.out.println(
							"ID: " + idLeidoMod + " | Stock: " + stockLeidoMod + " | Precio: " + precioLeidoMod);

					raf.seek(16 * (idModificar - 1));
					int idLeidoModificar = raf.readInt();

					System.out.println("Introduce un nuevo stock: ");
					int stockModificado = scanner.nextInt();
					raf.writeInt(stockModificado);

					System.out.println("Introduce un nuevo precio: ");
					double precioModificado = scanner.nextDouble();
					raf.writeDouble(precioModificado);

					System.out.println("Producto modificado: ID: " + idLeidoModificar + " | Stock: " + stockModificado
							+ " | Precio: " + precioModificado);

					break;
				case 6:
					bandera = 1;
					break;
				default:
					System.out.println("Error");
					break;

				}

				raf.close();

			} while (bandera == 0);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.close();

	}

}
