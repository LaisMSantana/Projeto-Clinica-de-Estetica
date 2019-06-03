package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Ajuda ajuda;
	private CadastroFuncionario cadastroFuncionario;
	private ListagemFuncionario listagemFuncionario;
	private TelaSobre sobreOPrograma;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 918, 547);

		contentPane = new JPanel();
		contentPane.setToolTipText("Vendas");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 916, 21);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Cliente");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar Novo");
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmListagem = new JMenuItem("Listar Clientes");
		mnNewMenu.add(mntmListagem);

		JMenuItem mntmRelatrio = new JMenuItem("Relat\u00F3rio");
		mnNewMenu.add(mntmRelatrio);

		JMenu mnFuncionrio = new JMenu("Funcion\u00E1rio");
		menuBar.add(mnFuncionrio);

		JMenuItem mntmCadastrarNovo = new JMenuItem("Cadastrar Novo");
		mntmCadastrarNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cadastroFuncionario == null) {
					cadastroFuncionario = new CadastroFuncionario();
					desktopPane.add(cadastroFuncionario);
					cadastroFuncionario.show();
				} else if (cadastroFuncionario != null) {
					cadastroFuncionario.setVisible(true);
				}
			}
		});
		mnFuncionrio.add(mntmCadastrarNovo);

		JMenuItem mntmListarFuncionrios = new JMenuItem("Listar Funcion\u00E1rios");
		mntmListarFuncionrios.addActionListener(new ActionListener() {
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
		mnFuncionrio.add(mntmListarFuncionrios);

		JMenuItem mntmRelatrio_1 = new JMenuItem("Relat\u00F3rio");
		mnFuncionrio.add(mntmRelatrio_1);

		JMenu mnProcedimentos = new JMenu("Procedimentos");
		menuBar.add(mnProcedimentos);

		JMenuItem mntmAgendarProcedimento = new JMenuItem("Agendar Procedimento");
		mnProcedimentos.add(mntmAgendarProcedimento);

		JMenuItem mntmCadastrarProcedimemento = new JMenuItem("Cadastrar Procedimento");
		mnProcedimentos.add(mntmCadastrarProcedimemento);

		JMenuItem mntmRelatrios = new JMenuItem("Relatorio");
		mnProcedimentos.add(mntmRelatrios);

		JMenu mnAjuda = new JMenu("Ajuda?");
		menuBar.add(mnAjuda);

		JMenuItem mntmSobreOPrograma = new JMenuItem("Sobre o Programa");
		mntmSobreOPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sobreOPrograma == null) {
					sobreOPrograma = new TelaSobre();
					desktopPane.add(sobreOPrograma);
					sobreOPrograma.show();
				} else if (sobreOPrograma != null) {
					sobreOPrograma.setVisible(true);
				}
			}
		});
		mnAjuda.add(mntmSobreOPrograma);

		JMenuItem mntmAjuda_1 = new JMenuItem("Ajuda");
		mntmAjuda_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ajuda == null) {
					ajuda = new Ajuda();
					desktopPane.add(ajuda);
					ajuda.show();
				} else if (ajuda != null) {
					ajuda.setVisible(true);
				}
			}
		});
		mnAjuda.add(mntmAjuda_1);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(221, 160, 221));
		desktopPane.setBounds(10, 22, 900, 194);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);

		JLabel lblPerodo = new JLabel("Periodo :");
		lblPerodo.setBounds(402, 27, 46, 14);
		 contentPane.add(lblPerodo);

		JComboBox cbPeriodo = new JComboBox();
		 cbPeriodo.setBounds(477, 24, 156, 20);
		 contentPane.add(cbPeriodo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 219, 916, 278);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBounds(282, 483, 512, -227);
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

	}
}
