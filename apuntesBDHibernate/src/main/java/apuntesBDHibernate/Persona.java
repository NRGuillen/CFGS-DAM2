package apuntesBDHibernate;

import jakarta.persistence.*;

// Le estoy diciendo que es una tabla de la bd
@Entity
// Le estoy diciendo a que tabla pertenece en la bd
@Table(name = "personas")
public class Persona {
	// Le digo que es la clave primaria y que se autoincrementa
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private int edad;

	public Persona() {
		super();
	}

	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

}
