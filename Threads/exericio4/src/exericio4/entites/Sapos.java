package exericio4.entites;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import exericio4.controller.CorridaController;

public class Sapos extends Thread {
//	static Comparator<Sapos> compara = (a, b) -> a.getPercorrido().compareTo(b.getPercorrido());
//	public static Map<Sapos, Integer> possicoes = new TreeMap<>(compara);
//	private static int prints = 0;

	private Integer id;
	private String nome;
	private int tamanhoPista;
	private int percorrido;
	private static List<Sapos> rank = new ArrayList<>();
	private JLabel panel;
	private int eixoX;
	private static List<JLabel> podio = new ArrayList<>();
	private CorridaController corridaC;


	public Sapos() {
	}

	public Sapos(int id, int tamanhoPista) {
		this.id = id;
		this.tamanhoPista = tamanhoPista;
		percorrido = 0;
	}

	public Sapos(String nome, int tamanhoPista) {
		this.nome = nome;
		this.tamanhoPista = tamanhoPista;
		percorrido = 0;
	}

	public Sapos(String nome, int tamanhoPista, JLabel panel, int eixoX, CorridaController corrida) {
		super();
		this.nome = nome;
		this.tamanhoPista = tamanhoPista;
		this.panel = panel;
		this.eixoX = eixoX;
		percorrido = 0;
		this.corridaC = corrida;
	}

	public Sapos(int nome, int tamanhoPista, JLabel panel, int eixoX) {
		super();
		this.id = nome;
		this.tamanhoPista = tamanhoPista;
		this.panel = panel;
		this.eixoX = eixoX;
		percorrido = 0;
	}

	@Override
	public void run() {
		int i = 0;
		while (percorrido < tamanhoPista) {

			percorrido += salto();
			percorrido = percorrido > 30 ? 30 : percorrido;
			exibirSalto();

			if (panel != null) {
				panel.setBounds(percorrido * 10, eixoX, 46, 14);
			}
		}
		rank.add(this);

		podio.add(new JLabel(i + ""));
		int eixoX = 20 + 10 * i;
		podio.get(i).setBounds(0, eixoX, 46, 14);
		corridaC.corrida.add(podio.get(i));

		i++;

		/*
		 * exibição do rank para qualquer tamanho de pista, mas com quantidade de
		 * corredorres chumbado
		 */
		if (rank.size() >= 5) {
			System.out.println();
			System.out.println("======================================");
			int cont = 1;
			for (Sapos s : rank) {
				if (this.getIdSapo() == null) {
					System.out.println(cont + "# " + s.getNome());

				} else {
					System.out.println(cont + "# " + s.getIdSapo());
				}
				cont++;
			}
		}

	}

	public void exibirSalto() {

		if (this.getIdSapo() == null) {
			System.out.println(this.getNome() + "# percorrido: " + this.getPercorrido());
		} else {
			System.out.println(this.getIdSapo() + "# percorrido: " + this.getPercorrido());
		}
	}

	public int salto() {
		try {

			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (this.getIdSapo() == null) {
			System.out.println(this.getNome() + "# percorrido: " + this.getPercorrido());
		} else {
			System.out.println(this.getIdSapo() + "# percorrido: " + this.getPercorrido());
		}
		if (this.getNome() == "Rubinho") {

			return 1;

		}
		return (int) (Math.random() * 3 + 1);
	}

	public Integer getIdSapo() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getPercorrido() {
		return percorrido;
	}

	public List<Sapos> getRank() {
		return rank;
	}

//	public static Map<Sapos, Integer> getRank() {
//		return possicoes;
//	}

//	private void mostrarPossicao() {
//	for(Sapos s : possicoes.keySet()) {
//		System.out.println(s.getIdSapo() + " Percorrido:" +s.getPercorrido());
//	}
//	System.out.println();
//}

}
