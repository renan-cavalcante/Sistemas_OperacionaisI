package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CancelController;
import controller.RunController;
import controller.SearchController;

public class Tela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Digite o caminho do executável ou clique em procurar");
	private JTextField tfCaminho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setTitle("Executar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 166);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Abri:");
		lblNewLabel_1.setBounds(10, 55, 46, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel.setBounds(66, 11, 335, 14);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel);
		
		tfCaminho = new JTextField();
		tfCaminho.setBounds(66, 52, 328, 20);
		contentPane.add(tfCaminho);
		tfCaminho.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setBounds(66, 93, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(190, 93, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(305, 93, 89, 23);
		contentPane.add(btnProcurar);
		
		SearchController searchController = new SearchController(tfCaminho);
		RunController runController = new RunController(tfCaminho, this);
		CancelController cancelController = new CancelController(this);
		
		btnCancelar.addActionListener(cancelController);
		btnOk.addActionListener(runController);
		btnProcurar.addActionListener(searchController);
	}

}
