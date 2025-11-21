package tema2.apuntes.BaseDeDatos.ejercicios._2_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/nba";
		String usuario = "root";
		String password = "cfgs";

		try {
			// 1. Cargar el drive de la BD
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Crear conexion
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			System.out.println("Conexion establecida");

			// 3 Crear un PreparedStatement
			System.out.println("1. Filtar jugadores por su inicial");
			System.out.println("2. El peso promedio de los jugadores");
			System.out.println("3. Listado de equipos y mostrar los jugadores de un equipo seleccionado");
			System.out.println("4. Insertar un jugador");
			System.out.println("5. Salir");
			Scanner scanner = new Scanner(System.in);
			int opcion = scanner.nextInt();
			int lineas = 0;
			switch (opcion) {
			case 1:
				scanner.nextLine();
				System.out.println("Introduce el codigo a eliminar: ");
				int codigo = scanner.nextInt();

				// No hay borrado en cascada, por lo tanto necesito borrar a mano
				String consulta = "Select * from estadisticas where jugador = ?";
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				sentencia.setInt(1, codigo);
				if (sentencia.execute()) { // Devuelve un boolean
					String consultaBorradoEstaditicas = "delete from estadisticas where jugador = ?";
					PreparedStatement sentenciaBorradoEstadisticas = conexion.prepareStatement(consultaBorradoEstaditicas);
					sentenciaBorradoEstadisticas.setInt(1, codigo);
					lineas = sentenciaBorradoEstadisticas.executeUpdate();
					if (lineas > 0) {
						System.out.println("Se han borrado todas las estdisticas del jugador: " + codigo);
					}
				}

				String consultaBorrado = "delete from jugadores where codigo = ?";
				PreparedStatement sentenciaBorrado = conexion.prepareStatement(consultaBorrado);
				sentenciaBorrado.setInt(1, codigo);
				lineas = sentenciaBorrado.executeUpdate();
				if (lineas > 0) {
					System.out.println("Se ha borrado al jugador: " + codigo);
				}
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

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
