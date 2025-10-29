package tema2.apuntes.BaseDeDatos.ejercicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class ejercicio1 {

	public static void mostrarConsulta(ResultSet resultadoConsulta) {
		// 4. Mostrar resultados

		try {
			// 4. Mostrar resultados
			while (resultadoConsulta.next()) { // next devuelve true hasta que sea null
				// En el get tiene que ser el nombre exacto de la columna en el sql
				int codigo = resultadoConsulta.getInt("codigo");
				String nombre = resultadoConsulta.getString("Nombre");
				String procedencia = resultadoConsulta.getString("Procedencia");
				String altura = resultadoConsulta.getString("Altura");
				int peso = resultadoConsulta.getInt("Peso");
				String posicion = resultadoConsulta.getString("Posicion");
				String nombreEquipo = resultadoConsulta.getString("Nombre_equipo");

				System.out.println("ID: " + codigo + " | Nombre: " + nombre + " | Procedencia: " + procedencia
						+ " | Altura: " + altura + " | Peso: " + peso + " | Posicion: " + posicion
						+ " | Nombre de equipo: " + nombreEquipo);

			}
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/nba";
		String usuario = "root";
		String contraseña = "cfgs";

		try {
			// 1. Cargar el drive de la BD
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Crear conexion
			Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
			System.out.println("Conexion establecida");

			// 3 Crear un PreparedStatement
			System.out.println("1. Filtar jugadores por su inicial");
			System.out.println("2. El peso promedio de los jugadores");
			System.out.println("3. Listado de equipos y mostrar los jugadores de un equipo seleccionado");
			System.out.println("4. Insertar un jugador");
			System.out.println("5. Salir");
			Scanner scanner = new Scanner(System.in);
			int opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				scanner.nextLine();
				System.out.println("Introduce la letra que quieres buscar: ");
				String letra = scanner.nextLine();
				letra += "%";
				String consulta = "select * from jugadores where Nombre like ?";
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				sentencia.setString(1, letra); 
				ResultSet resultadoConsulta = sentencia.executeQuery();
				
				mostrarConsulta(resultadoConsulta);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				break;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
