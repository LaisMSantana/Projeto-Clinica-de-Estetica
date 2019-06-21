package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;

import controller.FuncionarioControl;
import model.vo.Funcionario;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CadastroFuncionario extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtMunicipio;
	private JTextField txtEstado;
	private JTextField txtEmail;
	private JLabel lblRg;
	private JLabel lblCargo;
	private JLabel lblFuncao;
	private JLabel lblDataAdmissao;
	private JLabel lblEscolaridade;
	private JTextField txtEscolaridade;
	private JFormattedTextField formattedCpf;
	private JFormattedTextField formattedCep;
	private JFormattedTextField formattedCelular;
	private JFormattedTextField formattedRg;
	private JFormattedTextField formattedFone;
	DatePicker dataNascimento;
	DatePicker dataAdmissao;

	private FuncionarioControl funcionarioControl = new FuncionarioControl();

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
		lblNome.setBounds(5, 20, 55, 16);
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(60, 20, 360, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o :");
		lblEndereco.setBounds(5, 50, 85, 16);
		getContentPane().add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(88, 50, 332, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro :");
		lblBairro.setBounds(5, 80, 59, 16);
		getContentPane().add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setBounds(60, 80, 150, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblCep = new JLabel("CEP :");
		lblCep.setBounds(250, 80, 50, 16);
		getContentPane().add(lblCep);

		JLabel lblMunicpio = new JLabel("Munic\u00EDpio :");
		lblMunicpio.setBounds(8, 110, 78, 16);
		getContentPane().add(lblMunicpio);

		txtMunicipio = new JTextField();
		txtMunicipio.setBounds(88, 110, 122, 20);
		getContentPane().add(txtMunicipio);
		txtMunicipio.setColumns(10);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(240, 110, 56, 16);
		getContentPane().add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setBounds(301, 110, 85, 20);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);

		JLabel lblTelefone = new JLabel("Fone:");
		lblTelefone.setBounds(10, 138, 50, 16);
		getContentPane().add(lblTelefone);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(240, 140, 60, 16);
		getContentPane().add(lblCelular);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(5, 166, 59, 14);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(48, 166, 184, 20);
		getContentPane().add(txtEmail);

		JLabel lblCpf = new JLabel("CPF :");
		lblCpf.setBounds(250, 170, 50, 14);
		getContentPane().add(lblCpf);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento :");
		lblDataDeNascimento.setBounds(10, 200, 106, 16);
		getContentPane().add(lblDataDeNascimento);


		lblRg = new JLabel("RG :");
		lblRg.setBounds(255, 200, 39, 14);
		getContentPane().add(lblRg);

		lblCargo = new JLabel("Cargo :");
		lblCargo.setBounds(10, 250, 62, 22);
		getContentPane().add(lblCargo);

		JComboBox cbCargo = new JComboBox();
		cbCargo.setBounds(60, 270, 150, 20);
		getContentPane().add(cbCargo);
		cbCargo.addItem("Esteticista");
		cbCargo.addItem("Fisioterapeuta");
		cbCargo.addItem("Consultora");		
		lblFuncao = new JLabel("Fun\u00E7\u00E3o :");
		lblFuncao.setBounds(288, 321, 68, 16);
		getContentPane().add(lblFuncao);

		lblDataAdmissao = new JLabel("Data de Admissão :");
		lblDataAdmissao.setBounds(10, 350, 149, 16);
		getContentPane().add(lblDataAdmissao);

		lblEscolaridade = new JLabel("Escolaridade :");
		lblEscolaridade.setBounds(10, 300, 113, 16);
		getContentPane().add(lblEscolaridade);

		txtEscolaridade = new JTextField();
		txtEscolaridade.setColumns(10);
		txtEscolaridade.setBounds(60, 320, 150, 20);
		getContentPane().add(txtEscolaridade);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(txtNome.getText());
				funcionario.setEndereco(txtEndereco.getText());
				funcionario.setBairro(txtBairro.getText());
				funcionario.setMunicipio(txtMunicipio.getText());
				funcionario.setEstado(txtEstado.getText());
				funcionario.setEmail(txtEmail.getText());
				funcionario.setEscolaridade(txtEscolaridade.getText());
				funcionario.setCpf(formattedCpf.getText());
				funcionario.setCep(formattedCep.getText());
				funcionario.setCelular(formattedCelular.getText());
				funcionario.setRg(formattedRg.getText());
				funcionario.setCargo(null);
				funcionario.setFuncao(null);
				funcionario.setTelefone(formattedFone.getText());
				if (dataNascimento.getDate() != null) {
					Date dataNasc = Date.from(dataNascimento.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
					funcionario.setDataDeNascimento(dataNasc);
				}
				if (dataAdmissao.getDate() != null) {
					Date dataAdm = Date.from(dataAdmissao.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
					funcionario.setDataAdmissao(dataAdm);
				}
				String retorno = FuncionarioControl.salvar(funcionario);
				JOptionPane.showMessageDialog(null, retorno);
			}
		});
		btnSalvar.setBounds(5, 413, 95, 25);
		getContentPane().add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBounds(112, 413, 120, 25);
		getContentPane().add(btnCancelar);

		formattedCpf = new JFormattedTextField();
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
			formattedCpf = new javax.swing.JFormattedTextField(format_textField4);
		}catch (Exception e){
		}
		formattedCpf.setBounds(301, 170, 109, 20);
		getContentPane().add(formattedCpf);

		formattedCep = new JFormattedTextField();
		try{
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("#####-###");
			formattedCep = new javax.swing.JFormattedTextField(format_textField3);
		}catch (Exception e){
		}
		formattedCep.setBounds(301, 80, 106, 20);
		getContentPane().add(formattedCep);

		dataNascimento = new DatePicker();
		dataNascimento.setBounds(60, 220, 170, 20);
		this.getContentPane().add(dataNascimento);

		dataAdmissao = new DatePicker();
		dataAdmissao.setBounds(60, 370, 170, 20);
		this.getContentPane().add(dataAdmissao);

		formattedCelular = new JFormattedTextField();
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("(##)#####-####");
			formattedCelular = new javax.swing.JFormattedTextField(format_textField4);
		}catch (Exception e){
		}
		formattedCelular.setBounds(301, 140, 109, 20);
		getContentPane().add(formattedCelular);

		formattedRg = new JFormattedTextField();
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##.###.###-#");
			formattedRg = new javax.swing.JFormattedTextField(format_textField4);
		}catch (Exception e){
		}
		formattedRg.setBounds(301, 200, 109, 20);
		getContentPane().add(formattedRg);

		formattedFone = new JFormattedTextField();
		try{
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("(##)####-####");
			formattedFone = new javax.swing.JFormattedTextField(format_textField4);
		}catch (Exception e){
		}
		formattedFone.setBounds(60, 140, 130, 20);
		getContentPane().add(formattedFone);

		JComboBox comboBox1 = new JComboBox();
		comboBox1.setBounds(255, 346, 182, 24);
		getContentPane().add(comboBox1);
		comboBox1.addItem("Selecione uma opcao");
		comboBox1.addItem("Massagem");
		comboBox1.addItem("Limpeza de Pele");		
		comboBox1.addItem("Peeling");
		comboBox1.addItem("Botox");
		comboBox1.addItem("Venda");

		JComboBox comboBox2 = new JComboBox();
		comboBox2.setBounds(250, 378, 182, 24);
		getContentPane().add(comboBox2);
		comboBox2.addItem("Selecione uma opcao");
		comboBox2.addItem("Massagem");
		comboBox2.addItem("Limpeza de Pele");		
		comboBox2.addItem("Peeling");
		comboBox2.addItem("Botox");
		comboBox2.addItem("Venda");



		JComboBox comboBox3 = new JComboBox();
		comboBox3.setBounds(250, 413, 187, 24);
		getContentPane().add(comboBox3);
		comboBox3.addItem("Selecione uma opcao");
		comboBox3.addItem("Massagem");
		comboBox3.addItem("Limpeza de Pele");		
		comboBox3.addItem("Peeling");
		comboBox3.addItem("Botox");
		comboBox3.addItem("Venda");





	}private void cancelar() {
		this.setVisible(false);
	}
}
