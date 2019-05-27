package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Ajuda extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajuda frame = new Ajuda();
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
	public Ajuda() {
		setClosable(true);
		setTitle("Tire as suas D\u00FAvidas");
		setToolTipText("");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblDigiteAquiAs = new JLabel("Digite aqui a sua D\u00FAvida ");
		lblDigiteAquiAs.setBounds(101, 44, 202, 15);
		getContentPane().add(lblDigiteAquiAs);
		
		textField = new JTextField();
		textField.setBounds(12, 81, 416, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(124, 129, 117, 25);
		getContentPane().add(btnPesquisar);
		
		JButton button = new JButton("www.google.com");
		button.setBounds(77, 192, 226, 25);
		getContentPane().add(button);

	}

}
