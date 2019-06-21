package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ClienteControl;
import controller.ProcedimentoControl;
import model.vo.Procedimento;

public class CadastroProcedimento extends JInternalFrame {
	private JTextField txtNomeProcedimento;
	private JTextField txtSala;
	private ProcedimentoControl procedimentoControl;
	private String nome;
	private String sala;
	private String texto;
	/**
	 * Launch the application.
	 **/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProcedimento frame = new CadastroProcedimento();
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
	public CadastroProcedimento() {
		setTitle("Cadastro de Procedimentos");
		getContentPane().setForeground(Color.WHITE);
		setClosable(true);
		setBounds(100, 100, 332, 289);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(135, 25, 45, 15);
		getContentPane().add(lblNewLabel);

		txtNomeProcedimento = new JTextField();
		txtNomeProcedimento.setBounds(25, 60, 280, 20);
		getContentPane().add(txtNomeProcedimento);
		txtNomeProcedimento.setColumns(10);

		JLabel lblSala = new JLabel("Sala:");
		lblSala.setBounds(135, 85, 70, 15);
		getContentPane().add(lblSala);

		txtSala = new JTextField();
		txtSala.setBounds(100, 110, 115, 20);
		getContentPane().add(txtSala);
		txtSala.setColumns(10);



		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Procedimento procedimento = new Procedimento();
				procedimento.setNome(txtNomeProcedimento.getText());
				procedimento.setSala(txtSala.getText());
				String retorno = ProcedimentoControl.salvar(procedimento);
				JOptionPane.showMessageDialog(null, retorno);
				limpar();

			}

			private void limpar() {
				txtNomeProcedimento.setText(""); 
				txtSala.setText("");
			}
		});
		btnSalvar.setBounds(30, 160, 115, 25);
		getContentPane().add(btnSalvar);


		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBounds(175, 160, 115, 25);
		getContentPane().add(btnCancelar);

	}

	private void cancelar() {
		this.setVisible(false);
	}
}
