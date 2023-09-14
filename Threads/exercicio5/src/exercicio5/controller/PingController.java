package exercicio5.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PingController extends Thread {

	public PingController() {
	}
	
	@Override
	public void run() {
		if((System.getProperty("os.name").toLowerCase().contains("linux"))) {
			ping("google");
			ping("uol");
			ping("terra");
		}else {
			System.out.println("Esse sistema não é Linux");
		}
		
	}

	
	private void ping(String servidor) {
		
		
		
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(callProcess("ping -4 -c 10 www."+servidor+".com.br ").getInputStream()))){
						
			String linha;
			linha = buffer.readLine();
			
			
			while(linha != null) {
				System.out.println(servidor+"");
				if(linha.toLowerCase().contains("rtt")) { 
					
					System.out.println( linha.split("/")[4] + "ms");
				}else if(linha.toLowerCase().contains("reply"))  {
					System.out.println((linha.split(" ")[4]).split("=")[1]);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private Process callProcess(String process) {
		try {
			return Runtime.getRuntime().exec(process);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return null;	
	}

}
