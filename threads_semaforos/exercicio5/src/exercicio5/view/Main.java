package exercicio5.view;

import java.util.concurrent.Semaphore;

import exercicio5.controller.ThreadController;

public class Main {

	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);
		for(int i = 1; i < 22; i++) {
				new ThreadController(i,sem).start();
			}

	}

}
