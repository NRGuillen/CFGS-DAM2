package tema1.apuntes.LanzarProcesos.Proceso3;

public class PrincipalProceso1 {

	public static void main(String[] args) {
				
		GeneradorProceso3 lanzador = new GeneradorProceso3();
		String ruta = "C:/windows/system32";
		String nombreEjecutable = "notepad.exe";
		lanzador.ejecutar(ruta, nombreEjecutable);
	}
	
}
