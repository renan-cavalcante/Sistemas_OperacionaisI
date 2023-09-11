package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exericio4.controller.CorridaController;

public class Program {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int personalizar = 0;

		while (personalizar < 1 || personalizar > 2) {
			System.out.println("Digite 1 - para personalizar a corrida ou 2 - para corrida padrao");
			personalizar = ler.nextInt();
		}

		if (personalizar == 1) {
			int quantidadeCorredores = -1;
			int opcaoNome = 0;
			List<String> nomes = new ArrayList<>();

			while (quantidadeCorredores < 2 || quantidadeCorredores > 10) {
				System.out.println("Quantidade de corredores");
				System.out.println("Minimo 2 \n Maximo 10");
				System.out.println("Digite a quantidade:");
				quantidadeCorredores = ler.nextInt();
			}

			while (opcaoNome < 1 || opcaoNome > 2) {
				System.out.println("Corredores indentificados por nomes ou numeros");
				System.out.println("1 - para nome ou 2 - para numero");
				opcaoNome = ler.nextInt();
			}

			if (opcaoNome == 1) {
				ler.nextLine();
				System.out.println("Digite os nomes dos corredores");
				for (int i = 1; i <= quantidadeCorredores; i++) {
					System.out.print(i + "# ");
					nomes.add(ler.nextLine());
				}
			}

			CorridaController corridaController;

			if (opcaoNome == 1) {
				corridaController = new CorridaController(quantidadeCorredores, opcaoNome, nomes, true);
			} else {
				corridaController = new CorridaController(quantidadeCorredores, opcaoNome, true);
			}

			corridaController.start();
		}else {
			CorridaController corridaController = new CorridaController(true);
			corridaController.start();
		}

//		corridaController.exibirRankFinal();
	}

}
