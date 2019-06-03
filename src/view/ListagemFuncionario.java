package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;

public class ListagemFuncionario extends JInternalFrame {
	private JTextField textField;
	private JTextField txtCargo;
	private JTable table;

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
	public ListagemFuncionario() {
		setClosed(true);
		setTitle("Listagem de Funcionários");
		setBounds(100, 100, 564, 362);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(16, 13, 40, 16);
		getContentPane().add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(60, 10, 362, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo :");
		lblCargo.setBounds(16, 48, 40, 16);
		getContentPane().add(lblCargo);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(60, 45, 362, 22);
		getContentPane().add(txtCargo);
		txtCargo.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(171, 80, 97, 25);
		getContentPane().add(btnPesquisar);
		
		//Lista de funcionários na Tabela
		table = new JTable();
		table.setModel(new DefaultTableModel(new String[][] { { "#", "Nome do Funcionario", "Cargo", "Telefone", "Email" }, },
				new String[] { "#", "Nome do Funcionario", "Cargo", "Telefone",  "Email" }));

		table.setBounds(0, 117, 554, 201);
		getContentPane().add(table);


	}
}
