package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ListagemClientes extends JInternalFrame {
	private JTextField textField;
	private JTextField txtCPFCNPJ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListagemFuncionario frame = new ListagemFuncionario();
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
	public ListagemClientes() {
		setTitle("Listagem de Clientes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(16, 13, 34, 16);
		getContentPane().add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(60, 10, 362, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCPFCNPJ = new JLabel("CPF/CNPJ :");
		lblCPFCNPJ.setBounds(3, 48, 56, 16);
		getContentPane().add(lblCPFCNPJ);
		
		txtCPFCNPJ = new JTextField();
		txtCPFCNPJ.setBounds(60, 45, 362, 22);
		getContentPane().add(txtCPFCNPJ);
		txtCPFCNPJ.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(171, 80, 97, 25);
		getContentPane().add(btnPesquisar);

	}

}
