package exercicio2.view;

import exercicio2.controller.MatrizControlle;

public class program {
//	private static int[][] matriz = new int[5][5];


	public static void main(String[] args) {
		MatrizControlle.carregarMatriz();
		for(int[] i: MatrizControlle.getMatriz()) {
			int som = 0;
			for(int j : i) {
				som += j;
				System.out.print(j +",");
			}
			System.out.print(" soma da linha: " + som);
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 0; i < 3; i++) {
			 
			MatrizControlle matrizControlle = new MatrizControlle(MatrizControlle.getLinhaMatriz(i));
			matrizControlle.start(); 
		}
	}
	
//	public static void carregarMatriz() {
//		int lin = matriz.length;
//		for ( int i = 0; i < lin ; i++) {
//			int col = matriz[i].length;
//			for (int j = 0; j < col; j++) {
//				int num = (int) (Math.random() * 101);
//				matriz[i][j] = num;
//			}
//		}
//	}

}
