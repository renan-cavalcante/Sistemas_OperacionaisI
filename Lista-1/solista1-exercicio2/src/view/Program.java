package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Program {

	public static void main(String[] args) {
		KillController controller = new KillController();

		Object[] itens = { "Listar processos", "Matar por PID", "Matar por nome" };
		Object selecionar;

		do {
			selecionar = JOptionPane.showInputDialog(null, "Escolha um item", "Opçao", JOptionPane.INFORMATION_MESSAGE,
					null, itens, itens[0]);
			if (selecionar != null) {
				if (selecionar.equals("Listar processos"))
					controller.listarProcesso();

				else if (selecionar.equals("Matar por PID")) {
					 int pid = Integer.parseInt( JOptionPane.showInputDialog("Digite o PID do processo"));
					controller.matarPid(pid);
				}
				else if (selecionar.equals("Matar por nome")) {
					 String pid = JOptionPane.showInputDialog("Digite o nome do processo");
					controller.matarNome(pid);
				}
			}

		} while (selecionar != null);
	}

}
