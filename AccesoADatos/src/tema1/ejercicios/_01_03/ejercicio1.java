package tema1.ejercicios._01_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce el numero para calular fibonacci");
		int numero = scanner.nextInt();

		try {
			File fichero = new File("numerosFibonacci.dat");
			RandomAccessFile raf = new RandomAccessFile(fichero, "rw");

			int a = 0;
			int b = 1;

			for (int i = 0; i < numero; i++) {
				int valor;
				if (i == 0) {
					valor = 0;
					raf.writeInt(valor);
				} else if (i == 1) {
					valor = 1;
					raf.writeInt(valor);
				} else {
					valor = a + b;
					a = b;
					b = valor;
					raf.writeInt(valor);

				}

				System.out.println("i: " + i + " | Valor: " + valor + " | Posición: " + (i * 4) + " Bytes");
			}
			System.out.println(raf.length());

			RandomAccessFile raf2 = new RandomAccessFile(fichero, "r");

			System.out
					.println("Introduce el numero de memoria para ver un numero de fibonacci (limite " + numero + " )");
			int memoria = scanner.nextInt();

			for (int i = 0; i < raf2.length() / 4; i++) {

				System.out.println(raf2.readInt());

			}
			System.out.println();
			raf2.seek(memoria * 4);

			System.out.println(raf2.readInt());
			
			raf.close();
			raf2.close();
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
