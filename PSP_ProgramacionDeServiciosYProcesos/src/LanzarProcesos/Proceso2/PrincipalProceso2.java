package LanzarProcesos.Proceso2;

public class PrincipalProceso2 {

	public static void main(String[] args) {
		
		String ruta = "C:/windows/system32/notepad.exe";
		
		GenerarProceso2 lanzador = new GenerarProceso2();
		
		lanzador.ejecutar(ruta);
	}
	
}

