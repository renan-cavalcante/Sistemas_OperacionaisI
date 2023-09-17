package exercicio1.view;

import java.util.concurrent.Semaphore;

import exercicio1.controller.SemaforoController;

public class Main {

	public static void main(String[] args) {
		 Semaphore semaphore = new Semaphore(1);
		for (int i = 0; i < 4; i++) {
			SemaforoController controller = new SemaforoController(i, semaphore);
			controller.start();
		}
		

	}

}
