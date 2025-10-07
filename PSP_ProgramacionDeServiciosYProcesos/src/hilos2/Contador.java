package hilos2;

public class Contador {

	private int cuenta = 0;

	synchronized public int getCuenta() {
		return cuenta;
	}

	synchronized public int incrementa() {
		return cuenta++;
	}

}
