package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DateTimePicker;

import com.github.lgooddatepicker.components.DateTimePicker;

public class Agendamento extends JInternalFrame {
	private JTextField txtCPFCNPJ;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agendamento frame = new Agendamento();
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
	public Agendamento() {
		setTitle("Agendamento");
		setClosable(true);
		setBounds(100, 100, 583, 439);
		getContentPane().setLayout(null);
		
		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			//	 Atributos próprios do componente datePicker (date e time)
				DateTimePicker dataTeste = null;
				LocalDate dataSelecionada = dataTeste.getDatePicker().getDate();
				LocalTime horaSelecionada = dataTeste.getTimePicker().getTime();

				JOptionPane.showMessageDialog(null, "Data selecionada: " + dataSelecionada.toString());
				JOptionPane.showMessageDialog(null, "Horário selecionado: " + horaSelecionada.toString());

				// Preenche uma data utilizando os dois campos do componente
				Date dataCompleta = new Date(dataSelecionada.getYear(), dataSelecionada.getMonthValue(),
						dataSelecionada.getDayOfMonth(), horaSelecionada.getHour(), horaSelecionada.getMinute(),
						horaSelecionada.getSecond());
			}
		});
		button.setBounds(24, 288, 120, 25);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		button_1.setBounds(176, 288, 120, 25);
		getContentPane().add(button_1);
		
		JLabel lblNomeCliente = new JLabel("Cliente:");
		lblNomeCliente.setBounds(4, 130, 75, 15);
		getContentPane().add(lblNomeCliente);
		
		txtCPFCNPJ = new JTextField();
		txtCPFCNPJ.setColumns(10);
		txtCPFCNPJ.setBounds(79, 156, 236, 19);
		getContentPane().add(txtCPFCNPJ);
		
		JLabel label = new JLabel("Sala:");
		label.setBounds(4, 245, 45, 15);
		getContentPane().add(label);
		
		JComboBox cbSala = new JComboBox();
		cbSala.setBounds(43, 242, 75, 20);
		getContentPane().add(cbSala);
		
		//JLabel lblHorrio = new JLabel("Horário:");
		//lblHorrio.setBounds(191, 33, 46, 14);
		//getContentPane().add(lblHorrio);
		
		//JComboBox cbHorario = new JComboBox();
		//cbHorario.setBounds(240, 30, 75, 20);
		//getContentPane().add(cbHorario);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(79, 127, 236, 19);
		getContentPane().add(txtNome);
		
		JLabel lblCpfcnpj = new JLabel("CPF:");
		lblCpfcnpj.setBounds(4, 157, 45, 14);
		getContentPane().add(lblCpfcnpj);
		
		JComboBox cbFuncionario = new JComboBox();
		cbFuncionario.setBounds(194, 198, 194, 20);
		getContentPane().add(cbFuncionario);
		
		JLabel lblProcedimento = new JLabel("Procedimento:");
		lblProcedimento.setBounds(4, 98, 114, 14);
		getContentPane().add(lblProcedimento);
		
		JComboBox cbProcedimento = new JComboBox();
		cbProcedimento.setBounds(117, 95, 194, 20);
		getContentPane().add(cbProcedimento);
		
		JLabel lblFuncionrioResponsvel = new JLabel("Funcionário Responsavel:");
		lblFuncionrioResponsvel.setBounds(4, 201, 194, 15);
		getContentPane().add(lblFuncionrioResponsvel);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(12, 30, 45, 18);
		getContentPane().add(lblData);
		
		final DateTimePicker dataTeste = new DateTimePicker();
		dataTeste.setBounds(150, 47, 300, 30);
		this.getContentPane().add(dataTeste);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Atributos próprios do componente datePicker (date e time);
				LocalDate dataSelecionada = dataTeste.getDatePicker().getDate();
				LocalTime horaSelecionada = dataTeste.getTimePicker().getTime();

				JOptionPane.showMessageDialog(null, "Data selecionada: " + dataSelecionada.toString());
				JOptionPane.showMessageDialog(null, "Horário selecionado: " + horaSelecionada.toString());

				// Preenche uma data utilizando os dois campos do componente
				Date dataCompleta = new Date(dataSelecionada.getYear(), dataSelecionada.getMonthValue(),
						dataSelecionada.getDayOfMonth(), horaSelecionada.getHour(), horaSelecionada.getMinute(),
						horaSelecionada.getSecond());
			}
		});
		btnPesquisar.setBounds(191, 33, 46, 14);

	}
	
	private void cancelar() {
		this.setVisible(false);
	}
}
