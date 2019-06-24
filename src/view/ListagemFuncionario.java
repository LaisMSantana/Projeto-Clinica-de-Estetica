package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.FuncionarioControl;
import model.bo.FuncionarioBO;
import model.vo.Cliente;
import model.vo.Funcionario;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListagemFuncionario extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtCargo;
	private JTable table;
	FuncionarioBO funcionarioBO = new FuncionarioBO();
	FuncionarioControl funcionarioControl = new  FuncionarioControl();

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
		setClosable(true);
		setTitle("Listagem de Funcionários");
		setBounds(100, 100, 564, 362);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(15, 15, 51, 15);
		getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(70, 10, 350, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		
		JLabel lblCargo = new JLabel("Cargo :");
		lblCargo.setBounds(15, 50, 51, 15);
		getContentPane().add(lblCargo);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(70, 45, 350, 20);
		getContentPane().add(txtCargo);
		txtCargo.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Funcionario> funcionarios = funcionarioBO.listarTodos(txtNome.getText(),txtCargo.getText());
				atualizarTabela(funcionarios);
			}
			
		});
		btnPesquisar.setBounds(440, 10, 114, 25);
		getContentPane().add(btnPesquisar);
		
		//Lista de funcionários na Tabela

		table = new JTable();
		table.setModel(new DefaultTableModel(new String[][] { { "#", "Nome do Funcionario", "Cargo", "Telefone", "Email" }, },
				new String[] { "#", "Nome do Funcionario", "Cargo", "Telefone",  "Email" }));

		table.setBounds(0, 117, 554, 201);
		getContentPane().add(table);

		ArrayList<Funcionario> funcionarios = funcionarioBO.listarTodos(txtNome.getText(),txtCargo.getText());
		atualizarTabela(funcionarios);
		

	}

	private void atualizarTabela(ArrayList<Funcionario> funcionarios) {
		DefaultTableModel model = new DefaultTableModel(new String[][] { { "#", "Nome do Funcionario", "Cargo", "Telefone", "Email" }, },
				new String[] { "#", "Nome do Funcionario", "Cargo", "Telefone",  "Email" });
		table.setModel(model);
		for (Funcionario funcionario : funcionarios) {
			Object novaLinha [] = new Object[5];
			novaLinha[0]= funcionario.getIdFuncionario();
			novaLinha[1]= funcionario.getNome();
			novaLinha[2]= funcionario.getCargo();
			novaLinha[3]= funcionario.getTelefone();
			novaLinha[4]= funcionario.getEmail();
			model.addRow(novaLinha);
		}
    }
}
