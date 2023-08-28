package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CancelController implements ActionListener {
	
	private JFrame tela;

	public CancelController() {
		// TODO Auto-generated constructor stub
	}
	
	

	public CancelController(JFrame tela) {
		super();
		this.tela = tela;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		tela.dispose();
	}

}
