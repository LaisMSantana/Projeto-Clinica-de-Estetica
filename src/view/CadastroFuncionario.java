package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.text.MaskFormatter;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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
	private JRadioButton rdbtnMassagemRelaxante;
	private JRadioButton rdbtnMasssagemModeladora;
	private JRadioButton rdbtnDrenagemLinftica;
	private JRadioButton rdbtnVendaRenovacao;
	private JRadioButton rdbtnBotox;
	private JLabel lblDataAdmissao;
	private JLabel lblEscolaridade;
	private JTextField txtEscolaridade;
	private JFormattedTextField formattedCPf;
	private JFormattedTextField formattedCep;
	private JFormattedTextField formattedDtNascimento;
	private JFormattedTextField formattedDtAdmissao;
	private JFormattedTextField formattedCelular;
	private JFormattedTextField formattedRG;
	private JFormattedTextField formattedFone;

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
		lblNome.setBounds(23, 20, 37, 16);
		getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(60, 20, 360, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o :");
		lblEndereco.setBounds(5, 50, 56, 16);
		getContentPane().add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(60, 50, 360, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro :");
		lblBairro.setBounds(23, 80, 41, 16);
		getContentPane().add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(60, 80, 150, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP :");
		lblCep.setBounds(250, 80, 50, 16);
		getContentPane().add(lblCep);
		
		JLabel lblMunicpio = new JLabel("Munic\u00EDpio :");
		lblMunicpio.setBounds(8, 110, 56, 16);
		getContentPane().add(lblMunicpio);
		
		txtMunicipio = new JTextField();
		txtMunicipio.setBounds(60, 110, 150, 20);
		getContentPane().add(txtMunicipio);
		txtMunicipio.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(240, 110, 56, 16);
		getContentPane().add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(280, 110, 37, 20);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Fone:");
		lblTelefone.setBounds(30, 140, 37, 16);
		getContentPane().add(lblTelefone);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(240, 140, 37, 16);
		getContentPane().add(lblCelular);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(30, 170, 59, 14);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(60, 170, 150, 20);
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
		
		lblFuncao = new JLabel("Fun\u00E7\u00E3o :");
		lblFuncao.setBounds(240, 230, 114, 16);
		getContentPane().add(lblFuncao);
		
		JRadioButton rdbtnLimpezaPele = new JRadioButton("Limpeza de Pele");
		rdbtnLimpezaPele.setBounds(280, 250, 127, 25);
		getContentPane().add(rdbtnLimpezaPele);
		
		rdbtnMassagemRelaxante = new JRadioButton("Massagem Relaxante");
		rdbtnMassagemRelaxante.setBounds(280, 270, 149, 25);
		getContentPane().add(rdbtnMassagemRelaxante);
		
		rdbtnMasssagemModeladora = new JRadioButton("Masssagem Modeladora");
		rdbtnMasssagemModeladora.setBounds(280, 290, 167, 25);
		getContentPane().add(rdbtnMasssagemModeladora);
		
		rdbtnDrenagemLinftica = new JRadioButton("Drenagem Linfatica");
		rdbtnDrenagemLinftica.setBounds(280, 310, 167, 25);
		getContentPane().add(rdbtnDrenagemLinftica);
		
		rdbtnVendaRenovacao = new JRadioButton("Venda/ Renovação");
		rdbtnVendaRenovacao.setBounds(280, 330, 167, 25);
		getContentPane().add(rdbtnVendaRenovacao);
		
		rdbtnBotox = new JRadioButton("Botox");
		rdbtnBotox.setBounds(280, 350, 127, 25);
		getContentPane().add(rdbtnBotox);
		
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
		btnSalvar.setBounds(95, 400, 95, 25);
		getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			cancelar();
			}
		});
		btnCancelar.setBounds(260, 400, 95, 25);
		getContentPane().add(btnCancelar);
		
		formattedCPf = new JFormattedTextField();
		try{
	           javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
	           formattedCPf = new javax.swing.JFormattedTextField(format_textField4);
	        }catch (Exception e){
	        }
		formattedCPf.setBounds(280, 170, 130, 20);
		getContentPane().add(formattedCPf);
		
		formattedCep = new JFormattedTextField();
		try{
	           javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("#####-###");
	           formattedCep = new javax.swing.JFormattedTextField(format_textField3);
	        }catch (Exception e){
	        }
		formattedCep.setBounds(280, 80, 127, 20);
		getContentPane().add(formattedCep);
		
		formattedDtNascimento = new JFormattedTextField();
		try{
	           javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##/##/####");
	           formattedDtNascimento = new javax.swing.JFormattedTextField(format_textField4);
	        }catch (Exception e){	
	        }
		formattedDtNascimento.setBounds(60, 220, 100, 20);
		getContentPane().add(formattedDtNascimento);
		
		formattedDtAdmissao = new JFormattedTextField();
		try{
	           javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##/##/####");
	           formattedDtAdmissao = new javax.swing.JFormattedTextField(format_textField4);
	        }catch (Exception e){	
	        }
		formattedDtAdmissao.setBounds(60, 370, 100, 20);
		getContentPane().add(formattedDtAdmissao);
		
		formattedCelular = new JFormattedTextField();
		try{
	           javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("(##)#####-####");
	   		   formattedCelular = new javax.swing.JFormattedTextField(format_textField4);
	        }catch (Exception e){
	        }
		formattedCelular.setBounds(280, 140, 130, 20);
		getContentPane().add(formattedCelular);
		
		formattedRG = new JFormattedTextField();
		try{
	           javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##.###.###-#");
	           formattedRG = new javax.swing.JFormattedTextField(format_textField4);
			}catch (Exception e){
	        }
		formattedRG.setBounds(280, 200, 130, 20);
		getContentPane().add(formattedRG);
		
		formattedFone = new JFormattedTextField();
		try{
	           javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("(##)####-####");
	           formattedFone = new javax.swing.JFormattedTextField(format_textField4);
	        }catch (Exception e){
	        }
		formattedFone.setBounds(60, 140, 130, 20);
		getContentPane().add(formattedFone);

	}private void cancelar() {
		this.setVisible(false);
	}
}
