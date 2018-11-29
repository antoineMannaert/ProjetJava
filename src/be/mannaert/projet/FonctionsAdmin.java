package be.mannaert.projet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FonctionsAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtTarif;
	private String[] tab = new String[8];
	private ConsoleDAO cdao = new ConsoleDAO(ProjetConnection.getInstance());
	private JeuDAO jdao = new JeuDAO(ProjetConnection.getInstance());
	private JTextField txtNomJeu;
	private JTextField txtNewTarif;

	/**
	 * Create the frame.
	 */
	public FonctionsAdmin(User u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomJeu = new JLabel("Nom du Jeu : ");
		lblNomJeu.setBounds(10, 49, 77, 26);
		contentPane.add(lblNomJeu);
		
		JLabel lblAjoutJeu = new JLabel("Ajouter un jeu : ");
		lblAjoutJeu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjoutJeu.setBounds(10, 11, 201, 25);
		contentPane.add(lblAjoutJeu);
		
		txtNom = new JTextField();
		txtNom.setBounds(97, 49, 114, 26);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblTarifJeu = new JLabel("Tarif : ");
		lblTarifJeu.setBounds(10, 86, 77, 26);
		contentPane.add(lblTarifJeu);
		
		txtTarif = new JTextField();
		txtTarif.setBounds(97, 86, 114, 26);
		contentPane.add(txtTarif);
		txtTarif.setColumns(10);
		
		JLabel lblConsole = new JLabel("Console : ");
		lblConsole.setBounds(10, 123, 77, 26);
		contentPane.add(lblConsole);
		
		Choice cConsoles = new Choice();
		cConsoles.setBounds(97, 129, 114, 20);
		tab = cdao.getDiminutifs();
		cConsoles.add("-----");
		for(int i = 0; i<tab.length; i++)
			cConsoles.add(tab[i]);
		contentPane.add(cConsoles);
		
		JButton btnAjoutJeu = new JButton("Ajouter un Jeu");
		btnAjoutJeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!txtNom.getText().equals(null) && !txtTarif.getText().equals(null) && !cConsoles.getSelectedItem().equals("-----")) {
					
					try {
					
						String nom = txtNom.getText();
						int tarif = Integer.parseInt(txtTarif.getText());
						Console c = cdao.find(cConsoles.getSelectedItem());
						Jeu j = new Jeu(0, nom, tarif, c);
						Jeu oldJeu = jdao.find(j.getIdJeu());
						
						if(!j.equals(oldJeu)) {
							
							if(jdao.create(j)) {
								
								JOptionPane.showMessageDialog(null, "Jeu créé.");
								Menu m = new Menu(u);
								m.setVisible(true);
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Jeu impossible à créer.");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Jeu déjà créé.");
						}
					}
					catch(Exception err) {
						System.out.println(err.getMessage());
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Veuillez entrer toutes les informations.");
				}
			}
		});
		btnAjoutJeu.setBounds(10, 167, 201, 35);
		contentPane.add(btnAjoutJeu);
		
		JLabel lblChangerTarif = new JLabel("Changer le tarif d'un Jeu");
		lblChangerTarif.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangerTarif.setBounds(221, 11, 203, 25);
		contentPane.add(lblChangerTarif);
		
		JLabel lblJeu = new JLabel("Jeu :");
		lblJeu.setBounds(221, 49, 37, 26);
		contentPane.add(lblJeu);
		
		txtNomJeu = new JTextField();
		txtNomJeu.setBounds(268, 49, 156, 26);
		contentPane.add(txtNomJeu);
		txtNomJeu.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nouveau tarif :");
		lblNewLabel_1.setBounds(221, 86, 89, 26);
		contentPane.add(lblNewLabel_1);
		
		txtNewTarif = new JTextField();
		txtNewTarif.setBounds(320, 86, 104, 26);
		contentPane.add(txtNewTarif);
		txtNewTarif.setColumns(10);
		
		JButton btnModifTarif = new JButton("Modifier le tarif");
		btnModifTarif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!txtNomJeu.getText().equals(null) && !txtNewTarif.getText().equals(null)) {
					
					try {
						
						String nom = txtNomJeu.getText();
						int tarif = Integer.parseInt(txtNewTarif.getText());
						
						Jeu j = jdao.findByNom(nom);
						
						if(!j.equals(null)) {
							
							j.setTarif(tarif);
							
							if(jdao.update(j)) {
								
								JOptionPane.showMessageDialog(null, "Jeu mise à jour.");
								Menu m = new Menu(u);
								m.setVisible(true);
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Jeu impossible à mettre à jour.");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Ce jeu n'existe pas.");
						}
					}
					catch(Exception err) {
						System.out.println(err.getMessage());
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Veuillez entrer toutes les informations.");
				}
			}
		});
		btnModifTarif.setBounds(221, 167, 203, 35);
		contentPane.add(btnModifTarif);
	}
}
