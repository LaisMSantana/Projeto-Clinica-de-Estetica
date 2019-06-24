package view;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import model.vo.Agendamento;
import java.awt.Color;
import javax.swing.border.LineBorder;

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
		table.setBackground(new Color(255, 248, 220));
		int larguraDaTela = 150;
		//TODO testar o tamanho
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
					"ID", "Cliente", "Procedimento", "Data", "Horario", "Sala"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.setBounds(10, 483, 784, 360);
		scrollPane.setViewportView(table);
		
	}
	
	public  void atualizarTabela(List<Agendamento> agendamentos) {
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID", "Cliente", " Procedimento", "Data", "Horario", "Sala"
				}
				);
		table.setModel(model);
		Object novaLinha [] = new Object[6];

		DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat hora = new SimpleDateFormat("HH:mm");
		
		for (Agendamento agendamento : agendamentos) {
			novaLinha[0]= agendamento.getIdAgendamento();
			novaLinha[1]= agendamento.getCliente().getNome();
			novaLinha[2]= agendamento.getProcedimento().getNome();
			novaLinha[3]= data.format(agendamento.getData());
			novaLinha[4]= hora.format(agendamento.getData());
			novaLinha[5]= agendamento.getProcedimento().getSala();
			
			model.addRow(novaLinha);
		}
	}
	
	public Integer getIdSelecionado() {
		int linhaSelecionada = table.getSelectedRow();
		Integer id = (Integer) table.getModel().getValueAt(linhaSelecionada, 0);
		return id;
	}
}
