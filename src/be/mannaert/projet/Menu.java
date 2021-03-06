package be.mannaert.projet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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
						JOptionPane.showMessageDialog(null, "Suppression effectu�e");
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
		btnAfficherJeux.setBounds(10, 65, 230, 40);
		contentPane.add(btnAfficherJeux);
		
		JButton btnListEx = new JButton("Afficher ma liste d'exemplaires");
		btnListEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeExemplaires l = new ListeExemplaires(u);
				l.setVisible(true);
				dispose();
			}
		});
		btnListEx.setBounds(10, 116, 230, 40);
		contentPane.add(btnListEx);
		
		JButton btnVoirRes = new JButton("Afficher ma liste de r\u00E9servations");
		btnVoirRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListRes l = new ListRes(u);
				l.setVisible(true);
				dispose();
			}
		});
		btnVoirRes.setBounds(10, 167, 230, 40);
		contentPane.add(btnVoirRes);
		
		JButton btnListPret = new JButton("Afficher ma liste d'emprunts");
		btnListPret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListePret l = new ListePret(u);
				l.setVisible(true);
				dispose();
			}
		});
		btnListPret.setBounds(10, 218, 230, 40);
		contentPane.add(btnListPret);
		
		JLabel lblListJeux = new JLabel("Voyez quels jeux sont disponibles sur la plateforme \r");
		lblListJeux.setVerticalAlignment(SwingConstants.TOP);
		lblListJeux.setBounds(250, 65, 274, 40);
		contentPane.add(lblListJeux);
		
		JLabel lblListEx = new JLabel("Afficher vos exemplaires");
		lblListEx.setVerticalAlignment(SwingConstants.TOP);
		lblListEx.setBounds(250, 116, 274, 40);
		contentPane.add(lblListEx);
		
		JLabel lblNewLabel = new JLabel("Afficher vos r\u00E9servation \r\net annulez si besoin");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(250, 167, 274, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnAdmin = new JButton("Fonctions Admin");
		btnAdmin.setBounds(10, 269, 230, 30);
		if(!u.getAdmin()) {
			btnAdmin.setVisible(false);
		}
		contentPane.add(btnAdmin);
		
		JLabel lblEmprunts = new JLabel("Afficher les pr\u00EAts que vous avez fait");
		lblEmprunts.setBounds(250, 218, 274, 40);
		contentPane.add(lblEmprunts);
	}
}
