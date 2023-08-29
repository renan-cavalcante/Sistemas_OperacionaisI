package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class RedesController {

	public RedesController() {
		// TODO Auto-generated constructor stub
	}

	public void ip() {
		 String ip = "";
		
		if(os().toLowerCase().contains("windows")) {
			
			List<String> ips = readProcess("IPCONFIG");
			
			StringBuilder builder = new StringBuilder();
			String adaptador = "";
			for(String linha : ips) {
				if(linha.toLowerCase().contains("adaptador")) {
					adaptador = linha;
				}
				if(linha.toLowerCase().contains("ipv4")){
					builder.append(adaptador);
					builder.append(linha.split(":")[1]);
					builder.append("\n");
					
				}
			}
			
			ip = builder.toString();
			
		}else if(os().toLowerCase().contains("linux")) {
			
			List<String> ips = readProcess("ifconfig");
			
			StringBuilder builder = new StringBuilder();
			String adaptador = "";
			for(String linha : ips) {
				if(linha.toLowerCase().contains(" flags")) {
					adaptador = linha.split(" ")[0];
				}
				if(linha.toLowerCase().contains("netmask")){
					builder.append(adaptador + " ");
					builder.append(linha.split("inet ")[1].split(" ")[0]);
					builder.append("\n");
					
				}
			}
			ip = builder.toString();
			
		}else {
			System.out.println("O sistema não foi reconhecido");
		}
		
		
		JOptionPane.showMessageDialog(null,ip,
				  "IP" ,JOptionPane.INFORMATION_MESSAGE);
		
		
	}
	
	public void ping() {
		List<String> pings = new ArrayList<>();
		String media = "";
		
		if(os().toLowerCase().contains("windows")) {
			
			pings = readProcess("ping -4 -n 10 www.google.com.br ");
			
			for(String linha : pings) {
				if(linha.toLowerCase().contains("ximo")) {
					media = linha.split("= ")[3];
				}
			}
			
		}else if(os().toLowerCase().contains("linux")) {
			pings = readProcess("ping -4 -c 10 www.google.com.br ");
			
			for(String linha : pings) {
				if(linha.toLowerCase().contains("rtt")) { 
				
					media = linha.split("/")[4] + "ms";
				}
			}
			
		}
		
		  JOptionPane.showMessageDialog(null,media,
				  "PING" ,JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	
	
	private String os() {
		return System.getProperty("os.name");
	}
	
	private Process callProcess(String process) {
		try {
			return Runtime.getRuntime().exec(process);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return null;	
	}
	
	private List<String> readProcess(String process) {
		
		List<String> lista = new ArrayList<>();
		
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(callProcess(process).getInputStream()))){
						
			String linha;
			linha = buffer.readLine();
			
			
			while(linha != null) {
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
