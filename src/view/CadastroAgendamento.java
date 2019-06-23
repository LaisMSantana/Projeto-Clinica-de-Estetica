package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import com.github.lgooddatepicker.components.DateTimePicker;

import controller.AgendamentoControl;
import controller.ClienteControl;
import controller.FuncionarioControl;
import controller.ProcedimentoControl;
import model.vo.Agendamento;
import model.vo.Cliente;
import model.vo.Funcionario;
import model.vo.Procedimento;

public class CadastroAgendamento extends JInternalFrame {
	
	private Agendamento agendamento;
	private AgendamentoControl agendamentoControl = new AgendamentoControl();
	private ProcedimentoControl procedimentoControl = new ProcedimentoControl();
	private ClienteControl clienteControl = new ClienteControl();
	private FuncionarioControl funcionarioControl = new FuncionarioControl();
	private JComboBox cbProcedimento;
	

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

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBounds(260, 290, 120, 25);
		getContentPane().add(btnCancelar);

		JLabel lblNomeCliente = new JLabel("Cliente:");
		lblNomeCliente.setBounds(36, 130, 68, 15);
		getContentPane().add(lblNomeCliente);

		final JComboBox<Funcionario> cbFuncionario = new JComboBox<Funcionario>();
		cbFuncionario.setBounds(117, 184, 263, 20);
		getContentPane().add(cbFuncionario);

		JLabel lblProcedimento = new JLabel("Procedimento:");
		lblProcedimento.setBounds(4, 98, 114, 14);
		getContentPane().add(lblProcedimento);

		final JComboBox<Procedimento> cbProcedimento = new JComboBox<Procedimento>();
		cbProcedimento.setBounds(117, 95, 263, 20);
		getContentPane().add(cbProcedimento);

		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio:");
		lblFuncionrio.setBounds(14, 186, 104, 17);
		getContentPane().add(lblFuncionrio);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(45, 50, 45, 15);
		getContentPane().add(lblData);

		final DateTimePicker dataTeste = new DateTimePicker();
		dataTeste.setBounds(80, 50, 300, 25);
		this.getContentPane().add(dataTeste);

		final JComboBox<Cliente> cbCliente = new JComboBox<Cliente>();
		cbCliente.setBounds(122, 125, 258, 24);
		getContentPane().add(cbCliente);

		JFormattedTextField formatteCpf = new JFormattedTextField();
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
		} catch (Exception e) {

		}

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				agendamento = new Agendamento();
				LocalDate data = dataTeste.getDatePicker().getDate();
				LocalTime hora = dataTeste.getTimePicker().getTime();
				
				if (data != null && hora != null) {
					Date dataAgendamento = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
					dataAgendamento.setHours(hora.getHour());
					dataAgendamento.setMinutes(hora.getMinute());
					agendamento.setData(dataAgendamento);
				}
				agendamento.setCliente((Cliente) cbCliente.getSelectedItem());
				agendamento.setFuncionario((Funcionario) cbFuncionario.getSelectedItem());
				agendamento.setProcedimento((Procedimento) cbProcedimento.getSelectedItem());
				String retorno = agendamentoControl.salvar(agendamento);
				JOptionPane.showMessageDialog(null, retorno);
			}
		});
		btnSalvar.setBounds(90, 290, 120, 25);
		getContentPane().add(btnSalvar);
		
		this.addInternalFrameListener(new InternalFrameListener() {
			
			public void internalFrameOpened(InternalFrameEvent e) {
				preencheComboCliente(cbCliente);
				preencheComboFuncionario(cbFuncionario);
				preencheComboProcedimento(cbProcedimento);
			}
			
			public void internalFrameIconified(InternalFrameEvent e) {
			}
			
			public void internalFrameDeiconified(InternalFrameEvent e) {
			}
			
			public void internalFrameDeactivated(InternalFrameEvent e) {
			}
			
			public void internalFrameClosing(InternalFrameEvent e) {
			}
			
			public void internalFrameClosed(InternalFrameEvent e) {
			}
			
			public void internalFrameActivated(InternalFrameEvent e) {
				preencheComboCliente(cbCliente);
				preencheComboFuncionario(cbFuncionario);
				preencheComboProcedimento(cbProcedimento);
			}
		});
		
	}

	private void preencheComboCliente(final JComboBox<Cliente> cbCliente) {
		cbCliente.removeAllItems();
		ArrayList<Cliente> clientes = clienteControl.listarTodos();
		for (Cliente cliente : clientes) {
			cbCliente.addItem(cliente);
		}
	}

	private void preencheComboProcedimento(final JComboBox<Procedimento> cbProcedimento) {
		cbProcedimento.removeAllItems();
		ArrayList<Procedimento> procedimentos = procedimentoControl.listarTodosProcedimentos();
		for (Procedimento procedimento : procedimentos) {
			cbProcedimento.addItem(procedimento);
		}
	}

	private void preencheComboFuncionario(final JComboBox<Funcionario> cbFuncionario) {
		cbFuncionario.removeAllItems();
		ArrayList<Funcionario> funcionarios = funcionarioControl.listarTodos();
		for (Funcionario funcionario : funcionarios) {
			cbFuncionario.addItem(funcionario);
		}
	}

	private void cancelar() {
		this.setVisible(false);
	}
}
