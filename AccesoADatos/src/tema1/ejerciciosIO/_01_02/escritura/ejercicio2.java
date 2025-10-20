package tema1.ejerciciosIO._01_02.escritura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ejercicio2 {

	public static void main(String[] args) {

		ArrayList<String> palabras = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce frases hasta que escribas 'fin'");
		String frase = scanner.nextLine();

		while (!frase.equals("fin")) {
			palabras.add(frase);
			frase = scanner.nextLine();

		}

		File archivo = new File("registroDeUsuario.txt");

		try {
			BufferedWriter escrituraLinea = new BufferedWriter(new FileWriter(archivo));

			for (int i = 0; i < palabras.size(); i++) {

				escrituraLinea.write(palabras.get(i));
				escrituraLinea.newLine();
			}

			System.out.println("Archivo creado correctamente");
			escrituraLinea.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scanner.close();

	}

}
