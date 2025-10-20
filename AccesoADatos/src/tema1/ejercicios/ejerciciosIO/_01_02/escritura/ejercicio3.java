package tema1.ejercicios.ejerciciosIO._01_02.escritura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ejercicio3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce cuantos numeros aleatorios quieres:");
		int numero = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Introduce el nombre del archivo txt: ");
		String archivo = scanner.nextLine();

		File numerosAleatorios = new File(archivo);
		try {
			BufferedWriter bufferEscritura = new BufferedWriter(new FileWriter(numerosAleatorios));

			for (int i = 0; i < numero; i++) {

				Integer num = (int) (Math.random() * 100); // entre 0 y 99
				bufferEscritura.write(num.toString());
				bufferEscritura.newLine();
			}

			bufferEscritura.close();
			System.out.println("Archivo creado correctamente");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.close();
	}

}
