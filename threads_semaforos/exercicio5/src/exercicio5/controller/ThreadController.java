package exercicio5.controller;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {
	private int id;
	private Semaphore semaforo;

	

	public ThreadController(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		int abc = id % 3;
		switch (abc) {
		case 1:
			for (int i = 0; i < 2; i++) {
				calculos(Math.random() * 0.8 + 0.2);
				transacao(1);
			}
			break;
		case 2:
			for (int i = 0; i < 3; i++) {
				calculos(Math.random() + 0.5);
				transacao(1.5);
			}
			break;
		case 0:
			for (int i = 0; i < 3; i++) {
				calculos(Math.random() + 1.0);
				transacao(1.5);
			}
			break;
		default:
			break;
		}

	}

	private void calculos(double tempo) {
		System.out.println(id + "# thread esta calculando");
		try {
			sleep((long) tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void transacao(double tempo) {
		
		try {
			semaforo.acquire();
			System.out.println(id + "# thread esta Transacionando");
			sleep((long) tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println("Fim transação thread"+id);
			semaforo.release();
		}
	}
}
