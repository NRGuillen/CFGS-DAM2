package tema1.EjerciciosDeRepaso.Ejercicio8;

import java.util.ArrayList;
import java.util.Scanner;

public class mainEjercicio {

	public static void añadirAdministrador(Scanner scanner) {

		scanner.nextLine();

		Administracion adm = new Administracion();

		System.out.println("Introduce el DNI del administrador/a");
		String dniAdm = scanner.nextLine();
		adm.setDni(dniAdm);

		System.out.println("Introduce el Nombre del administrador/a");
		String nombreAdm = scanner.nextLine();
		adm.setNombre(nombreAdm);

		System.out.println("Introduce el Apellidos del administrador/a");
		String apellidosAdm = scanner.nextLine();
		adm.setApellidos(apellidosAdm);

		System.out.println("Introduce el Salario del administrador/a");
		double salarioAdm = scanner.nextDouble();
		adm.setSalario(salarioAdm);
		scanner.nextLine();

		System.out.println("Introduce el Estudios del administrador/a");
		String estudiosAdm = scanner.nextLine();
		adm.setEstudios(estudiosAdm);

		System.out.println("Introduce el Antiguedad del administrador/a");
		int antiguedadAdm = scanner.nextInt();
		adm.setAntiguedad(antiguedadAdm);

		System.out.println("Administrador añadido: " + adm.toString() + "\n");

	}

	public static void añadirAlumno(Scanner scanner, ArrayList<Modulo> modulos) {

		scanner.nextLine();

		Alumno alum = new Alumno();
		System.out.println("Introduce el DNI del Alumno/a");
		String dniAlum = scanner.nextLine();
		alum.setDni(dniAlum);

		System.out.println("Introduce el Nombre del Alumno/a");
		String nombreAlum = scanner.nextLine();
		alum.setNombre(nombreAlum);

		System.out.println("Introduce el Apellidos del Alumno/a");
		String apellidosAlum = scanner.nextLine();
		alum.setApellidos(apellidosAlum);

		System.out.println("Introduce el Fecha del Alumno/a DD-MM-AAAA");
		String fechaAlum = scanner.nextLine();
		alum.setFechaNacimiento(fechaAlum);

		System.out.println("Introduce el Sexo del Alumno/a");
		System.out.println("\t1 - Masculino");
		System.out.println("\t2 - Femenino");

		int opcionSexo = scanner.nextInt();
		switch (opcionSexo) {
		case 1:
			alum.setSexo(Sexo.MASCULINO);
			break;
		case 2:
			alum.setSexo(Sexo.FEMENINO);
			break;
		default:
			System.out.println("No has elegido una opcion correcta");
			break;

		}

		scanner.nextLine();

		System.out.println("Introduce si el Alumno/a es repetidor");
		System.out.println("\t1 - Es repetidor");
		System.out.println("\t1 - No es repetidor");

		int alumRep = scanner.nextInt();
		switch (alumRep) {
		case 1:
			alum.setRepetidor(true);
			break;
		case 2:
			alum.setRepetidor(false);
			break;
		default:
			System.out.println("No has elegido una opcion correcta");
			break;
		}

		System.out.println("Introduce el nombre del modulo al que el alumno quiere apuntarse");

		// FALTA TERMINAR MODULOS
		// FALTA TERMINAR MODULOS
		if (modulos != null) {

			for (Modulo modulo : modulos) {
				System.out.println(modulo);
			}

		}

		scanner.nextLine();

		String moduloBuscar = scanner.nextLine().toLowerCase().trim();

		if (modulos != null) {

			for (Modulo modulo : modulos) {
				if (moduloBuscar.equals(modulo.getNombre().toLowerCase().trim())) {
					alum.añadirModulo(modulo);
				}
			}

		}

		System.out.println("Alumno/a añadido: " + alum + "\n");

	}

	public static void añadirDirectivo(Scanner scanner) {

		scanner.nextLine();

		Directivo direct = new Directivo();
		System.out.println("Introduce el DNI del Directivo/a");
		String dniDirectivo = scanner.nextLine();
		direct.setDni(dniDirectivo);

		System.out.println("Introduce el Nombre del Directivo/a");
		String nombreDirectivo = scanner.nextLine();
		direct.setNombre(nombreDirectivo);

		System.out.println("Introduce el Apellidos del Directivo/a");
		String apellidosDirectivom = scanner.nextLine();
		direct.setApellidos(apellidosDirectivom);

		System.out.println("Introduce el Salario del Directivo/a");
		double salarioDirectivo = scanner.nextDouble();
		direct.setSalario(salarioDirectivo);
		scanner.nextLine();

		System.out.println("¿El Directivo/a es salesiano?");
		System.out.println("\t1 - Si, es salesiano");
		System.out.println("\t2 - No, no es salesiano");

		int salesianoOp = scanner.nextInt();
		switch (salesianoOp) {
		case 1:
			direct.setEsSalesiano(true);
			break;
		case 2:
			direct.setEsSalesiano(false);
			break;
		default:
			System.out.println("No has elegido una opcion correcta");
			break;
		}

		System.out.println("Introduce el turno del Directivo/a");
		System.out.println("\t1 - Mañana");
		System.out.println("\t2 - Tarde");

		int opcionTurno = scanner.nextInt();
		switch (opcionTurno) {
		case 1:
			direct.setTurno(Turno.MAÑANA);
			break;
		case 2:
			direct.setTurno(Turno.TARDE);
			break;
		default:
			System.out.println("No has elegido una opcion correcta");
			break;

		}
		scanner.nextLine();

		System.out.println("Directivo/a añadido: " + direct + "\n");

	}

