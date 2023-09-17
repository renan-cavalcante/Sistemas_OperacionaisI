package exercicio6.vier;

import java.util.concurrent.Semaphore;

import exercicio6.controller.CozinhaController;

public class Main {

	public static void main(String[] args) {
		Semaphore cozimento = new Semaphore(5);
		Semaphore entrega = new Semaphore(1);
		
		for(int i = 1; i < 20; i++) {
			new CozinhaController(i, entrega, cozimento).start();
		}
	}

}
