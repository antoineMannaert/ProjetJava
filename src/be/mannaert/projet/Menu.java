package be.mannaert.projet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		setBounds(100, 100, 550, 400);
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
		btnDeco.setBounds(374, 310, 150, 40);
		contentPane.add(btnDeco);
		
		JLabel labelSolde = new JLabel("Solde : " + u.getSolde());
		labelSolde.setBounds(449, 11, 75, 20);
		contentPane.add(labelSolde);
		
		JButton btnSupp = new JButton("Supprimer compte");
		btnSupp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserDAO dao = new UserDAO(ProjetConnection.getInstance());
				
				try {
					
					if(dao.delete(u)) {
						JOptionPane.showMessageDialog(null, "Suppression effectuée");
						Login l = new Login();
						l.setVisible(true);
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
		});
		btnSupp.setBounds(214, 310, 150, 40);
		contentPane.add(btnSupp);
		
		JButton btnChangerMDP = new JButton("Changer Mot de passe");
		btnChangerMDP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangerMDP c = new ChangerMDP(u);
				c.setVisible(true);
				dispose();
			}
		});
		btnChangerMDP.setBounds(10, 310, 194, 40);
		contentPane.add(btnChangerMDP);
		
		JButton btnAfficherJeux = new JButton("Afficher la liste des jeux");
		btnAfficherJeux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeJeux lJeux = new ListeJeux(u);
				lJeux.setVisible(true);
				dispose();
			}
		});
		btnAfficherJeux.setBounds(10, 65, 194, 40);
		contentPane.add(btnAfficherJeux);
	}
}
