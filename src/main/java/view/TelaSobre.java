package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

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
		setClosable(true);
		setTitle("Sobre");
		setBounds(100, 100, 644, 468);
		getContentPane().setLayout(null);
		
		JTextPane txtpnSobre = new JTextPane();
		txtpnSobre.setForeground(new Color(0, 0, 0));
		txtpnSobre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnSobre.setText("O Sistema foi desenvolvido com o intuito de automatizar e gerenciar as funcionalidades de uma Cl\u00EDnica Est\u00E9tica, agilizando e armazenando as informa\u00E7\u00F5es dos processos da Cl\u00EDnica. Tem enfoque na atua\u00E7\u00E3o dos Funcion\u00E1rios que seriam os operadores do sistema."
				+ "Foi Desenvolvido por:Jhully,Lais,Natalia.");
		txtpnSobre.setBounds(12, 289, 622, 135);
		getContentPane().add(txtpnSobre);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaSobre.class.getResource("/icones/sobre.png")));
		label.setBounds(147, 0, 262, 247);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Vers\u00E3o 1.0");
		label_1.setForeground(Color.BLACK);
		label_1.setBounds(237, 239, 116, 15);
		getContentPane().add(label_1);

	}
}
