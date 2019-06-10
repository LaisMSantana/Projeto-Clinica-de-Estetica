package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DateTimePicker;

public class TelaInicial extends JFrame {

	private JDesktopPane desktopPane;
	private JTable table;
	private Ajuda ajuda;
	private CadastroFuncionario cadastroFuncionario;
	private ListagemFuncionario listagemFuncionario;
	private TelaSobre telaSobre;
	private CadastroProcedimento cadastroP;
	private JTextField txtDigite;

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

	private void adicionarComponente(Component c){
		this.getContentPane().add(c);
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		// consulta o tamanho do monitor do usuário		
		Dimension dimension = this.getToolkit().getScreenSize();
		int larguraDaTela = (int) dimension.getWidth();
		int alturaDaTela = (int) dimension.getHeight();

		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		desktopPane = new JDesktopPane();

		this.setTitle("Vendas");
		this.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, larguraDaTela, 20);
		this.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Cliente");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar Novo");
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmListagem = new JMenuItem("Listar Clientes");
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

		JMenuItem mntmListarFuncionarios = new JMenuItem("Listar Funcion\u00E1rios");
		mntmListarFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listagemFuncionario == null) {
					listagemFuncionario = new ListagemFuncionario();
					adicionarComponente(listagemFuncionario);
					listagemFuncionario.show();
				} else if (listagemFuncionario != null) {
					listagemFuncionario.setVisible(true);
				}
			}
		});
		mnFuncionario.add(mntmListarFuncionarios);

		JMenuItem mntmRelatorio = new JMenuItem("Relat\u00F3rio");
		mnFuncionario.add(mntmRelatorio);

		JMenu mnProcedimentos = new JMenu("Procedimentos");
		menuBar.add(mnProcedimentos);

		JMenuItem mntmAgendarProcedimento = new JMenuItem("Agendar Procedimento");
		mnProcedimentos.add(mntmAgendarProcedimento);

		JMenuItem mntmCadastrarProcedimemento = new JMenuItem("Cadastrar Procedimento");
		mntmCadastrarProcedimemento.addActionListener(new ActionListener() {
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

		mnProcedimentos.add(mntmCadastrarProcedimemento);

		JMenuItem mntmRelatrios = new JMenuItem("Relatorio");
		mnProcedimentos.add(mntmRelatrios);

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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 78, 520, 437);
		this.getContentPane().add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);

		//TODO testar o tamanho
		table.setBounds(280, 485, larguraDaTela / 2, 225);
		table.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setToolTipText("Biom\u00E9dica\nConsultora\nEsteticista\n");
		table.setModel(
				new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
								"Cliente", "Nome Procedimento", "Data", "Hor\u00E1rio", "Sala"
						}
						));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.setBounds(10, 483, 784, 360);
		scrollPane.setViewportView(table);
//
//		txtDigite = new JTextField();
//		txtDigite.setBounds(10, 47, 185, 20);
//		//		this.getContentPane().add(txtDigite);
//		txtDigite.setColumns(10);

		final DateTimePicker dataTeste = new DateTimePicker();
		dataTeste.setBounds(150, 47, 300, 30);
		this.getContentPane().add(dataTeste);

		JButton btnPegarData = new JButton("Criar data (java.util.Date)");
		btnPegarData.addActionListener(new ActionListener() {
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
		btnPegarData.setBounds(500, 47, 180, 23);
		this.getContentPane().add(btnPegarData);
	}
}