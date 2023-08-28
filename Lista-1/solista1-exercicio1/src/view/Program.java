package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Program {

	public static void main(String[] args) {
		RedesController controller = new RedesController();

		Object[] itens = { "Ip", "Ping" };
		Object selecionar;

		do {
			selecionar = JOptionPane.showInputDialog(null, "Escolha um item", "Opçao", JOptionPane.INFORMATION_MESSAGE,
					null, itens, itens[0]);
			if (selecionar != null) {
				if (selecionar.equals("Ip"))
					controller.ip();

				else if (selecionar.equals("Ping"))
					controller.ping();
			}

		} while (selecionar != null);
	}

}
