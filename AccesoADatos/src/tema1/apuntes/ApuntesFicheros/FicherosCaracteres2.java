package tema1.apuntes.ApuntesFicheros;

import java.io.*;

public class FicherosCaracteres2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File fichero = new File("FicheroEjemplo.txt");

		if (!fichero.exists()) {

			try {
				fichero.createNewFile();
			} catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}	
			System.out.println("Nombre fichero: " + fichero.getName());
			System.out.println("Ruta relativa fichero: " + fichero.getPath());
			System.out.println("Ruta absoluta fichero: " + fichero.getAbsolutePath());
			System.out.println("Tamaño del fichero: " + fichero.length());
			System.out.println("Permiso lectura: " + fichero.canRead());
			System.out.println(fichero);
			
			try {				
				//#############################################################################################
				//##########SOLO SE PUEDE USAR UNO U OTRO, NO SE PUEDE HACER 2 PROCESOS A LA VEZ###############
				//#############################################################################################
				//FileWriter escritura = new FileWriter(fichero);
				//PrintWriter pw = new PrintWriter(escritura);
				//BufferedWriter bw = new BufferedWriter(escritura); // Hace lo mismo que PrintWriter, pero con distintos metodos
				
				BufferedWriter bwpw = new BufferedWriter(new FileWriter(fichero, true)); /*Esto sirve para que no sobreescriba el contenido, por mas que se repita
				si usas esto, no puedes utilizar otros procesos, es decir printwriter, bufferedwriter, filewwriter...*/
				
				for (int i = 0; i < 10; i++) {
					
					// PrintWriter
					//pw.println("Linea " + i);
					// BufferedWriter
					//bw.write("Linea " + i);
					//bw.newLine();// Salto de linea para el BufferedWriter
					bwpw.write("Linea "+i);
					bwpw.newLine();


				}

				//pw.close();
				//bw.close();
				bwpw.close();
				
				FileReader lector = new FileReader(fichero);
				BufferedReader buffer = new BufferedReader(lector);

				String linea = buffer.readLine();
				while (linea != null) {
					System.out.println("Contenido: " + linea);
					linea = buffer.readLine();

				}
				lector.close();

			} catch (IOException e) {
				// TODO: handle exception
				e.getMessage();
			}

		
	}

}
