package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DateTimePicker;

public class CadastroCliente extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtMunicipio;
	private JTextField txtEstado;
	private JTextField txtTelefone;
	private JTextField textField;
	private JTextField txtCelular;
	private JTextField txtCpf;
	private JTextField txtDataNascimento;

	/**
	 * Create the frame.
	 */
	public CadastroCliente(int largura, int altura) {
		setClosable(true);
		setTitle("Cadastro de Clientes");
		
//		largura = 1000;
//		altura = 500;
		//x, y, largura, altura		
		setBounds(largura / 2, 0, 660, altura);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(33, 11, 46, 14);
		getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(78, 8, 346, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o :");
		lblEndereco.setBounds(16, 47, 63, 14);
		getContentPane().add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(78, 44, 346, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro :");
		lblBairro.setBounds(33, 84, 46, 14);
		getContentPane().add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(78, 81, 183, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP :");
		lblCep.setBounds(297, 84, 32, 14);
		getContentPane().add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(334, 81, 90, 20);
		getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblMunicpio = new JLabel("Munic\u00EDpio :");
		lblMunicpio.setBounds(16, 124, 56, 14);
		getContentPane().add(lblMunicpio);
		
		txtMunicipio = new JTextField();
		txtMunicipio.setBounds(78, 121, 183, 20);
		getContentPane().add(txtMunicipio);
		txtMunicipio.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(283, 124, 46, 14);
		getContentPane().add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(334, 121, 90, 20);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setBounds(16, 157, 56, 14);
		getContentPane().add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(78, 154, 183, 20);
		getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(33, 190, 46, 14);
		getContentPane().add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(78, 187, 186, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular :");
		lblCelular.setBounds(283, 157, 46, 14);
		getContentPane().add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(334, 156, 90, 20);
		getContentPane().add(txtCelular);
		txtCelular.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF :");
		lblCpf.setBounds(297, 190, 32, 14);
		getContentPane().add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(334, 190, 90, 20);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento :");
		lblDataDeNascimento.setBounds(24, 223, 157, 14);
		getContentPane().add(lblDataDeNascimento);
		MaskFormatter formatter = new MaskFormatter();
		try {
			formatter.setMask("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(129, 270, 89, 23);
		getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			cancelar();	
			}
		});
		btnCancelar.setBounds(230, 270, 89, 23);
		getContentPane().add(btnCancelar);

		final DatePicker dataNascimento = new DatePicker();
		dataNascimento.setBounds(180, 221, 250, 35);
		this.getContentPane().add(dataNascimento);
		
	} private void cancelar() {
		this.setVisible(false);
	}
}
