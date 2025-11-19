package tema2.Ventanas.EjemploTraductorClases;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Operaciones {

	public static String traducir(String entrada) {
		
		String web = "https://www.spanishdict.com/translate/"+entrada;
		String resultado = null;
		try {
			Document document = Jsoup.connect(web).get();

			// <div id="quickdef1-es" class="jkbnWXMh ct5mIhTF">
			// <a href="/translate/folder?langFrom=en" class="tCur1iYh">folder</a>
			// </div>

			Element palabra = document.select("div#quickdef1-es a.tCur1iYh").get(0); // selector css
			// el # es para buscar id
			// el . es para buscar clases

			resultado = palabra.html().toUpperCase();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
		
	}

	
}
