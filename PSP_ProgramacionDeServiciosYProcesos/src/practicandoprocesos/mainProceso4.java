package practicandoprocesos;

import java.util.Scanner;

public class mainProceso4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce el comando: ");
		String comando = scanner.nextLine();
		
		lanzarProceso4 proceso = new lanzarProceso4();
		proceso.ejecutar(comando);
	}

}
