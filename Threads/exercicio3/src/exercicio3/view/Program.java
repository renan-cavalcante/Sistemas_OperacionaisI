package exercicio3.view;

import exercicio3.controller.ThreadVetor;

public class Program {
	public static void main(String[] args) {

		int[] vetor = new int[1000];
		
		for(int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * 100) + 1;
		}
		
		ThreadVetor threadVetor1 = new ThreadVetor(vetor, 1);
		ThreadVetor threadVetor2 = new ThreadVetor(vetor, 2);
		
		threadVetor1.start();
		threadVetor2.start();

	}

}
