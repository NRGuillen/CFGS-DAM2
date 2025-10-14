package interBloqueos;

public class transferenciaConInterblock {

	public static void main(String[] args) {
		
		CuentaBancaria c1 = new CuentaBanciaria("ES23213142", 12500);
		CuentaBancaria c2 = new CuentaBanciaria("ES90787861", 23500);

		System.out.println("Saldo inicial de: "+c1.getNumeroCuenta+ " es " +c1.getSaldo);
		System.out.println("Saldo inicial de: "+c1.getNumeroCuenta+ " es " +c2.getSaldo);
		System.out.println("--------------------------------------");
		
		Thread h1 = new Thread(new Hilo(c1, c2, "H1"));
		Thread h2 = new Thread(new Hilo(c2, c1, "H2"));

		h1.start();
		h2.start();
		
		try {
			h1.join();
			h2.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("--------------------------------------");
		System.out.println("Saldo final de: "+c1.getNumeroCuenta+ " es " +c1.getSaldo);
		System.out.println("Saldo final de: "+c1.getNumeroCuenta+ " es " +c2.getSaldo);		
	}
	
}
