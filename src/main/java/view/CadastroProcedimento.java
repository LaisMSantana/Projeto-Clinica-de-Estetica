package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class CadastroProcedimento extends JInternalFrame {
	private JTextField txtNomeProcedimento;
	private JTextField txtSala;

	/**
	 * Launch the application.
	 */
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
		lblNewLabel.setBounds(135, 26, 45, 15);
		getContentPane().add(lblNewLabel);
		
		txtNomeProcedimento = new JTextField();
		txtNomeProcedimento.setBounds(27, 58, 278, 19);
		getContentPane().add(txtNomeProcedimento);
		txtNomeProcedimento.setColumns(10);
		
		JLabel lblSala = new JLabel("Sala:");
		lblSala.setBounds(135, 84, 70, 15);
		getContentPane().add(lblSala);
		
		txtSala = new JTextField();
		txtSala.setBounds(97, 111, 114, 19);
		getContentPane().add(txtSala);
		txtSala.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(27, 163, 117, 25);
		getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(175, 163, 117, 25);
		getContentPane().add(btnCancelar);

	}
}
