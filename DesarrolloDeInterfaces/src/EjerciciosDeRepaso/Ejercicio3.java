
public class Ejercicio3 {

	public static void main(String[] args) {

		int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int numerosPar = 0;
		for (int i = 0; i < numeros.length; i++) {

			if (numeros[i] % 2 == 0) {
				numerosPar++;
			}

		}

		System.out.println(numerosPar);

	}

}
