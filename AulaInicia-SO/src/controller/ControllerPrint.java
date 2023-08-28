package controller;

public class ControllerPrint {

	public ControllerPrint() {
		// TODO Auto-generated constructor stub
	}
	
	public int[] criarVetor(int tamanho) {
		int[] vetor = new int[tamanho];
		for(int i = 0; i < tamanho; i++) {
			vetor[i] = 1;
		}
		return vetor;
	}
	
	public void tempoVetor(int[] vetor) {
		double tempoInicial = System.nanoTime();
		for(int i : vetor) {
		}
		double tempoFinal = System.nanoTime();
		double var = (tempoFinal - tempoInicial)/Math.pow(10,9) ;
		System.out.printf("%.9f S. \n",var);
		 
	}
	
	public void tempoVetorFor(int[] vetor) {
		double tempoInicial = System.nanoTime();
		for(int i = 0; i < vetor.length; i++) {
		}
		double tempoFinal = System.nanoTime();
		double var = (tempoFinal - tempoInicial)/Math.pow(10,9) ;
		System.out.printf("%.9f S. \n",var);
		 
	}
	
	public void tempoVetorFor2(int[] vetor) {
		double tempoInicial = System.nanoTime();
		int tamanho = vetor.length;
		for(int i = 0; i < tamanho; i++) {
		}
		double tempoFinal = System.nanoTime();
		double var = (tempoFinal - tempoInicial)/Math.pow(10,9) ;
		System.out.printf("%.9f S. \n",var);
		 
	}

}
