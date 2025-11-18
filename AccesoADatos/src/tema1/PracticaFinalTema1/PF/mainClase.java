package tema1.PracticaFinalTema1.PF; //Para funcionar el paquete deberia llamarse solo PF

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class mainClase {

	// 6.2, esta en la clase de Ticket

	static final String plantasXML = "plantas.xml";
	static final String plantasBajaXML = "plantasBaja.xml";
	static final String plantasDAT = "plantas.dat";
	static final String empleadoDAT = "empleado.dat";
	static final String empleadoBajaDAT = "empleadoBaja.dat";

	static String rutaGlobalStatic;
	static String rutaSrcPlantas = rutaGlobalStatic + "PLANTAS";
	static String rutaSrcEmpleados = rutaGlobalStatic + "EMPLEADOS";
	static String rutaSrcEmpleadosBaja = rutaGlobalStatic + "EMPLEADOS\\BAJA";
	static String rutaSrcTickets = rutaGlobalStatic + "TICKETS";
	static String rutaSrcDevoluciones = rutaGlobalStatic + "DEVOLUCIONES";

	static int contadorTickets = 1;
	static int idEmpleadoIiciado;
	static long tamañoDat; // Coge el tamaño total del plantas.dat, usado en generarCompras para que el
							// usuario introduzca un id correcto

	public static void inicioSesion(ArrayList<Empleado> empleadosVerificados, ArrayList<Plantas> plantasCaracteristicas,
			ArrayList<Ticket> tickets, ArrayList<Ticket> ticketsDevolucion, ArrayList<Empleado> empleadosSinVerificar,
			ArrayList<Empleado> empleadosDeBaja, ArrayList<Plantas> plantasDeBaja) {
		Scanner scanner = new Scanner(System.in);
		Empleado empleadoID = null;

		do {
			String expReg = "^[0-9]{4}$";
			int bandera = 0;
			do {
				System.out.print("\nIntroduce tu identificacion : ");
				String identificacion = scanner.nextLine();
				if (identificacion.matches(expReg)) {
					for (Empleado empleado : empleadosVerificados) {
						int idEmpleado = Integer.parseInt(identificacion);
						// 3.1
						if (empleado.getIdentificacion() == idEmpleado) {
							empleadoID = empleado;
							idEmpleadoIiciado = idEmpleado;
							bandera = 1;
						}
					}

					if (empleadoID == null) {
						// 3.3
						System.out.println("No existe ningun empleado con la id " + identificacion);
					}
				} else {
					System.out.println("La identificacion " + identificacion
							+ " no cumple con los parametros permitidos, intentalo de nuevo:");
				}

			} while (bandera == 0);

		} while (empleadoID == null);

		int bandera = 0;
		int banderaPass = 0;
		String expRegStrings = "^[a-zA-Z0-9ñ._!$%&@()+-]{5,7}$";

		do {
			System.out.print("Introduce la contraseña : ");
			do {
				String contraseña = scanner.nextLine();

				if (contraseña.matches(expRegStrings)) {
					// 3.1
					if (empleadoID.getPassword().equals(contraseña)) {
						System.out.println("\nBienvenid@ de nuevo al sistema de gestion, " + empleadoID.getNombre());
						bandera = 1;
					} else {
						// 3.3
						System.out.println("Contraseña erronea, intentelo de nuevo\n");
					}
					banderaPass = 0;
				} else {
					System.out.println("La contraseña " + contraseña
							+ " no cumple con los parametros permitidos, intentalo de nuevo\n");
				}
			} while (banderaPass != 0);

		} while (bandera == 0);
		// 3.2
		if (empleadoID.getCargo().toLowerCase().trim().equals("vendedor")) {
			menuVendedor(empleadoID, plantasCaracteristicas, empleadosVerificados, tickets, empleadoDAT,
					ticketsDevolucion, rutaSrcEmpleados);
		}
		if (empleadoID.getCargo().toLowerCase().trim().equals("gestor")) {
			menuGestor(empleadoID, plantasCaracteristicas, empleadosSinVerificar, empleadosDeBaja, empleadosVerificados,
					tickets, plantasDeBaja);
		}
	}

	public static void generarCompra(ArrayList<Plantas> plantasCaracteristicas,
			ArrayList<Empleado> empleadosVerificados, ArrayList<Ticket> tickets, String rutaArchivo,
			String nombreArchivo) {
		File archivo = new File(rutaSrcPlantas + "\\" + nombreArchivo);
		RandomAccessFile rafLectura;
		Scanner scanner = new Scanner(System.in);
		String expRegID = "^[0-9]{1,4}$";
		int banderaID = 3;
		Boolean encontrado = false;
		int numeroSeek = 0;
		int stock = 0;
		boolean noExiste = false;
		int codigoTicket = 1;
		Ticket nuevoTicket = new Ticket();

		System.out.print("\nIntroduce el id de la planta a comprar: ");
		// introduce id
		do {
			String buscar = scanner.nextLine();
			// 4.3 5.1
			if (buscar.matches(expRegID)) {
				if (archivo.exists() && archivo.isFile()) {
					if (Integer.parseInt(buscar) <= 0) {
						noExiste = true;
						banderaID = 1;
					} else {
						noExiste = false;
						numeroSeek = ((Integer.parseInt(buscar) * 12) - 12);

					}

					try {
						if (numeroSeek < tamañoDat && !noExiste) {

							rafLectura = new RandomAccessFile(archivo, "r");
							// Como leo el redint en el if, no es necesario ponerlo dentro de nuevo, ya que
							// estoy leyendo de 12 en 12

							for (Plantas plantas : plantasCaracteristicas) {
								rafLectura.seek(numeroSeek);
								if (plantas.getCodigo() == rafLectura.readInt()) {
									rafLectura.seek(numeroSeek);
									if (rafLectura.readFloat() > 0 && rafLectura.readInt() > 0) { // precio y stock
										rafLectura.seek(numeroSeek);
										rafLectura.readInt();
										System.out.println(
												"\n- - - - - - - - - Planta Seleccionada - - - - - - - - - - -");
										System.out.print("# Codigo: " + plantas.getCodigo());
										System.out.print(" | Nombre: " + plantas.getNombre());
										System.out.print(" | Precio: " + rafLectura.readFloat());
										System.out.println(" | Stock: " + rafLectura.readInt());
										System.out.println(
												"- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
										encontrado = true;
									}
								}
							}
							rafLectura.close();
						} else {
							encontrado = false;
						}
						if (!encontrado) {
							System.out.print("No existe ninguna planta con el id " + buscar + ", intentelo de nuevo: ");
						} else {
							banderaID = 0;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				System.out.print("Error, el id introducido no cumple con el formato, le quedan (" + --banderaID
						+ "/3) intentos: ");
			}
		} while (banderaID != 0);

		// Introduce stock
		if (encontrado) {
			System.out.print("Introduce la cantidad a comprar: ");
			String expRegStock = "^[0-9]{1,10}$";
			boolean encontradoCantidad = false;
			int banderaCompra = 3;
			do {
				String stockString = scanner.nextLine();
				// 4.3 5.1 5.2
				if (stockString.matches(expRegStock) && Integer.parseInt(stockString) > 0) {

					stock = Integer.parseInt(stockString);

					try {
						rafLectura = new RandomAccessFile(archivo, "rw");
						// 5.2.1
						rafLectura.seek(numeroSeek + 8);
						int stockActual = rafLectura.readInt();
						if (stock <= stockActual) {

							for (Plantas plantas : plantasCaracteristicas) {
								rafLectura.seek(numeroSeek);
								if (plantas.getCodigo() == rafLectura.readInt()) {
									rafLectura.seek(numeroSeek);
									rafLectura.readInt(); // codigo
									if (rafLectura.readFloat() > 0 && rafLectura.readInt() > 0) { // precio y stock
										rafLectura.seek(numeroSeek);
										rafLectura.readInt();
										System.out.println(
												"\n- - - - - - - - - Planta Actualizada  - - - - - - - - - - -");
										System.out.print("# Codigo: " + plantas.getCodigo());
										System.out.print(" | Nombre: " + plantas.getNombre());
										System.out.print(" | Precio: " + rafLectura.readFloat());
										System.out.println(" | Stock: " + (rafLectura.readInt() - stock));
										System.out.println(
												"- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
										banderaCompra = 0;
										encontradoCantidad = true;
									}
								}
							}
						} else {
							System.out.println("Stock introducido: " + stock);
							rafLectura.seek(numeroSeek + 8);
							System.out.println("Stock disponible: " + rafLectura.readInt());
							System.out.println("Error introducido una cantidad mayor al stock, le quedan ("
									+ --banderaCompra + "/3) intentos: ");
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println(
							"Error, has introducido un formato incorrecto o estas intentando comprar una cantidad igual o menor a cero, le quedan ("
									+ --banderaCompra + "/3) intentos: ");
				}
			} while (banderaCompra != 0);

			// Acepta compra ticket
			if (encontrado && encontradoCantidad) {

				try {
					rafLectura = new RandomAccessFile(archivo, "rw");

					rafLectura.seek(numeroSeek + 4);
					// 5.4.2
					float precioTotal = rafLectura.readFloat() * stock;

					for (Plantas plantas : plantasCaracteristicas) {
						rafLectura.seek(numeroSeek);
						if (plantas.getCodigo() == rafLectura.readInt()) {
							// 5.3
							System.out.println("\n- - - - - - - - - - - Ticket compra - - - - - - - - - - - -");
							System.out.print("# Codigo: " + plantas.getCodigo());
							System.out.print(" | Nombre: " + plantas.getNombre());
							System.out.print(" | Precio Unidad: " + rafLectura.readFloat());
							rafLectura.readInt();
							System.out.println(" | Cantidad: " + stock);
							System.out.println("Precio total: " + precioTotal);
							System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

							System.out.println("\n- - - - - - - - - Confirmacion necesaria - - - - - - - - - -");

							System.out.println(
									"¿Aceptas comprar el producto mostrado en el ticket con opcion a reembolso?");
							System.out.println("   1. Acepto");
							System.out.println("   2. No acepto");
							System.out.print("Opcion: ");
							int opcionAutorizar = 3;
							// 4.3
							String expRegAutorizar = "^[1-2]{1}$";
							do {
								String opcionCompra = scanner.nextLine();

								if (opcionCompra.matches(expRegAutorizar)) {
									// 5.4
									if (Integer.parseInt(opcionCompra) == 1) {
										// 5.4.1
										rafLectura.seek(numeroSeek + 8); // Lo leo
										int actualizarStock = rafLectura.readInt() - stock;
										rafLectura.seek(numeroSeek + 8); // Me posiciono para reescribirlo
										rafLectura.writeInt(actualizarStock);

										rafLectura.seek(numeroSeek);
										// 5.5
										for (Empleado empleado : empleadosVerificados) {
											if (empleado.getIdentificacion() == idEmpleadoIiciado) {
												// 5.5.1, no leo los nombres de los tickets en si, cuentos los archivos
												// entre las 2 carpetas de tickets, los nomrales y los de devolucion, y
												// lo incremento en 1 para que sea el siguiente
												nuevoTicket.setCodigoTicket(contadorTickets);
												nuevoTicket.setCodigoEmpleado(empleado.getIdentificacion());
												nuevoTicket.setNombreEmpleado(empleado.getNombre());
												nuevoTicket.setFecha(new Date());
												rafLectura.seek(numeroSeek);
												nuevoTicket.setCodigoPlanta(rafLectura.readInt());
												nuevoTicket.setPrecio(rafLectura.readFloat());
												rafLectura.readInt();
												nuevoTicket.setStock(stock);
												nuevoTicket.setTotal(precioTotal);

												tickets.add(nuevoTicket);
											}
										}
										// 5.5.2
										try {
											File nuevoticket = new File(
													rutaSrcTickets + "\\" + contadorTickets + "Ticket.txt");
											BufferedWriter bw = new BufferedWriter(new FileWriter(nuevoticket));

											bw.write(nuevoTicket.toString());
											bw.close();
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}

										System.out.println(
												"\n| - - - - - - - - - - - Ticket de compra - - - - - - - - - - - |\n");
										System.out.println(nuevoTicket.toString());

										System.out.println("Compra realizada con exito");
										// Como no vuelvo a leer hasta que reinicie la app, tengo que incrementarlo
										// cuando se crre un ticket
										++contadorTickets;

										opcionAutorizar = 0;
									} else {
										System.out.println("Compra cancelada");
										opcionAutorizar = 0;
									}
								} else {
									System.out.println(
											"Error, introduce 1 o 2 para confirmar o rechazar el ticket, le quedan ("
													+ --opcionAutorizar + "/3) intentos: ");
								}
							} while (opcionAutorizar != 0);

						}
					}
					rafLectura.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

	public static void mostrarCatalogo(ArrayList<Plantas> plantasCaracteristicas, String nombreArchivo) {
		File archivo = new File(rutaSrcPlantas + "\\" + nombreArchivo);
		if (archivo.exists() && archivo.isFile()) {

			try {
				File fichero = new File(rutaSrcPlantas + "\\" + nombreArchivo);
				RandomAccessFile rafLectura = new RandomAccessFile(fichero, "r");

				System.out.println("\n|- - - - - - - Plantas disponibles en el vivero - - - - - - -|");

				for (Plantas plantas : plantasCaracteristicas) {
					rafLectura.seek(plantas.getCodigo() * 12 - 12);
					rafLectura.readInt();
					if (rafLectura.readFloat() > 0 && rafLectura.readInt() > 0) {

						System.out.print("Codigo: " + plantas.getCodigo());
						System.out.print(" | Nombre: " + plantas.getNombre());
						rafLectura.seek(plantas.getCodigo() * 12 - 12);
						/*
						 * codigo 1 * 12 = 12 | 12 - 12 = 0 | seek 0 es la primera planta y como el
						 * codigo cambia en 1 cada bucle lo multiplico por 12, 2 * 12 = 24 | 24 - 12 =
						 * 12 | seek 12 es la segunda planta
						 */
						rafLectura.readInt();
						System.out.print(" | Precio: " + rafLectura.readFloat());
						System.out.println(" | Stock: " + rafLectura.readInt());
						System.out.println("\n|- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - |");

					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void mostrarTicketPorBusqueda(ArrayList<Ticket> tickets) {
		Scanner scanner = new Scanner(System.in);

		for (Ticket ticket : tickets) {
			System.out.println(ticket);
		}

		int banderaTicket = 3;
		String expRegId = "^[0-9]{1,3}$";
		System.out.println("Introduce el id a buscar: ");

		do {
			String codigoBuscar = scanner.nextLine();
			if (codigoBuscar.matches(expRegId)) {
				if (!tickets.isEmpty()) {
					int codigoTicket = Integer.parseInt(codigoBuscar);
					for (Ticket ticket : tickets) {
						// 7.1
						if (codigoTicket == ticket.getCodigoTicket()) {
							System.out.println(ticket.toString());
							banderaTicket = 0;
						}
					}

					if (banderaTicket != 0) {
						System.out.print("El numero de ticket " + codigoBuscar + " no existe, te quedan ("
								+ --banderaTicket + "/3) intentos: ");
					}
				} else {
					System.out
							.println("No hay ningun ticket existente, cree un ticket o intentelo de nuevo mas tarde.");
					banderaTicket = 0;
				}

			} else {
				System.out.println("Error, has introducido un formato incorrecto, te quedan (" + --banderaTicket
						+ "/3) intentos: ");
			}
		} while (banderaTicket != 0);
	}

	public static void devolucion(ArrayList<Ticket> tickets, String archivo, ArrayList<Plantas> plantasCaracteristicas,
			ArrayList<Ticket> ticketsDevolucion) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n - - - - - - - Tickets disponibles para devolucion - - - - - - -\n");

		for (Ticket ticket : tickets) {
			System.out.println(ticket);
		}
		System.out.print("Introduce el codigo del ticket a devolver: ");
		int banderaDevolucion = 3;
		String expRegDevolucion = "^[0-9]{1,4}$";
		do {
			String codigoDevolucion = scanner.nextLine();

			if (codigoDevolucion.matches(expRegDevolucion)) {

				int codigo = Integer.parseInt(codigoDevolucion);
				Ticket ticketDevolucion = new Ticket();
				for (Ticket ticket : tickets) {
					// 6.1
					if (codigo == ticket.getCodigoTicket()) {
						ticketDevolucion = ticket;
						int idPlantaDevolucion = ticket.getCodigoPlanta();
						int stockDevolucion = ticket.getStock();

						try (RandomAccessFile rafLectura = new RandomAccessFile(rutaSrcPlantas + "\\" + archivo,
								"rw")) {
							for (Plantas plantas : plantasCaracteristicas) {

								if (plantas.getCodigo() == idPlantaDevolucion) {

									if (!ticket.isDevolucion()) {
										// -1, porque no existe la planta 0, empieza de 1 a 20, si lo pongo sin el -1 y
										// por ejemplo meto el 5, se posiciona en la planta 6
										idPlantaDevolucion--;
										if (idPlantaDevolucion == 1) {
											rafLectura.seek(0 + 8);
										} else {
											rafLectura.seek((idPlantaDevolucion * 12) + 8); // Se posiciona en el stock
																							// del
																							// producto
											int stockAcutal = rafLectura.readInt();
											rafLectura.seek((idPlantaDevolucion * 12) + 8);
											// 6.4
											rafLectura.writeInt(stockDevolucion + stockAcutal);
										}

										ticket.setDevolucion(true);
										// 6.3
										ticket.setTotal(ticket.getTotal() * (-1));
										ticketsDevolucion.add(ticketDevolucion);
										File comprobarTicket = new File(rutaSrcTickets + "\\" + codigo + "Ticket.txt");
										// Si existe lo elimino, para reescribir con devolucion y luego pasarlo a la
										// otra carpeta
										if (comprobarTicket.exists()) {
											comprobarTicket.delete();
										}
										File escribirTicketDevolucion = new File(
												rutaSrcTickets + "\\" + codigo + "Ticket.txt");
										BufferedWriter bw = new BufferedWriter(
												new FileWriter(escribirTicketDevolucion));
										bw.write(ticket.toString());
										bw.close();
										System.out.println("\nTicket devuelto correctamente");
										banderaDevolucion = 0;
									} else {
										System.out.println("El ticket ya ha sido devuelto");
										banderaDevolucion = 0;
									}

								}

							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// 6.4
						File moverArchivo = new File(rutaSrcTickets + "\\" + codigo + "Ticket.txt");
						if (moverArchivo.exists() && moverArchivo.isFile()) {
							Path rutaOrigen = Paths.get(rutaSrcTickets + "\\" + codigo + "Ticket.txt");
							Path rutaDestino = Paths.get(rutaSrcDevoluciones + "\\" + codigo + "Ticket.txt");

							try {
								System.gc();
								Files.move(rutaOrigen, rutaDestino, StandardCopyOption.REPLACE_EXISTING);

							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}

						}

					}
				}

				if (banderaDevolucion != 0) {
					System.out.println("No existe ningun ticket con el codigo introducido, le quedan ("
							+ --banderaDevolucion + "/3) intentos: ");

				}

				tickets.remove(ticketDevolucion);

			} else {
				System.out.print("El codigo de ticket introducido no cumnple con los parametros permitidos, le quedan ("
						+ --banderaDevolucion + "/3) intentos: ");

			}

		} while (banderaDevolucion != 0);

	}

	public static void menuVendedor(Empleado empleadoID, ArrayList<Plantas> plantasCaracteristicas,
			ArrayList<Empleado> empleadosVerificados, ArrayList<Ticket> tickets, String nombreArchivo,
			ArrayList<Ticket> ticketsDevolucion, String rutaArchivo) {

		Scanner scanner = new Scanner(System.in);
		String expReg = "^[0-9]{1}$";
		int bandera = 0;

		do {
			System.out.println("\n\n - - - Menu Vendedor - - -");
			System.out.println("   1. Visualizar catalogo");
			System.out.println("   2. Buscar ticket por id");
			System.out.println("   3. Realizar una devolucion");
			System.out.println("   4. Salir");
			System.out.print("Opcion: ");
			String opcion = scanner.nextLine();

			if (opcion.matches(expReg)) {

				switch (Integer.parseInt(opcion)) {
				case 1:
					String expRegOpcion = "^[1-2]$";
					int banderaCompra = 3;
					// 4.1
					mostrarCatalogo(plantasCaracteristicas, plantasDAT);
					// 5.0
					System.out.println("\n¿Desea realizar una compra?");
					System.out.println("   1. Realizar compra");
					System.out.println("   2. Regresar menu");
					System.out.print("Opcion: ");
					do {
						String opcionCompra = scanner.nextLine();
						if (opcionCompra.matches(expRegOpcion)) {
							if (Integer.parseInt(opcionCompra) == 1) {
								// 4.2
								generarCompra(plantasCaracteristicas, empleadosVerificados, tickets, rutaArchivo,
										plantasDAT);
							} else if (Integer.parseInt(opcionCompra) == 2) {
								System.out.println("Saliendo");
							}
							banderaCompra = 0;

						} else {
							System.out
									.print("Error, introduce 1 o 2, le quedan (" + --banderaCompra + "/3) intentos: ");
						}
					} while (banderaCompra != 0);

					break;
				case 2:
					mostrarTicketPorBusqueda(tickets);

					break;
				case 3:
					devolucion(tickets, plantasDAT, plantasCaracteristicas, ticketsDevolucion);

					break;
				case 4:
					System.out.println("\nHasta la proxima " + empleadoID.getNombre());
					bandera = 2;
					break;
				default:
					// Fallo de numero case
					System.out.println("La opcion introducida no existe, intentalo de nuevo\n");
					break;
				}
			} else {
				// ExpReg
				System.out
						.println("La opcion introducida no cumple con los parametros permitidos, intentalo de nuevo\n");
			}

		} while (bandera == 0);

	}

	public static void darDeAltaPlanta(ArrayList<Plantas> plantasCaracteristicas, String nombreArchivo,
			String nombreArchivoXML) {
		Scanner scanner = new Scanner(System.in);
		int contadorArchivoXML = 1;
		for (Plantas plantas : plantasCaracteristicas) {
			contadorArchivoXML++;
		}

		Plantas altaPlanta = new Plantas();
		altaPlanta.setCodigo(contadorArchivoXML);
		int banderaNombrePlanta = 0;

		System.out.print("\nIntroduce el nombre de la planta a agregar: ");
		do {
			String expRegNombrePlanta = "^[a-zA-Zñ0-9. _()\\[\\]-]{1,38}$"; // La planta con mas caracteres es una con
																			// 38
			// Ornithogalum adseptentrionesvergentulum
			String nombrePlanta = scanner.nextLine();
			if (nombrePlanta.matches(expRegNombrePlanta)) {
				altaPlanta.setNombre(nombrePlanta);
				banderaNombrePlanta = 1;
			} else {
				System.out.print(
						"\nError, el nombre introducido no cumple con los parametros permitidos o ha introducido un nombre con una longitud mayor a la permitida (38). Intentelo de nuevo: ");
			}
		} while (banderaNombrePlanta == 0);

		int banderaNombreFoto = 0;
		System.out.print("\nIntroduce el nombre de la foto a añadir: ");
		do {
			String expRegFotoPlanta = "^[a-zA-Zñ0-9_]{1,100}\\.[a-zA-Z]{1,10}$";
			String fotoPlanta = scanner.nextLine();
			if (fotoPlanta.matches(expRegFotoPlanta)) {
				altaPlanta.setFoto(fotoPlanta);
				banderaNombreFoto = 1;
			} else {
				System.out.print(
						"El nombre de la foto introducido no cumple con los parametros permitidos, ejemplo: foto.png. Intentelo de nuevo: ");
			}
		} while (banderaNombreFoto == 0);

		int banderaDesc = 0;
		String expRegDesc = "^[a-zA-Zñ0-9 ,._()\\[\\]\\-]{1,1000}$";
		System.out.print("\nIntroduce una breve descripcion: ");
		do {
			String descPlanta = scanner.nextLine();
			if (descPlanta.matches(expRegDesc)) {
				altaPlanta.setDescripcion(descPlanta);
				banderaDesc = 1;
			} else {
				System.out.print(
						"La descripcion introducida no cumple con los parametros permitidos o excedes la longitud de caracteres (1000). Intetelo de nuevo: ");
			}
		} while (banderaDesc == 0);

		if (banderaDesc == 1 && banderaNombreFoto == 1 && banderaNombrePlanta == 1) {
			// 8.1.1.1
			plantasCaracteristicas.add(altaPlanta);

			try {
				// 8.1.1.2
				File ficheroPlantasXML = new File(rutaSrcPlantas + "\\" + nombreArchivoXML);
				DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
				DocumentBuilder docB = DBF.newDocumentBuilder();
				Document doc = docB.parse(ficheroPlantasXML);
				doc.getDocumentElement().normalize();

				// Sacado de
				// https://chuidiang.org/index.php?title=Leer_y_escribir_ficheros_XML_con_Java

				Element raiz = doc.getDocumentElement(); // Obtiene la etiqueta padre del xml obtenido de Document doc

				Element nuevaPlanta = doc.createElement("planta"); // Creo el elemento planta

				Element codigoPlanta = doc.createElement("codigo"); // Creo el elemento codigo
				// Añado el codigoPlanta como hijo de codigo, si el codigoPlanta es 1, se veria
				// <codigo> 1
				// </codigo>
				codigoPlanta.appendChild(doc.createTextNode(String.valueOf(altaPlanta.getCodigo()))); // No admite int,
																										// por lo que lo
																										// paso a string
				Element nombrePlanta = doc.createElement("nombre");
				nombrePlanta.appendChild(doc.createTextNode(altaPlanta.getNombre()));

				Element fotoPlanta = doc.createElement("foto");
				fotoPlanta.appendChild(doc.createTextNode(altaPlanta.getFoto()));

				Element descPlanta = doc.createElement("descripcion");
				descPlanta.appendChild(doc.createTextNode(altaPlanta.getDescripcion()));

				// Inserto a nuevaPlanta todos los campos anteriores como hijos, se veria algo
				// asi
				// <planta>
				// <codigo>1</codigo>
				// <nombre>asd</nombre>
				// <foto>asd.png</foto>
				// <descripcion>asd</descripcion>
				// </planta>
				nuevaPlanta.appendChild(codigoPlanta);
				nuevaPlanta.appendChild(nombrePlanta);
				nuevaPlanta.appendChild(fotoPlanta);
				nuevaPlanta.appendChild(descPlanta);

				// Inserta en la raiz la nueva planta, pero existe en memoria no en el archivo
				raiz.appendChild(nuevaPlanta);

				TransformerFactory tf = TransformerFactory.newInstance(); // Permite a Transformer pasar el xml a texto
																			// plano
				Transformer trans = tf.newTransformer(); // Transforma el xml en texto plano
				DOMSource documento = new DOMSource(doc); // XML en memoria para el Transformer
				StreamResult resultado = new StreamResult(new File(rutaSrcPlantas + "\\" + nombreArchivoXML)); // Apunta
																												// al
																												// archivo
																												// que
																												// quiero
				// escribir

				trans.setOutputProperty(OutputKeys.INDENT, "yes"); // Le indico como quiero que formatee el archivo de
																	// salida
				// OutputKeys.INDENT le indico el formato de escritura, es decir con sus
				// sangrias, saltos de linea...
				// Y el yes es un para confirmar que quiero que el XML quede bonito

				trans.transform(documento, resultado); // Realiza la escritura en el archivo XML
				// documento -> el archivo que quiero modificar
				// resultado -> donde se va a escribir
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("Ha ocurrido un error, intetelo de nuevo");
			darDeAltaPlanta(plantasCaracteristicas, nombreArchivo, nombreArchivoXML);
		}
		// 8.1.1.2
		File archivo = new File(rutaSrcPlantas + "\\" + nombreArchivo);
		if (archivo.exists() && archivo.isFile()) {

			try {

				File fichero = new File(rutaSrcPlantas + "\\" + nombreArchivo);
				RandomAccessFile rafLectura = new RandomAccessFile(fichero, "rw");
				int contador = 1;
				rafLectura.seek(0);

				// Leo el fichero porque al añadir una planta aumenta en 12 su tamaño
				while (rafLectura.getFilePointer() < rafLectura.length()) {

					rafLectura.readInt();
					rafLectura.readFloat();
					rafLectura.readInt();
					contador++;
				}

				rafLectura.seek(rafLectura.getFilePointer()); // Apunto al final del archivo
				// 8.1.3.3
				rafLectura.writeInt(contador); // id del plantas.dat

				System.out.print("\nIntroduce el precio por unidad: ");
				int banderaUnidad = 0;
				do {
					String expRegUnidad = "^[0-9]{1,7}$";
					String precioUnidad = scanner.nextLine();
					if (precioUnidad.matches(expRegUnidad) && Float.parseFloat(precioUnidad) > 0) {
						// 8.1.3.3
						rafLectura.writeFloat(Float.parseFloat(precioUnidad));
						banderaUnidad = 1;
					} else {
						System.out.print(
								"El precio por unidad introducida no cumple con los parametros permitidos o a introducido un valor fuera del rango de 1 - 9999999. Intentelo de nuevo: ");
					}
				} while (banderaUnidad == 0);

				System.out.print("\nIntroduce el stock de la planta: ");
				int banderaStock = 0;
				do {
					String expRegStockPlanta = "^[0-9]{1,6}$";
					String stockPlanta = scanner.nextLine();
					if (stockPlanta.matches(expRegStockPlanta) && Integer.parseInt(stockPlanta) > 0) {
						// 8.1.3.3
						rafLectura.writeInt(Integer.parseInt(stockPlanta));
						banderaStock = 1;
					} else {
						System.out.print(
								"El stock introducido no cumple con los parametros permitidos o a introducido un valor fuera del rango de 1 - 999999. Intentelo de nuevo: ");
					}
				} while (banderaStock == 0);

				for (Plantas plantas : plantasCaracteristicas) {
					if (contador == plantas.getCodigo()) {

						System.out.println("\n- - - - - - - - - - Planta Agregada - - - - - - - - - - - -");
						System.out.println(" | Codigo: " + plantas.getCodigo());
						System.out.println(" | Nombre:" + plantas.getNombre());
						System.out.println(" | Nombre archivo foto: " + plantas.getFoto());
						System.out.println(" | Descripcion:  " + plantas.getDescripcion());
						rafLectura.seek((contador - 1) * 12);
						rafLectura.readInt();
						System.out.println(" | Precio: " + rafLectura.readFloat());
						System.out.println(" | Stock: " + rafLectura.readInt());
						System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

					}
				}

				rafLectura.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public static void darDeBajaPlanta(ArrayList<Plantas> plantasCaracteristicas, String nombreArchivo,
			ArrayList<Plantas> plantasDeBaja) {
		Scanner scanner = new Scanner(System.in);
		Plantas plantaDarDeBaja = null;
		System.out.print("\nIntroduce el id de la planta a dar de baja: ");
		int banderaBaja = 3;
		boolean encontrado = false;
		do {
			// 8.1.3.1
			String expRegId = "^[0-9]{1,4}$";
			String idPlanta = scanner.nextLine();

			if (idPlanta.matches(expRegId)) {
				for (Plantas plantas : plantasCaracteristicas) {
					// 8.1.3.1
					if (plantas.getCodigo() == Integer.parseInt(idPlanta)) {
						plantaDarDeBaja = plantas;
						encontrado = true;
					}
				}
				try {
					File fichero = new File(rutaSrcPlantas + "\\" + nombreArchivo);
					RandomAccessFile rafLectura = new RandomAccessFile(fichero, "rw");

					rafLectura.seek(0);
					// 8.1.3.2
					while (rafLectura.getFilePointer() < rafLectura.length()) {

						rafLectura.readInt();
						rafLectura.readFloat();
						rafLectura.readInt();

					}

					if (Integer.parseInt(idPlanta) == 1) {
						rafLectura.seek(0 + 4);
					} else {
						rafLectura.seek(((Integer.parseInt(idPlanta) - 1) * 12) + 4);
					}
					// 8.1.2.1
					rafLectura.writeFloat(0);
					rafLectura.writeInt(0);

					rafLectura.close();

					if (!encontrado) {
						System.out.print("El id introducido no existe, te quedan (" + --banderaBaja + "/3) intentos: ");
					} else {
						banderaBaja = 0;
					}
					System.out.println(
							"\n| - - - - - - - - - - - - - - - - - Planta dada de baja correctamente - - - - - - - - - - - - - - - - - |");
					System.out.println(plantaDarDeBaja.toString());
					System.out.println(
							"| - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - |");

					plantasDeBaja.add(plantaDarDeBaja);

				} catch (IOException e) {
					e.printStackTrace();
				}

				// LISTA REESCRIBIR PLANTAS DE BAJA
				// 8.1.2.2
				try {
					File ficheroPlantasXML = new File(rutaSrcPlantas + "\\" + plantasBajaXML);
					DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
					DocumentBuilder docB = DBF.newDocumentBuilder();
					Document doc;

					if (!ficheroPlantasXML.exists() || ficheroPlantasXML.length() == 0) {
						// Si el archivo esta vacio, te tira un error de que no puede leer un xml vacio,
						// entonces escribo en el xml la raiz padre y entonces lo leo
						doc = docB.newDocument();
						Element raiz = doc.createElement("plantas");
						doc.appendChild(raiz);
						doc.getDocumentElement().normalize();
					} else {
						// Si el archivo no esta vacio que lo haga normal
						doc = docB.parse(ficheroPlantasXML);
						doc.getDocumentElement().normalize();
					}

					Plantas plantaBajaEscritura = null;
					for (Plantas plantas : plantasCaracteristicas) {
						if (plantas.getCodigo() == Integer.parseInt(idPlanta)) {

							plantaBajaEscritura = plantas;

							Element raiz = doc.getDocumentElement();

							Element nuevaPlanta = doc.createElement("planta");

							Element codigoPlanta = doc.createElement("codigo");

							codigoPlanta
									.appendChild(doc.createTextNode(String.valueOf(plantaBajaEscritura.getCodigo())));
							Element nombrePlanta = doc.createElement("nombre");
							nombrePlanta.appendChild(doc.createTextNode(plantaBajaEscritura.getNombre()));

							Element fotoPlanta = doc.createElement("foto");
							fotoPlanta.appendChild(doc.createTextNode(plantaBajaEscritura.getFoto()));

							Element descPlanta = doc.createElement("descripcion");
							descPlanta.appendChild(doc.createTextNode(plantaBajaEscritura.getDescripcion()));

							nuevaPlanta.appendChild(codigoPlanta);
							nuevaPlanta.appendChild(nombrePlanta);
							nuevaPlanta.appendChild(fotoPlanta);
							nuevaPlanta.appendChild(descPlanta);

							raiz.appendChild(nuevaPlanta);

							TransformerFactory tf = TransformerFactory.newInstance();

							Transformer trans = tf.newTransformer();
							DOMSource documento = new DOMSource(doc);
							StreamResult resultado = new StreamResult(new File(rutaSrcPlantas + "\\" + plantasBajaXML));

							trans.setOutputProperty(OutputKeys.INDENT, "yes");

							trans.transform(documento, resultado);

						}
					}

					plantasCaracteristicas.remove(plantaDarDeBaja);

				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// SOBREESCRIBO EL ARCHIVO CARACTERISTICASXML

				try {
					File ficheroPlantasXML = new File(rutaSrcPlantas + "\\" + plantasXML);
					DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
					DocumentBuilder docB = DBF.newDocumentBuilder();
					Document doc = docB.parse(ficheroPlantasXML);
					doc.getDocumentElement().normalize();

					Element raiz = doc.getDocumentElement();

					// Elimina todo el contenido del archivo
					while (raiz.hasChildNodes()) {
						raiz.removeChild(raiz.getFirstChild());
					}

					// Sobreescribo todo el xml con el nombre cambiado
					for (Plantas plantas : plantasCaracteristicas) {

						Element nuevaPlanta = doc.createElement("planta");

						Element codigoPlanta = doc.createElement("codigo");

						codigoPlanta.appendChild(doc.createTextNode(String.valueOf(plantas.getCodigo())));

						Element nombrePlanta = doc.createElement("nombre");
						nombrePlanta.appendChild(doc.createTextNode(plantas.getNombre()));

						Element fotoPlanta = doc.createElement("foto");
						fotoPlanta.appendChild(doc.createTextNode(plantas.getFoto()));

						Element descPlanta = doc.createElement("descripcion");
						descPlanta.appendChild(doc.createTextNode(plantas.getDescripcion()));

						nuevaPlanta.appendChild(codigoPlanta);
						nuevaPlanta.appendChild(nombrePlanta);
						nuevaPlanta.appendChild(fotoPlanta);
						nuevaPlanta.appendChild(descPlanta);

						raiz.appendChild(nuevaPlanta);
					}

					TransformerFactory tf = TransformerFactory.newInstance();
					Transformer trans = tf.newTransformer();
					DOMSource documento = new DOMSource(doc);
					StreamResult resultado = new StreamResult(new File(rutaSrcPlantas + "\\" + plantasXML));
					trans.setOutputProperty(OutputKeys.INDENT, "yes");

					trans.transform(documento, resultado);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				System.out.print("El id introducido no cumple con los parametros permitidos, intetelo de nuevo: ");
			}
		} while (banderaBaja != 0);
	}

	public static void modificarDatosPlanta(ArrayList<Plantas> plantasCaracteristicas, String nombreArchivo,
			String nombreArchivoXML) {
		Scanner scanner = new Scanner(System.in);
		Plantas plantaModificar = new Plantas();
		String id = "";
		// Comprobar que la planta exista
		int banderaID = 0;
		String expRegIDPlanta = "^[0-9]{1,4}$";
		System.out.print("\nIntroduce el id de la planta a modificar: ");
		do {
			id = scanner.nextLine();

			if (id.matches(expRegIDPlanta)) {
				for (Plantas plantas : plantasCaracteristicas) {
					if (Integer.parseInt(id) == plantas.getCodigo()) {
						plantaModificar = plantas;
						banderaID = 1;
					}
				}
				if (banderaID == 0) {
					System.out.print("El id introducido no existe, intentelo de nuevo: ");
					banderaID = 0;
				}
			} else {
				System.out.print("El id introducido no cumple con los parametros permitidos, intentelo de nuevo: ");
			}

		} while (banderaID == 0);

		int banderaGlobal = 0;
		String opcion = "";
		int banderaMenu = 0;
		String expRegMenu = "^[1-5]{1}$";
		do {
			System.out.println("\nIntroduce el campo a modifcar: ");
			System.out.println("  1. Nombre");
			System.out.println("  2. Nombre archivo foto");
			System.out.println("  3. Descripcion");
			System.out.println("  4. Precio");
			System.out.println("  5. Stock");
			System.out.print("Opcion: ");
			do {
				opcion = scanner.nextLine();

				if (opcion.matches(expRegMenu)) {
					banderaMenu = 1;
					switch (Integer.parseInt(opcion)) {
					case 1:
						int banderaNombre = 0;
						String expRegNombrePlanta = "^[a-zA-Zñ0-9. _()\\[\\]-]{1,38}$";
						System.out.print("\nIntroduce el nuevo nombre: ");
						do {
							String nombreMod = scanner.nextLine();
							if (nombreMod.matches(expRegNombrePlanta)) {
								plantaModificar.setNombre(nombreMod);

								try {
									File ficheroPlantasXML = new File(rutaSrcPlantas + "\\" + nombreArchivoXML);
									DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
									DocumentBuilder docB = DBF.newDocumentBuilder();
									Document doc = docB.parse(ficheroPlantasXML);
									doc.getDocumentElement().normalize();

									Element raiz = doc.getDocumentElement();

									// Elimina todo el contenido del archivo
									while (raiz.hasChildNodes()) {
										raiz.removeChild(raiz.getFirstChild());
									}

									// Sobreescribo todo el xml con el nombre cambiado
									for (Plantas plantas : plantasCaracteristicas) {

										Element nuevaPlanta = doc.createElement("planta");

										Element codigoPlanta = doc.createElement("codigo");

										codigoPlanta
												.appendChild(doc.createTextNode(String.valueOf(plantas.getCodigo())));

										Element nombrePlanta = doc.createElement("nombre");
										nombrePlanta.appendChild(doc.createTextNode(plantas.getNombre()));

										Element fotoPlanta = doc.createElement("foto");
										fotoPlanta.appendChild(doc.createTextNode(plantas.getFoto()));

										Element descPlanta = doc.createElement("descripcion");
										descPlanta.appendChild(doc.createTextNode(plantas.getDescripcion()));

										nuevaPlanta.appendChild(codigoPlanta);
										nuevaPlanta.appendChild(nombrePlanta);
										nuevaPlanta.appendChild(fotoPlanta);
										nuevaPlanta.appendChild(descPlanta);

										raiz.appendChild(nuevaPlanta);
									}

									TransformerFactory tf = TransformerFactory.newInstance();
									Transformer trans = tf.newTransformer();
									DOMSource documento = new DOMSource(doc);
									StreamResult resultado = new StreamResult(
											new File(rutaSrcPlantas + "\\" + plantasXML));
									trans.setOutputProperty(OutputKeys.INDENT, "yes");

									trans.transform(documento, resultado);
								} catch (Exception e) {
									e.printStackTrace();
								}
								banderaNombre = 1;
							} else {
								System.out.print(
										"El nombre introducido no cumple con los parametros permitidos, intentelo de nuevo: ");
								banderaNombre = 0;
							}
						} while (banderaNombre == 0);
						int banderaSeguir = 0;
						System.out.println("\n¿Desea seguir modificando la misma planta?");
						System.out.println("   1. Seguir modificando");
						System.out.println("   2. Salir al menu");
						System.out.print("Opcion: ");
						String expRegSeguir = "^[1-2]{1}$";
						do {
							String seguirEditando = scanner.nextLine();
							if (seguirEditando.matches(expRegSeguir)) {
								if (Integer.parseInt(seguirEditando) == 1) {
									banderaGlobal = 0;
									banderaSeguir = 1;
								} else {
									banderaGlobal = 1;
									banderaSeguir = 1;
								}
							} else {
								System.out.print(
										"La opcion introducida no cumple con los parametros permitidos, introduce 1 o 2. Intentelo de nuevo: ");
							}
						} while (banderaSeguir == 0);

						break;
					case 2:
						String expRegFotoPlanta = "^[a-zA-Zñ0-9_]{1,100}\\.[a-zA-Z]{1,10}$";
						int banderaFoto = 0;
						System.out.print("\nIntroduce el nombre del nuevo archivo a usar: ");
						do {
							String nombreFoto = scanner.nextLine();
							if (nombreFoto.matches(expRegFotoPlanta)) {
								plantaModificar.setFoto(nombreFoto);

								// Implementar una opcion que pueda volver a elegir si quiere o no modificar con
								// un do while y modificar el xml

								try {
									File ficheroPlantasXML = new File(rutaSrcPlantas + "\\" + nombreArchivoXML);
									DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
									DocumentBuilder docB = DBF.newDocumentBuilder();
									Document doc = docB.parse(ficheroPlantasXML);
									doc.getDocumentElement().normalize();

									Element raiz = doc.getDocumentElement();

									// Elimina todo el contenido del archivo
									while (raiz.hasChildNodes()) {
										raiz.removeChild(raiz.getFirstChild());
									}

									// Sobreescribo todo el xml con la foto cambiada
									for (Plantas plantas : plantasCaracteristicas) {

										Element nuevaPlanta = doc.createElement("planta");

										Element codigoPlanta = doc.createElement("codigo");

										codigoPlanta
												.appendChild(doc.createTextNode(String.valueOf(plantas.getCodigo())));

										Element nombrePlanta = doc.createElement("nombre");
										nombrePlanta.appendChild(doc.createTextNode(plantas.getNombre()));

										Element fotoPlanta = doc.createElement("foto");
										fotoPlanta.appendChild(doc.createTextNode(plantas.getFoto()));

										Element descPlanta = doc.createElement("descripcion");
										descPlanta.appendChild(doc.createTextNode(plantas.getDescripcion()));

										nuevaPlanta.appendChild(codigoPlanta);
										nuevaPlanta.appendChild(nombrePlanta);
										nuevaPlanta.appendChild(fotoPlanta);
										nuevaPlanta.appendChild(descPlanta);

										raiz.appendChild(nuevaPlanta);
									}

									TransformerFactory tf = TransformerFactory.newInstance();
									Transformer trans = tf.newTransformer();
									DOMSource documento = new DOMSource(doc);
									StreamResult resultado = new StreamResult(
											new File(rutaSrcPlantas + "\\" + plantasXML));
									trans.setOutputProperty(OutputKeys.INDENT, "yes");

									trans.transform(documento, resultado);
								} catch (Exception e) {
									e.printStackTrace();
								}
								banderaFoto = 1;
							} else {
								System.out.print(
										"La imagen introducida no cumple con los parametros permitidos, ejemplo foto.png. Intentelo de nuevo: ");
								banderaFoto = 0;
							}
						} while (banderaFoto == 0);
						int banderaSeguir2 = 0;
						System.out.println("\n¿Desea seguir modificando la misma planta?");
						System.out.println("   1. Seguir modificando");
						System.out.println("   2. Salir al menu");
						System.out.print("Opcion: ");
						String expRegSeguir2 = "^[1-2]{1}$";
						do {
							String seguirEditando = scanner.nextLine();
							if (seguirEditando.matches(expRegSeguir2)) {
								if (Integer.parseInt(seguirEditando) == 1) {
									banderaGlobal = 0;
									banderaSeguir2 = 1;
								} else {
									banderaGlobal = 1;
									banderaSeguir2 = 1;
								}
							} else {
								System.out.print(
										"La opcion introducida no cumple con los parametros permitidos, introduce 1 o 2. Intentelo de nuevo: ");
							}
						} while (banderaSeguir2 == 0);
						break;
					case 3:
						String expRegDesc = "^[a-zA-Zñ0-9 ,._()\\[\\]\\-]{1,1000}$";
						int banderaDesc = 0;
						System.out.print("\nIntroduce la nueva descripcion: ");
						do {
							String nuevaDesc = scanner.nextLine();
							if (nuevaDesc.matches(expRegDesc)) {
								plantaModificar.setDescripcion(nuevaDesc);

								// Implementar una opcion que pueda volver a elegir si quiere o no modificar con
								// un do while y modificar el xml

								try {
									File ficheroPlantasXML = new File(rutaSrcPlantas + "\\" + nombreArchivoXML);
									DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
									DocumentBuilder docB = DBF.newDocumentBuilder();
									Document doc = docB.parse(ficheroPlantasXML);
									doc.getDocumentElement().normalize();

									Element raiz = doc.getDocumentElement();

									// Elimina todo el contenido del archivo, si no lo hago asi, se duplica el xml
									// 20 + 20...
									while (raiz.hasChildNodes()) {
										raiz.removeChild(raiz.getFirstChild());
									}

									// Sobreescribo todo el xml con la descripcion cambiada
									for (Plantas plantas : plantasCaracteristicas) {

										Element nuevaPlanta = doc.createElement("planta");

										Element codigoPlanta = doc.createElement("codigo");

										codigoPlanta
												.appendChild(doc.createTextNode(String.valueOf(plantas.getCodigo())));

										Element nombrePlanta = doc.createElement("nombre");
										nombrePlanta.appendChild(doc.createTextNode(plantas.getNombre()));

										Element fotoPlanta = doc.createElement("foto");
										fotoPlanta.appendChild(doc.createTextNode(plantas.getFoto()));

										Element descPlanta = doc.createElement("descripcion");
										descPlanta.appendChild(doc.createTextNode(plantas.getDescripcion()));

										nuevaPlanta.appendChild(codigoPlanta);
										nuevaPlanta.appendChild(nombrePlanta);
										nuevaPlanta.appendChild(fotoPlanta);
										nuevaPlanta.appendChild(descPlanta);

										raiz.appendChild(nuevaPlanta);
									}

									TransformerFactory tf = TransformerFactory.newInstance();
									Transformer trans = tf.newTransformer();
									DOMSource documento = new DOMSource(doc);
									StreamResult resultado = new StreamResult(
											new File(rutaSrcPlantas + "\\" + plantasXML));
									trans.setOutputProperty(OutputKeys.INDENT, "yes");

									trans.transform(documento, resultado);
								} catch (Exception e) {
									e.printStackTrace();
								}
								banderaDesc = 1;
							} else {
								System.out.println(
										"La descripcion introducida no cumple con los parametros permitidos, intentelo de nuevo: ");
							}
						} while (banderaDesc == 0);
						int banderaSeguir3 = 0;
						System.out.println("\n¿Desea seguir modificando la misma planta?");
						System.out.println("   1. Seguir modificando");
						System.out.println("   2. Salir al menu");
						System.out.print("Opcion: ");
						String expRegSeguir3 = "^[1-2]{1}$";
						do {
							String seguirEditando = scanner.nextLine();
							if (seguirEditando.matches(expRegSeguir3)) {
								if (Integer.parseInt(seguirEditando) == 1) {
									banderaGlobal = 0;
									banderaSeguir3 = 1;
								} else {
									banderaGlobal = 1;
									banderaSeguir3 = 1;
								}
							} else {
								System.out.print(
										"La opcion introducida no cumple con los parametros permitidos, introduce 1 o 2. Intentelo de nuevo: ");
							}
						} while (banderaSeguir3 == 0);
						break;
					case 4:
						try {
							File fichero = new File(rutaSrcPlantas + "\\" + nombreArchivo);
							RandomAccessFile rafLectura = new RandomAccessFile(fichero, "rw");

							rafLectura.seek(0);

							while (rafLectura.getFilePointer() < rafLectura.length()) {

								rafLectura.readInt();
								rafLectura.readFloat();
								rafLectura.readInt();

							}
							System.out.println("\nIntroduce el nuevo precio por unidad");
							int banderaUnidad = 0;
							do {
								String expRegUnidad = "^[0-9]{1,7}$";
								String nuevoPrecio = scanner.nextLine();
								if (nuevoPrecio.matches(expRegUnidad) && Integer.parseInt(nuevoPrecio) > 0) {

									if (Integer.parseInt(id) == 1) {
										rafLectura.seek(0 + 4); // Precio
									} else {
										rafLectura.seek((((Integer.parseInt(id) * 12) - 12) + 4)); // Precio
									}

									rafLectura.writeFloat(Float.parseFloat(nuevoPrecio));

									banderaUnidad = 1;
								} else {
									System.out.print(
											"El precio introducido no cumple con los parametros permitidos o a introducido un precio fuera del rango de 1 - 9999999. Intentelo de nuevo: ");
								}
							} while (banderaUnidad == 0);

						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}

						int banderaSeguir4 = 0;
						System.out.println("\n¿Desea seguir modificando la misma planta?");
						System.out.println("   1. Seguir modificando");
						System.out.println("   2. Salir al menu");
						System.out.print("Opcion: ");
						String expRegSeguir4 = "^[1-2]{1}$";
						do {
							String seguirEditando = scanner.nextLine();
							if (seguirEditando.matches(expRegSeguir4)) {
								if (Integer.parseInt(seguirEditando) == 1) {
									banderaGlobal = 0;
									banderaSeguir4 = 1;
								} else {
									banderaGlobal = 1;
									banderaSeguir4 = 1;
								}
							} else {
								System.out.print(
										"La opcion introducida no cumple con los parametros permitidos, introduce 1 o 2. Intentelo de nuevo: ");
							}
						} while (banderaSeguir4 == 0);

						break;
					case 5:
						try {
							File fichero = new File(rutaSrcPlantas + "\\" + nombreArchivo);
							RandomAccessFile rafLectura = new RandomAccessFile(fichero, "rw");

							rafLectura.seek(0);

							while (rafLectura.getFilePointer() < rafLectura.length()) {

								rafLectura.readInt();
								rafLectura.readFloat();
								rafLectura.readInt();

							}
							int banderaStock = 0;
							System.out.print("\nIntroduce el nuevo stock: ");
							do {
								String expRegStockPlanta = "^[0-9]{1,7}$";
								String nuevoStock = scanner.nextLine();

								if (nuevoStock.matches(expRegStockPlanta) && Integer.parseInt(nuevoStock) > 0) {
									if (Integer.parseInt(id) == 1) {
										rafLectura.seek(0 + 8); // stock
									} else {
										rafLectura.seek((((Integer.parseInt(id) * 12) - 12) + 8)); // Stock
									}
									rafLectura.writeInt(Integer.parseInt(nuevoStock));

									banderaStock = 1;
								} else {
									System.out.print(
											"El stock introducido no cumple con los parametros permitidos o a introducido un valor fuera del rango de 1 - 9999999. Intentelo de nuevo: ");
								}
							} while (banderaStock == 0);

							rafLectura.close();

						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						int banderaSeguir5 = 0;
						System.out.println("\n¿Desea seguir modificando la misma planta?");
						System.out.println("   1. Seguir modificando");
						System.out.println("   2. Salir al menu");
						System.out.print("Opcion: ");
						String expRegSeguir5 = "^[1-2]{1}$";
						do {
							String seguirEditando = scanner.nextLine();
							if (seguirEditando.matches(expRegSeguir5)) {
								if (Integer.parseInt(seguirEditando) == 1) {
									banderaGlobal = 0;
									banderaSeguir5 = 1;
								} else {
									banderaGlobal = 1;
									banderaSeguir5 = 1;
								}
							} else {
								System.out.print(
										"La opcion introducida no cumple con los parametros permitidos, introduce 1 o 2. Intentelo de nuevo: ");
							}
						} while (banderaSeguir5 == 0);
						break;
					default:
						System.out.print(
								"La opcion introducida no cumple con los parametros permitidos, intentelo de nuevo");
						modificarDatosPlanta(plantasCaracteristicas, nombreArchivo, nombreArchivoXML);
						break;

					}
				} else {
					System.out.println("Has introducido una opcion invalida, intentelo de nuevo: ");
				}

			} while (banderaMenu == 0);
		} while (banderaGlobal == 0);

	}

	public static void darDeAltaEmpleado(ArrayList<Empleado> empleadosVerificados, String nombreArchivo) {
		Scanner scanner = new Scanner(System.in);
		try (FileOutputStream FicheroEscritura = new FileOutputStream(rutaSrcEmpleados + "\\" + nombreArchivo);
				ObjectOutputStream escritura = new ObjectOutputStream(FicheroEscritura)) {

			Empleado empleadoNuevo = new Empleado();

			empleadoNuevo.setIdentificacion(empleadoNuevo.generarID());
			int banderaNombre = 0;
			System.out.print("Introduce el nombre del nuevo empleado: ");
			do {
				// 8.2.1.2
				String expRegNombre = "^[a-zA-Z ]{1,50}$";
				String nombreNuevoEmpleado = scanner.nextLine();
				if (nombreNuevoEmpleado.matches(expRegNombre)) {
					empleadoNuevo.setNombre(nombreNuevoEmpleado);
					banderaNombre = 1;
				} else {
					System.out.print(
							"El nombre introducido no cumple con los parametros permitidos, intentelo de nuevo: ");
				}

			} while (banderaNombre == 0);

			System.out.print("Introduce la contraseña del nuevo empleado: ");
			int banderaContraseña = 0;
			do {
				// 8.2.1.2
				String expRegStrings = "^[a-zA-Z0-9ñ._!$%&@()+-]{5,7}$";
				String contraseñaNuevoEmpleado = scanner.nextLine();

				if (contraseñaNuevoEmpleado.matches(expRegStrings)) {
					empleadoNuevo.setPassword(contraseñaNuevoEmpleado);
					banderaContraseña = 1;
				} else {
					System.out.print(
							"La contraseña introducido no cumple con los parametros permitidos, intentelo de nuevo: ");
				}

			} while (banderaContraseña == 0);

			System.out.println("Introduce el cargo del nuevo empleado");
			System.out.println("   1. Gestor");
			System.out.println("   2. Vendedor");
			System.out.print("Opcion: ");
			int banderaCargo = 0;
			do {
				// 8.2.1.2
				String expRegCargo = "^[1-2]{1}$";
				String cargoNuevoEmpleado = scanner.nextLine();

				if (cargoNuevoEmpleado.matches(expRegCargo)) {
					if (Integer.parseInt(cargoNuevoEmpleado) == 1) {
						empleadoNuevo.setCargo("gestor");
					} else {
						empleadoNuevo.setCargo("vendedor");
					}
					banderaCargo = 1;
				} else {
					System.out.print("La opcion introducida es incorrecta, introduzca 1 o 2, intentelo de nuevo: ");
				}

			} while (banderaCargo == 0);
			// 8.2.1.1
			empleadosVerificados.add(empleadoNuevo);
			System.out.println("\n - - - - - - - - Empleado añadido correctamente - - - - - - - -");

			for (Empleado empleado : empleadosVerificados) {
				if (empleado.getIdentificacion() == empleadoNuevo.getIdentificacion()) {
					System.out.println(empleado);
				}
			}
			System.out.println(" - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - -");
			// 8.2.1.3
			escritura.writeObject(empleadosVerificados);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void darDeBajaEmpleado(ArrayList<Empleado> empleadosDeBaja, ArrayList<Empleado> empleadosVerificados,
			String nombreArchivo) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n - - - - - - - - - - Lista de empleados contratados - - - - - - - - - - -");
		for (Empleado empleado : empleadosVerificados) {
			if (empleado.getIdentificacion() != idEmpleadoIiciado) {
				System.out.println(empleado);
			}
		}
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - -\n");

		int banderaId = 3;
		System.out.print("Introduce el id a dar de baja: ");

		do {
			String expRegID = "^[0-9]{4}$";
			String id = scanner.nextLine();
			if (id.matches(expRegID)) {
				Empleado empleadoEliminar = new Empleado();
				for (Empleado empleado : empleadosVerificados) {
					if (empleado.getIdentificacion() == Integer.parseInt(id)
							&& empleado.getIdentificacion() != idEmpleadoIiciado) {
						// 8.2.2.1
						empleadosDeBaja.add(empleado);
						empleadoEliminar = empleado;
						banderaId = 0;
					}
				}
				// 8.2.2.1
				empleadosVerificados.remove(empleadoEliminar);
				if (banderaId != 0) {
					System.out.print("El codigo introducido no existe, te quedan (" + --banderaId + "/3) intentos: ");
				}

			} else {
				System.out.print("El id introducido no cumple con los parametros permitidos, te quedan (" + --banderaId
						+ "/3) intentos: ");
			}

		} while (banderaId != 0);

		// Sobreescribo el archivo con empleadosDat sin el empleado dado de baja
		// 8.2.2.3
		try (FileOutputStream FicheroEscritura = new FileOutputStream(rutaSrcEmpleados + "\\" + nombreArchivo);
				ObjectOutputStream escritura = new ObjectOutputStream(FicheroEscritura)) {
			escritura.writeObject(empleadosVerificados);

		} catch (IOException i) {
			i.printStackTrace();
		}
		// Sobreescribo el archivo con empleadosDeBaja con los empleados de baja
		try (RandomAccessFile raf = new RandomAccessFile(rutaSrcEmpleadosBaja + "\\" + empleadoBajaDAT, "rw")) {
			// 8.2.2.2
			for (Empleado empleado : empleadosDeBaja) {
				raf.writeInt(empleado.getIdentificacion());
				raf.writeUTF(empleado.getNombre());
				raf.writeUTF(empleado.getPassword());
				raf.writeUTF(empleado.getCargo());

			}

			raf.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void recontratarEmpleado(ArrayList<Empleado> empleadosVerificados,
			ArrayList<Empleado> empleadosDeBaja, String nombreArchivo) {
		Scanner scanner = new Scanner(System.in);
		try (FileOutputStream FicheroEscritura = new FileOutputStream(rutaSrcEmpleados + "\\" + nombreArchivo);
				ObjectOutputStream escritura = new ObjectOutputStream(FicheroEscritura)) {
			System.out.println("\n- - - - - - - - - Empleados disponibles para recontratar - - - - - - - - -");
			for (Empleado empleado : empleadosDeBaja) {
				System.out.println(empleado);
			}
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - -");

			int banderaId = 0;
			System.out.print("Introduce el id a recontratar: ");

			do {
				String expRegID = "^[0-9]{4}$";
				String id = scanner.nextLine();
				if (id.matches(expRegID)) {
					Empleado empleadoRecontratar = new Empleado();
					// 8.2.3.1
					for (Empleado empleado : empleadosDeBaja) {
						// 8.2.3.2
						if (empleado.getIdentificacion() == Integer.parseInt(id)) {
							empleadoRecontratar = empleado;
							banderaId = 1;
						}
					}
					// 8.2.3.2
					empleadosVerificados.add(empleadoRecontratar);
					// 8.2.3.3
					empleadosDeBaja.remove(empleadoRecontratar);

					if (banderaId != 1) {
						System.out.print("El id introducido no existe, intentelo de nuevo: ");
					}

				} else {
					System.out
							.println("El id introducido no cumple con los parametros permitidos, intentelo de nuevo: ");
				}

			} while (banderaId == 0);
			// 8.2.3.4
			escritura.writeObject(empleadosVerificados);

			System.out.println("Empleado añadido a la plantilla correctamente.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void estadisticasTicket(ArrayList<Ticket> tickets) {

		float totalRecaudado = 0;
		String repetidos = "";
		System.out.println("\n - - - - - - - - - - - - Tickets usados - - - - - - - -  - - - -");

		if (tickets != null) {
			// 8.3.1.1
			for (Ticket ticket : tickets) {
				System.out.println(ticket);
				// 8.3.1.2
				totalRecaudado += ticket.getTotal();
				repetidos += ticket.getCodigoPlanta() + " ";
			}
			if (totalRecaudado > 0) {
				System.out.println("Total recaudado: " + totalRecaudado);
			}
		}

		if (repetidos.trim().isEmpty()) {
			System.out.println("\nNo existen ticket, crealos como vendedor. ");
		} else {

			String[] plantasCod = repetidos.trim().split(" ");

			int masRepetido = 0;
			int maxContador = 0;
			// 8.3.2.1
			for (int i = 0; i < plantasCod.length; i++) {
				int contador = 0;
				for (int j = 0; j < plantasCod.length; j++) {
					if (plantasCod[i].equals(plantasCod[j])) {
						contador++;
					}
				}

				if (contador > maxContador) {
					maxContador = contador;
					masRepetido = Integer.parseInt(plantasCod[i]);
				}
			}

			System.out.println("La planta mas vendida es la planta con id: " + masRepetido);
		}
	}

	public static void menuGestor(Empleado empleadoID, ArrayList<Plantas> plantasCaracteristicas,
			ArrayList<Empleado> empleadosSinVerificar, ArrayList<Empleado> empleadosDeBaja,
			ArrayList<Empleado> empleadosVerificados, ArrayList<Ticket> tickets, ArrayList<Plantas> plantasDeBaja) {
		Scanner scanner = new Scanner(System.in);
		String expReg = "^[0-9]{1}$";
		int bandera = 0;

		do {
			System.out.println("\n\n - - - - Menu Gestor - - - -");
			System.out.println("   1. Dar de alta planta");
			System.out.println("   2. Dar de baja planta");
			System.out.println("   3. Modificar datos de planta");
			System.out.println("   4. Dar de alta empleado");
			System.out.println("   5. Dar de baja empleado");
			System.out.println("   6. Recontratar empleado");
			System.out.println("   7. Estadisticas tickets");
			System.out.println("   8. Salir");
			System.out.print("Opcion: ");
			String opcion = scanner.nextLine();

			if (opcion.matches(expReg)) {

				switch (Integer.parseInt(opcion)) {
				case 1:
					darDeAltaPlanta(plantasCaracteristicas, plantasDAT, plantasXML);
					break;
				case 2:
					darDeBajaPlanta(plantasCaracteristicas, plantasDAT, plantasDeBaja);
					break;
				case 3:
					modificarDatosPlanta(plantasCaracteristicas, plantasDAT, plantasXML);
					break;
				case 4:
					darDeAltaEmpleado(empleadosVerificados, empleadoDAT);
					break;
				case 5:
					darDeBajaEmpleado(empleadosDeBaja, empleadosVerificados, empleadoDAT);
					break;
				case 6:
					recontratarEmpleado(empleadosVerificados, empleadosDeBaja, empleadoDAT);
					break;
				case 7:
					estadisticasTicket(tickets);
					break;
				case 8:
					System.out.println("Hasta la proxima " + empleadoID.getNombre());
					bandera = 1;
					break;
				default:
					// Fallo de numero case
					System.out.println(
							"La opcion " + opcion + " no cumple con los parametros permitidos, intentalo de nuevo: ");
					break;
				}
			} else {
				// ExpReg
				System.out.println(
						"La opcion " + opcion + "  no cumple con los parametros permitidos, intento de nuevo: ");
			}

		} while (bandera == 0);
	}

	public static void comprobarValidedEmpleados(ArrayList<Empleado> empleadosSinVerificar,
			ArrayList<Empleado> empleadosVerificados) {

		Boolean comprobacionContraseña = true;
		Boolean comprobacionCargo = true;
		Boolean comprobacionNombre = true;

		for (Empleado empleado : empleadosSinVerificar) {

			if (empleado.comprobarContraseña() != true) {
				System.out.println("Empleado " + empleado.getIdentificacion()
						+ " no valido, la contraseña no cumple las especificaciones");
				comprobacionContraseña = false;
			}

			if (empleado.comprobarCargo() != true) {
				System.out.println("Empleado " + empleado.getIdentificacion()
						+ " no valido, el cargo no cumple las especificaciones");
				comprobacionCargo = false;
			}

			if (empleado.comprobarNombre() != true) {
				System.out.println("Empleado " + empleado.getIdentificacion()
						+ " no valido, el nombre no cumple las especificaciones");
				comprobacionNombre = false;
			}

			if (comprobacionContraseña && comprobacionCargo && comprobacionNombre) {
				empleadosVerificados.add(empleado);
			} else {
				System.out.println("Empleado " + empleado.getIdentificacion() + " " + empleado.getNombre()
						+ " rechazado, corrige los errores\n");
			}

			comprobacionContraseña = true;
			comprobacionCargo = true;
			comprobacionNombre = true;

		}

	}

	public static void leerEmpleadosDat(String nombreArchivo, ArrayList<Empleado> empleadosSinVerificar) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Empleado> listaEmpleados = new ArrayList<>();
		File archivo = new File(rutaSrcEmpleados + "\\" + nombreArchivo);

		if (archivo.exists() && archivo.isFile()) {

			try (

					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {

				// Pasa el texto dat, a texto plano
				listaEmpleados = (ArrayList<Empleado>) ois.readObject();

				for (Empleado empleado : listaEmpleados) {
					Empleado empleados = new Empleado();

					// Compruebo si tiene 0 a la izquierda el id, el maximo codigo con 0 a la
					// izquierda es 0757, y nos devuelve 495, por ende la longitud mayor con un
					// numero de 4 digitos y un 0 a la izquierda es de 3.
					// Y el menor numero seria el 0, con 0000 con una longitud de 1

					// Esto no influye con los que añade el gestor porque tengo en la clase Empleado
					// un generador automaticno existe, introduce el nombre del archivo con su
					// extension correcta:o de 4 digitos

					// 3.4

					if (String.valueOf(empleado.getIdentificacion()).length() == 1
							|| String.valueOf(empleado.getIdentificacion()).length() == 2
							|| String.valueOf(empleado.getIdentificacion()).length() == 3) {
						empleados.setIdentificacion(empleado.getIdentificacion() + 1000);
					} else {
						empleados.setIdentificacion(empleado.getIdentificacion());

					}
					empleados.setNombre(empleado.getNombre());
					empleados.setPassword(empleado.getPassword());
					empleados.setCargo(empleado.getCargo());

					empleadosSinVerificar.add(empleados);

				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} else {
			// 1.3
			String expReg = "^[a-zA-Z0-9ñ_]+\\.[a-zA-Z0-9ñ_]+$";
			int bandera = 0;
			System.out.println("El archivo " + nombreArchivo
					+ " no existe, introduce el nombre del archivo con su extension correcta: ");
			do {
				nombreArchivo = scanner.nextLine();
				if (nombreArchivo.matches(expReg)) {
					leerEmpleadosDat(empleadoDAT, empleadosSinVerificar);
					bandera = 1;
				} else {
					System.out
							.print("El nombre introducido no es valido para un nombre de archivo. Intentelo de nuevo:");
				}
			} while (bandera == 0);
		}
	}

	public static void leerPlantasDat(String nombreArchivo) {
		Scanner scanner = new Scanner(System.in);
		File archivo = new File(rutaSrcPlantas + "\\" + nombreArchivo);

		if (archivo.exists() && archivo.isFile()) {

			try {
				File fichero = new File(rutaSrcPlantas + "\\" + nombreArchivo);
				RandomAccessFile rafLectura = new RandomAccessFile(fichero, "r");

				rafLectura.seek(0);

				while (rafLectura.getFilePointer() < rafLectura.length()) {

					rafLectura.readInt();
					rafLectura.readFloat();
					rafLectura.readInt();

				}
				tamañoDat = rafLectura.getFilePointer();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// 1.2
			String expReg = "^[a-zA-Z0-9ñ_]+\\.[a-zA-Z0-9ñ_]+$";
			int bandera = 0;
			System.out.println("El archivo " + nombreArchivo
					+ " no existe, introduce el nombre del archivo con su extension correcta: ");
			do {
				nombreArchivo = scanner.nextLine();
				if (nombreArchivo.matches(expReg)) {
					leerPlantasDat(nombreArchivo);
					bandera = 1;
				} else {
					// 2.5 Esta hecho asi en todas las lecturas
					System.out
							.print("El nombre introducido no es valido para un nombre de archivo. Intentelo de nuevo:");
				}
			} while (bandera == 0);
		}
	}

	public static void leerPlantasXML(String nombreArchivo, ArrayList<Plantas> plantasCaracteristicas) {
		Scanner scanner = new Scanner(System.in);
		File archivo = new File(rutaSrcPlantas + "\\" + nombreArchivo); // Aqui cambio al archivo que quiera yo
		if (archivo.exists() && archivo.isFile()) {

			try {
				File ficheroPlantasXML = new File(rutaSrcPlantas + "\\" + nombreArchivo);
				DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
				DocumentBuilder docB = DBF.newDocumentBuilder();
				Document doc = docB.parse(ficheroPlantasXML);
				doc.getDocumentElement().normalize();
				NodeList lista = doc.getElementsByTagName("planta");
				int cantidad = lista.getLength();

				for (int i = 0; i < cantidad; i++) {

					Node nodo = lista.item(i);
					if (nodo.getNodeType() == Node.ELEMENT_NODE) {
						Element planta = (Element) nodo;
						Plantas plantas = new Plantas();
						String codigo = planta.getElementsByTagName("codigo").item(0).getTextContent();
						String nombre = planta.getElementsByTagName("nombre").item(0).getTextContent();
						String foto = planta.getElementsByTagName("foto").item(0).getTextContent();
						String descripcion = planta.getElementsByTagName("descripcion").item(0).getTextContent();

						plantas.setCodigo(Integer.parseInt(codigo));
						plantas.setNombre(nombre);
						plantas.setFoto(foto);
						plantas.setDescripcion(descripcion);

						plantasCaracteristicas.add(plantas);
					}

				}

			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// 1.1
			String expReg = "^[a-zA-Z0-9ñ_]+\\.[a-zA-Z0-9ñ_]+$";
			int bandera = 0;
			System.out.println("El archivo " + nombreArchivo
					+ " no existe, introduce el nombre del archivo con su extension correcta: ");
			do {
				nombreArchivo = scanner.nextLine();
				if (nombreArchivo.matches(expReg)) {
					leerPlantasXML(nombreArchivo, plantasCaracteristicas);
					bandera = 1;
				} else {
					System.out
							.print("El nombre introducido no es valido para un nombre de archivo. Intentelo de nuevo:");
				}
			} while (bandera == 0);
		}
	}

	public static void leerEmpladoBajaDat(String nombreArchivo, ArrayList<Empleado> empleadosDeBaja) {
		Scanner scanner = new Scanner(System.in);
		File archivo = new File(rutaSrcEmpleadosBaja + "\\" + nombreArchivo);
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			if (archivo.exists() && archivo.isFile()) {

				try {
					File fichero = new File(rutaSrcEmpleadosBaja + "\\" + nombreArchivo);
					RandomAccessFile rafLectura = new RandomAccessFile(fichero, "r");

					rafLectura.seek(0);

					while (rafLectura.getFilePointer() < rafLectura.length()) {
						Empleado empleadoBaja = new Empleado();
						empleadoBaja.setIdentificacion(rafLectura.readInt());
						empleadoBaja.setNombre(rafLectura.readUTF());
						empleadoBaja.setPassword(rafLectura.readUTF());
						empleadoBaja.setCargo(rafLectura.readUTF());
						empleadosDeBaja.add(empleadoBaja);

					}
					rafLectura.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				String expReg = "^[a-zA-Z0-9ñ_]+\\.[a-zA-Z0-9ñ_]+$";
				int bandera = 0;
				System.out.println("El archivo " + nombreArchivo
						+ " no existe, introduce el nombre del archivo con su extension correcta: ");
				do {
					nombreArchivo = scanner.nextLine();
					if (nombreArchivo.matches(expReg)) {
						leerPlantasDat(nombreArchivo);
						bandera = 1;
					} else {
						System.out.print(
								"El nombre introducido no es valido para un nombre de archivo. Intentelo de nuevo:");
					}
				} while (bandera == 0);
			}
		}

	}

	public static void leerTickets(ArrayList<Ticket> tickets) {

		File contieneArchivosTickets = new File(rutaSrcTickets);
		File[] cuenta = contieneArchivosTickets.listFiles();

		for (int i = 0; i < cuenta.length; i++) {
			Ticket ticketAñadir = new Ticket();
			try {
				File lecturaTicket = new File(rutaSrcTickets + "\\" + cuenta[i].getName());

				BufferedReader br = new BufferedReader(new FileReader(lecturaTicket));

				String linea;
				ArrayList<String> datos = new ArrayList<>();
				// Si la linea que leo contiene :, lo separo con split y me lo llevo a un
				// arrayList
				while ((linea = br.readLine()) != null) {
					if (linea.contains(":")) {
						String[] partes = linea.split(":");
						datos.add(partes[1].trim());
					}

					if (linea.contains("#")) {
						String[] partes2 = linea.split("\\s+");
						for (int j = 0; j < partes2.length; j++) {
							if (partes2[j] != " ") {
								// El 0 seria el # y el 1 seria un hueco en blanco
								if (j == 2) {
									ticketAñadir.setCodigoPlanta(Integer.parseInt(partes2[2]));
								}
								if (j == 3) {
									ticketAñadir.setStock(Integer.parseInt(partes2[3]));
								}
								if (j == 4) {
									ticketAñadir.setPrecio(Float.parseFloat(partes2[4]));
								}

							}
						}

					}

				}

				for (int j = 0; j < datos.size(); j++) {

					if (j == 0) {
						ticketAñadir.setCodigoTicket(Integer.parseInt(datos.get(0)));
					}
					if (j == 1) {
						ticketAñadir.setCodigoEmpleado(Integer.parseInt(datos.get(1)));
					}
					if (j == 2) {
						ticketAñadir.setNombreEmpleado(datos.get(2));
					}
					if (j == 3) {
						ticketAñadir.setTotal(Float.parseFloat(datos.get(3)));
					}

				}
				tickets.add(ticketAñadir);
				br.close();

			} catch (Exception e) {
				// TODO: handle exception
				if (e.getMessage().contains("Being used by another process")
						|| e.getMessage().contains("utilizado por otro proceso")) {

					System.out.println("No se puede mover: el archivo sigue abierto.");
				}
			}

		}

	}

	public static void leerTicketsDevolucion(ArrayList<Ticket> ticketsDevolucion) {

		File contieneArchivosTickets = new File(rutaSrcDevoluciones);
		File[] cuenta = contieneArchivosTickets.listFiles();
		for (int i = 0; i < cuenta.length; i++) {
			Ticket ticketAñadir = new Ticket();
			try {
				File lecturaTicket = new File(rutaSrcDevoluciones + "\\" + cuenta[i].getName());
				BufferedReader br = new BufferedReader(new FileReader(lecturaTicket));

				String linea;
				ArrayList<String> datos = new ArrayList<>();
				// Si la linea que leo contiene :, lo separo con split y me lo llevo a un
				// arrayList
				while ((linea = br.readLine()) != null) {
					if (linea.contains(":")) {
						String[] partes = linea.split(":");
						datos.add(partes[1].trim());
					}

					if (linea.contains("#")) {
						String[] partes2 = linea.split("\\s+");
						for (int j = 0; j < partes2.length; j++) {
							if (partes2[j] != " ") {
								// El 0 seria el # y el 1 seria un hueco en blanco
								if (j == 2) {
									ticketAñadir.setCodigoPlanta(Integer.parseInt(partes2[2]));
								}
								if (j == 3) {
									ticketAñadir.setStock(Integer.parseInt(partes2[3]));
								}
								if (j == 4) {
									ticketAñadir.setPrecio(Float.parseFloat(partes2[4]));
								}

							}
						}

					}

				}

				for (int j = 0; j < datos.size(); j++) {

					if (j == 0) {
						ticketAñadir.setCodigoTicket(Integer.parseInt(datos.get(0)));
					}
					if (j == 1) {
						ticketAñadir.setCodigoEmpleado(Integer.parseInt(datos.get(1)));
					}
					if (j == 2) {
						ticketAñadir.setNombreEmpleado(datos.get(2));
					}
					if (j == 3) {
						ticketAñadir.setTotal(Float.parseFloat(datos.get(3)));
					}

				}
				ticketsDevolucion.add(ticketAñadir);
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public static void cargarDatos(ArrayList<Empleado> empleadosSinVerificar, ArrayList<Plantas> plantasCaracteristicas,
			ArrayList<Empleado> empleadosDeBaja, ArrayList<Ticket> tickets, ArrayList<Ticket> ticketsDevolucion,
			ArrayList<Plantas> plantasDeBaja) {
		// 2.3 | 2.4
		leerEmpleadosDat(empleadoDAT, empleadosSinVerificar);
		// 2.1
		leerPlantasDat(plantasDAT);
		// 2.2
		leerPlantasXML(plantasXML, plantasCaracteristicas);

		leerEmpladoBajaDat(empleadoBajaDAT, empleadosDeBaja);
		leerPlantasBajaXML(plantasBajaXML, plantasDeBaja);

		// Si contiene algo que lo lea, si no, no
		File contieneArchivosTickets = new File(rutaSrcTickets);
		File[] cuenta = contieneArchivosTickets.listFiles();
		if (cuenta != null) {
			for (File file : cuenta) {
				contadorTickets++;
			}
			leerTickets(tickets);
		}

		File contieneArchivosDevolucion = new File(rutaSrcDevoluciones);
		File[] cuenta2 = contieneArchivosDevolucion.listFiles();
		if (cuenta2 != null) {
			for (File file : cuenta2) {
				contadorTickets++;
			}
			leerTicketsDevolucion(ticketsDevolucion);
		}
	}

	public static void crearEstructura() {

		crearCarpetas(rutaSrcPlantas);
		crearCarpetas(rutaSrcEmpleados);
		crearCarpetas(rutaSrcEmpleadosBaja);
		crearCarpetas(rutaSrcTickets);
		crearCarpetas(rutaSrcDevoluciones);

		// ESTO SE TIENE QUE AÑADIR AL FINAL DEL PROGRAMA PORQUE TIENE LOS ARCHIVOS
		// MODIFICADOS

		moverArchivos(rutaGlobalStatic, plantasXML, rutaSrcPlantas);
		moverArchivos(rutaGlobalStatic, plantasDAT, rutaSrcPlantas);
		moverArchivos(rutaGlobalStatic, empleadoDAT, rutaSrcEmpleados);

	}

	public static void crearCarpetas(String nombreCarpeta) {
		File capetaPlantas = new File(nombreCarpeta);
		if (!capetaPlantas.exists() && !capetaPlantas.isDirectory()) {
			capetaPlantas.mkdir();
		}
	}

	public static void moverArchivos(String rutaGlobal, String archivoMover, String rutaCarpetaDestino) {
		// 1.4
		File moverArchivo = new File(rutaGlobal + archivoMover);
		if (moverArchivo.exists() && moverArchivo.isFile()) {
			Path rutaOrigen = Paths.get(rutaGlobal + archivoMover);
			Path rutaDestino = Paths.get(rutaCarpetaDestino + "\\" + archivoMover);
			try {
				Files.copy(rutaOrigen, rutaDestino, StandardCopyOption.REPLACE_EXISTING);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	public static void leerPlantasBajaXML(String nombreArchivo, ArrayList<Plantas> plantasDeBaja) {

		File comprobarExistencia = new File(rutaGlobalStatic + "\\" + nombreArchivo); // Comprueba el src
		File comprobarExistenciaRutaFInal = new File(rutaSrcPlantas + "\\" + nombreArchivo);

		if (comprobarExistenciaRutaFInal.exists() && comprobarExistenciaRutaFInal.isFile()
				&& comprobarExistenciaRutaFInal.length() > 0) {

			// Leer
			// 8.1.3.2
			try {
				File ficheroPlantasXML = new File(rutaSrcPlantas + "\\" + nombreArchivo);
				DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
				DocumentBuilder docB = DBF.newDocumentBuilder();
				Document doc = docB.parse(ficheroPlantasXML);
				doc.getDocumentElement().normalize();
				NodeList lista = doc.getElementsByTagName("planta");
				int cantidad = lista.getLength();

				for (int i = 0; i < cantidad; i++) {

					Node nodo = lista.item(i);
					if (nodo.getNodeType() == Node.ELEMENT_NODE) {
						Element planta = (Element) nodo;
						Plantas plantas = new Plantas();
						String codigo = planta.getElementsByTagName("codigo").item(0).getTextContent();
						String nombre = planta.getElementsByTagName("nombre").item(0).getTextContent();
						String foto = planta.getElementsByTagName("foto").item(0).getTextContent();
						String descripcion = planta.getElementsByTagName("descripcion").item(0).getTextContent();

						plantas.setCodigo(Integer.parseInt(codigo));
						plantas.setNombre(nombre);
						plantas.setFoto(foto);
						plantas.setDescripcion(descripcion);

						plantasDeBaja.add(plantas);
					}

				}

			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			if (comprobarExistencia.exists() && comprobarExistencia.isFile()) {
				// si existe en el src lo muevo a la carpeta buena

				File moverArchivo = new File(rutaGlobalStatic + "\\" + nombreArchivo);
				if (moverArchivo.exists() && moverArchivo.isFile()) {
					Path rutaOrigen = Paths.get(rutaGlobalStatic + "\\" + nombreArchivo);
					Path rutaDestino = Paths.get(rutaSrcPlantas + "\\" + nombreArchivo);

					try {
						Files.copy(rutaOrigen, rutaDestino, StandardCopyOption.REPLACE_EXISTING);

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}

				}

				moverArchivo.delete();

			} else {
				// si no existe lo creo y lo muevo
				try {
					comprobarExistencia.createNewFile();
					File moverArchivo = new File(rutaGlobalStatic + "\\" + nombreArchivo);
					if (moverArchivo.exists() && moverArchivo.isFile()) {
						Path rutaOrigen = Paths.get(rutaGlobalStatic + "\\" + nombreArchivo);
						Path rutaDestino = Paths.get(rutaSrcPlantas + "\\" + nombreArchivo);

						try {
							Files.copy(rutaOrigen, rutaDestino, StandardCopyOption.REPLACE_EXISTING);

						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}

					}

					moverArchivo.delete();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void borrarArchivosCopia(String archivoBorrar) {
		File archivo = new File(rutaGlobalStatic + "\\" + archivoBorrar);
		archivo.delete();
	}

	public static void mostrarEmpleados(ArrayList<Empleado> empleadosVerificados) {

		System.out.println("==============================================================================");
		System.out.println("================ Bienvenido al sistema de gestion de vivero ==================");
		System.out.println("==============================================================================\n");
		for (Empleado emp : empleadosVerificados) {
			System.out.println(emp);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayList<Empleado> empleadosSinVerificar = new ArrayList<>();
		ArrayList<Empleado> empleadosVerificados = new ArrayList<>();
		ArrayList<Empleado> empleadosDeBaja = new ArrayList<>();
		ArrayList<Plantas> plantasCaracteristicas = new ArrayList<>();
		ArrayList<Plantas> plantasDeBaja = new ArrayList<>();
		ArrayList<Ticket> tickets = new ArrayList<>();
		ArrayList<Ticket> ticketsDevolucion = new ArrayList<>();
		File rutaPadre = new File("src");
		String rutaCompleta = rutaPadre.getAbsolutePath();
		String[] rutaCreacionCarpetas = rutaCompleta.split("\\\\");

		String rutaGlobalSrc = "";

		for (int i = 0; i < rutaCreacionCarpetas.length - 1; i++) {
			// El -1, es para que no me agrege el nombre del src, ya que solo quiero la
			// ruta padre donde guardamos todos los xml .dat etc
			rutaGlobalSrc += rutaCreacionCarpetas[i] + "\\"; // C:\Users\NewRuben\Desktop\CFGS\ProyectoAcceso\
		}

		rutaGlobalStatic = rutaGlobalSrc;

		rutaSrcPlantas = rutaGlobalSrc + "PLANTAS";
		rutaSrcEmpleados = rutaGlobalSrc + "EMPLEADOS";
		rutaSrcEmpleadosBaja = rutaGlobalSrc + "EMPLEADOS\\BAJA";
		rutaSrcTickets = rutaGlobalSrc + "TICKETS";
		rutaSrcDevoluciones = rutaGlobalSrc + "DEVOLUCIONES";

		crearEstructura();

		borrarArchivosCopia(plantasXML);
		borrarArchivosCopia(plantasDAT);
		borrarArchivosCopia(empleadoDAT);

		cargarDatos(empleadosSinVerificar, plantasCaracteristicas, empleadosDeBaja, tickets, ticketsDevolucion,
				plantasDeBaja);

		comprobarValidedEmpleados(empleadosSinVerificar, empleadosVerificados);

		mostrarEmpleados(empleadosVerificados);

		inicioSesion(empleadosVerificados, plantasCaracteristicas, tickets, ticketsDevolucion, empleadosSinVerificar,
				empleadosDeBaja, plantasDeBaja);

	}

}
