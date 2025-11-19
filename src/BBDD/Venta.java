package BBDD;

import java.sql.Date;

public class Venta {

	int idVenta; // PK
	int idEmpleado; // FK
	int idJuguete; // FK
	int idStand; // FK
	Date fecha;
	float monto;
	TipoPagoVenta tipoPago;
	
}
