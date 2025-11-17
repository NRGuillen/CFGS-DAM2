package HilosNuevoProfesor.SincronizacionHilos;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MensajeroGriego implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int threadNumber = Integer.parseInt(Thread.currentThread().getName());
		
		//
		long tsInicio = (new Date()).getTime();
		
		System.out.println("Comienza la ejecucion del hilo " +threadNumber);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			//Tambien sirve e.printStackTrace();
			Logger.getLogger(MensajeroGriego.class.getName()).log(Level.SEVERE, null, e);
		}

		System.out.println("Llego a la meta fin del hilo" +threadNumber);
		long tsFin = (new Date()).getTime();
		
		System.out.println("He tardado " + (tsInicio - tsFin) / 1000.0);

		registraFinEjecucionHilo(threadNumber);
		
	}
	
	protected synchronized void registraFinEjecucionHilo (int threadNumber) {
		
		boolean [] arrayHilosFinalizados = SincornizaciónWaitNotify.getFlagsArra;
		
		for (boolean b : arrayHilosFinalizados) {
			if (b == false) {
				return ;
			}
		}
		
	}

	
	
}
