package exercicio3.controller;

public class ThreadVetor extends Thread {
	private int[] vetor;
	private int opcao;
	
	public ThreadVetor(int[] vetor, int opcao) {
		super();
		this.vetor = vetor;
		this.opcao = opcao;
	}
	
	@Override
	public void run() {
		percorrerVetor();
	}
	
	private void percorrerVetor() {
		double tempoIn;
		double tempoFim;
		if( opcao % 2 == 0) {
			int tamanho =  vetor.length;
			tempoIn = System.nanoTime();
			for (int i = 0; i < tamanho; i++) {
				
			} 
			tempoFim = System.nanoTime();
		}else {
			tempoIn = System.nanoTime();
			for( @SuppressWarnings("unused") int i : vetor) {
				
			}
			tempoFim = System.nanoTime();
		}
		System.out.printf("threadController%s %.8f \n",opcao,(tempoFim-tempoIn)/Math.pow(10, 9));
	}
	
}
