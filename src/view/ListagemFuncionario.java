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
		lblNome.setBounds(15, 15, 40, 15);
		getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(60, 10, 360, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		
		JLabel lblCargo = new JLabel("Cargo :");
		lblCargo.setBounds(15, 50, 40, 15);
		getContentPane().add(lblCargo);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(60, 45, 360, 20);
		getContentPane().add(txtCargo);
		txtCargo.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setBounds(440, 10, 95, 25);
		getContentPane().add(btnPesquisar);
		
		//Lista de funcionários na Tabela

		table = new JTable();
		table.setModel(new DefaultTableModel(new String[][] { { "#", "Nome do Funcionario", "Cargo", "Telefone", "Email" }, },
				new String[] { "#", "Nome do Funcionario", "Cargo", "Telefone",  "Email" }));

		table.setBounds(0, 117, 554, 201);
		getContentPane().add(table);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/// fazer o excluir funcionar 
				int linhaSelecionada = table.getSelectedRow();
				Integer id = (Integer) table.getModel().getValueAt(linhaSelecionada, 0);
				funcionarioControl.excluir(id);
				ArrayList<Funcionario> funcionarios = funcionarioBO.listarTodos(txtNome.getText(),txtCargo.getText());
				atualizarTabela(funcionarios);
				
			}
		});
		btnExcluir.setBounds(440, 45, 95, 25);
		getContentPane().add(btnExcluir);

		ArrayList<Funcionario> funcionarios = funcionarioBO.listarTodos(txtNome.getText(),txtCargo.getText());
		atualizarTabela(funcionarios);
		

	}

	private void atualizarTabela(ArrayList<Funcionario> funcionarios) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		Object novaLinha [] = new Object[5];

		DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat hora = new SimpleDateFormat("HH:mm");
		
		for (Funcionario funcionario : funcionarios) {
			novaLinha[0]= funcionario.getIdFuncionario();
			novaLinha[1]= funcionario.getNome();
			novaLinha[2]= funcionario.getCargo();
			novaLinha[3]= funcionario.getTelefone();
			novaLinha[4]= funcionario.getEmail();
			
			model.addRow(novaLinha);
		}
    }
}
