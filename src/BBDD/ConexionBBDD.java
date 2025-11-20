package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConexionBBDD {

	private static String URLbaseDeDatos = "jdbc:mysql://localhost:3306/jugueteria";
	private static String drive = "com.mysql.cj.jdbc.Driver";
	private static String usuario = "root";
	private static String contraseña = "root";

	// Le asigno la conexion de la BD para acceder mas comodo a traves de un static
	private static Connection conexion = conexionBD();

	private static Connection conexionBD() {
		Connection conexionBD = null;
		try {

			Class.forName(drive);
			// Seteo al static conexion, la conexion de la BD
			conexionBD = DriverManager.getConnection(URLbaseDeDatos, usuario, contraseña);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la conexion de la base de datos");
			e.printStackTrace();
		}

		return conexionBD;
	}

	// Sentencia de insercion para un nuevo empleado que se pasa por parametro al metodo nuevoEmpleado de la clase Empleado
	private static Empleado nuevoEmpleado() {
		Scanner scanner = new Scanner(System.in);

		Empleado empleadoNuevo = new Empleado(null, null); // nombre | cargo | fecha

		// NOMBRE
		boolean cargo = false;
		boolean nombre = false;

		int banderaNombreEmpleado = 3;
		System.out.println("Introduce el nombre del empleado a añadir: ");
		do {
			String nombreEmpleado = scanner.nextLine();

			if (empleadoNuevo.comprobacionNombre(nombreEmpleado)) {
				empleadoNuevo.setNombre(nombreEmpleado); // Seteo el nombre del empleado nuevo
				banderaNombreEmpleado = 0; // Salgo del bucle
				nombre = true;
			} else {
				System.out.println("Error, has introducido un nombre no valido. Intentelo de nuevo("
						+ --banderaNombreEmpleado + "/3): ");
			}
		} while (banderaNombreEmpleado != 0);

		// CARGO
		if (nombre) {
			int banderaCargoEmpleado = 3;
			System.out.print("Introduce el cargo del empleado (Jefe / Cajero): ");
			do {
				String cargoEmpleado = scanner.nextLine();
				if (empleadoNuevo.comprobacionCargo(cargoEmpleado)) {
					if (cargoEmpleado.equals("jefe")) {
						empleadoNuevo.setCargo(CargoEmpleado.JEFE); // Seteo el cargo del empleado nuevo
						banderaCargoEmpleado = 0; // Salgo del bucle
						cargo = true;
					} else {
						empleadoNuevo.setCargo(CargoEmpleado.CAJERO);
						banderaCargoEmpleado = 0; // Salgo del bucle
						cargo = true;
					}
				} else {
					System.out.println("Error, has introducido un nombre no valido. Intentelo de nuevo("
							+ --banderaCargoEmpleado + "/3): ");
				}
			} while (banderaCargoEmpleado != 0);
		}

		// Si el nombre y el cargo son correctos llamo al metodo que pasa los datos del objeto nuevo para realizar la insercion
		if (nombre && cargo) {
			insertNuevoEmpleado(empleadoNuevo);
		} else {
			System.out.println(
					"No se ha podido agregar ningun empleado porque has introducido datos erroneos y el empleado es NULL");
		}

		return null;

	}

	private static void insertNuevoEmpleado(Empleado empleadoNuevo) {
		empleadoNuevo.sentenciaNuevoEmpleado(empleadoNuevo, conexion); // Llamo al metodo que esta en Empleado con la sentencia correcta para la insercion del nuevo empleado
	}

	// Mostrar todos los empleados existentes
	private static void mostrarTablaEmpleados() {
		try {
			Empleado consultaTablaEmpleado = new Empleado();
			ResultSet mostrarEmpleados = consultaTablaEmpleado.mostrarEmpleados(conexion); // Paso de la clase Empleado los datos obtenidos de la consulta, para leerlos en el main

			if (mostrarEmpleados != null) {
				while (mostrarEmpleados.next()) {

					System.out.println("IdEmpleado: " + mostrarEmpleados.getInt("idEMPLEADO") + " | Nombre: "
							+ mostrarEmpleados.getString("Nombre") + " | Cargo: " + mostrarEmpleados.getString("Cargo")
							+ " | Fecha_Ingreso: " + mostrarEmpleados.getDate("Fecha_Ingreso"));
				}
			} else {
				System.out.println("No ha datos existentes");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void eliminarEmpleado() {
		Scanner scanner = new Scanner(System.in);

		Empleado eliminarEmpleado = new Empleado();
		int banderaComprobacionID = 3;

		System.out.println("Introduce el id a eliminar");
		do {
			String id = scanner.nextLine();

			if (eliminarEmpleado.comprobacionID(id)) {
				// Aunque el empleado no existe mysql retorna todos los datos a null, entonces lo paso todo al objeto eliminarEmpleado y compruebo que el id no sea 0, si es 0, se que no existe y cojo el id porque no se repite nunca
				eliminarEmpleado = eliminarEmpleado.consultarExistenciaEmpleado(Integer.parseInt(id), conexion);

				if (eliminarEmpleado.getIdEmpleado() != 0) {
					// Si existe, ejecuto la sentencia de eliminacion
					if (eliminarEmpleado.eliminarEmpleado(Integer.parseInt(id), conexion)) { // Si el metodo retorna true es que se ha borrado
						System.out.println("Empleado eliminado");
						System.out.println(eliminarEmpleado.toString());
						banderaComprobacionID = 0;
					}
				} else {
					System.out
							.println("Error, el id no existe. Intetelo de nuevo(" + --banderaComprobacionID + "/3): ");
				}

			} else {
				System.out.println("Error, has introducido un id no valido. Intentelo de nuevo("
						+ --banderaComprobacionID + "/3): ");
			}
		} while (banderaComprobacionID != 0);
	}

	private static void modificarDatosEmpleado() {

		Scanner scanner = new Scanner(System.in);

		Empleado modificarEmpleado = new Empleado();
		int banderaComprobacionID = 3;
		boolean existeEmpleado = false; // Boolean para separar codigo y que no haya 30 bucles o 30 ifs en un solo bloque
		boolean campoNombre = false; // Lo mismo que con el existe
		boolean campoCargo = false;

		System.out.println("Introduce el id del empleado a modificar");
		do {
			String idEmpleado = scanner.nextLine();
			if (modificarEmpleado.comprobacionID(idEmpleado)) {
				modificarEmpleado = modificarEmpleado.consultarExistenciaEmpleado(Integer.parseInt(idEmpleado),
						conexion);
				if (modificarEmpleado.getIdEmpleado() != 0) {
					existeEmpleado = true; // no puedo usar el banderaComprobacionID como condicion, porque si falla tambien se setea a 0 y se ejecutaria
					banderaComprobacionID = 0;
				} else {
					System.out
							.println("Error, el id no existe. Intetelo de nuevo(" + --banderaComprobacionID + "/3): ");
				}
			} else {
				System.out.println("Error, el id no existe. Intetelo de nuevo(" + --banderaComprobacionID + "/3): ");
			}
		} while (banderaComprobacionID != 0);

		// Si existe el empleado pregunta el campo a modificar
		if (existeEmpleado) {
			int banderaComprobacionCampo = 3;
			System.out.println("Introduce el campo a modificar (Nombre / Cargo): ");
			do {
				String campoAModificar = scanner.nextLine();
				String expReg = "^[a-zA-Z]{5,6}$";

				if (campoAModificar.matches(expReg)) {

					if (campoAModificar.toLowerCase().trim().equals("nombre")) {
						campoNombre = true;
					} else if (campoAModificar.toLowerCase().trim().equals("cargo")) {
						campoCargo = true;
					}

					banderaComprobacionCampo = 0;

				} else {
					System.out.println("Error, has introducido un valor incorrecto. Intetelo de nuevo("
							+ --banderaComprobacionCampo + "/3): ");

				}
			} while (banderaComprobacionCampo != 0);
		}

		if (campoNombre) {

			int banderaComprobacionNombre = 3;

			System.out.println("Introduce el nuevo nombre; ");
			do {
				String nuevoNombreEmpleado = scanner.nextLine();

				if (modificarEmpleado.comprobacionNombre(nuevoNombreEmpleado)) {
					modificarEmpleado.setNombre(nuevoNombreEmpleado);
					banderaComprobacionNombre = 0;
					System.out.println(modificarEmpleado.toString());
					modificarEmpleado.sentenciaModificarEmpleado(modificarEmpleado, conexion);
				} else {
					System.out.println("Error, has introducido un nombre incorrecto. Intetelo de nuevo("
							+ --banderaComprobacionNombre + "/3): ");
				}
			} while (banderaComprobacionNombre != 0);

		}

		if (campoCargo) {

			int banderaComprobacionCargo = 3;

			System.out.println("Introduce el nuevo cargo (jefe/cajero): ");
			do {
				String nuevoCargoEmpleado = scanner.nextLine();
				if (modificarEmpleado.comprobacionCargo(nuevoCargoEmpleado)) {

					if (nuevoCargoEmpleado.toUpperCase().trim().equals("JEFE")) {
						modificarEmpleado.setCargo(CargoEmpleado.JEFE);
					} else {
						modificarEmpleado.setCargo(CargoEmpleado.CAJERO);
					}
					modificarEmpleado.sentenciaModificarEmpleado(modificarEmpleado, conexion);
					banderaComprobacionCargo = 0;

				} else {
					System.out.println("Error, has introducido un cargo incorrecto. Intetelo de nuevo("
							+ --banderaComprobacionCargo + "/3): ");
				}
			} while (banderaComprobacionCargo != 0);
		}

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Establezco conexion con la base de datos
		conexionBD();

		// Inserto un nuevo empleado
		// nuevoEmpleado();

		// Mostrar todos los empleados existentes
		// mostrarTablaEmpleados();

		// Elimino un empleado por id
		// eliminarEmpleado();

		// Modifico un empleado por id
		modificarDatosEmpleado(); // FALTA CONTROL DE ERRORES :)

	}

}
