package BBDD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Empleado {

	int idEmpleado; // PK
	String nombre;
	CargoEmpleado cargo;
	Date fechaIngreso;

	public Empleado() {
		super();
	}

	public Empleado(String nombre, CargoEmpleado cargo) {
		super();
		// El id no lo necesito, porque sql lo setea solo, es autoincremental
		this.nombre = nombre;
		this.cargo = cargo;
		this.fechaIngreso = new Date(System.currentTimeMillis()); // Seteo directamente la fecha cuando se crea el
																	// objeto
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CargoEmpleado getCargo() {
		return cargo;
	}

	public void setCargo(CargoEmpleado cargo) {
		this.cargo = cargo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	// Comprobacion de nombre correcto
	public Boolean comprobacionNombre(String nombre) {

		final String expReg = "^[a-zA-Zñ ]{1,45}$"; // 45 es el varchar nombre de la bd
		if (!nombre.matches(expReg)) {
			return false; // Si no cumple la expReg retorna false
		}
		return true;
	}

	// Comprobacion de cargo correcto
	public Boolean comprobacionCargo(String cargo) {

		if (cargo.toUpperCase().trim().equals("CAJERO") || cargo.toUpperCase().trim().equals("JEFE")) {
			return true;
		}
		return false;

	}

	// Comprobacion de id correcto
	public boolean comprobacionID(String id) {

		final String expReg = "^[0-9]{1,4}$";
		if (id.matches(expReg)) {
			return true;
		}
		return false;
	}

	// Sentencia para insertar un nuevo empleado
	public PreparedStatement sentenciaNuevoEmpleado(Empleado empleadoNuevo, Connection conexion) {

		try {
			String insercion = "insert into empleado(Nombre, Cargo, Fecha_ingreso) values(?, ? ,?)";
			PreparedStatement sentencia = conexion.prepareStatement(insercion);

			// Seteo los datos, cogidos de el objeto empleado
			sentencia.setString(1, empleadoNuevo.getNombre());
			sentencia.setString(2, empleadoNuevo.getCargo().toString()); // Lo paso a string porque no admite enums y se vera igual
			sentencia.setDate(3, empleadoNuevo.getFechaIngreso());

			sentencia.executeUpdate(); // Ejecuto la sentencia en update porque añado datos

			return sentencia;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public Boolean eliminarEmpleado(int id, Connection conexion) {

		try {
			String consulta = "delete empleado from empleado where idEMPLEADO = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setInt(1, id);
			sentencia.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public Boolean sentenciaModificarEmpleado(Empleado empleadoNuevo, Connection conexion) {

		try {
			String consulta = "update empleado SET Nombre = ?, Cargo = ?  where idEMPLEADO = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, empleadoNuevo.getNombre());
			sentencia.setString(2, empleadoNuevo.getCargo().toString());
			sentencia.setInt(3, empleadoNuevo.getIdEmpleado());
			sentencia.executeUpdate();

			return true;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	// Consulta para mostrar todos los empleados
	public ResultSet mostrarEmpleados(Connection conexion) { // ResultSet porque no inserto ni modifico nada
		try {
			String consulta = "select * from empleado";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			return sentencia.executeQuery(); // Retorno el resulset de la consulta para leerlo en el main

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	// Retorno empleado ya que quiero obtener todos los datos y modificar el que yo quiera, por lo tanto es mas facil setearlos teniendolos todos
	public Empleado consultarExistenciaEmpleado(int idEmpleado, Connection conexion) {
		Empleado empleadoModificar = new Empleado();
		try {
			String consulta = "select * from empleado where idEMPLEADO = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setInt(1, idEmpleado);
			// Compruebo la existencia
			ResultSet comprobarExistencia = sentencia.executeQuery();

			if (comprobarExistencia.next() != false) { // Si el execute retorna una linea el next retorna true y por ende existe el empleado
				empleadoModificar.setIdEmpleado(comprobarExistencia.getInt("idEMPLEADO"));
				empleadoModificar.setNombre(comprobarExistencia.getString("Nombre"));

				// Como el cargo es un enum, no puedo hacer un seteo de un string a un enum, entonces lo seteo en un string y el string lo paso a enum
				String cargoEnum = comprobarExistencia.getString("Cargo").toUpperCase(); // Como lo coje de la BD esta en minusculas y en el enum en mayusculas, si no pongo el upper daria error
				empleadoModificar.setCargo(CargoEmpleado.valueOf(cargoEnum));

				empleadoModificar.setFechaIngreso(comprobarExistencia.getDate("Fecha_ingreso"));

			}

			return empleadoModificar;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public String toString() {
		return "IdEmpleado: " + idEmpleado + " | Nombre: " + nombre + " | Cargo: " + cargo + " | Fecha_Ingreso: "
				+ fechaIngreso;
	}

}
