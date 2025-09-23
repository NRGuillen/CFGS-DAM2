package EjsLanzarComando;

public class mainComandos {

	public static void main(String[] args) {
		
		Comando comando = new Comando("ipconfig");
		GeneradorProcesos lanzador = new GeneradorProcesos();
		lanzador.ejecutar(comando.getDirectorio());

	}
	
}

