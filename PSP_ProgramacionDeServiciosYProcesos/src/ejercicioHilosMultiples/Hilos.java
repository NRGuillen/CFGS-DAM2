package ejercicioHilosMultiples;

public class Hilos implements Runnable {

	int voto = 0;
	int partido = 0;
	int zona = 0;
	int numeroHilos = 0;
	ResultadosEncuesta cont;
	int miCuenta = 0;

	public Hilos(int zona, int numeroHilos, ResultadosEncuesta cont) {
		super();
		this.voto = ((int) Math.random() * 2); // 0 vota, 1 no vota
		this.partido = ((int) Math.random() * 4); // 4 partidos 0 pp, 1 psoe, 2 vox, 3 sumar
		this.zona = zona;
	}

	public int getMiCuenta() {
		return miCuenta;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		if (voto == 1) {
			cont.incrementoNoNulos();
			if (partido == 0) {
				cont.incrementoPP();
			} else if (partido == 1) {
				cont.incrementoPsoe();
			} else if (partido == 2) {
				cont.incrementoVox();
			} else if (partido == 3) {
				cont.incrementoSumar();
			}
		} 

		System.out.println("Hilo " + zona + " lo damos por terminado y la cuenta de " + getMiCuenta());

	}

}
