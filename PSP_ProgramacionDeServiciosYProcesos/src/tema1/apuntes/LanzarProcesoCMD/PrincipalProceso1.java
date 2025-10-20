package tema1.apuntes.LanzarProcesoCMD;

public class PrincipalProceso1 {

	public static void main(String[] args) {
				
		GeneradorProceso1 lanzador = new GeneradorProceso1();
		String ruta = "ipconfig";
		lanzador.ejecutar(ruta);
	}
	
}
