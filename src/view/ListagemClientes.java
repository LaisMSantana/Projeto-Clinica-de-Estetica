package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;

public class ListagemClientes extends JInternalFrame {
	private JTextField textField;
	private JTextField txtCPFCNPJ;
	private JTable table;
	/**
	 * Launch the application.
	 */
	


	public ListagemClientes() {
		setClosable(true);
		setTitle("Listagem de Clientes");
		setBounds(100, 100, 554, 430);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(3, 12, 56, 16);
		getContentPane().add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(60, 10, 362, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCPFCNPJ = new JLabel("CPF/CNPJ :");
		lblCPFCNPJ.setBounds(3, 48, 84, 16);
		getContentPane().add(lblCPFCNPJ);
		
		txtCPFCNPJ = new JTextField();
		txtCPFCNPJ.setBounds(80, 46, 342, 22);
		getContentPane().add(txtCPFCNPJ);
		txtCPFCNPJ.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(171, 80, 97, 25);
		getContentPane().add(btnPesquisar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new String[][] { { "#", "Cliente", "CPF", "Telefone", "Email" }, },
				new String[] { "#", "Cliente", "CPF", "Telefone",  "Email" }));

		table.setBounds(3, 140, 529, 244);
		getContentPane().add(table);

	}
	
}