package BBDD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * -- Creo el empleado
 * insert into empleado(idEMPLEADO, Nombre, Cargo, Fecha_ingreso) VALUES(1, "Ruben2", 'jefe', "2001-01-21");
 *
 * -- Creo el juguete 1
 * insert into juguete(idJuguete, Nombre, Descripcion, Precio, Cantidad_stock) VALUES(1, "Oso", "Peluche en forma de oso", 3.99, 120); 
 * -- Creo el juguete 2
 * insert into juguete(idJuguete, Nombre, Descripcion, Precio, Cantidad_stock) VALUES(2, "Bicicleta", "Bicicleta roja", 93.99, 33); 
 *
 * -- Creo la zona 1
 * insert into zona(idzona, Nombre, Descripcion) VALUES(1, "Zona 1", "Almacen de juguetes"); 
 * -- Creo la zona 2
 * insert into zona(idzona, Nombre, Descripcion) VALUES(2, "Zona 2", "Almacen de peluches"); 
 *
 * -- Creo el stand 1, en la zona 1
 * insert into stand(idStand, Nombre, Descripcion, ZONA_idzona) VALUES(1, "Stand 1", "Almacen de juguetes", 1);
 * -- Creo el stand 2, en la zona 2
 * insert into stand(idStand, Nombre, Descripcion, ZONA_idzona) VALUES(2, "Stand 2", "Almacen de peluches", 2); 
 *
 * -- Creo el stock de la stand 1, del zona 1, del juguete 1, con una cantidad DISPONIBLE de 120
 * insert into stock(STAND_idStand, STAND_ZONA_idzona, JUGUETE_idJuguete, CANTIDAD) VALUES(1, 1, 1, 120);
 * -- Creo el stock de la stand 1, de la zona 1, del juguete 2, con una cantidad DISPONIBLE de 12
 * insert into stock(STAND_idStand, STAND_ZONA_idzona, JUGUETE_idJuguete, CANTIDAD) VALUES(2, 2, 2, 12); 
 *
 * -- Creo la venta 1, del juguete 1, con el empleado 1, lo cojo del stand 1, de la zona 1
 * insert into venta(idventa, Fecha, Monto, tipo_pago,JUGUETE_idJuguete, EMPLEADO_idEMPLEADO,STAND_idStand,STAND_ZONA_idzona) 
 *	 VALUES(1, CURRENT_DATE, 1 , 'efectivo', 1, 1, 1, 1); 
 * -- Creo la venta 2, del juguete 1, con el empleado 1, lo cojo del stand 1, de la zona 1
 * insert into venta(idventa, Fecha, Monto, tipo_pago,JUGUETE_idJuguete, EMPLEADO_idEMPLEADO,STAND_idStand,STAND_ZONA_idzona) 
 * 	 VALUES(2, CURRENT_DATE, 315 , 'efectivo', 1, 1, 1, 1);
 * 
 * -- Creo el cambio 1, muevo del stand 2, de la zona 2, el juguete 2, <- hacia -> el stand 1, de la zona 1, el juguete 2, con el empleado 1
 * insert into cambio(idCAMBIO, MOTIVO, Fecha, STOCK_STAND_idStand_Original, STOCK_STAND_ZONA_idzona_Original, STOCK_JUGUETE_idJuguete_Original, STOCK_STAND_idStand_Nuevo, STOCK_STAND_ZONA_idzona_Nuevo, STOCK_JUGUETE_idJuguete_Nuevo, EMPLEADO_idEMPLEADO)
 *   VALUES(1, "Cambio juguete 2 ", CURRENT_DATE, 2, 2, 2, 1, 1, 2, 1);
*/

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
					if (cargoEmpleado == "jefe") {
						empleadoNuevo.setCargo(CargoEmpleado.jefe); // Seteo el cargo del empleado nuevo
						banderaCargoEmpleado = 0; // Salgo del bucle
						cargo = true;
					} else {
						empleadoNuevo.setCargo(CargoEmpleado.cajero);
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

	public static void insertNuevoEmpleado(Empleado empleadoNuevo) {
		empleadoNuevo.sentenciaNuevoEmpleado(empleadoNuevo, conexion); // Llamo al metodo que esta en Empleado con la sentencia correcta para la insercion del nuevo empleado
	}

	// Mostrar todos los empleados existentes
	public static void mostrarTablaEmpleados() {
		try {
			Empleado consultaTablaEmpleado = new Empleado();
			ResultSet mostrarEmpleados = consultaTablaEmpleado.mostrarEmpleados(conexion); // Paso de la clase Empleado los datos obtenidos de la consulta, para leerlos en el main

			if (mostrarEmpleados != null) {
				while (mostrarEmpleados.next()) {

					System.out.println("IdEmpleado: " + mostrarEmpleados.getInt("idEMPLEADO") + " | Nombre: "
							+ mostrarEmpleados.getString("Nombre") + " | Cargo" + mostrarEmpleados.getString("Cargo")
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

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Establezco conexion con la base de datos
		conexionBD();

		// Inserto un nuevo empleado
		// nuevoEmpleado();

		// Mostrar todos los empleados existentes
		// mostrarTablaEmpleados();

		Empleado modificarEmpleado = new Empleado();
		
		modificarEmpleado.consultarExistenciaEmpleado(3, conexion);

	}

}
