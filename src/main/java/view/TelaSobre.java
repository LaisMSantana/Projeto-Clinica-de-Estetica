package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.DropMode;
import java.awt.Color;

public class TelaSobre extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSobre frame = new TelaSobre();
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
	public TelaSobre() {
		setTitle("Sobre");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JTextPane txtpnSobre = new JTextPane();
		txtpnSobre.setForeground(new Color(0, 0, 0));
		txtpnSobre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnSobre.setText("O Sistema foi desenvolvido com o intuito de automatizar e gerenciar as funcionalidades de uma Cl\u00EDnica Est\u00E9tica, agilizando e armazenando as informa\u00E7\u00F5es dos processos da Cl\u00EDnica. Tem enfoque na atua\u00E7\u00E3o dos Funcion\u00E1rios que seriam os operadores do sistema.");
		txtpnSobre.setBounds(0, 0, 434, 264);
		getContentPane().add(txtpnSobre);

	}

}
