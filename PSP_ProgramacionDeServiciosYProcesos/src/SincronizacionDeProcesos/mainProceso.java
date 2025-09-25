package SincronizacionDeProcesos;

public class mainProceso {

	public static void main(String[] args) {

		String[] argumentos = { "cmd.exe", "/C", "start" };
		EjecutarProceso ep = new EjecutarProceso();
		ep.ejecutar(argumentos);
		System.out.println("Proceso ejecutado");
	}
}
