package tema1.ejercicios.ejercicioHilosMultiples;

public class Hilos implements Runnable {

	int zona = 0;
	int numeroProcesos;
	int conteoVotos = 0;
	ResultadosEncuesta cont;
	int votoPP = 0, votoPSOE = 0, votoVox = 0, votoSumar = 0, votosNulosLocales = 0, votosNoNulos = 0;

	public Hilos(int zona, int numeroProcesos, ResultadosEncuesta cont) {
		super();
		this.zona = zona;
		this.numeroProcesos = numeroProcesos;
		this.cont = cont;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < numeroProcesos; i++) {
			int voto = (int) (Math.random() * 2);// 0 vota, 1 no vota
			int votoPartido = (int) (Math.random() * 4);// 4 partidos 0 pp, 1 psoe, 2 vox, 3 sumar
			cont.getVotosGlobales();
			if (voto == 0) {
				conteoVotos++;
				votosNoNulos++;
				cont.getIncrementaNoNulos();
				if (votoPartido == 0) {
					votoPP++;
				} else if (votoPartido == 1) {
					votoPSOE++;
				} else if (votoPartido == 2) {
					votoVox++;
				} else if (votoPartido == 3) {
					votoSumar++;
				}
			} else if (voto == 1) {
				conteoVotos++;
				votosNulosLocales++;
				cont.getIncrementaNulos();
			}
		}
		System.out.println("\n=====Votos de la zona " + zona + "=====" 
				+ "\nVotos del PP: " + votoPP
				+ "\nVotos del PSOE: " + votoPSOE 
				+ "\nVotos del Vox: " + votoVox 
				+ "\nVotos del Sumar: " + votoSumar
				+ "\nVotos nulos " + votosNulosLocales + "/" + numeroProcesos 
				+"\nVotos no nulos " + votosNoNulos+ "/" + numeroProcesos 
				+ "\nVotos totales de la zona:  " + numeroProcesos + "/" + numeroProcesos);
	}

}
