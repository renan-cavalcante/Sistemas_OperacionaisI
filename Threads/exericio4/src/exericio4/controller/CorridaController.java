package exericio4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import exericio4.entites.Sapos;
import view.Corrida;

public class CorridaController extends Thread {
	private final int tamanhoPistal = 30;
	private int quantidadeDeSapos;
	private String[] nomes = { "Rubinho", "Lewis Hamilton", "Verstappen", "Carlos Sainz", "Airton Senna" };
	private int nomeOuId;
	private List<String> nomesList = new ArrayList<>();
	private boolean padrao = false;
	private List<JLabel> labels = new ArrayList<>();
	private boolean grafic = false;

	public Corrida corrida;

	public CorridaController() {

	}

	public CorridaController(boolean padrao) {
		this.padrao = true;
	}

	public CorridaController(int quantidadeDeSapos, int opc, List<String> nomes, boolean ativado) {
		this.quantidadeDeSapos = quantidadeDeSapos;
		nomeOuId = opc;
		this.nomesList = nomes;
	}

	public CorridaController(int quantidadeDeSapos, int opc, boolean ativado) {
		this.quantidadeDeSapos = quantidadeDeSapos;
		nomeOuId = opc;
	}

	/* construtor para saida grafica */
	public CorridaController(int quantidadeDeSapos, int opc, Corrida corrida, boolean ativado, boolean grafic) {
		this.quantidadeDeSapos = quantidadeDeSapos;
		this.corrida = corrida;
		nomeOuId = opc;
		this.grafic = grafic;
	}

	/*
	 * exibição do rank para qualquer quantidade de corredores, mas tamanho da pista
	 * chumbado
	 */
	public void exibirRankFinal() {
		Sapos sapoController = new Sapos();
		int cont = 1;
		System.out.println();
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("======================================");
		for (Sapos s : sapoController.getRank()) {
			switch (nomeOuId) {
			case 1:
				System.out.println(cont + "# " + s.getNome());
				break;
			case 2:
				System.out.println(cont + "# " + s.getIdSapo());
				break;
			}

			cont++;
		}
	}


	@Override
	public void run() {

		if (grafic) {
			corridaGrafica();
		} else {
			if(padrao) {
				corridaPadrao();
			}
			for (int i = 0; i < quantidadeDeSapos; i++) {
				System.out.println(i);
				corrida(i);
			}
		}

	}

	public void corridaPadrao() {
		Sapos sapo;
		for (int i = 0; i < 5; i++) {
			sapo = new Sapos(nomes[i], tamanhoPistal);
			sapo.start();
		}
	}

	public void corridaGrafica() {
		Sapos sapo;

		for (int i = 0; i < 5; i++) {
			labels.add(new JLabel(nomes[i] + ""));
			int eixoX = 180 + 15 * i;
			labels.get(i).setBounds(0, eixoX, 46, 14);
			corrida.add(labels.get(i));
			sapo = new Sapos(nomes[i], tamanhoPistal, labels.get(i), eixoX, this);
			sapo.start();
		}
	}
	


	public void corrida(int corredor) {
		Sapos sapo = new Sapos();
	
		if (corrida.equals(null)) {
			if (nomeOuId == 1) {
				sapo = new Sapos(nomesList.get(corredor), tamanhoPistal);
			}
			sapo = new Sapos(corredor, tamanhoPistal);
		} else {
			if (nomeOuId == 1) {
				labels.add(new JLabel(corredor + ""));
				int eixoX = 180 + 15 * corredor;
				labels.get(corredor).setBounds(0, eixoX, 46, 14);
				corrida.add(labels.get(corredor));
				
				sapo = new Sapos(nomesList.get(corredor), tamanhoPistal, labels.get(corredor), eixoX, this);
			} else {
				labels.add(new JLabel(corredor + ""));
				int eixoX = 180 + 15 * corredor;
				labels.get(corredor).setBounds(0, eixoX, 46, 14);
				corrida.add(labels.get(corredor));
				sapo = new Sapos(corredor, tamanhoPistal, labels.get(corredor), eixoX);
			}
		}
		sapo.start();

	}

}
