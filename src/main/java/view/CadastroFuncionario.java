package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class CadastroFuncionario extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtMunicipio;
	private JTextField txtEstado;
	private JTextField txtTelefone;
	private JTextField txtField;
	private JTextField txtEmail;
	private JTextField txtCpf;
	private JTextField txtDataNascimento;
	private JLabel lblRg;
	private JTextField txtRg;
	private JLabel lblCargo;
	private JLabel lblFuncao;
	private JRadioButton rdbtnMassagemRelaxante;
	private JRadioButton rdbtnMasssagemModeladora;
	private JRadioButton rdbtnDrenagemLinftica;
	private JRadioButton rdbtnVendaRenovacao;
	private JRadioButton rdbtnBotox;
	private JLabel lblDataAdmissao;
	private JTextField txtDataAdmissao;
	private JLabel lblEscolaridade;
	private JTextField txtEscolaridade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario frame = new CadastroFuncionario();
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
	public CadastroFuncionario() {
		setClosable(true);
		setTitle("Cadastro de Funcionários");
		setBounds(100, 100, 465, 482);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(0, 19, 42, 16);
		getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(71, 13, 351, 22);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o :");
		lblEndereco.setBounds(0, 51, 62, 16);
		getContentPane().add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(71, 48, 351, 22);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro :");
		lblBairro.setBounds(0, 85, 56, 16);
		getContentPane().add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(71, 82, 149, 22);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP :");
		lblCep.setBounds(249, 83, 39, 16);
		getContentPane().add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(280, 82, 142, 22);
		getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblMunicpio = new JLabel("Munic\u00EDpio :");
		lblMunicpio.setBounds(0, 120, 62, 16);
		getContentPane().add(lblMunicpio);
		
		txtMunicipio = new JTextField();
		txtMunicipio.setBounds(71, 117, 149, 22);
		getContentPane().add(txtMunicipio);
		txtMunicipio.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(232, 117, 56, 16);
		getContentPane().add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(280, 117, 142, 22);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setBounds(0, 160, 62, 16);
		getContentPane().add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(71, 157, 149, 22);
		getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular :");
		lblCelular.setBounds(232, 160, 56, 16);
		getContentPane().add(lblCelular);
		
		txtField = new JTextField();
		txtField.setBounds(280, 157, 142, 22);
		getContentPane().add(txtField);
		txtField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(0, 196, 46, 14);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(71, 192, 149, 22);
		getContentPane().add(txtEmail);
		
		JLabel lblCpf = new JLabel("CPF :");
		lblCpf.setBounds(249, 196, 39, 14);
		getContentPane().add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(280, 192, 142, 22);
		getContentPane().add(txtCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento :");
		lblDataDeNascimento.setBounds(0, 223, 123, 16);
		getContentPane().add(lblDataDeNascimento);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(126, 223, 94, 22);
		getContentPane().add(txtDataNascimento);
		
		lblRg = new JLabel("RG :");
		lblRg.setBounds(249, 223, 39, 14);
		getContentPane().add(lblRg);
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(280, 223, 142, 22);
		getContentPane().add(txtRg);
		
		lblCargo = new JLabel("Cargo :");
		lblCargo.setBounds(0, 252, 46, 22);
		getContentPane().add(lblCargo);
		
		JComboBox cbCargo = new JComboBox();
		cbCargo.setBounds(71, 252, 149, 22);
		getContentPane().add(cbCargo);
		
		lblFuncao = new JLabel("Fun\u00E7\u00E3o :");
		lblFuncao.setBounds(232, 258, 56, 16);
		getContentPane().add(lblFuncao);
		
		JRadioButton rdbtnLimpezaPele = new JRadioButton("Limpeza de Pele");
		rdbtnLimpezaPele.setBounds(280, 254, 127, 25);
		getContentPane().add(rdbtnLimpezaPele);
		
		rdbtnMassagemRelaxante = new JRadioButton("Massagem Relaxante");
		rdbtnMassagemRelaxante.setBounds(280, 283, 149, 25);
		getContentPane().add(rdbtnMassagemRelaxante);
		
		rdbtnMasssagemModeladora = new JRadioButton("Masssagem Modeladora");
		rdbtnMasssagemModeladora.setBounds(280, 313, 167, 25);
		getContentPane().add(rdbtnMasssagemModeladora);
		
		rdbtnDrenagemLinftica = new JRadioButton("Drenagem Linf\u00E1tica");
		rdbtnDrenagemLinftica.setBounds(280, 343, 167, 25);
		getContentPane().add(rdbtnDrenagemLinftica);
		
		rdbtnVendaRenovacao = new JRadioButton("Venda/ Renovação");
		rdbtnVendaRenovacao.setBounds(280, 373, 167, 25);
		getContentPane().add(rdbtnVendaRenovacao);
		
		rdbtnBotox = new JRadioButton("Botox");
		rdbtnBotox.setBounds(280, 403, 127, 25);
		getContentPane().add(rdbtnBotox);
		
		lblDataAdmissao = new JLabel("Data de Admissão :");
		lblDataAdmissao.setBounds(0, 287, 123, 16);
		getContentPane().add(lblDataAdmissao);
		
		txtDataAdmissao = new JTextField();
		txtDataAdmissao.setColumns(10);
		txtDataAdmissao.setBounds(126, 287, 94, 22);
		getContentPane().add(txtDataAdmissao);
		
		lblEscolaridade = new JLabel("Escolaridade :");
		lblEscolaridade.setBounds(0, 317, 94, 16);
		getContentPane().add(lblEscolaridade);
		
		txtEscolaridade = new JTextField();
		txtEscolaridade.setColumns(10);
		txtEscolaridade.setBounds(126, 316, 94, 22);
		getContentPane().add(txtEscolaridade);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(12, 388, 97, 25);
		getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(123, 388, 97, 25);
		getContentPane().add(btnCancelar);

	}
}
