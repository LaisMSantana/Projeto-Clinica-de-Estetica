package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;

import controller.ClienteControl;
import model.vo.Cliente;
public class CadastroCliente extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtMunicipio;
	private JTextField txtEstado;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtCelular;
	private JTextField txtCpf;
	private JTextField txtDataNascimento;
	private JFormattedTextField formattedCPf;
	private JFormattedTextField formattedCep;
	private JFormattedTextField formattedCelular;
	private JFormattedTextField formattedFone;
	private ClienteControl clienteControl;
	private Cliente cliente;
	DatePicker dataNascimento;

	/**
	 * Create the frame.
	 */
	public CadastroCliente(int largura, int altura) {
		setClosable(true);
		setTitle("Cadastro de Clientes");
		
    largura = 1000;
	altura = 500;
//		x, y, largura, altura		
		setBounds(largura / 2, 0, 660, altura);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(40, 10, 45, 15);
		getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(80, 10, 345, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o :");
		lblEndereco.setBounds(25, 50, 60, 15);
		getContentPane().add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(80, 45, 345, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro :");
		lblBairro.setBounds(40, 85, 45, 15);
		getContentPane().add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(80, 80, 180, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP :");
		lblCep.setBounds(305, 85, 30, 15);
		getContentPane().add(lblCep);
		
		formattedCep = new JFormattedTextField();
		try{
	           javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("#####-###");
	           formattedCep = new javax.swing.JFormattedTextField(format_textField3);
	        }catch (Exception e){
	        }
		formattedCep.setBounds(335, 80, 90, 20);
		getContentPane().add(formattedCep);
		
		JLabel lblMunicpio = new JLabel("Munic\u00EDpio :");
		lblMunicpio.setBounds(25, 125, 55, 15);
		getContentPane().add(lblMunicpio);
		
		txtMunicipio = new JTextField();
		txtMunicipio.setBounds(80, 120, 180, 20);
		getContentPane().add(txtMunicipio);
		txtMunicipio.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(290, 125, 45, 15);
		getContentPane().add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(335, 120, 90, 20);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setBounds(25, 160, 55, 15);
		getContentPane().add(lblTelefone);
		

		formattedFone = new JFormattedTextField();
		try{
	           javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("(##)####-####");
	           formattedFone = new javax.swing.JFormattedTextField(format_textField4);
	        }catch (Exception e){
	        }
		formattedFone.setBounds(80, 155, 180, 20);
		getContentPane().add(formattedFone);
		
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(45, 190, 45, 15);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(80, 190, 185, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular :");
		lblCelular.setBounds(290, 160, 45, 15);
		getContentPane().add(lblCelular);
		
		formattedCelular = new JFormattedTextField();
		try{
	           javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("(##)#####-####");
	   		   formattedCelular = new javax.swing.JFormattedTextField(format_textField4);
	        }catch (Exception e){
	        }
		formattedCelular.setBounds(335, 155, 90, 20);
		getContentPane().add(formattedCelular);
	
		JLabel lblCpf = new JLabel("CPF :");
		lblCpf.setBounds(305, 190, 30, 15);
		getContentPane().add(lblCpf);
		
		formattedCPf = new JFormattedTextField();
		try{
	           javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
	           formattedCPf = new javax.swing.JFormattedTextField(format_textField4);
	        }catch (Exception e){
	        }
		formattedCPf.setBounds(335, 190, 90, 20);
		getContentPane().add(formattedCPf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento :");
		lblDataDeNascimento.setBounds(25, 225, 160, 15);
		getContentPane().add(lblDataDeNascimento);
		final MaskFormatter formatter = new MaskFormatter();
		try {
			formatter.setMask("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setNome(txtNome.getText());
				cliente.setEndereco(txtEndereco.getText());
				cliente.setBairro(txtBairro.getText());
				cliente.setMunicipio(txtMunicipio.getText());
				cliente.setTelefone(formattedFone.getText());
				cliente.setEmail(txtEmail.getText());
				cliente.setCep(formattedCep.getText());
				cliente.setEstado(txtEstado.getText());
				cliente.setCelular(formattedCelular.getText());
				if (dataNascimento.getDate() != null) {
					Date data = Date.from(dataNascimento.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
					cliente.setDataDeNascimento(data);
				}
				cliente.setCpf(formattedCPf.getText());
				String retorno = ClienteControl.salvar(cliente);
				JOptionPane.showMessageDialog(null, retorno);
				limpar();
			}

			private void limpar() {
				
				txtNome.setText(""); 
				txtEndereco.setText(""); 
				txtBairro.setText(""); 
				txtMunicipio.setText("");
				formattedFone.setText("");
				txtEmail.setText("");
				formattedCep.setText("");
				txtEstado.setText("");
				formattedCelular.setText("");
				formattedCPf.setText("");
				}
				
			
		});
		btnSalvar.setBounds(120, 270, 90, 25);
		getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();	
			}
		});
		btnCancelar.setBounds(230, 270, 90, 25);
		getContentPane().add(btnCancelar);

		dataNascimento = new DatePicker();
		dataNascimento.setBounds(135, 220, 250, 25);
		this.getContentPane().add(dataNascimento);
	} 
	
	private void cancelar() {
		this.dispose();
	}
}