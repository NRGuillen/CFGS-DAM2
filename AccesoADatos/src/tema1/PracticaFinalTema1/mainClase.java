package tema1.PracticaFinalTema1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class mainClase {

	public static void copiaArchivosPlantas(String nombreArchivo, String rutaFinal) {
	}

	public static void copiaArchivosEmpleado(String nombreArchivo, String rutaFinal) {

		String archivoDATCopia = rutaFinal + "\\" + nombreArchivo;

		File ficheroComprueba = new File(archivoDATCopia);

		if (!ficheroComprueba.isFile() && !ficheroComprueba.exists()) {

			try {
				File fichero = new File(nombreArchivo);
				RandomAccessFile rafLectura = new RandomAccessFile(fichero, "r");

				File ficheroCopia = new File(archivoDATCopia);
				RandomAccessFile rafEscritura = new RandomAccessFile(ficheroCopia, "rw");

				while (rafLectura.getFilePointer() < rafLectura.length()) {
					int codigo = rafLectura.readInt();
					float precio = rafLectura.readFloat();
					int stock = rafLectura.readInt();

					System.out.println("\nCodigo: " + codigo);
					System.out.println("Precio: " + precio);
					System.out.println("Stock: " + stock);

					rafEscritura.writeInt(codigo); // Si no lo pongo con variables saltan de 2 en 2 (no se porque)
					rafEscritura.writeFloat(precio);
					rafEscritura.writeInt(stock);
				}

				rafLectura.close();
				rafEscritura.close();

				System.out.println("Copia realizada correctamente en: " + archivoDATCopia);

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("El archivo " + nombreArchivo + " ya existe en la ruta: " + rutaFinal);
		}
	}

	public static void copiaArchivosXML(String nombreArchivo, String rutaFinal) {

		ArrayList<String> copiaXML = new ArrayList<>();

		try {
			File archivoXML = new File(nombreArchivo);
			BufferedReader br = new BufferedReader(new FileReader(archivoXML));
			String leerLineaXML;

			while ((leerLineaXML = br.readLine()) != null) {
				copiaXML.add(leerLineaXML);
			}
			br.close();

			String rutaDestino = rutaFinal + "\\" + nombreArchivo;

			File archivoXMLCopia = new File(rutaDestino);
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivoXMLCopia));

			for (String string : copiaXML) {
				bw.write(string);
				bw.newLine();
			}

			bw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		String rutaCompleta = rutaPadre.getAbsolutePath(); // C:\Users\XXXXXX\eclipse-workspace\AccesoADatos\src
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

		String plantasXML = "plantas.xml";
		String plantasDAT = "plantas.dat";
		// String empleadoDAT = "empleado.dat";

		copiaArchivosXML(plantasXML, directorioPlantas);
		copiaArchivosEmpleado(plantasDAT, directorioPlantas);

	}

	public static void main(String[] args) {

		// directorios();

		try {
			File fichero = new File("empleado.dat");
			RandomAccessFile rafLectura = new RandomAccessFile(fichero, "r");

			rafLectura.seek(0);
			while (rafLectura.getFilePointer() < rafLectura.length()) {
				int codigo = rafLectura.readInt();
				String nombre = "";

				for (int i = 0; i < rafLectura.readUTF().length(); i++) {
					nombre += rafLectura.readChar();
				}
				
				String contraseña = rafLectura.readUTF();
				String cargo = rafLectura.readUTF();

				System.out.println("\nCodigo: " + codigo);
				System.out.println("Nombre: " + nombre);
				System.out.println("Contraseña: " + contraseña);
				System.out.println("Cargo: " + cargo);

			}
			System.out.println(rafLectura.getFilePointer());
			rafLectura.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
