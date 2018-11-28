package be.mannaert.projet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class ChoixPret extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ExemplaireDAO edao = new ExemplaireDAO(ProjetConnection.getInstance());
	private PretDAO pdao = new PretDAO(ProjetConnection.getInstance());
	private UserDAO udao = new UserDAO(ProjetConnection.getInstance());
	User newUser;

	/**
	 * Create the frame.
	 */
	public ChoixPret(User u, Jeu j) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelIntro = new JLabel("Veuillez choisir l'exemplaire pour la semaine :");
		labelIntro.setBounds(10, 11, 250, 25);
		contentPane.add(labelIntro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 414, 161);
		contentPane.add(scrollPane);
		
		JList<Exemplaire> listEx = new JList<>(edao.findAll(j.getIdJeu(), "idJeu"));
		scrollPane.setViewportView(listEx);
		
		JButton btnValider = new JButton("Valider le choix");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!listEx.isSelectionEmpty()) {
					
					Pret p = new Pret(0, new Date(0), false, listEx.getSelectedValue(), u);
					
					try {
						
						if(pdao.find(u.getIdUser(), p.getExemplaire().getIdExemplaire()) != null && pdao.find(p.getIdPret()).getFin()) {
							
							JOptionPane.showMessageDialog(null, "Vous avez déjà cet exemplaire en prêt."); //cas normalement impossible mais prudence est mère de sureté
						}
						else {
							if(pdao.create(p)) {

								JOptionPane.showMessageDialog(null, "Votre prêt a été effectué, votre solde est diminué de " + j.getTarif() + " unité(s).");
								u.setSolde(u.getSolde() - j.getTarif());
								listEx.getSelectedValue().getUser().setSolde(listEx.getSelectedValue().getUser().getSolde() + j.getTarif());
								udao.update(u);
								udao.update(listEx.getSelectedValue().getUser());
								newUser = udao.find(u.getIdUser());
								Menu m = new Menu(newUser);
								m.setVisible(true);
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Votre prêt n'a pas été effectué, désolé pour ce bug");
							}
						}
					}
					catch(Exception err) {
						System.out.println(err.getMessage());
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Veuillez choisir un exemplaire à emprunter");
				}
			}
		});
		btnValider.setBounds(10, 219, 203, 31);
		contentPane.add(btnValider);
		
		JButton btnRetour = new JButton("Annuler et retourner au menu");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu(u);
				m.setVisible(true);
				dispose();
			}
		});
		btnRetour.setBounds(223, 219, 201, 31);
		contentPane.add(btnRetour);
		
		JLabel labelSolde = new JLabel("Votre solde : " + u.getSolde());
		labelSolde.setBounds(329, 11, 95, 25);
		contentPane.add(labelSolde);
	}
}
