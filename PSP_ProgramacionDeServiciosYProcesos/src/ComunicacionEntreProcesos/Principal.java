package ComunicacionEntreProcesos;

public class Principal {

	public static void main(String[] args) {
		
		String ruta = "ping" + " google.es";
		
		GeneradorProcesos lanzador = new GeneradorProcesos();
		lanzador.ejecutar(ruta);
		System.out.println("Proceso ejecutado");
	}
	
}
