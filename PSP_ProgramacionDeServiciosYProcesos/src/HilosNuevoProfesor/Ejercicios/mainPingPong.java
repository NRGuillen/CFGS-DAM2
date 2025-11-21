package HilosNuevoProfesor.Ejercicios;

public class mainPingPong {


	public static void main(String[] args) {

		Semaforos jPing = new Semaforos("PING");
		Semaforos jPong = new Semaforos("PONG");

		jPing.start();
		jPong.start();


	}

}
