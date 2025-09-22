package tema1.ejercicios._01_02.escritura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ejercicio1 {

	public static void main(String[] args) {

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

				Integer primo = i;
				primos.add(primo.toString());
			}
		}

		File archivoPrimos = new File("primos.txt");

		try {
			if (!archivoPrimos.exists()) {
				archivoPrimos.createNewFile();

			}

			FileWriter escribirOrdenado = new FileWriter(archivoPrimos); //abre el fichero para escritura
			BufferedWriter bufferEscritura = new BufferedWriter(escribirOrdenado); //escribe en el fichero

			for (int i = 0; i < primos.size(); i++) {
				bufferEscritura.write(primos.get(i));
				bufferEscritura.newLine();
			}

			bufferEscritura.close();
			escribirOrdenado.close();
			
			System.out.println("Archivo creado correctamente");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
