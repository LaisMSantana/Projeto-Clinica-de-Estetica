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
import java.awt.SystemColor;

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
		setBounds(100, 100, 670, 460);
		getContentPane().setLayout(null);
		
		JTextPane txtpnSobre = new JTextPane();
		txtpnSobre.setBackground(SystemColor.menu);
		txtpnSobre.setForeground(new Color(0, 0, 0));
		txtpnSobre.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		txtpnSobre.setText("Bem Vindo você adquiriu o sistema que foi desenvolvido pensando na sua Clínica de Estética, com o intuito de automatizar e gerenciar as funcionalidades de sua Cl\u00EDnica, podendo assim agilizar e armazenar as informa\u00E7\u00F5es dos processos da Cl\u00EDnica. Tem enfoque na atua\u00E7\u00E3o dos Funcion\u00E1rios que seriam os operadores do sistema."
				+ "\nFoi Desenvolvido por: Jhully, Lais, Natália.");
		txtpnSobre.setBounds(10, 153, 634, 224);
		getContentPane().add(txtpnSobre);
		
		JLabel lblImagem = new JLabel("");
//		lblImagem.setIcon(new ImageIcon(TelaSobre.class.getResource("/main/java/icones/icons8-sobre-150.png")));
		lblImagem.setBounds(365, 0, 163, 164);
		getContentPane().add(lblImagem);
		
		JLabel lblVersao = new JLabel("Vers\u00E3o 1.0");
		lblVersao.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		lblVersao.setForeground(Color.BLACK);
		lblVersao.setBounds(270, 94, 116, 15);
		getContentPane().add(lblVersao);
		
		JLabel lblSobreClnica = new JLabel("Sobre Cl\u00EDnica");
		lblSobreClnica.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 30));
		lblSobreClnica.setBounds(210, 45, 209, 38);
		getContentPane().add(lblSobreClnica);

	}
}
