package tema1.ejercicios.EjsLanzarComando.Correccion.Profesor;

public class PrincipalProceso1 {

	public static void main(String[] args) {

		String[] parametros = {"/all"};
		String ruta = "ipconfig";

		GeneradorProceso1 lanzador = new GeneradorProceso1();
		lanzador.ejecutar(ruta, parametros);
	}

}
