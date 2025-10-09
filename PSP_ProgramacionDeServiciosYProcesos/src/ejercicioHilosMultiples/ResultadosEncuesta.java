package ejercicioHilosMultiples;

public class ResultadosEncuesta {

	int incrementaNoNulos = 0, incrementaNulos = 0, votosGlobales = 0;

	synchronized public int getIncrementaNoNulos() {
		return incrementaNoNulos++;
	}

	synchronized public int getIncrementaNulos() {
		return incrementaNulos++;
	}
	
	synchronized public int getVotosGlobales() {
		return votosGlobales++;
	}

	

}
