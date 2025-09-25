package ejercicioBiblioteca;

public class Libros extends Biblioteca implements Prestable {

	private boolean esPrestado = false;

	public Libros(int codigo, String titulo, String añoPublicacion, boolean esPrestado) {
		super(codigo, titulo, añoPublicacion);
		this.esPrestado = esPrestado;
	}

	public boolean isEsPrestado() {
		return esPrestado;
	}

	public void setEsPrestado(boolean esPrestado) {
		this.esPrestado = esPrestado;
	}

	@Override
	public boolean prestar() {
		// TODO Auto-generated method stub
		return esPrestado = true;
	}

	@Override
	public boolean devolver() {
		// TODO Auto-generated method stub
		return esPrestado = false;
	}

	@Override
	public boolean prestado() {
		// TODO Auto-generated method stub
		return esPrestado;
	}

	@Override
	public String añoPublicacion() {
		// TODO Auto-generated method stub
		return "El año de pubicacion del libro fue en: " + getAñoPublicacion();
	}

	@Override
	public String codigoProducto() {
		// TODO Auto-generated method stub
		return "El codigo de producto del libro es: " + getCodigo();
	}

	@Override
	public String toString() {
		return "Libro -> Codigo: "+codigo+ " -Titulo: "+titulo+" -Año de publicacion: " +añoPublicacion+ " -Prestado "+esPrestado;
	}

}
