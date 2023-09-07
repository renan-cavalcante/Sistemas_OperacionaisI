package exercicio2.controller;

public class MatrizControlle extends Thread{
	private int[] linha;
	private static int[][] matriz = new int[3][5];
	
	public MatrizControlle(int[] linha) {
		this.linha = linha;
	}
	
	@Override
	public void run() {
		System.out.println( somaLinha(linha));
	}

	
	public int somaLinha(int[] linha) {
		int som = 0;
		for(int i : linha) {
			som += i;
		}
		return som;
	}
	
	
	
	public static int[][] getMatriz() {
		return matriz;
	}
	
	public static int[] getLinhaMatriz(int lin) {
		return matriz[lin];
	}

	public static void carregarMatriz() {
		int lin = matriz.length;
		for ( int i = 0; i < lin ; i++) {
			int col = matriz[i].length;
			for (int j = 0; j < col; j++) {
				int num = (int) (Math.random() * 101);
				matriz[i][j] = num;
			}
		}
	}
}

