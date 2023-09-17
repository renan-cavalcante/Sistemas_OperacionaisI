package exercicio2.view;

import java.util.concurrent.Semaphore;

import exercicio2.controller.CorredorController;

public class Main {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);
		for(int i = 1; i <= 4; i++) {
			CorredorController corredorController = new CorredorController(i, semaphore);
			corredorController.start();
		}
	}

}
