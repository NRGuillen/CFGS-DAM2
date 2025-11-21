package tema1.PracticaFinalTema1.PF; //Para funcionar el paquete deberia llamarse solo PF

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Ticket  {
	
	private static int contadorTickets = 0;
	int codigoTicket;
	int codigoEmpleado;
	String nombreEmpleado;
	Date fecha;
	int codigoPlanta;
	int stock;
	float precio;
	float total;
	boolean devolucion;

	public Ticket() {
		super();
		this.codigoTicket = ++contadorTickets;
	}

	public int getCodigoTicket() {
		return codigoTicket;
	}

	public void setCodigoTicket(int codigoTicket) {
		this.codigoTicket = codigoTicket;
	}

	public int getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(int codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCodigoPlanta() {
		return codigoPlanta;
	}

	public void setCodigoPlanta(int codigoPlanta) {
		this.codigoPlanta = codigoPlanta;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public boolean isDevolucion() {
		return devolucion;
	}

	public void setDevolucion(boolean devolucion) {
		this.devolucion = devolucion;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(" Número Ticket: " + codigoTicket)
			.append("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -")
			.append("\n | Codigo del empleado que ha atendido: " + codigoEmpleado)
			.append("\n | Nombre del empleado: " + nombreEmpleado)
			.append("\n\n | Codigo del producto | Cantidad comprada | Precio por unidad")
		    .append("\n #         " + codigoPlanta + "                     " + stock + "                " + precio);						
			sb.append("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

			sb.append("\n Precio total: " + total + "\n");
			//6.2
			if (devolucion) {
				sb.append("- - - - Devuelto - - - -");
			}

		return sb.toString();
	}

}
