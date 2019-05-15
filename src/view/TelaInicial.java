package view;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTable table;

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

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

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
		mnFuncionrio.add(mntmCadastrarNovo);

		JMenuItem mntmListarFuncionrios = new JMenuItem("Listar Funcion\u00E1rios");
		mnFuncionrio.add(mntmListarFuncionrios);

		JMenuItem mntmRelatrio_1 = new JMenuItem("Relat\u00F3rio");
		mnFuncionrio.add(mntmRelatrio_1);

		JMenu mnProcedimentos = new JMenu("Procedimentos");
		menuBar.add(mnProcedimentos);

		JMenuItem mntmAgendarProcedimento = new JMenuItem("Agendar Procedimento");
		mnProcedimentos.add(mntmAgendarProcedimento);

		JMenuItem mntmCadastrarProcedimemento = new JMenuItem("Cadastrar Procedimento");
		mnProcedimentos.add(mntmCadastrarProcedimemento);

		JMenuItem mntmRelatrios = new JMenuItem("Relat\u00F3rio");
		mnProcedimentos.add(mntmRelatrios);

		JMenu mnAjuda = new JMenu("Ajuda?");
		menuBar.add(mnAjuda);

		JMenuItem mntmSobreOPrograma = new JMenuItem("Sobre o Programa");
		mnAjuda.add(mntmSobreOPrograma);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mnAjuda.add(mntmAjuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPerodo = new JLabel("Per\u00EDodo :");
		lblPerodo.setBounds(402, 27, 46, 14);
		contentPane.add(lblPerodo);

		JComboBox cbPeriodo = new JComboBox();
		cbPeriodo.setBounds(477, 24, 156, 20);
		contentPane.add(cbPeriodo);

		table = new JTable();
		table.setBounds(10, 483, 784, -360);
		contentPane.add(table);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(861, 110, 17, 366);
		contentPane.add(scrollBar);
	}
}
