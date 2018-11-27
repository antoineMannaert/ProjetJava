package be.mannaert.projet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class ListeJeux extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private UserDAO udao = new UserDAO(ProjetConnection.getInstance());
	private JeuDAO jdao = new JeuDAO(ProjetConnection.getInstance());
	private ConsoleDAO cdao = new ConsoleDAO(ProjetConnection.getInstance());
	private ExemplaireDAO edao = new ExemplaireDAO(ProjetConnection.getInstance());
	private JTextField txtNomJeu;
	private String[] tab = new String[8];
	private JList<Jeu> listJeux;
	private Choice cConsoles;
	private JScrollPane scrollPane;
	private JButton btnAddEx;
	private JButton btnReser;
	private JButton btnRetour;

	/**
	 * Create the frame.
	 */
	public ListeJeux(User u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEntrezLeNom = new JLabel("Entrez le nom du jeu :");
		lblEntrezLeNom.setBounds(10, 11, 151, 25);
		contentPane.add(lblEntrezLeNom);
		
		txtNomJeu = new JTextField();
		txtNomJeu.setBounds(171, 11, 160, 25);
		contentPane.add(txtNomJeu);
		txtNomJeu.setColumns(10);
		
		cConsoles = new Choice();
		cConsoles.setBounds(337, 11, 80, 20);
		tab = cdao.getDiminutifs();
		cConsoles.add("-----");
		for(int i = 0; i<tab.length; i++)
			cConsoles.add(tab[i]);
		contentPane.add(cConsoles);
		
		JButton btnRecherche = new JButton("Rechercher");
		btnRecherche.setBounds(423, 11, 102, 25);
		btnRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!cConsoles.getSelectedItem().toString().equals("-----")) {
					listJeux = new JList<>(jdao.findAll(txtNomJeu.getText().toString(), cConsoles.getSelectedItem().toString()));
				}
				else {
					listJeux = new JList<>(jdao.findAll(txtNomJeu.getText().toString()));
				}
				listJeux.setBounds(10, 49, 515, 200);
				listJeux.setBorder(new LineBorder(new Color(0, 0, 0)));
				listJeux.setBackground(Color.WHITE);
				listJeux.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				contentPane.add(listJeux);
				scrollPane.setViewportView(listJeux);
				btnAddEx.setEnabled(true);
				btnReser.setEnabled(true);
			}
		});
		contentPane.add(btnRecherche);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 515, 200);
		contentPane.add(scrollPane);
		
		btnAddEx = new JButton("Ajouter un exemplaire");
		btnAddEx.setEnabled(false);
		btnAddEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jeu j = listJeux.getSelectedValue();
				Exemplaire ex;
				
				if(j != null) {
					
					ex = new Exemplaire(true, j, u);
					if(edao.create(ex)) {
						
						JOptionPane.showMessageDialog(null, "Mise à jour de votre liste d'exemplaires effectuée");
						Menu m = new Menu(udao.find(u.getIdUser()));
						m.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Mise à jour de votre liste d'exemplaires non effectuée");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Veuillez choisir un jeu!");
				}
			}
		});
		btnAddEx.setBounds(10, 260, 177, 40);
		contentPane.add(btnAddEx);
		
		btnReser = new JButton("Faire une r\u00E9servation");
		btnReser.setEnabled(false);
		btnReser.setBounds(198, 260, 177, 40);
		contentPane.add(btnReser);
		
		btnRetour = new JButton("Retour au menu");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu(u);
				m.setVisible(true);
				dispose();
			}
		});
		btnRetour.setBounds(385, 260, 140, 40);
		contentPane.add(btnRetour);
	}
}
