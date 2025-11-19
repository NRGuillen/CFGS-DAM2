package PF;

import java.util.ArrayList;

public class Plantas {

	private int codigo;
	private String nombre;
	private String foto;
	private String descripcion;

	public Plantas() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Planta: " + codigo + " | Nombre: " + nombre + " | Foto: " + foto + " | Descripcion: " + descripcion;
	}

}
