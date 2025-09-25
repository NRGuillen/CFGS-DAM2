package EjerciciosDeRepaso;

import java.util.Scanner;

public class Ejercicio4 {

	public static int random() {

		return (int) (Math.random() * 10);

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int alto = 0, bajo = 0;

		System.out.println("Introduce el ancho de la matriz");
		alto = scanner.nextInt();
		System.out.println("Introduce el alto de la matriz");
		bajo = scanner.nextInt();

		int[][] matriz = new int[alto][bajo];

		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < bajo; j++) {
				matriz[i][j] = random();
			}

		}

		for (int i = 0; i < alto; i++) {
			System.out.println();
			for (int j = 0; j < bajo; j++) {
				System.out.print(matriz[i][j]);
			}

		}

	}

}
