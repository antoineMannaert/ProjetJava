package be.mannaert.projet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangerMDP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField oldMDP;
	private JPasswordField newMDP;
	private JPasswordField confNewMDP;

	/**
	 * Create the frame.
	 */
	public ChangerMDP(User u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelAncien = new JLabel("Ancien mot de passe : ");
		labelAncien.setBounds(10, 11, 185, 30);
		contentPane.add(labelAncien);
		
		JLabel lblNewMDP = new JLabel("Nouveau mot de passe : ");
		lblNewMDP.setBounds(10, 52, 185, 30);
		contentPane.add(lblNewMDP);
		
		JLabel lblConfirmerNouveauMot = new JLabel("Confirmer nouveau mot de passe : ");
		lblConfirmerNouveauMot.setBounds(10, 93, 185, 30);
		contentPane.add(lblConfirmerNouveauMot);
		
		oldMDP = new JPasswordField();
		oldMDP.setBounds(204, 11, 220, 30);
		contentPane.add(oldMDP);
		
		newMDP = new JPasswordField();
		newMDP.setBounds(205, 52, 220, 30);
		contentPane.add(newMDP);
		
		confNewMDP = new JPasswordField();
		confNewMDP.setBounds(204, 93, 220, 30);
		contentPane.add(confNewMDP);
		
		JButton btnChangerMDP = new JButton("Changer de mot de passe");
		btnChangerMDP.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				UserDAO dao = new UserDAO(ProjetConnection.getInstance());
				String oldPassword = oldMDP.getText().toString();
				String newPassword = newMDP.getText().toString();
				String conf = confNewMDP.getText().toString();
				
				try {
					
					if(!oldPassword.isEmpty() && !newPassword.isEmpty() && !conf.isEmpty()) {
						
						if(oldPassword.equals(u.getPassword()) && newPassword.equals(conf)) {

							u.setPassword(newPassword);
							if(dao.update(u)) {
								JOptionPane.showMessageDialog(null, "Mot de passe changé");
								Menu m = new Menu(u);
								m.setVisible(true);
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Mot de passe non changé");
								u.setPassword(oldPassword);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "champ(s) incorect(s)");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Remplir les champs");
					}
				}
				catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnChangerMDP.setBounds(10, 210, 200, 40);
		contentPane.add(btnChangerMDP);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu(u);
				m.setVisible(true);
				dispose();
			}
		});
		btnAnnuler.setBounds(224, 210, 200, 40);
		contentPane.add(btnAnnuler);
	}
}
