package tema1.apuntes.SincronizacionDeProcesos;

public class mainProceso {

	public static void main(String[] args) {

		String[] argumentos = { "cmd.exe", "/C", "start" }; // Este ejemplo no tiene sentido porque cuando se abre un
															// cmd fuera de eclipse, que es independiente al proceso de
															// eclipse, por eso el buffer no imprime salida y el waitFor
															// no sirve de nada
		EjecutarProceso ep = new EjecutarProceso();
		ep.ejecutar(argumentos);
		System.out.println("Proceso ejecutado");

		/*
		 * Lo que pasa en este ejemplo es que, al iniciar un cmd fuera de eclipse el
		 * proceso queda independiente de java eclipse por lo tanto el waitFor no
		 * esperaria al proceso porque no existe ninguno en eclipse. Parece que si
		 * espera al proceso ya que cuando ejecuto el programa no imprime el sout del
		 * main hasta que lo cierre, pero la realidad es que el buffer esta leyendo el
		 * buffer del cmd y como el cmd sigue abierto no termina la ejecucion del
		 * proceso
		 * 
		 * ¿Porque el bufferedreader espera al cmd si es un proceso fuera de eclipse?
		 * 
		 * El BufferedReader nunca lee directamente la ventana CMD que abri con start.
		 * Lo que bloquea al programa Java es la EOF (espera de fin de stream) del
		 * proceso hijo original, no la ventana que abriste. 
		 * 
		 * proceso.getInputStream() → es la salida estándar del proceso hijo que Java lanzó.
		 * readLine() intenta leer una línea completa del stream. 
		 * Si el proceso hijo no cierra su salida, readLine() se queda esperando indefinidamente a que
		 * aparezca una línea o al fin de stream (EOF).
		 * 
		 */
	}
}
