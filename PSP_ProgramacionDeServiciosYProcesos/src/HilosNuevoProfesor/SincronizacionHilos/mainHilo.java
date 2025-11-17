package HilosNuevoProfesor.SincronizacionHilos;

public class mainHilo {

	private static final int NUM_HILOS = 6;
	
	public static void main(String[] args) {
		
		for (int i = 0; i < NUM_HILOS; i++) {

			Runnable hilo = new MensajeroGriego();
			Thread hAux = new Thread(hilo);
			hAux.setName(Integer.toString(i + 1));

			hAux.start();
		}
		
	}
	
}
