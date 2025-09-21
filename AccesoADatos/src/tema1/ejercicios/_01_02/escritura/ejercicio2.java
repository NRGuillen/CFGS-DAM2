package tema1.ejercicios._02._02.escritura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ejercicio2 {

	public static void main(String[] args) {

		ArrayList<String> palabras = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		int indice = 1;
		System.out.println("Introduce frases hasta que escribas 'fin'");
		System.out.print("Frase " + indice + ":");
		String frase = scanner.nextLine();

		while (!frase.equals("fin")) {

			indice++;
			System.out.print("Frase " + indice + ":");
			palabras.add(frase);
			frase = scanner.nextLine();

		}

		File archivo = new File("registroDeUsuario.txt");

		try {
			FileWriter archivoEscritura = new FileWriter(archivo);
			BufferedWriter escrituraLinea = new BufferedWriter(archivoEscritura);

			for (int i = 0; i < palabras.size(); i++) {

				escrituraLinea.write(palabras.get(i));
				escrituraLinea.newLine();
				System.out.println("Archivo creado correctamente");
			}

			escrituraLinea.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
