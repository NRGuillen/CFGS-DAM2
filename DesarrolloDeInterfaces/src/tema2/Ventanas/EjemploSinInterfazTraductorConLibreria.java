package tema2.Ventanas;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

//https://jsoup.org/download Insatlo los 3 archivos primeros

/*
 * jsoup-1.21.2.jar core library
 * jsoup-1.21.2-sources.jar sources (optional)
 * jsoup-1.21.2-javadoc.jar javadoc (optional)
 * 
 * Arrastro los 3 archivos al paquete en el que estoy trabajando y luego click derecho al paquete 
 * Build Path > Configure build path > Libraries > addJars y solo añado el jsoup-1.21.2.jar core library, 
 * luego tienes una opcion para desplegar y hay un apartado para sources y para javadoc, ahi pones la ruta 
 * de ambos jars, pero la ruta de los archivos dentro del paquete del workspace.
 * 
 * 
 */

public interface EjemploSinInterfazTraductorConLibreria {

	public static void main(String[] args) {

		String web = "https://www.spanishdict.com/translate/hola";

		try {
			Document document = Jsoup.connect(web).get();

			// <div id="quickdef1-es" class="jkbnWXMh ct5mIhTF">
			// <a href="/translate/folder?langFrom=en" class="tCur1iYh">folder</a>
			// </div>

			Element palabra = document.select("div#quickdef1-es a.tCur1iYh").get(0); // selector css
			// el # es para buscar id
			// el . es para buscar clases

			String resultado = palabra.html().toUpperCase();

			System.out.println(resultado);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
