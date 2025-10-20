package tema1.ejerciciosIO._01_04_LecturaXML;

import java.util.ArrayList;

public class Fruta {
	String nombre;
	String tipo;
	String color;
	String origen;
	String precio;
	String temporada;
	ArrayList<String> nutrientes = new ArrayList<>();

	public Fruta() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public ArrayList<String> getNutrientes() {
		return nutrientes;
	}

	public void setNutrientes(ArrayList<String> nutrientes) {
		this.nutrientes = nutrientes;
	}

	public void addNutrientes(String tipoNutrientes) {

		nutrientes.add(tipoNutrientes);

	}

	public void limpiarLista() {
		nutrientes.removeAll(nutrientes);

	}

	@Override
	public String toString() {
		return "La fruta es " + nombre + " | Tipo: " + tipo + " | Color: " + color + " | Origen: " + origen
				+ " | Precio: " + precio + " | Temporada: " + temporada + " | Nutrientes: " + nutrientes;

	}

}
