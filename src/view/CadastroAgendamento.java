package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.math3.analysis.function.Cbrt;

import com.github.lgooddatepicker.components.DateTimePicker;

import controller.AgendamentoControl;
import controller.FuncionarioControl;
import controller.ProcedimentoControl;
import model.vo.Agendamento;
import model.vo.Cliente;
import model.vo.Funcionario;
import model.vo.Procedimento;

import com.github.lgooddatepicker.components.DateTimePicker;
import javax.swing.JFormattedTextField;

public class CadastroAgendamento extends JInternalFrame {
	private JTextField txtNomeCliente;
	private JComboBox cbProcedimento;
	private JComboBox cbFuncionario;
	private JComboBox cbSala;
	private JFormattedTextField formattedCpf;
	DateTimePicker dataAgendamento;
	ArrayList<Procedimento> procedimentos = new ArrayList<Procedimento>();
	ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAgendamento frame = new CadastroAgendamento();
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
	public CadastroAgendamento() {
		setTitle("Agendamento");
		setClosable(true);
		setBounds(100, 100, 500, 440);
		getContentPane().setLayout(null);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agendamento agendamento = new Agendamento();	
				if ((dataAgendamento.getDatePicker() != null) && (dataAgendamento.getTimePicker() != null)) {
					LocalDate dataSelecionada = dataAgendamento.getDatePicker().getDate();
					LocalTime horaSelecionada = dataAgendamento.getTimePicker().getTime();	
					Date dataCompleta = new Date(dataSelecionada.getYear(), dataSelecionada.getMonthValue(),
							dataSelecionada.getDayOfMonth(), horaSelecionada.getHour(), horaSelecionada.getMinute(),
							horaSelecionada.getSecond());
					agendamento.setData(dataCompleta);
				}
				Procedimento procedimento = new Procedimento();
				procedimento.setNome(cbProcedimento.getSelectedItem().toString());
				procedimento.setSala(cbSala.getSelectedItem().toString());
				agendamento.setProcedimento(procedimento);
				Cliente cliente = new Cliente();
				cliente.setNome(txtNomeCliente.getText());
				cliente.setCpf(formattedCpf.getText());
				agendamento.setCliente(cliente);
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(cbFuncionario.getSelectedItem().toString());
				agendamento.setFuncionario(funcionario);	
				String retorno = AgendamentoControl.salvar(agendamento);
				JOptionPane.showMessageDialog(null, retorno);
				limpar();
			}

			private void limpar() {
				formattedCpf.setText("");
				txtNomeCliente.setText("");
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
		lblNomeCliente.setBounds(36, 130, 50, 15);
		getContentPane().add(lblNomeCliente);
		
		JLabel lblSala = new JLabel("Sala:");
		lblSala.setBounds(47, 219, 32, 15);
		getContentPane().add(lblSala);
		
		JComboBox cbSala = new JComboBox(procedimentos.toArray());
		consultarSala();
		cbSala.setBounds(79, 216, 75, 20);
		getContentPane().add(cbSala);
		
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(79, 127, 230, 20);
		getContentPane().add(txtNomeCliente);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(47, 159, 45, 14);
		getContentPane().add(lblCpf);
		
		JComboBox cbFuncionario = new JComboBox(funcionarios.toArray());
		consultarFuncionario();
		cbFuncionario.setBounds(79, 186, 190, 20);
		getContentPane().add(cbFuncionario);
		
		JLabel lblProcedimento = new JLabel("Procedimento:");
		lblProcedimento.setBounds(4, 98, 114, 14);
		getContentPane().add(lblProcedimento);
		
		JComboBox cbProcedimento = new JComboBox();
		cbProcedimento.setBounds(79, 95, 190, 20);
		getContentPane().add(cbProcedimento);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio:");
		lblFuncionrio.setBounds(14, 186, 194, 15);
		getContentPane().add(lblFuncionrio);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(45, 50, 45, 15);
		getContentPane().add(lblData);
		
		final DateTimePicker dataAgendamento = new DateTimePicker();
		dataAgendamento.setBounds(80, 50, 300, 25);
		this.getContentPane().add(dataAgendamento);
		
		JFormattedTextField formatteCpf = new JFormattedTextField();
		try{
	           javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
	           formatteCpf = new javax.swing.JFormattedTextField(format_textField4);
	        }catch (Exception e){
	        	
	        }
		formatteCpf.setBounds(79, 156, 190, 20);
		getContentPane().add(formatteCpf);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Atributos próprios do componente datePicker (date e time);
				LocalDate dataSelecionada = dataAgendamento.getDatePicker().getDate();
				LocalTime horaSelecionada = dataAgendamento.getTimePicker().getTime();

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
	
	private void consultarFuncionario() {
		FuncionarioControl controlFuncionario = new FuncionarioControl();
		funcionarios = controlFuncionario.listarTodosFuncionarios();
		cbFuncionario.setModel(new DefaultComboBoxModel(funcionarios.toArray()));
		cbFuncionario.setSelectedIndex(-1);
	}

	private void consultarSala() {
		ProcedimentoControl controlProcedimento = new ProcedimentoControl();
		//procedimentos = controlProcedimento
		
	}

	private void cancelar() {
		this.setVisible(false);
	}
}
