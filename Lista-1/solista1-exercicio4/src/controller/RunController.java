package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class RunController implements ActionListener {

	private JTextField tfCaminho;
	private JFrame tela;

	public RunController() {
		// TODO Auto-generated constructor stub
	}	

	public RunController(JTextField tfCaminho, JFrame tela) {
		super();
		this.tfCaminho = tfCaminho;
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StringBuilder builder = new StringBuilder();
		try {
			if(tfCaminho.getText().contains(".jar")) {
				builder.append("java -jar ");
				
			}
			builder.append(tfCaminho.getText());
			Runtime.getRuntime().exec(builder.toString());
			tela.dispose();
		} catch (Exception erro) {
			if(erro.getMessage().contains("740")) {
				StringBuilder builderErro = new StringBuilder();
				builderErro.append("cmd /c ");
				builderErro.append(builder);
				try {
					Runtime.getRuntime().exec(builderErro.toString());
					tela.dispose();
				} catch (IOException e1) {
					System.err.println(e1.getMessage());
				}
			}
			
		}
	}

}
