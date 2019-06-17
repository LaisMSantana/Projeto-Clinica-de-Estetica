package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

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

import com.github.lgooddatepicker.components.DateTimePicker;

import controller.AgendamentoControl;
import model.dao.AgendamentoDAO;
import model.util.GeradordePlanilha;

public class TelaInicial extends JFrame {

	private JDesktopPane desktopPane;
	private JTable table;
	private Ajuda ajuda;
	private CadastroFuncionario cadastroFuncionario;
	private CadastroCliente cadastroCliente;
	private ListagemFuncionario listagemFuncionario;
	private TelaSobre telaSobre;
	private CadastroProcedimento cadastroP;
	private JTextField txtDigite;
	private JTextField txtNomeCliente;
	private CadastroProcedimento agendaP;
	private Agendamento novoAgendamento;
	private ListagemClientes listagemC;
	private AgendamentoControl agendamentoControl = new AgendamentoControl();

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
		// consulta o tamanho do monitor do usuário
		Dimension dimension = this.getToolkit().getScreenSize();
		final int larguraDaTela = (int) dimension.getWidth();
		final int alturaDaTela = (int) dimension.getHeight();
		//final int larguraDaTela = 1000;
		//final int alturaDaTela = 1000;
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(204, 153, 204));
		desktopPane.setSize(larguraDaTela - 10, alturaDaTela - 10);
		desktopPane.setLocation(20, 90);
		this.getContentPane().add(desktopPane);

		this.setTitle("Vendas");
		this.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, larguraDaTela, 20);
		this.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Cliente");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar Novo");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cadastroCliente == null) {
					cadastroCliente = new CadastroCliente(larguraDaTela, alturaDaTela);
					adicionarComponente(cadastroCliente);
					cadastroCliente.show();
				} else if (cadastroCliente != null) {
					cadastroCliente.setVisible(true);
				}
			}
		});

		JMenuItem mntmListagem = new JMenuItem("Listar Clientes");
		mntmListagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listagemC == null) {
					listagemC = new ListagemClientes();
					desktopPane.add(listagemC);
					listagemC.show();
				} else if (listagemC != null) {
				}
			}
		});
		mnNewMenu.add(mntmListagem);

		JMenuItem mntmRelatrio = new JMenuItem("Relatorio");
		mnNewMenu.add(mntmRelatrio);

		JMenu mnFuncionario = new JMenu("Funcionario");
		menuBar.add(mnFuncionario);

		JMenuItem mntmCadastrarNovo = new JMenuItem("Cadastrar Novo");
		mntmCadastrarNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cadastroFuncionario == null) {
					cadastroFuncionario = new CadastroFuncionario();
					adicionarComponente(cadastroFuncionario);
					cadastroFuncionario.show();
				} else if (cadastroFuncionario != null) {
					cadastroFuncionario.setVisible(true);
				}
			}
		});
		mnFuncionario.add(mntmCadastrarNovo);

		JMenuItem mntmListarFuncionarios = new JMenuItem("Listar Funcionários");
		mntmListarFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listagemFuncionario == null) {
					listagemFuncionario = new ListagemFuncionario();
					desktopPane.add(listagemFuncionario);
					listagemFuncionario.show();
				} else if (listagemFuncionario != null) {
					listagemFuncionario.setVisible(true);
				}
			}
		});
		mnFuncionario.add(mntmListarFuncionarios);

		JMenuItem mntmRelatorio = new JMenuItem("Relatório");
		mnFuncionario.add(mntmRelatorio);

		JMenu mnProcedimentos = new JMenu("Procedimentos");
		menuBar.add(mnProcedimentos);

		JMenuItem mntmAgendarProcedimento = new JMenuItem("Agendar Procedimento");
		mntmAgendarProcedimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cadastroP == null) {
					cadastroP = new CadastroProcedimento();
					adicionarComponente(cadastroP);
					cadastroP.show();
				} else if (cadastroP != null) {
					cadastroP.setVisible(true);
				}
			}
		});

		mnProcedimentos.add(mntmAgendarProcedimento);

		JMenuItem mntmCadastrarProcedimento = new JMenuItem("Cadastrar Procedimento");
		mntmCadastrarProcedimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (agendaP == null) {
					agendaP = new CadastroProcedimento();
					desktopPane.add(agendaP);
					agendaP.show();
				} else if (agendaP != null) {
					agendaP.setVisible(true);
				}
			}
		});
		mnProcedimentos.add(mntmCadastrarProcedimento);

		JMenuItem mntmAgendarProcedimento_1 = new JMenuItem("Agendar Procedimento");
		mntmAgendarProcedimento_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (novoAgendamento == null) {
					novoAgendamento = new Agendamento();
					desktopPane.add(novoAgendamento);
					novoAgendamento.show();
				} else if (novoAgendamento != null) {
					novoAgendamento.setVisible(true);
				}
			}
		});

		mnProcedimentos.add(mntmAgendarProcedimento_1);

		JMenuItem mntmRelatrios = new JMenuItem("Relatório");
		mnProcedimentos.add(mntmRelatrios);

		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);

		JMenuItem mntmAgendamentos = new JMenuItem("Agendamentos");
		mntmAgendamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel", "xlsx");
				fileChooser.setFileFilter(filter);
				if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					String caminhoArquivo = file.getAbsolutePath();
					String mensagem = agendamentoControl.gerarRelatorio(caminhoArquivo);
					JOptionPane.showMessageDialog(null, mensagem);
				}

			}
		});
		mnRelatrios.add(mntmAgendamentos);

		JMenu mnAjuda = new JMenu("Ajuda?");
		menuBar.add(mnAjuda);

		JMenuItem mntmSobreOPrograma = new JMenuItem("Sobre o Programa");
		mntmSobreOPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (telaSobre == null) {
					telaSobre = new TelaSobre();
					desktopPane.add(telaSobre);
					telaSobre.show();
				} else if (telaSobre != null) {
					telaSobre.setVisible(true);
				}
			}
		});
		mnAjuda.add(mntmSobreOPrograma);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ajuda == null) {
					ajuda = new Ajuda();
					adicionarComponente(ajuda);
					ajuda.show();
				} else if (ajuda != null) {
					ajuda.setVisible(true);
				}
			}
		});
		mnAjuda.add(mntmAjuda);

		this.getContentPane().setBackground(new Color(221, 160, 221));
		this.getContentPane().setBounds(10, 20, larguraDaTela - 15, alturaDaTela - 15);
		this.getContentPane().setLayout(null);

		final DateTimePicker dataTeste = new DateTimePicker();
		dataTeste.setBounds(250, 47, 300, 25);
		this.getContentPane().add(dataTeste);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Atributos próprios do componente datePicker (date e time)
				LocalDate dataSelecionada = dataTeste.getDatePicker().getDate();
				LocalTime horaSelecionada = dataTeste.getTimePicker().getTime();

				JOptionPane.showMessageDialog(null, "Data selecionada: " + dataSelecionada.toString());
				JOptionPane.showMessageDialog(null, "Horário selecionado: " + horaSelecionada.toString());

				// Preenche uma data utilizando os dois campos do componente
				Date dataCompleta = new Date(dataSelecionada.getYear(), dataSelecionada.getMonthValue(),
						dataSelecionada.getDayOfMonth(), horaSelecionada.getHour(), horaSelecionada.getMinute(),
						horaSelecionada.getSecond());
			}
		});
		btnPesquisar.setBounds(560, 50, 130, 25);
		this.getContentPane().add(btnPesquisar);

		TabelaAgendamento tabela = new TabelaAgendamento(larguraDaTela / 2, alturaDaTela - 15);
		desktopPane.add(tabela);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(20, 50, 220, 20);
		getContentPane().add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		JLabel lblNomeDoCliente = new JLabel("Nome Do Cliente:");
		lblNomeDoCliente.setBounds(20, 30, 122, 15);
		getContentPane().add(lblNomeDoCliente);
		tabela.show();
	}
}