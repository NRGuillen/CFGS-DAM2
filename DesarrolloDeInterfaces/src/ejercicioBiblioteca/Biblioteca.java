package ejercicioBiblioteca;

abstract public class Biblioteca {

	protected int codigo;
	protected String titulo;
	protected String añoPublicacion;

	public Biblioteca(int codigo, String titulo, String añoPublicacion) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.añoPublicacion = añoPublicacion;
	}

	public Biblioteca() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAñoPublicacion() {
		return añoPublicacion;
	}

	abstract public String añoPublicacion();

	abstract public String codigoProducto();

}
