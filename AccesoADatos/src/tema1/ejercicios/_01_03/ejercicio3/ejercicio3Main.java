package tema1.ejercicios._01_03.ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ejercicio3Main {

	public static void mostrarPersonas(RandomAccessFile raf) {

		try {
			raf.seek(0);
			while (raf.getFilePointer() < raf.length()) {

				String leerNombre = raf.readUTF();
				int leerEdad = raf.readInt();
				System.out.println("Persona: Nombre: " + leerNombre + " | Edad: " + leerEdad);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Persona persona1 = new Persona();
		int bandera = 0;
		try {
			File fichero = new File("almacenPersona.dat");
			RandomAccessFile raf = new RandomAccessFile(fichero, "rw");

			do {

				System.out.println("1. Añadir persona");
				System.out.println("2. Visualizar personas");
				System.out.println("3. Salir");

				int opcion = scanner.nextInt();

				switch (opcion) {

				case 1:
					scanner.nextLine();
					System.out.println("Introduce el nombre de la persona: ");
					String nombre = scanner.nextLine();
					persona1.setNombre(nombre);
					raf.writeUTF(nombre);

					System.out.println("Introduce la edad de la persona: ");
					int edad = scanner.nextInt();
					persona1.setEdad(edad);
					raf.writeInt(edad);
					break;
				case 2:

					mostrarPersonas(raf);

					break;
				case 3:
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
