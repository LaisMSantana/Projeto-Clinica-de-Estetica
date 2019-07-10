package view;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import controller.AgendamentoControl;
import model.vo.Agendamento;
import model.vo.Cliente;
import model.vo.Funcionario;
import model.vo.Procedimento;

import java.awt.Color;
import java.sql.Date;

import javax.swing.border.LineBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class TabelaAgendamento extends JInternalFrame {
	
	private JTable table;

	/**
	 * Create the frame.
	 */
	
	public TabelaAgendamento(int largura, int altura) {
		setBounds(0, 0, largura, altura);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.PINK);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.PINK);
		scrollPane.setBounds(0, 20, 554, 443);
		this.getContentPane().add(scrollPane);

		table = new JTable();
		table.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				if (table.isEditing())
	                processEditingStarted(table.getEditingRow(), table.getEditingColumn());
	            else
	                processEditingStopped(table.getEditingRow(), table.getEditingColumn());				
			}
		});
		table.setBackground(new Color(255, 248, 220));
		int larguraDaTela = 150;
		
		table.setBounds(20, 20, larguraDaTela / 2, 240);
		table.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setToolTipText("");
		table.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "Cliente", "Procedimento", "Data", "Horario", "Sala" , "Status"
			}
		){
					boolean[] columnEditables = new boolean[] {
							false, false, false, false, false, false, false, true
					};
				
				});
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.setBounds(10, 483, 785, 360);
		scrollPane.setViewportView(table);
		
		
		
	}
	
	protected void processEditingStopped(int editingRow, int editingColumn) {
	    System.out.println("save " + editingRow + ":" + editingColumn);
	    if (editingRow > -1 && editingColumn > -1) {
	    	
	    	int linhaSelecionada = editingRow;
			Agendamento agendamento = new Agendamento();
			AgendamentoControl control = new AgendamentoControl();
			Cliente cliente = new Cliente();
			Procedimento procedimento = new Procedimento();
			Funcionario funcionario = new Funcionario();
			
			int id =(Integer) table.getModel().getValueAt(linhaSelecionada, 0);
			cliente.setNome((String)table.getModel().getValueAt(linhaSelecionada, 1));
			procedimento.setNome((String)table.getModel().getValueAt(linhaSelecionada, 2));
			procedimento.setSala((String)table.getModel().getValueAt(linhaSelecionada, 5));
			String status = (String)table.getModel().getValueAt(linhaSelecionada, 7);
			System.out.println(status);
			
			agendamento.setIdAgendamento(id);
			agendamento.setCliente(cliente);
			agendamento.setProcedimento(procedimento);
			agendamento.setFuncionario(funcionario);
			agendamento.setData(null);
			agendamento.setStatus(status);
			
			String retorno = control.salvar(agendamento);
			
	    }
	}

	protected void processEditingStarted(int editingRow, int editingColumn) {
	    System.out.println("edit " + editingRow + ":" + editingColumn);
	}	
	
	public  void atualizarTabela(List<Agendamento> agendamentos) {
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID", "Cliente", " Procedimento", "Data", "Horario", "Sala" , "Funcionário" , "Status"
				}
				);
		table.setModel(model);
		Object novaLinha [] = new Object[8];

		DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat hora = new SimpleDateFormat("HH:mm");
		
		for (Agendamento agendamento : agendamentos) {
			novaLinha[0] = agendamento.getIdAgendamento();
			novaLinha[1] = agendamento.getCliente().getNome();
			novaLinha[2] = agendamento.getProcedimento().getNome();
			novaLinha[3] = data.format(agendamento.getData());
			novaLinha[4] = hora.format(agendamento.getData());
			novaLinha[5] = agendamento.getProcedimento().getSala();
			novaLinha[6] = agendamento.getFuncionario().getNome();
			novaLinha[7] = agendamento.getStatus();
			
			model.addRow(novaLinha);
		}
	}
	
	public Integer getIdSelecionado() {
		int linhaSelecionada = table.getSelectedRow();
		Integer id = (Integer) table.getModel().getValueAt(linhaSelecionada, 0);
		return id;
	}
	
	public Agendamento getLinhaSelecionada()  {
		int linhaSelecionada = table.getSelectedRow();
		/*
		Agendamento agendamento = new Agendamento();
		AgendamentoControl control = new AgendamentoControl();
		Cliente cliente = new Cliente();
		Procedimento procedimento = new Procedimento();
		Funcionario funcionario = new Funcionario();
		
		
		int id =(Integer) table.getModel().getValueAt(linhaSelecionada, 0);
		cliente.setNome((String)table.getModel().getValueAt(linhaSelecionada, 1));
		procedimento.setNome((String)table.getModel().getValueAt(linhaSelecionada, 2));
		procedimento.setSala((String)table.getModel().getValueAt(linhaSelecionada, 5));
		String status = (String)table.getModel().getValueAt(linhaSelecionada, 7);
		System.out.println(status);
		
		agendamento.setIdAgendamento(id);
		agendamento.setCliente(cliente);
		agendamento.setProcedimento(procedimento);
		agendamento.setFuncionario(funcionario);
		agendamento.setData(null);
		agendamento.setStatus(status);
		
		String retorno = control.salvar(agendamento);
		JOptionPane.showMessageDialog(null, retorno);
		*/
		return null;
		
	}

}
