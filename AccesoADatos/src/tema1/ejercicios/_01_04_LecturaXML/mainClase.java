package tema1.ejercicios._01_04_LecturaXML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class mainClase {

	public static void main(String[] args) {

		try {

			File ficheroXML = new File("frutas.xml");
			DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
			DocumentBuilder docB = DBF.newDocumentBuilder();
			Document doc = docB.parse(ficheroXML);
			doc.getDocumentElement().normalize();
			NodeList lista = doc.getElementsByTagName("fruta");
			int cantidad = lista.getLength();

			for (int i = 0; i < cantidad; i++) {

				Node nodo = lista.item(i);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element persona = (Element) nodo;
					String nombre = persona.getElementsByTagName("nombre").item(0).getTextContent();
					String tipo = persona.getElementsByTagName("tipo").item(0).getTextContent();
					String color = persona.getElementsByTagName("color").item(0).getTextContent();
					String origen = persona.getElementsByTagName("origen").item(0).getTextContent();
					String precio = persona.getElementsByTagName("precio").item(0).getTextContent();
					String temporada = persona.getElementsByTagName("temporada").item(0).getTextContent();

					NodeList listaNutrientes = doc.getElementsByTagName("nutrientes");
					Element nutriente = (Element) nodo;
					int cantidadNutrientes = nutriente.getElementsByTagName("nutriente").getLength();
					String nutrientes = "";

					for (int j = 0; j < cantidadNutrientes; j++) {
						String nutriente2 = persona.getElementsByTagName("nutriente").item(j).getTextContent();

						nutrientes += nutriente2 + " ";

					}

					System.out.println("La persona es " + nombre + " | Tipo: " + tipo + " | Color: " + color
							+ " | Origen: " + origen + " | Precio: " + precio + " | Temporada: " + temporada
							+ " | Nutrientes: " + nutrientes);

				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
