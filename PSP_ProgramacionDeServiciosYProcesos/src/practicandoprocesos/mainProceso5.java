package practicandoprocesos;

public class mainProceso5 {

	public static void main(String[] args) {

		String[] comando = { "ping", "goole.es", "-n", "4" };

		LanzarProceso5 proceso = new LanzarProceso5();

		proceso.lanzarProceso(comando);
	}

}
