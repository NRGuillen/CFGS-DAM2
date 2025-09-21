package tema1.ejercicios._02._02.escritura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ejercicio1 {

	public static void main(String[] args) {

		int contador = 0;
		ArrayList<String> primos = new ArrayList<>();
		for (int i = 2; i < 500; i++) {
			boolean esPrimo = true;

			for (int j = 2; j < i; j++) {
				if (i % j == 0) {

					System.out.println("No primo -> " + i + " / " + j + " =  " + (i % j));
					esPrimo = false;
				}
			}

			if (esPrimo) {
				System.out.println("Primo -> " + i);

				contador++;
				Integer primo = i;
				primos.add(primo.toString());
			}
		}

		File archivoPrimos = new File("primos.txt");

		try {
			FileWriter escribirOrdenado = new FileWriter(archivoPrimos);
			BufferedWriter bufferEscritura = new BufferedWriter(escribirOrdenado);

			for (int i = 0; i < primos.size(); i++) {
				bufferEscritura.write(primos.get(i));
				bufferEscritura.newLine();
			}

			bufferEscritura.close();

			System.out.println("Archivo creado correctamente");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
