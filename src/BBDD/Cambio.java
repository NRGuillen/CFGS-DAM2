package BBDD;

import java.sql.Date;

public class Cambio {

	int idCambio; // PK
	int idEmpleado; // FK
	int idJugueteOriginal; // FK
	int idJugueteNuevo; // FK
	String motivo;
	Date fecha;
	int standOrigen; // FK
	int idZonaOrigen; // FK
	int standDestino; // FK
	int idZonaDestino; // FK

}
