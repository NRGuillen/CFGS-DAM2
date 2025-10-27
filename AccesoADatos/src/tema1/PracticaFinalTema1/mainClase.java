package tema1.PracticaFinalTema1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class mainClase {

	public static void comprobarExistenciaDeArchivos(String rutaArchivoComprobar) {

		File rutaComprobar = new File(rutaArchivoComprobar);
		if (rutaComprobar.exists() && rutaComprobar.isFile()) {
			String archivo = rutaComprobar.getName();
			System.out.println("El " + archivo + " existe en la ruta " + rutaArchivoComprobar);
		} else {
			System.out.println("Ha habido un problema, no existe el archivo en la carpeta" + rutaArchivoComprobar);
		}

	}

	public static void copiaArchivos(File moverArchivo, File rutaArchivo, String nombreArchivo) {

		try {
			ArrayList<String> copiaPlantas = new ArrayList<>();
			BufferedReader lecturaLinea = new BufferedReader(new FileReader(moverArchivo));
			String lineaLectura;
			while ((lineaLectura = lecturaLinea.readLine()) != null) {
				copiaPlantas.add(lineaLectura);
			} 
			lecturaLinea.close();

			String copiaArchivo = rutaArchivo + "\\" + nombreArchivo;

			BufferedWriter escrituraLinea = new BufferedWriter(new FileWriter(copiaArchivo));

			for (int i = 0; i < copiaPlantas.size(); i++) {
				escrituraLinea.write(copiaPlantas.get(i));
				escrituraLinea.newLine();
			}

			copiaPlantas.clear();

			escrituraLinea.close();
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
		File moverEmpleados = new File("empleado.dat");

		copiaArchivos(moverPlantasXML, rutaPlantas, "plantas.xml");
		copiaArchivos(moverPlantasDAT, rutaPlantas, "plantas.dat");
		copiaArchivos(moverEmpleados, rutaEmpleados, "empleado.dat");

		comprobarExistenciaDeArchivos("C:\\Users\\DAM\\Desktop\\DAM2\\AccesoADatos\\Plantas\\plantas.dat");
		comprobarExistenciaDeArchivos("C:\\Users\\DAM\\Desktop\\DAM2\\AccesoADatos\\Plantas\\plantas.xml");
		comprobarExistenciaDeArchivos("C:\\Users\\DAM\\Desktop\\DAM2\\AccesoADatos\\Empleados\\empleado.dat");

		System.out.println(rutaPlantas);

	}

	public static void main(String[] args) {

		directorios();

	}

}
