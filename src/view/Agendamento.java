package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

import controller.AgendamentoControl;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 350, 320);
		getContentPane().setLayout(null);
		
		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			}
		});
		button.setBounds(40, 230, 120, 25);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(180, 230, 120, 25);
		getContentPane().add(button_1);
		
		JLabel lblNomeCliente = new JLabel("Nome Cliente:");
		lblNomeCliente.setBounds(4, 130, 75, 15);
		getContentPane().add(lblNomeCliente);
		
		txtCPFCNPJ = new JTextField();
		txtCPFCNPJ.setColumns(10);
		txtCPFCNPJ.setBounds(79, 156, 236, 19);
		getContentPane().add(txtCPFCNPJ);
		
		JLabel label = new JLabel("Sala:");
		label.setBounds(24, 189, 45, 15);
		getContentPane().add(label);
		
		JComboBox cbSala = new JComboBox();
		cbSala.setBounds(79, 186, 75, 20);
		getContentPane().add(cbSala);
		
		JLabel lblHorrio = new JLabel("Horário:");
		lblHorrio.setBounds(191, 33, 46, 14);
		getContentPane().add(lblHorrio);
		
		JComboBox cbHorario = new JComboBox();
		cbHorario.setBounds(240, 30, 75, 20);
		getContentPane().add(cbHorario);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(79, 127, 236, 19);
		getContentPane().add(txtNome);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ:");
		lblCpfcnpj.setBounds(14, 156, 65, 14);
		getContentPane().add(lblCpfcnpj);
		
		JTextPane txtpnFuncionrioResponsvel = new JTextPane();
		txtpnFuncionrioResponsvel.setBackground(SystemColor.control);
		txtpnFuncionrioResponsvel.setText("Funcionário "
				+ "\nResponsável:");
		txtpnFuncionrioResponsvel.setBounds(4, 85, 75, 34);
		getContentPane().add(txtpnFuncionrioResponsvel);
		
		JComboBox cbFuncionario = new JComboBox();
		cbFuncionario.setBounds(79, 99, 236, 20);
		getContentPane().add(cbFuncionario);
		
		JLabel lblProcedimento = new JLabel("Procedimento:");
		lblProcedimento.setBounds(4, 71, 75, 14);
		getContentPane().add(lblProcedimento);
		
		JComboBox cbProcedimento = new JComboBox();
		cbProcedimento.setBounds(79, 68, 236, 20);
		getContentPane().add(cbProcedimento);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(40, 33, 36, 14);
		getContentPane().add(lblData);
		
		JComboBox cbData = new JComboBox();
		cbData.setBounds(79, 30, 75, 20);
		getContentPane().add(cbData);

	}
}
