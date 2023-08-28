package application;

import controller.ControllerPrint;

public class Program {

	public static void main(String[] args) {
		ControllerPrint controller = new ControllerPrint();
		int n = 100;
		System.out.printf("Tamanho = %s \n",n);
		System.out.printf("%-35s","For Each");
		controller.tempoVetor(controller.criarVetor(n));
		System.out.printf("%-35s","For normal com Length");
		controller.tempoVetorFor(controller.criarVetor(n));
		System.out.printf("%-35s","For normal com variável fixa");
		controller.tempoVetorFor2(controller.criarVetor(n));
		
		System.out.println();
		n = 1000;
		System.out.printf("Tamanho = %s \n",n);
		System.out.printf("%-35s","For Each");
		controller.tempoVetor(controller.criarVetor(n));
		System.out.printf("%-35s","For normal com Length");
		controller.tempoVetorFor(controller.criarVetor(n));
		System.out.printf("%-35s","For normal com variável fixa");
		controller.tempoVetorFor2(controller.criarVetor(n));
		
		System.out.println();
		n = 10000;
		System.out.printf("Tamanho = %s \n",n);
		System.out.printf("%-35s","For Each");
		controller.tempoVetor(controller.criarVetor(n));
		System.out.printf("%-35s","For normal com Length");
		controller.tempoVetorFor(controller.criarVetor(n));
		System.out.printf("%-35s","For normal com variável fixa");
		controller.tempoVetorFor2(controller.criarVetor(n));
	}

}
