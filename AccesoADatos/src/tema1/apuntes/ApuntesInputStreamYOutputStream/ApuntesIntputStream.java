package tema1.apuntes.ApuntesInputStreamYOutputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ApuntesIntputStream {

	public static void LecturaDatos() {

		try {
			
			/*
			 * DataOutputStream -> escribe en bytes, sabe cómo transformar los tipos primitivos 
			 * de Java (int, double, boolean, UTF String…) en bytes automáticamente, de una forma estándar.
			 * FileOutputStream -> es una clase de Java que permite escribir bytes en un archivo.
			 */
			
			/*
			 * DIFERENCIA CON BufferedWriter y DataOutputStream
			 * 
			 * BufferedWriter -> Solo escribe string, y si quieres escribir primitivos, tienes que hacer una conversion malgastando memoria, por ejemplo para sumar
			 * DataOutputStream -> Escribe cualquier dato primitivo, y no necesita hacer ninguna conversion
			 */
			
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("datos.dat"));
			dos.writeInt(25); //→ ocupa 4 bytes (00 00 00 19 en hexadecimal).
			dos.writeDouble(3.14); //double → ocupa 8 bytes (representación IEEE 754 de 3.14).
			dos.writeBoolean(true); //boolean → ocupa 1 byte (01).
			dos.writeUTF("Hola Mundo"); //UTF → primero escribe 2 bytes con la longitud (00 04), y luego cada carácter en UTF (48 6F 6C 61 en hexadecimal).
			dos.close();
			
			
			/*
			 * FileInputStream -> Abre el fichero.dat 
			 * DataInputStream -> Permite leer tipo de datos primitivos, en el mismo orden en el que fueron escritos
			 * Input (entrada) → lo que entra al programa (lo que lees de teclado, de un fichero, de la red, etc.).
			 */

			/*
			 * DIFERENCIA CON BufferedReader y FileReader
			 * 
			 * BufferedReader -> En el archivo puedes abrirlo con el bloc de notas y ver los valores claramente, porque está escrito como texto.
			 * DataInputStream -> Ese archivo en un editor de texto no se entiende, porque no está escrito "25", "3.14"… sino los bytes binarios que representan esos valores.
			 */
			
			DataInputStream dis = new DataInputStream(new FileInputStream("datos.dat"));
			int entero = dis.readInt();
			double doble = dis.readDouble();
			boolean boleano = dis.readBoolean();
			String frase = dis.readUTF();

			System.out.println("\nEntero: " + entero);
			System.out.println("Double: " + doble);
			System.out.println("Boolean: " + boleano);
			System.out.println("Frase: " + frase);

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void lecturaPersonas() {

		try {

			/*
			 * FileInputStream -> Abre el archivo personas.dat en modo lectura de bytes.
			 * ObjectInputStream -> Envuelve el FileInputStream y permite leer objetos SERIALIZADOS que fueron guardados en el archivo.
			 * 		¿Que es leer objetos SERIALIZADOS?
			 * 		Los objetos de Java no se pueden guardar directamente en un archivo como los primitivos (int, double, etc.), porque un 
			 * 		objeto es una estructura compleja con atributos, referencias a otros objetos, y métodos.
			 *		 - Por ejemplo, un objeto Persona tiene nombre y edad.
			 *		 - Para guardar eso en un archivo necesitamos “aplanarlo” en bytes, y eso es lo que hace la serialización.
			 *
			 * ois.readObject() - >readObject() lee la siguiente secuencia de bytes del archivo y trata de reconstruir el objeto que fue guardado con ObjectOutputStream.
			 */

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personas.dat")); //lee el archivo .dat
			ArrayList<Persona> personas = (ArrayList<Persona>) ois.readObject(); //readObject() lee los objetos guardados en el archivo .dat.
			System.out.println("Las personas almacenadas en el fichero son:");
			for (Persona persona : personas) {
				System.out.println(persona.toString());
			}
			ois.close();

		} catch (IOException e) {
			// TODO: handle exception
			e.getStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona("Ruben", 20));
		personas.add(new Persona("Luis", 21));
		personas.add(new Persona("Mateo", 23));
		lecturaPersonas();
		LecturaDatos();

	}

}
