package tema1.apuntes.SincronizacionDeProcesos;

public class mainProceso2 {

	public static void main(String[] args) {
		
		String proceso1 = "notepad.exe";
		String proceso2 = "notepad.exe";

		EjecutarProceso2 proceso = new EjecutarProceso2();
		proceso.ejecutar(proceso1, proceso2);
		System.out.println("$$");
	}
	
}
