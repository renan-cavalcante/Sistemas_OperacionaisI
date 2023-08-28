package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KillController implements ActionListener {

	private JTextField tfNome;
	private JFormattedTextField tfPID;
	private JTextArea textArea;

	public KillController() {
		// TODO Auto-generated constructor stub
	}

	public KillController(JTextField tfNome, JFormattedTextField tfPID, JTextArea textArea) {
		super();
		this.tfNome = tfNome;
		this.tfPID = tfPID;
		this.textArea = textArea;
	}

	public String listarProcesso() {
		List<String> lista = new ArrayList<>();
		StringBuilder builder = new StringBuilder();

		if (os().toLowerCase().contains("windows")) {
			lista = readProcess("TASKLIST /FO TABLE");

			int tamanho = lista.size();

			for (int i = 0; i < tamanho; i++) {
//				if (i > 2) {
//					String[] sub = lista.get(i).split("\\s+");
//					builder.append(String.format("%-35s", sub[0]));
//					builder.append(String.format("%s", sub[1].trim()));
//					builder.append(String.format("%s", sub[1].trim()));
//					builder.append(String.format("%s", sub[1].trim()));
//					builder.append(String.format("%s", sub[1].trim()));

//					System.out.printf("%-35s", sub[0]);
//					System.out.printf("%s\n", sub[1].trim());
//				} else {
				builder.append(lista.get(i));
//				}

				builder.append("\n");

			}

		} else if (os().toLowerCase().contains("linux")) {
			lista = readProcess("ps -ef");

			for (String s : lista) {
				builder.append(s + "\n");

			}
		}
		System.out.println(builder.toString());
		return builder.toString();
	}

	public void matarPid(int pid) {
		if (os().toLowerCase().contains("windows")) {
			callProcess("TASKKILL /PID " + pid);
		} else if (os().toLowerCase().contains("linux")) {
			callProcess("kill -9 " + pid);
		}

	}

	public void matarNome(String name) {
		if (os().toLowerCase().contains("windows")) {
			callProcess("TASKKILL /IM " + name);
		} else if (os().toLowerCase().contains("linux")) {
			callProcess("pkill -f " + name);
		}

	}

	private String os() {
		return System.getProperty("os.name");
	}

	private Process callProcess(String process) {
		try {
			return Runtime.getRuntime().exec(process);
		} catch (Exception e) {
			return null;
		}

	}

	private List<String> readProcess(String process) {

		List<String> lista = new ArrayList<>();

		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(callProcess(process).getInputStream()))) {

			String linha;
			linha = buffer.readLine();

			while (linha != null) {
				lista.add(linha);
				linha = buffer.readLine();
			}
			buffer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String butt = e.getActionCommand();

		switch (butt) {
		case "Matar":
			escolherMatar();
			break;
		case "Listar":

			textArea.setText(listarProcesso());
			break;
		default:
			break;
		}

	}

	private void escolherMatar() {
		String nome = tfNome.getText();
		String pid = tfPID.getText();

		if (nome != null || nome != "") {

			matarNome(nome);

			tfNome.setText("");
			JOptionPane.showMessageDialog(null, "Sucees", "Processo assassinado", JOptionPane.INFORMATION_MESSAGE);
		}
		if (pid != null || pid != "") {

			matarPid(Integer.parseInt(pid));
			tfPID.setText("0");
			JOptionPane.showMessageDialog(null, "Sucees", "Processo assassinado", JOptionPane.INFORMATION_MESSAGE);

		}

		
	}

}
