package tema2.apuntes.BaseDeDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class mainConexionArreglandoBulnerabilidad {

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

			// 3.1 Crear un Statement (Crear una clase que permite insetar consultas)
			/*
			 * Statement sentencia=conexion.createStatement(); 
			 * String consulta ="select*from usuario where idUSUARIO = 1"; 
			 * ResultSet resultadoConsulta=sentencia.executeQuery(consulta);
			 */

			// 3.2 Crear un PreparedStatement
			String consulta = "select * from usuario where idUSUARIO = ? or nombre = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setInt(1, 1); // El segundo 1, se cambia por el '?'
			sentencia.setString(2, "leo"); //El primer numero, busca la segunda '?'
			ResultSet resultadoConsulta = sentencia.executeQuery();

			// 4. Mostrar resultados
			while (resultadoConsulta.next()) { // next devuelve true hasta que sea null
				// En el get tiene que ser el nombre exacto de la columna en el sql
				int idUsuario = resultadoConsulta.getInt("idUSUARIO"); 
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
