package be.mannaert.projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ListeExemplaires extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ExemplaireDAO edao = new ExemplaireDAO(ProjetConnection.getInstance());
	private UserDAO udao = new UserDAO(ProjetConnection.getInstance());

	/**
	 * Create the frame.
	 */
	public ListeExemplaires(User u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelBienvenue = new JLabel("Liste de vos exemplaires de jeux");
		labelBienvenue.setBounds(10, 11, 414, 30);
		contentPane.add(labelBienvenue);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 414, 150);
		contentPane.add(scrollPane);
		
		JList<Exemplaire> list = new JList<>(edao.findAll(u.getIdUser()));
		scrollPane.setViewportView(list);
		
		JButton btnMenu = new JButton("Retour");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu(u);
				m.setVisible(true);
				dispose();
			}
		});
		btnMenu.setBounds(220, 220, 204, 30);
		contentPane.add(btnMenu);
		
		JButton btnSupp = new JButton("Supprimer l'exemplaire");
		btnSupp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Exemplaire ex = list.getSelectedValue();
				
				if(ex != null) {

					try {
						
						if(edao.delete(ex)) {
							JOptionPane.showMessageDialog(null, "Suppression effectuée");
							Menu m = new Menu(udao.find(u.getIdUser()));
							m.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Suppression non valide");
						}
					}
							
					catch(Exception err) {
						System.out.println(err);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Choisissez un jeu à supprimer.");
				}
			}
		});
		btnSupp.setBounds(10, 220, 204, 30);
		contentPane.add(btnSupp);
	}
}
