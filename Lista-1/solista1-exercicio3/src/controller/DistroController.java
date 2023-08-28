package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DistroController {

	public DistroController() {
	}

	
	public void exibirDistro() {
		if(os().toLowerCase().contains("linux")) {
			
			StringBuilder builder = new StringBuilder();
			for(String s : readProcess("cat /etc/os-release")) {
				if(s.toLowerCase().contains("name") || s.toLowerCase().contains("version=")) {
					if(!s.contains("_")) {
						builder.append(s + "\n");
					}
					
				}
				
			}
			JOptionPane.showMessageDialog(null, builder.toString(), "distro ", JOptionPane.INFORMATION_MESSAGE);
			
		}else {
			JOptionPane.showMessageDialog(null, "O sistema não é uma distribuição linux", "Erro ", JOptionPane.ERROR_MESSAGE);
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
}
