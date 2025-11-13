package tema2.Ventanas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class EjemploSinInterfazTraductor {

	public static void main(String[] args) {

		// https://www.spanishdict.com/translate/alfombra

		try {
			URL direccion = new URL("https://www.spanishdict.com/translate/alfombra");
			String htmlTroceado = obtenerHTML(direccion);
			System.out.println(htmlTroceado);

			String palabraTraducida = cortarHTML(htmlTroceado);
			System.out.println("Carpeta -> "+palabraTraducida);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String cortarHTML(String htmlTroceado) {
		// TODO Auto-generated method stub

		// "?langFrom=en\" class=\"tCur1iYh\">"

		int inicio, puntoFinal, puntoFinal2;

		inicio = htmlTroceado.indexOf("?langFrom=en\" class=\"tCur1iYh\">"); // Cuenta todo hasta que encuentra el
																				// sting, en este ejemplo 147836
		// indexOf -> la primera vez que aparezca algo

		// Opcion1, crear una sub cadena y buscar desde ahi
		String trozo = htmlTroceado.substring(inicio); // Coge desde el ?langFrom=en\" class=\"tCur1iYh\"> hacia
														// adelante
		puntoFinal = trozo.indexOf("</a>"); //Cuenta desde el inicio hasta que encuenta el </a>, es decir contaria todo esto
		// ?langFrom=en" class="tCur1iYh">carpet = 37
		
		
		// Opcion2, buscar en la misma cadena pero desde el punto anteriormente
		// calculado
		puntoFinal2 = htmlTroceado.indexOf("</a>", inicio);

		String resultado = htmlTroceado.substring(inicio + 31, inicio + puntoFinal); // 31 porque en el link los \ no
																						// cuentan.
		String resultado2 = htmlTroceado.substring(inicio + 31, puntoFinal2);

		return resultado2;
	}

	private static String obtenerHTML(URL direccion) {
		// TODO Auto-generated method stub
		String codigo = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(direccion.openStream()));// openStream -> abrir
																									// la URL
			String inputLine;

			while ((inputLine = br.readLine()) != null) {
				codigo += inputLine;
			}

			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return codigo;
	}

}
