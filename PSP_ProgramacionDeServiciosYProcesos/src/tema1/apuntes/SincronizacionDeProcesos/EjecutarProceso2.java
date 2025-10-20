package tema1.apuntes.SincronizacionDeProcesos;

import java.io.IOException;
import java.util.ArrayList;

public class EjecutarProceso2 {

	public void ejecutar(String proceso1, String proceso2) {

		ArrayList<String> lanzarProceso1 = new ArrayList<>();
		lanzarProceso1.add(proceso1);

		ArrayList<String> lanzarProceso2 = new ArrayList<>();
		lanzarProceso2.add(proceso2);

		Process proceso01 = null;
		Process proceso02 = null;

		try {
			// Esta mal porque no puedo controlar el orden de ejcucion de los procesos

			ProcessBuilder pb = new ProcessBuilder(lanzarProceso1);
			proceso01 = pb.start();
			System.out.println("Esperando a que se cierre la carpteta");
			proceso01.waitFor();

			ProcessBuilder pb2 = new ProcessBuilder(lanzarProceso2);
			proceso02 = pb2.start();
			System.out.println("Esperando a que se cierre la calculadora");
			proceso02.waitFor();

			System.out.println("Padre: ambos procesos han terminado");

		} catch (IOException e) {
			// TODO: handle exception
			e.getStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
