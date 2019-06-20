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
import javax.swing.JFormattedTextField;

public class Agendamento extends JInternalFrame {
	private JTextField txtNomeCliente;

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
		setBounds(100, 100, 490, 440);
		getContentPane().setLayout(null);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
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
		btnSalvar.setBounds(90, 290, 120, 25);
		getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBounds(260, 290, 120, 25);
		getContentPane().add(btnCancelar);
		
		JLabel lblNomeCliente = new JLabel("Cliente:");
		lblNomeCliente.setBounds(35, 130, 50, 15);
		getContentPane().add(lblNomeCliente);
		
		JLabel lblSala = new JLabel("Sala:");
		lblSala.setBounds(50, 220, 30, 15);
		getContentPane().add(lblSala);
		
		JComboBox cbSala = new JComboBox();
		cbSala.setBounds(80, 215, 75, 20);
		getContentPane().add(cbSala);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(80, 130, 230, 20);
		getContentPane().add(txtNomeCliente);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(50, 160, 45, 15);
		getContentPane().add(lblCpf);
		
		JComboBox cbFuncionario = new JComboBox();
		cbFuncionario.setBounds(80, 185, 190, 20);
		getContentPane().add(cbFuncionario);
		
		JLabel lblProcedimento = new JLabel("Procedimento:");
		lblProcedimento.setBounds(5, 100, 115, 15);
		getContentPane().add(lblProcedimento);
		
		JComboBox cbProcedimento = new JComboBox();
		cbProcedimento.setBounds(80, 95, 190, 20);
		getContentPane().add(cbProcedimento);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio:");
		lblFuncionrio.setBounds(15, 185, 195, 15);
		getContentPane().add(lblFuncionrio);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(45, 50, 45, 15);
		getContentPane().add(lblData);
		
		final DateTimePicker dataTeste = new DateTimePicker();
		dataTeste.setBounds(80, 50, 300, 25);
		this.getContentPane().add(dataTeste);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnExcluir.setBounds(325, 290, 120, 25);
		getContentPane().add(btnExcluir);
		
		JFormattedTextField formatteCpf = new JFormattedTextField();
		try{
	           javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
	           formatteCpf = new javax.swing.JFormattedTextField(format_textField4);
	        }catch (Exception e){
	        	
	        }
		formatteCpf.setBounds(80, 155, 190, 20);
		getContentPane().add(formatteCpf);

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
		btnPesquisar.setBounds(190, 30, 45, 15);

	}
	
	private void cancelar() {
		this.setVisible(false);
	}
}
