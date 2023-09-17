package exercicio6.controller;

import java.util.concurrent.Semaphore;

public class CozinhaController extends Thread {
	
	private int id;
	private Semaphore entrega;
	private Semaphore cozimento;
	
	public CozinhaController(int id, Semaphore entrega, Semaphore cozimento) {
		super();
		this.id = id;
		this.entrega = entrega;
		this.cozimento = cozimento;
	}

	@Override
	public void run() {
		try {
			cozimento.acquire();
			cozinhar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			cozimento.release();
			try {
				entrega.acquire();
				entregar();
			}catch(Exception e2) {
				e2.printStackTrace();
			}finally {
				entrega.release();
			}
		}
		
	}

	private void entregar() {
		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if( id % 2 == 0) {
			System.err.println(id+"# Lasanha a Bolonhesa Entregue");
		}else {
			System.err.println(id+"# Sopa de cebola Entregue");
		}
		
	}

	private void cozinhar() {
		if(id % 2 == 0) {
			int tempo =(int) Math.random()*601 + 600;
			int tempoTotal = tempo;
			System.out.println("Cozinhando "+id+"# Lasanha a Bolonhesa");
			while (tempo > 0) {
				try {
					sleep(100);
					tempo -= 100;
					System.out.println(id+"# Lasanha a Bolonhesa " +(((tempoTotal- tempo)*100)/tempoTotal)+"% feito");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}else {
			int tempo =(int) Math.random()*301 + 500;
			int tempoTotal = tempo;
			System.out.println("Cozinhando "+id+"# Sopa de cebola");
			while (tempo > 0) {
				try {
					sleep(100);
					tempo -= 100;
					System.out.println(id+"# Sopa de cebola " +(((tempoTotal- tempo)*100)/tempoTotal)+"% feito");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}

}
