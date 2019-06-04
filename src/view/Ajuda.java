package view;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ajuda extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajuda frame = new Ajuda();
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
	public Ajuda() {
		setClosable(true);
		setTitle("Tire as suas D\u00FAvidas");
		setToolTipText("");
		setBounds(100, 100, 315, 300);
		getContentPane().setLayout(null);
		
		JLabel lblDigiteAquiAs = new JLabel("Digite aqui a sua D\u00FAvida ");
		lblDigiteAquiAs.setBounds(34, 12, 184, 15);
		getContentPane().add(lblDigiteAquiAs);
		
		textField = new JTextField();
		textField.setBounds(12, 39, 281, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					URI uri = new URI("https://www.google.com/search?q=" + URLEncoder.encode(textField.getText(), "UTF-8"));
					Desktop.getDesktop().browse(uri);
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (URISyntaxException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnPesquisar.setBounds(12, 70, 117, 25);
		getContentPane().add(btnPesquisar);
		
		JButton button = new JButton("www.google.com");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					try {
						URI uri = new URI("https://www.google.com.br");
						Desktop.getDesktop().browse(uri);
					} catch (IOException | URISyntaxException ex) {
						ex.printStackTrace();
					}
					}
				}
			});
		button.setBounds(127, 70, 166, 25);
			getContentPane().add(button);

		}
	}

