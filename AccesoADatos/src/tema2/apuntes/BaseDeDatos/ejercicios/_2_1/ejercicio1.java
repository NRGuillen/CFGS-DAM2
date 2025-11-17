package tema2.apuntes.BaseDeDatos.ejercicios._2_1;

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

				System.out.println("ID: " + codigo + " | Nombre: " + nombre + " | Procedencia: " + procedencia + " | Altura: " + altura + " | Peso: " + peso + " | Posicion: " + posicion + " | Nombre de equipo: " + nombreEquipo);

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
				scanner.nextLine();
				String consulta2 = "select avg(*) from jugadores";
				PreparedStatement sentencia2 = conexion.prepareStatement(consulta2);
				// sentencia2.setString(1, "(Peso)");
				ResultSet resultadoConsulta2 = sentencia2.executeQuery();

				while (resultadoConsulta2.next()) { // next devuelve true hasta que sea null
					// En el get tiene que ser el nombre exacto de la columna en el sql

					int peso = resultadoConsulta2.getInt("Peso");

					System.out.println("Peso: " + peso);

				}

				mostrarConsulta(resultadoConsulta2);
				break;
			case 3:

				ArrayList<String> nombresEquipo = new ArrayList<String>();

				String consulta3 = "select nombre from equipos";
				PreparedStatement sentencia3 = conexion.prepareStatement(consulta3);
				ResultSet resultadoConsulta3 = sentencia3.executeQuery();
				int contador = 0;
				while (resultadoConsulta3.next()) {
					String nombre = resultadoConsulta3.getString("nombre");
					System.out.println("Nombre: " + nombre);
					nombresEquipo.add(nombre);
					contador++;
				}
				scanner.nextLine();
				System.out.println("Introduce el nombre del equipo: ");
				String numeroEquipo = scanner.nextLine();

				String insercion3 = "select nombre from jugadores where Nombre_equipo = ?";
				PreparedStatement insercionSentencia3 = conexion.prepareStatement(insercion3);
				for (String string : nombresEquipo) {
					if (numeroEquipo.equals(string)) {
						insercionSentencia3.setString(1, string);
						
						ResultSet resultadoCOnsulta3_1 = insercionSentencia3.executeQuery();
						while (resultadoCOnsulta3_1.next()) {
							System.out.println(resultadoCOnsulta3_1.getString("nombre"));
						}
					}
				}

				break;
			case 4:

				// select max(codigo) from jugadores; obtengo el numero de jugadores que hay
				String consulta4 = "select max(codigo) codigo_max from jugadores";
				PreparedStatement sentencia4 = conexion.prepareStatement(consulta4);
				ResultSet resultadoConsulta4 = sentencia4.executeQuery();
				int codigo = 0;
				while (resultadoConsulta4.next()) {
					codigo = resultadoConsulta4.getInt(1);
				}
				scanner.nextLine();
				System.out.println("Introduce los datos del jugador (nombre): ");
				String nombre = scanner.nextLine();

				String insercion4 = "insert into jugadores (codigo, Nombre) VALUES(?,?)";
				PreparedStatement insercionSentencia4 = conexion.prepareStatement(insercion4);
				insercionSentencia4.setInt(1, codigo + 1);
				insercionSentencia4.setString(2, nombre);

				int linea = insercionSentencia4.executeUpdate();

				if (linea > 0) {
					System.out.println("Se han cambiado las lineas " + linea);
				}

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
