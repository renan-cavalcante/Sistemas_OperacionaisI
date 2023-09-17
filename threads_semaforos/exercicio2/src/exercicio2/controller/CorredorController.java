package exercicio2.controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CorredorController extends Thread{
	private final int TAMANHO_CORREDOR = 200;
	private int velocidade;
	private int pessoa;
	private int percorrido = 0;
	private Semaphore semaforo;

	public CorredorController(int pessoa, Semaphore semaforo) {
		this.pessoa = pessoa;
		this.semaforo = semaforo;
				
	}
	
	@Override
	public void run() {
		
		andar();
		
		try {
			semaforo.acquire();
			porta();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
		
	}
	
	private void porta() {
		System.out.println("Pessoa "+pessoa+" abriu a porta");
		try {
			sleep((int) (Math.random()*1001 + 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Pessoa "+pessoa+ " cruzou a porta");
	}
	
	private void andar() {
		while (percorrido < TAMANHO_CORREDOR) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int andou = (int) (Math.random() * 3) + 4;
			percorrido += andou;
			System.out.println("Pessoa " + pessoa + " andou " + andou + "m e ja perccoreu "+percorrido+"m");
		}
	}
}
