package LanzarProcesos.Poceso1;
import java.util.ArrayList;
import java.util.List;

public class GeneradorProceso1 {

	public void ejecutar(/*String ruta*/) {

		List<String> nombreArgumentos = new ArrayList<>();
		//List es como el Integer, con list existen metodos, por ejemplo de ordenamiento
		//ArrayList es como el int, sin metodos ni nada, primitivo
		
		//PARAMETROS 
		nombreArgumentos.add("C: \\MyCode\\Suma2Numeros.exe");
		nombreArgumentos.add("18");
		nombreArgumentos.add("20");

		
		ProcessBuilder pb = new ProcessBuilder(/* ruta*/);

		try {
			

			pb.start();

		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
