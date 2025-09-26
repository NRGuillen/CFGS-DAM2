package EjerciciosProcesos;

public class mainProceso {

	public static void main(String[] args) {

		String nombreEjecutable = "notepad.exe";
		String ruta = "C:\\Users\\DAM\\Desktop\\DAM2\\AccesoADatos\\frutas.txt";
		Proceso lanzarProces = new Proceso();
		lanzarProces.ejecutar(nombreEjecutable, ruta);

	}

}
