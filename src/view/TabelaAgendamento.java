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

public class TabelaAgendamento extends JInternalFrame {
	private JTable table;

	/**
	 * Create the frame.
	 */
	public TabelaAgendamento(int largura, int altura) {
		setBounds(0, 0, largura, altura);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 20, 554, 443);
		this.getContentPane().add(scrollPane);

		table = new JTable();
		int larguraDaTela = 200;
		//TODO testar o tamanho
		//table.setBounds(20, 20, larguraDaTela / 2, 225);
		table.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setToolTipText("Biom\u00E9dica\nConsultora\nEsteticista\n");
		table.setModel(
				new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
								"Cliente", "Nome Procedimento", "Data", "Horario", "Sala"
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
						"Cliente", "Nome Procedimento", "Data", "Horario", "Sala"
				}
				);
		table.setModel(model);
		Object novaLinha [] = new Object[5];

		DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat hora = new SimpleDateFormat("HH:mm");
		
		for (Agendamento agendamento : agendamentos) {
			novaLinha[0]= agendamento.getCliente().getNome();
			novaLinha[1]= agendamento.getProcedimento().getNome();
			novaLinha[2]= data.format(agendamento.getData());
			novaLinha[3]= hora.format(agendamento.getData());
			novaLinha[4]= agendamento.getProcedimento().getSala();
			
			model.addRow(novaLinha);
		}
	}
}
