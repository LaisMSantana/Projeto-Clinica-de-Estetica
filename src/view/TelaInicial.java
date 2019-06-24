package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.github.lgooddatepicker.components.DatePicker;

import controller.AgendamentoControl;
import model.bo.AgendamentoBO;
import model.vo.Agendamento;
import model.vo.Cliente;

public class TelaInicial extends JFrame {

	private JDesktopPane desktopPane;
	private Ajuda ajuda;
	private CadastroFuncionario cadastroFuncionario;
	private CadastroCliente cadastroCliente;
	private ListagemFuncionario listagemFuncionario;
	private TelaSobre telaSobre;
	private CadastroProcedimento cadastroP;
	private JTextField txtDigite;
	private JTextField txtNomeCliente;
	private DatePicker dataFiltro;
	private TabelaAgendamento tabela;
	private CadastroProcedimento agendaP;
	private CadastroAgendamento novoAgendamento;
	private ListagemClientes listagemC;
	private AgendamentoControl agendamentoControl = new AgendamentoControl();
	private model.vo.Agendamento agendamento;
	private BufferedImage img;
	private AbstractButton ttxtNomeCliente;
	private Object dataSelecionada;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					// Inicializa a tela principal Maximizada
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void adicionarComponente(JInternalFrame c) {
		this.desktopPane.add(c);
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		Dimension dimension = this.getToolkit().getScreenSize();
		 final int larguraDaTela = (int) dimension.getWidth();
		  final int alturaDaTela = (int) dimension.getHeight();
		 try {
            img = ImageIO.read(new URL("http://celiaprado.com.br/wp-content/uploads/2018/04/estetica-corporal.jpg"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		desktopPane = new JDesktopPane() {
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                grphcs.drawImage(img, 0, 0, null);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(larguraDaTela, alturaDaTela);
            }
        };
		 
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/jhully/\u00C1rea de Trabalho/icones/icons8-flor-de-spa-30.png"));
//		setBackground(Color.PINK);
		// consulta o tamanho do monitor do usuário
		 
		 //final int larguraDaTela = 1500;
		 //final int alturaDaTela = 1500;
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//		desktopPane.setBackground(Color.PINK);
		desktopPane.setSize(larguraDaTela - 10, alturaDaTela - 10);
		desktopPane.setLocation(20, 90);
		this.getContentPane().add(desktopPane);

		this.setTitle("Clinica Estética");
		this.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 2000, 35);
		this.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Cliente");
		mnNewMenu.setIcon(new ImageIcon("/home/jhully/\u00C1rea de Trabalho/icones/icons8-flor-de-spa-30.png"));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar Novo");
		mntmNewMenuItem.setIcon(new ImageIcon("/home/jhully/\u00C1rea de Trabalho/icones/icons8-adicionar-grupo-de-usu\u00E1rios-mulher-homem-50.png"));
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cadastroCliente == null) {
					cadastroCliente = new CadastroCliente(larguraDaTela, alturaDaTela);
					adicionarComponente(cadastroCliente);
					cadastroCliente.show();
				} else if (cadastroCliente != null) {
					cadastroCliente.setVisible(true);
					cadastroCliente.show();
					desktopPane.add(cadastroCliente);
					desktopPane.moveToFront(cadastroCliente);
				}
			}
		});

		JMenuItem mntmListagem = new JMenuItem("Listar Clientes");
		mntmListagem.setIcon(new ImageIcon("/home/jhully/git/projetoClinica-Estetica2/src/main/java/icones/icons8-documento-regular.png"));
		mntmListagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listagemC == null) {
					listagemC = new ListagemClientes();
					desktopPane.add(listagemC);
					listagemC.show();
				} else if (listagemC != null) {
					listagemC.setVisible(true);
					desktopPane.add(listagemC);
					desktopPane.moveToFront(listagemC);
				}
			}
		});
		mnNewMenu.add(mntmListagem);

		JMenu mnFuncionario = new JMenu("Funcionário");
		mnFuncionario.setIcon(new ImageIcon("/home/jhully/\u00C1rea de Trabalho/icones/icons8-flor-de-spa-30.png"));
		menuBar.add(mnFuncionario);

		JMenuItem mntmCadastrarNovo = new JMenuItem("Cadastrar Novo");
		mntmCadastrarNovo.setIcon(new ImageIcon("/home/jhully/\u00C1rea de Trabalho/icones/icons8-trabalhador-50.png"));
		mntmCadastrarNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cadastroFuncionario == null) {
					cadastroFuncionario = new CadastroFuncionario();
					adicionarComponente(cadastroFuncionario);
					cadastroFuncionario.show();
				} else if (cadastroFuncionario != null) {
					cadastroFuncionario.setVisible(true);
					desktopPane.add(cadastroFuncionario);
					desktopPane.moveToFront(cadastroFuncionario);
				}
			}
		});
		mnFuncionario.add(mntmCadastrarNovo);

		JMenuItem mntmListarFuncionarios = new JMenuItem("Listar Funcionários");
		mntmListarFuncionarios.setIcon(new ImageIcon("/home/jhully/\u00C1rea de Trabalho/icones/icons8-documento-regular.png"));
		mntmListarFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listagemFuncionario == null) {
					listagemFuncionario = new ListagemFuncionario();
					desktopPane.add(listagemFuncionario);
					listagemFuncionario.show();
				} else if (listagemFuncionario != null) {
					listagemFuncionario.setVisible(true);
					desktopPane.add(listagemFuncionario);
					desktopPane.moveToFront(listagemFuncionario);
				}
			}
		});
		mnFuncionario.add(mntmListarFuncionarios);

		JMenu mnProcedimentos = new JMenu("Procedimentos");
		mnProcedimentos.setIcon(new ImageIcon("/home/jhully/\u00C1rea de Trabalho/icones/icons8-flor-de-spa-30.png"));
		menuBar.add(mnProcedimentos);

		JMenuItem mntmAgendarProcedimento = new JMenuItem("Cadastrar  Procedimento");
		mntmAgendarProcedimento.setIcon(new ImageIcon("/home/jhully/\u00C1rea de Trabalho/icones/icons8-barris-de-madeira-30.png"));
		mntmAgendarProcedimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cadastroP == null) {
					cadastroP = new CadastroProcedimento();
					adicionarComponente(cadastroP);
					cadastroP.show();
				} else if (cadastroP != null) {
					cadastroP.setVisible(true);
					desktopPane.add(cadastroP);
					desktopPane.moveToFront(cadastroP);
				}
			}
		});

		mnProcedimentos.add(mntmAgendarProcedimento);

		JMenuItem mntmAgendarProcedimento_1 = new JMenuItem("Novo Agendamento");
		mntmAgendarProcedimento_1.setIcon(new ImageIcon("/home/jhully/\u00C1rea de Trabalho/icones/icons8-adicionar-a-lista-50.png"));
		mntmAgendarProcedimento_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (novoAgendamento == null) {
					novoAgendamento = new CadastroAgendamento();
					desktopPane.add(novoAgendamento);
					novoAgendamento.show();
				} else if (novoAgendamento != null) {
					novoAgendamento.setVisible(true);
					desktopPane.add(novoAgendamento);
					desktopPane.moveToFront(novoAgendamento);
				}
			}
		});

		mnProcedimentos.add(mntmAgendarProcedimento_1);

		JMenu mnAjuda = new JMenu("Ajuda?");
		mnAjuda.setIcon(new ImageIcon("/home/jhully/\u00C1rea de Trabalho/icones/icons8-flor-de-spa-30.png"));
		menuBar.add(mnAjuda);

		JMenuItem mntmSobreOPrograma = new JMenuItem("Sobre o Programa");
		mntmSobreOPrograma.setIcon(new ImageIcon("/home/jhully/\u00C1rea de Trabalho/icones/icons8-confian\u00E7a.png"));
		mntmSobreOPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (telaSobre == null) {
					telaSobre = new TelaSobre();
					desktopPane.add(telaSobre);
					telaSobre.show();
				} else if (telaSobre != null) {
					telaSobre.setVisible(true);
					desktopPane.add(telaSobre);
					desktopPane.moveToFront(telaSobre);
				}
			}
		});
		mnAjuda.add(mntmSobreOPrograma);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.setIcon(new ImageIcon("/home/jhully/\u00C1rea de Trabalho/icones/icons8-por-que-n\u00F3s-feminino-50.png"));
		mntmAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ajuda == null) {
					ajuda = new Ajuda();
					adicionarComponente(ajuda);
					ajuda.show();
				} else if (ajuda != null) {
					ajuda.setVisible(true);
					desktopPane.add(ajuda);
					desktopPane.moveToFront(ajuda);
				}
			}
		});
		mnAjuda.add(mntmAjuda);

		this.getContentPane().setBackground(Color.PINK);
		this.getContentPane().setBounds(10, 20, larguraDaTela - 15, alturaDaTela - 15);
		this.getContentPane().setLayout(null);

		dataFiltro = new DatePicker();
		dataFiltro.setBounds(250, 50, 300, 30);
		this.getContentPane().add(dataFiltro);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// Atributos próprios do componente datePicker (date e time)
				LocalDate dataSelecionada = dataFiltro.getDate();
				List<Agendamento> agendamentos = agendamentoControl.listarTodosAgendamentos(txtNomeCliente.getText(), dataSelecionada);
				tabela.atualizarTabela(agendamentos);
			}
		});
		btnPesquisar.setBounds(560, 50, 130, 25);
		this.getContentPane().add(btnPesquisar);

		tabela = new TabelaAgendamento(larguraDaTela / 4, alturaDaTela - 50);
		desktopPane.add(tabela);
		
		JButton btnExcluirAgendamento = new JButton("Excluir");
		btnExcluirAgendamento.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				Integer idAgendamento = tabela.getIdSelecionado();
				agendamentoControl.excluirAgendamento(idAgendamento);
				LocalDate dataSelecionada = dataFiltro.getDate();
				List<Agendamento> agendamentos = agendamentoControl.listarTodosAgendamentos(txtNomeCliente.getText(), dataSelecionada);
				tabela.atualizarTabela(agendamentos);
				
			}
		});
		btnExcluirAgendamento.setBounds(559, 22, 80, 28);
		tabela.getContentPane().add(btnExcluirAgendamento);
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(20, 50, 220, 30);
		getContentPane().add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		JLabel lblNomeDoCliente = new JLabel("Nome Do Cliente:");
		lblNomeDoCliente.setBounds(37, 36, 122, 15);
		getContentPane().add(lblNomeDoCliente);
		
		JButton btnGerarPlanilha = new JButton("Gerar Planilha");
		btnGerarPlanilha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel", "xlsx");
				fileChooser.setFileFilter(filter);
				if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					String caminhoArquivo = file.getAbsolutePath();
					LocalDate dataSelecionada = dataFiltro.getDate();
					String mensagem = agendamentoControl.gerarRelatorio(caminhoArquivo, txtNomeCliente.getText(), dataSelecionada);
					JOptionPane.showMessageDialog(null, mensagem);
				}

			}
		});
			
		btnGerarPlanilha.setBounds(702, 50, 135, 25);
		getContentPane().add(btnGerarPlanilha);
		tabela.show();
		List<Agendamento> agendamentos = agendamentoControl.listarTodosAgendamentos(null, null);
		tabela.atualizarTabela(agendamentos);
	}
}