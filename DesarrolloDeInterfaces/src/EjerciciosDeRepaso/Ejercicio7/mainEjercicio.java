package Ejercicio7;

public class mainEjercicio {

	public static void main(String[] args) {
		
		Profesor profesor = new Profesor("123432W", "Juan", "Domingez sales", 1230.42, 2, true);
		Directivo directivo = new Directivo("1235438A", "Alberto", "Escobar si", 3421.2, true , Turno.MAÑANA);
		Administracion admin = new  Administracion("38237A", "Juan", "Guillen almodo", 35412.1, "Ingeniero informatico", 7);
		Profesor profesor2 = new Profesor("123432W", "Juan", "Domingez sales", 1230.42, 2, true);
		Directivo directivo2 = new Directivo("1235438A", "Alberto", "Escobar si", 3421.2, true , Turno.MAÑANA);
		Administracion admin2 = new  Administracion("38237A", "Juan", "Guillen almodo", 35412.1, "Ingeniero informatico", 7);
		
		System.out.println(profesor);
		System.out.println(directivo);
		System.out.println(admin);
		System.out.println(profesor2);
		System.out.println(directivo2);
		System.out.println(admin2);
		
		
		
	}
	
}
