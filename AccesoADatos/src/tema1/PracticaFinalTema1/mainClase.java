package tema1.PracticaFinalTema1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class mainClase {

	// Falta comprobar que el archivo exista en la carpeta y eliminar el antiguo
	public static void copiaArchivoDAT(File moverPlantasDAT, File rutaPlantas) {

		try {
			ArrayList<String> copiaPlantasDAT = new ArrayList<>();
			BufferedReader lecturaLineaDAT = new BufferedReader(new FileReader(moverPlantasDAT));
			String lineaLecturaDAT;
			while ((lineaLecturaDAT = lecturaLineaDAT.readLine()) != null) {
				copiaPlantasDAT.add(lineaLecturaDAT);
			}
			lecturaLineaDAT.close();

			String copiaArchivoDAT = rutaPlantas + "\\plantas.dat";

			BufferedWriter escrituraLineaDAT = new BufferedWriter(new FileWriter(copiaArchivoDAT));

			for (int i = 0; i < copiaPlantasDAT.size(); i++) {
				escrituraLineaDAT.write(copiaPlantasDAT.get(i));
				escrituraLineaDAT.newLine();
			}

			escrituraLineaDAT.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// Falta comprobar que el archivo exista en la carpeta y eliminar el antiguo
	public static void copiaArchivoXML(File moverPlantasXML, File rutaPlantas) {

		try {
			ArrayList<String> copiaPlantasXML = new ArrayList<>();
			BufferedReader lecturaLineaXML = new BufferedReader(new FileReader(moverPlantasXML));
			String lineaLecturaXML;
			while ((lineaLecturaXML = lecturaLineaXML.readLine()) != null) {
				copiaPlantasXML.add(lineaLecturaXML);
			}
			lecturaLineaXML.close();

			String copiaArchivoXML = rutaPlantas + "\\plantas.xml";

			BufferedWriter escrituraLineaXML = new BufferedWriter(new FileWriter(copiaArchivoXML));

			for (int i = 0; i < copiaPlantasXML.size(); i++) {
				escrituraLineaXML.write(copiaPlantasXML.get(i));
				escrituraLineaXML.newLine();
			}

			escrituraLineaXML.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void creacionDirectorios(File rutaPlantas, String nombreDirectorio) {
		if (!rutaPlantas.exists() && !rutaPlantas.isDirectory()) {
			rutaPlantas.mkdir();
			System.out.println("Directorio " + nombreDirectorio + " creado con exito.");
		} else {
			System.out.println("El directorio " + nombreDirectorio + " ya existe.");
		}

	}

	public static void directorios() {
		File rutaPadre = new File("src");
		String rutaCompleta = rutaPadre.getAbsolutePath();
		String[] rutaCreacionCarpetas = rutaCompleta.split("\\\\");

		String rutaGlobal = "";

		for (int i = 0; i < rutaCreacionCarpetas.length - 1; i++) {
			// El -1, es para que no me agrege el nombre del src, ya que solo quiero la
			// ruta padre donde guardamos todos los xml .dat etc
			rutaGlobal += rutaCreacionCarpetas[i] + "\\";
		}

		String directorioPlantas = rutaGlobal + "Plantas", directorioEmpleados = rutaGlobal + "Empleados",
				directorioTickets = rutaGlobal + "Tickets", directorioDevoluciones = rutaGlobal + "Devoluciones";

		File rutaEmpleados = new File(directorioEmpleados);
		File rutaPlantas = new File(directorioPlantas);
		File rutaTickets = new File(directorioTickets);
		File rutaDevoluciones = new File(directorioDevoluciones);

		creacionDirectorios(rutaEmpleados, "Empleados");
		creacionDirectorios(rutaPlantas, "Planetas");
		creacionDirectorios(rutaTickets, "Tickets");
		creacionDirectorios(rutaDevoluciones, "Devoluciones");

		File moverPlantasXML = new File("plantas.xml");
		File moverPlantasDAT = new File("plantas.dat");

		copiaArchivoDAT(moverPlantasDAT, rutaPlantas);
		copiaArchivoXML(moverPlantasXML, rutaPlantas);

		System.out.println(rutaPlantas);

	}

	public static void main(String[] args) {

		directorios();

	}

}
