/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package HilosNuevoProfesor.SincronizacionHilos;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fran
 */
public class SincroWaitNotify {

    private static final int NUM_HILOS = 6;

    private final static boolean[] flagsArrayHilosFinalizados = new boolean[NUM_HILOS];

    /**
     * Pone la posición del array asociada a cada hilo a false
     */
    private static void inicializaFlagsArrayHilosFinalizados() {
        for (int i = 0; i < NUM_HILOS; i++) {
            flagsArrayHilosFinalizados[i] = false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Invocamos al método static para inicializar el array
        SincroWaitNotify.inicializaFlagsArrayHilosFinalizados();

        for (int i = 0; i < NUM_HILOS; i++) {
            Runnable hilo = new MensajeroGriego();
            Thread hAux = new Thread(hilo);
            hAux.setName(Integer.toString(i + 1));
            
            // Lanzo la ejecución de cada hilo
            hAux.start();
        }

        try {
            synchronized (flagsArrayHilosFinalizados) {
                flagsArrayHilosFinalizados.wait();
            }
            System.out.println("\n=== DESDE MAIN ANUNCIAMOS QUE TODOS LOS HILOS ACABARON LA CARRERA!!! ===");
        } catch (InterruptedException ex) {
            //ex.printStackTrace();
            Logger.getLogger(SincroWaitNotify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Getter para encapsular el array con el estado de los hilos
     * @return boolean[] El array con los estados
     */
    public static boolean[] getFlagsArrayHilosFinalizados() {
        return flagsArrayHilosFinalizados;
    }
}
