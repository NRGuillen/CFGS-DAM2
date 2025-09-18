package LanzarProcesos.Proceso3;

public class PrincipalProceso1 {

	public static void main(String[] args) {
				
		GeneradorProceso1 lanzador = new GeneradorProceso1();
		String ruta = "C:/windows/system32";
		String nombreEjecutable = "notepad.exe";
		lanzador.ejecutar(ruta, nombreEjecutable);
	}
	
}
