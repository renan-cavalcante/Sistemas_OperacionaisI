package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.KillController;
import javax.swing.JTextField;

public class Tela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(422, 72, 2, 2);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 98, 622, 370);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListar.setBounds(132, 64, 109, 23);
		contentPane.add(btnListar);
		
		JLabel lblPID = new JLabel("PID");
		lblPID.setBounds(10, 17, 46, 14);
		contentPane.add(lblPID);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 41, 46, 14);
		contentPane.add(lblNome);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(66, 11, 81, 20);
		contentPane.add(formattedTextField);
		
		JButton btnMatar = new JButton("Matar");
		btnMatar.setBounds(10, 64, 89, 23);
		contentPane.add(btnMatar);
		
		JTextField textName = new JTextField();
		textName.setBounds(61, 38, 180, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		KillController killController =new KillController( textName, formattedTextField, textArea);
		
		btnListar.addActionListener(killController);
		btnMatar.addActionListener(killController);
	}
}
