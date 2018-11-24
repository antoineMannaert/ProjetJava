package be.mannaert.projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Menu(User u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelBienvenue = new JLabel("Bienvenue " + u.getPseudo());
		labelBienvenue.setBounds(10, 11, 123, 20);
		contentPane.add(labelBienvenue);
		
		JButton btnDeco = new JButton("Se d\u00E9connecter");
		btnDeco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnDeco.setBounds(284, 210, 140, 40);
		contentPane.add(btnDeco);
		
		JLabel labelSolde = new JLabel("Solde" + u.getSolde());
		labelSolde.setBounds(349, 11, 75, 20);
		contentPane.add(labelSolde);
	}
}