	public static void añadirModulo(Scanner scanner, ArrayList<Profesor> profesores) {

		scanner.nextLine();

		Modulo mod = new Modulo();
		System.out.println("Introduce el Nombre del Modulo");
		String modNombre = scanner.nextLine();
		mod.setNombre(modNombre);

		System.out.println("Introduce las horas del modulo");
		int modHoras = scanner.nextInt();
		mod.setNumeroHoras(modHoras);
		scanner.nextLine();

		System.out.println("Introduce el Nombre del Profesor/a que imparte el modulo");
		System.out.println("Lista de profesores: ");
		for (Profesor prof : profesores) {
			System.out.println("\t- "+prof.getNombre());
		}

		String modNombreProfesor = scanner.nextLine();

		if (profesores != null) {

			for (Profesor profesor3 : profesores) {
				if (modNombreProfesor.equals(profesor3.getNombre())) {
					mod.setNombreProfesor(modNombreProfesor);
				}
			}
		}
		mod.setNombreProfesor(modNombreProfesor);

		System.out.println("Introduce si el modulo es convalidable");
		System.out.println("\t1 - Es convalidable");
		System.out.println("\t2 - No es convalidable");

		int opcionConv = scanner.nextInt();
		switch (opcionConv) {
		case 1:
			mod.setEsConvaldable(true);
			break;
		case 2:
			mod.setEsConvaldable(false);
			break;
		default:
			System.out.println("No has elegido una opcion correcta");
			break;

		}

		System.out.println("Alumno añadido: " + mod.toString() + "\n");

	}

	public static void añadirProfesor(Scanner scanner, ArrayList<Profesor> profesores) {

		scanner.nextLine();

		Profesor prof = new Profesor();

		System.out.println("Introduce el DNI del Profesor/a");
		String dniProf = scanner.nextLine();
		prof.setDni(dniProf);

		System.out.println("Introduce el Nombre del Profesor/a");
		String nombreProf = scanner.nextLine();
		prof.setNombre(nombreProf);

		System.out.println("Introduce el Apellidos del Profesor/a");
		String apellidosProf = scanner.nextLine();
		prof.setApellidos(apellidosProf);

		System.out.println("Introduce el Salario del Profesor/a");
		int salarioProf = scanner.nextInt();
		prof.setSalario(salarioProf);

		System.out.println("Introduce si el Profesor/a va a ser tutor");

		System.out.println("\t1 - Si va a ser tutor");
		System.out.println("\t2 - No va a ser tutor");

		int profOpcion = scanner.nextInt();
		switch (profOpcion) {
		case 1:
			prof.setEsTutor(true);
			break;
		case 2:
			prof.setEsTutor(true);
			break;
		default:
			System.out.println("No has elegido una opcion correcta");
			break;
		}

		System.out.println("Profesor añadido: " + prof + "\n");
		profesores.add(prof);

	}

	public static void main(String[] args) {

		ArrayList<Profesor> profesores = new ArrayList<Profesor>();
		ArrayList<Modulo> modulos = new ArrayList<Modulo>();

		Scanner scanner = new Scanner(System.in);

		Profesor profesor = new Profesor("123432W", "Juan", "Domingez sales", 1230.42, 2, true);
		Profesor profesor2 = new Profesor("123432W", "Ruben", "Domingez sales", 1230.42, 2, true);
		profesores.add(profesor);
		profesores.add(profesor2);

		Directivo directivo = new Directivo("1235438A", "Alberto", "Escobar si", 3421.2, true, Turno.MAÑANA);
		Directivo directivo2 = new Directivo("1235438A", "Alberto", "Escobar si", 3421.2, true, Turno.MAÑANA);

		Administracion admin = new Administracion("38237A", "Juan", "Guillen almodo", 35412.1, "Ingeniero informatico",
				7);
		Administracion admin2 = new Administracion("38237A", "Juan", "Guillen almodo", 35412.1, "Ingeniero informatico",
				7);

		System.out.println("Profesor: " + profesor);
		System.out.println("Profesor: " + profesor2);
		System.out.println("Directivo: " + directivo);
		System.out.println("Directivo: " + directivo2);
		System.out.println("Administrador: " + admin);
		System.out.println("Administrador: " + admin2 + "\n");

		Alumno alumno = new Alumno("123124A", "Ruben", "Guillen Rojas", "13/02/2005", Sexo.MASCULINO, false);
		Alumno alumno2 = new Alumno("25435342W", "Juan", "Francisco Muñoz", "11/01/2003", Sexo.MASCULINO, false);

		Modulo dam = new Modulo("DAM", 120, "Sergio", false);
		Modulo teleco = new Modulo("Telecomunicaciones", 120, "Vicente", false);
		modulos.add(dam);
		modulos.add(teleco);

		alumno.añadirModulo(dam);
		alumno.añadirModulo(teleco);
		alumno2.añadirModulo(teleco);

		System.out.println(alumno);
		System.out.println(alumno2);

		int opcion = 0;

		do {

			System.out.println("Introduce que quieres añadir");
			System.out.println("1. Administracion");
			System.out.println("2. Alumno");
			System.out.println("3. Directivo");
			System.out.println("4. Modulo");
			System.out.println("5. Profesor");
			System.out.println("6. Salir");

			opcion = scanner.nextInt();

			switch (opcion) {

			case 1:

				añadirAdministrador(scanner);

				break;

			case 2:

				añadirAlumno(scanner, modulos);

				break;

			case 3:

				añadirDirectivo(scanner);

				break;

			case 4:

				añadirModulo(scanner, profesores);

				break;

			case 5:

				añadirProfesor(scanner, profesores);

				break;

			}

		} while (opcion != 6);
	}

}
