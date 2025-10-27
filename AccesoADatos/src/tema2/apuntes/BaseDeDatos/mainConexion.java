package tema2.apuntes.BaseDeDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class mainConexion {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydb";
		String usuario = "root";
		String contraseña = "cfgs";

		try {
			// 1. Cargar el drive de la BD
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Crear conexion
			Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
			System.out.println("Conexion establecida");

			// 3. Crear un Statement (Crear una clase que permite insetar consultas)
			Statement sentencia = conexion.createStatement();
			String consulta = "select * from usuario";
			ResultSet resultadoConsulta = sentencia.executeQuery(consulta);

			// 4. Mostrar resultados
			while (resultadoConsulta.next()) { // next devuelve true hasta que sea null
				int idUsuario = resultadoConsulta.getInt("idUSUARIO"); // En el get tiene que ser el nombre exacto de la columna en el sql
				String nombre = resultadoConsulta.getString("Nombre");
				Date fecha = resultadoConsulta.getDate("FechaDeNacimiento");
				String genero = resultadoConsulta.getString("Genero");

				System.out.println(
						"ID: " + idUsuario + " | Nombre: " + nombre + " | Fecha: " + fecha + " | Genero: " + genero);

			}
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}

	}

}
