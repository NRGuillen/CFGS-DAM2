package practicandoprocesos;

import java.util.Scanner;

public class mainProceso3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Introduce el host a hacer ping: ");
		String host = scanner.nextLine();

		LanzarProceso3 proceso = new LanzarProceso3();
		proceso.ejecutar(host);

	}

}
