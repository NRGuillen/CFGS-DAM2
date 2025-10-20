package tema1.ejerciciosIO._01_04_LecturaXML;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class mainClase {

	public static void main(String[] args) {

		ArrayList<Fruta> almacenFrutas = new ArrayList<>();

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
					Element frutas = (Element) nodo;
					Fruta fruta = new Fruta();

					fruta.setNombre(frutas.getElementsByTagName("nombre").item(0).getTextContent());
					fruta.setTipo(frutas.getElementsByTagName("tipo").item(0).getTextContent());
					fruta.setColor(frutas.getElementsByTagName("color").item(0).getTextContent());
					fruta.setOrigen(frutas.getElementsByTagName("origen").item(0).getTextContent());
					fruta.setPrecio(frutas.getElementsByTagName("precio").item(0).getTextContent());
					fruta.setTemporada(frutas.getElementsByTagName("temporada").item(0).getTextContent());

					NodeList listaNutrientes = frutas.getElementsByTagName("nutriente");
					int cantidadNutrientes = listaNutrientes.getLength();

					for (int j = 0; j < cantidadNutrientes; j++) {

						fruta.addNutrientes(frutas.getElementsByTagName("nutriente").item(j).getTextContent());

					}

					almacenFrutas.add(fruta);

				}

			}

			System.out.println(
					"===============================================================Listado de frutas===============================================================");
			for (Fruta fruta : almacenFrutas) {
				System.out.println(fruta);
			}

			Scanner scanner = new Scanner(System.in);
			int bandera = 0;

			do {
				System.out.println("\nIntroduce el filtrado de precio: ");
				System.out.println("1. Mostrar frutas con filtrado mayor");
				System.out.println("2. Mostrar frutas con filtrado igual");
				System.out.println("3. Mostrar frutas con filtrado menor");
				System.out.println("4. Mostrar frutas por nutrientes");
				System.out.println("5. Salir");
				System.out.print("Opcion:");
				int opcion = scanner.nextInt();

				switch (opcion) {

				case 1:
					scanner.nextLine();
					System.out.print("Introduce el precio, para imprimir todas las frutas mayor a: ");
					double precioMayor = scanner.nextDouble();
					for (Fruta fruta : almacenFrutas) {
						if (Double.parseDouble(fruta.getPrecio()) > precioMayor) {
							System.out.println(fruta);
						}
					}
					break;
				case 2:
					System.out.print("Introduce el precio, para imprimir todas las frutas igual a: ");
					double precioIgual = scanner.nextDouble();
					for (Fruta fruta : almacenFrutas) {
						if (Double.parseDouble(fruta.getPrecio()) == precioIgual) {
							System.out.println(fruta);
						}
					}
					break;
				case 3:
					System.out.print("Introduce el precio, para imprimir todas las frutas menor a: ");
					double precioMenor = scanner.nextDouble();
					for (Fruta fruta : almacenFrutas) {
						if (Double.parseDouble(fruta.getPrecio()) < precioMenor) {
							System.out.println(fruta);
						}
					}

					break;
				case 4:
					scanner.nextLine();
					System.out.print("Introduce el nutriente a buscar: ");
					String nutrienteBuscar = scanner.nextLine();
					int recorrer = 0;
					for (Fruta fruta : almacenFrutas) {
						do {
							if (nutrienteBuscar.equals(fruta.getNutrientes().get(recorrer))) {
								System.out.println(fruta.toString().replace('[', ' ').replace(']', ' '));
							}
							recorrer++;
						} while (recorrer < fruta.getNutrientes().size());
						recorrer = 0;
					}

					break;
				case 5:
					bandera = 1;
					break;
				default:
					System.out.println("Error");
					break;

				}
			} while (bandera == 0);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
