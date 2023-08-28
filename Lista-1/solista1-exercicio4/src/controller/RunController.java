package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		try {
			Runtime.getRuntime().exec(tfCaminho.getText());
			tela.dispose();
		} catch (Exception erro) {
			System.err.println(erro.getMessage());
		}
	}

}
