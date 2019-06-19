package view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.bo.ClienteBO;
import model.vo.Agendamento;
import model.vo.Cliente;

public class ListagemClientes extends JInternalFrame {
	private JTextField textField;
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
		lblNome.setBounds(20, 12, 56, 16);
		getContentPane().add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(60, 10, 360, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCPFCNPJ = new JLabel("CPF:");
		lblCPFCNPJ.setBounds(30, 40, 56, 16);
		getContentPane().add(lblCPFCNPJ);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(171, 80, 97, 25);
		getContentPane().add(btnPesquisar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new String[][] { { "#", "Cliente", "CPF", "Telefone", "Email" }, },
				new String[] { "#", "Cliente", "CPF", "Telefone",  "Email" }));
		
		ClienteBO clienteBO = new ClienteBO();
		ArrayList<Cliente> clientes = new ArrayList();
		
		clientes = (ArrayList<Cliente>) clienteBO.listarTodos();
		atualizarTabela(clientes);
		
		
		
		
		table.setBounds(3, 140, 529, 244);
		getContentPane().add(table);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(83, 83, -13, 19);
		getContentPane().add(formattedTextField);
		
		JFormattedTextField formatteCpf = new JFormattedTextField();
		try{
	           javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
	           formatteCpf = new javax.swing.JFormattedTextField(format_textField4);
	        }catch (Exception e){
	        	
	        }
		formatteCpf.setBounds(60, 40, 80, 20);
		getContentPane().add(formatteCpf);

	}
	private void atualizarTabela(ArrayList<Cliente> clientes) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
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