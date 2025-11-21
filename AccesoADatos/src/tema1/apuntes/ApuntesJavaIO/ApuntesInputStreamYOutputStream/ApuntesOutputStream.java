package tema1.apuntes.ApuntesJavaIO.ApuntesInputStreamYOutputStream;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ApuntesOutputStream {

	public static void escrituraDatos() {
		File ficheroDatos = new File("datos.dat");

		try {
			if (!ficheroDatos.exists()) {
				ficheroDatos.createNewFile();
			}

			DataOutputStream dos = new DataOutputStream(new FileOutputStream(ficheroDatos));
			dos.writeInt(2);
			dos.writeDouble(1.2);
			dos.writeBoolean(false);
			dos.writeUTF("Hola que tal");
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();		}
	}

	public static void escrituraPersonas(ArrayList<Persona> personas) {

		String fichero = "personas.dat";

		File ficheroEscritura = new File(fichero);
		if (!ficheroEscritura.exists()) {
			try {
				ficheroEscritura.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			if (ficheroEscritura.isFile()) {
				try {
					// Lo abro para escritura en bytes
					FileOutputStream fos = new FileOutputStream(ficheroEscritura);

					 /* 
					 * ObjectInputStream -> permite escribir objetos SERIALIZADOS que fueron guardados en el archivo.
					 * 	  ¿Que es escribir objetos SERIALIZADOS?
					 * 	  Los objetos de Java no se pueden guardar directamente en un archivo como los primitivos (int, double, etc.), porque un 
					 * 	  objeto es una estructura compleja con atributos, referencias a otros objetos, y métodos.
					 *	   - Por ejemplo, un objeto Persona tiene nombre y edad.
					 *	   - Para guardar eso en un archivo necesitamos “aplanarlo” en bytes, y eso es lo que hace la serialización.
					 */
					
					ObjectOutputStream oos = new ObjectOutputStream(fos);

					oos.writeObject(personas);
					oos.close();

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				System.out.println("No es un fichero");
			}
		}

	}

	public static void main(String[] args) {

		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona("Ruben", 20));
		personas.add(new Persona("Luis", 21));
		personas.add(new Persona("Mateo", 23));
		escrituraPersonas(personas);
		escrituraDatos();

	}

}
