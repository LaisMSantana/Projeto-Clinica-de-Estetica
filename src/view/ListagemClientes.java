package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ClienteControl;
import model.bo.ClienteBO;
import model.vo.Cliente;

public class ListagemClientes extends JInternalFrame {
	private JTextField txtNome;
	JFormattedTextField formatteCpf;
	private JTable table;
	ClienteBO clienteBO = new ClienteBO();
	ClienteControl clienteControl =new ClienteControl();
	
	/**
	 * Launch the application.
	 */

	public ListagemClientes() {
		setClosable(true);
		setTitle("Listagem de Clientes");
		setBounds(100, 100, 554, 430);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(20, 12, 56, 16);
		getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(73, 10, 347, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCPFCNPJ = new JLabel("CPF:");
		lblCPFCNPJ.setBounds(30, 40, 31, 16);
		getContentPane().add(lblCPFCNPJ);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Cliente> clientes = clienteBO.listarTodos(txtNome.getText(),formatteCpf.getText());
				atualizarTabela(clientes);
			}
		});
		btnPesquisar.setBounds(60, 83, 97, 25);
		getContentPane().add(btnPesquisar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"#", "Cliente", "CPF", "Telefone", "Email"},
			},
			new String[] {
				"#", "Cliente", "CPF", "Telefone", "Email"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		
		table.setBounds(3, 140, 529, 244);
		getContentPane().add(table);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(83, 83, -13, 19);
		getContentPane().add(formattedTextField);
		
		formatteCpf = new JFormattedTextField();
		try{
	           javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
	           formatteCpf = new javax.swing.JFormattedTextField(format_textField4);
	        }catch (Exception e){
	        	
	        }
		formatteCpf.setBounds(73, 40, 94, 20);
		getContentPane().add(formatteCpf);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				int linhaSelecionada = table.getSelectedRow();
				Integer id = (Integer) table.getModel().getValueAt(linhaSelecionada, 0);
				clienteControl.excluir(id);
				ArrayList<Cliente> clientes = clienteBO.listarTodos(txtNome.getText(),formatteCpf.getText());
				atualizarTabela(clientes);
				
			}
		});
		btnExcluir.setBounds(362, 83, 117, 25);
		getContentPane().add(btnExcluir);
		
		JButton btnEditar = new JButton("Atualizar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = table.getSelectedRow();
				Integer id  = (Integer) table.getModel().getValueAt(linhaSelecionada, 0);
				String nome = (String)table.getModel().getValueAt(linhaSelecionada, 1);
				String cpf = (String)table.getModel().getValueAt(linhaSelecionada, 2);
				String telefone = (String)table.getModel().getValueAt(linhaSelecionada, 3);
				String email = (String)table.getModel().getValueAt(linhaSelecionada, 4);
				
				Cliente cliente = new Cliente();
				cliente.setIdCliente(id);
				cliente.setNome(nome);
				cliente.setCpf(cpf);
				cliente.setTelefone(telefone);
				cliente.setEmail(email);
				
				String retorno = ClienteControl.salvar(cliente);
				JOptionPane.showMessageDialog(null, retorno);
				ArrayList<Cliente> clientes = clienteBO.listarTodos(txtNome.getText(),formatteCpf.getText());
				atualizarTabela(clientes);
			}
		});
		btnEditar.setBounds(190, 83, 117, 25);
		getContentPane().add(btnEditar);
		
		JButton btnAtualizarInformacao = new JButton("...");
		btnAtualizarInformacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String atualizar = "Clique duas vezes em cima do campo desejado, atualize a informação e clique em atualizar";
				JOptionPane.showMessageDialog(null, atualizar);
			}
		});
		btnAtualizarInformacao.setBounds(312, 84, 23, 23);
		getContentPane().add(btnAtualizarInformacao);
		
		JButton btnExcluirInformacao = new JButton("...");
		btnExcluirInformacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String excluir = "Clique em cima do cliente desejado na tabela e clique em excluir";
				JOptionPane.showMessageDialog(null, excluir);
			}
		});
		btnExcluirInformacao.setBounds(484, 84, 23, 23);
		getContentPane().add(btnExcluirInformacao);
		
		ArrayList<Cliente> clientes = clienteBO.listarTodos(txtNome.getText(),formatteCpf.getText());
		atualizarTabela(clientes);
		

	}
	private void atualizarTabela(ArrayList<Cliente> clientes) {
		DefaultTableModel model = new DefaultTableModel(new String[][] { { "#", "Cliente", "CPF", "Telefone", "Email" }, },
				new String[] { "#", "Cliente", "CPF", "Telefone",  "Email" });
		table.setModel(model);
		Object novaLinha [] = new Object[5];

		DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat hora = new SimpleDateFormat("HH:mm");
		
		for (Cliente cliente : clientes) {
			novaLinha[0]= cliente.getIdCliente();
			novaLinha[1]= cliente.getNome();
			novaLinha[2]= cliente.getCpf();
			novaLinha[3]= cliente.getTelefone();
			novaLinha[4]= cliente.getEmail();
			
			model.addRow(novaLinha);
		}		
	}
}