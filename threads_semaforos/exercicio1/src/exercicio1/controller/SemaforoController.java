package exercicio1.controller;

import java.util.concurrent.Semaphore;

public class SemaforoController extends Thread{
	private static String[] sentido = {"Norte","Leste","Sul","Oeste"};
	private int carro;
	private String sentidoCarro;
	private String sentidoIda;
	private Semaphore semaforo;
	
	public SemaforoController(int carro, Semaphore semaforo) {
		this.carro = carro;
		sentidoCarro = sentido[carro];
		definiIda();
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		chegouSemaforo();
		try {
			semaforo.acquire();
			cruzamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
		
	}
	
	private void cruzamento() {
		
		System.out.print("Carro "+ (carro+1)  );
		System.out.print(" foi de " +sentidoCarro);
		System.out.println(" para "+sentidoIda);
		
	}
	
	private void definiIda() {
		if(carro == 2) {
			sentidoIda = sentido[0];
			return;
		}
		if(carro == 3) {
			sentidoIda = sentido[1];
			return;
		}
		sentidoIda = sentido[carro+2];
	}
	
	private void chegouSemaforo() {
		System.out.println("Carro "+(carro+1)+ " chegou no semaforo");
	}

}
