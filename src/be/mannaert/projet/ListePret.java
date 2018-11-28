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
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class ListePret extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PretDAO pdao = new PretDAO(ProjetConnection.getInstance());
	private ExemplaireDAO edao = new ExemplaireDAO(ProjetConnection.getInstance());
	private ReservationDAO rdao = new ReservationDAO(ProjetConnection.getInstance());

	/**
	 * Create the frame.
	 */
	public ListePret(User u) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("Voici votre liste d'emprunts : ");
		lbl.setBounds(10, 11, 414, 25);
		contentPane.add(lbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 414, 170);
		contentPane.add(scrollPane);
		
		JList<Pret> list = new JList<>(pdao.findAll(u.getIdUser()));
		scrollPane.setViewportView(list);
		
		JButton btnTerminer = new JButton("Terminer l'emprunt");
		btnTerminer.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				
				Pret p;
				Exemplaire ex;
				Reservation res;
				
				if(!list.isSelectionEmpty()) {
					
					p = list.getSelectedValue();
					ex = p.getExemplaire();
					try {
						
						if(p.getDateFin() != null) {
							
							Date d = new Date(Calendar.getInstance().getTime().getTime());
							p.setDateFin(d);
							ex.setDispo(true);
							
							if(pdao.update(p) && edao.update(ex)) {
								
								JOptionPane.showMessageDialog(null, "Pret terminé");
								res = rdao.findByIdJeu(ex.getJeu().getIdJeu());
								if(res != null){
									p = new Pret(0, d, null, edao.find(res.getIdRes()), res.getUser());
									pdao.create(p);
									}
							}
							else {
								JOptionPane.showMessageDialog(null, "Pret non terminé");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Choisissez un pret qui n'est pas encore terminé");
						}
					}
					catch(Exception err) {
						System.out.println(err.getMessage());
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Choisissez un pret à terminer");
				}
			}
		});
		btnTerminer.setBounds(10, 215, 203, 35);
		contentPane.add(btnTerminer);
		
		JButton btnRetour = new JButton("Retour au menu");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu m = new Menu(u);
				m.setVisible(true);
				dispose();
			}
		});
		btnRetour.setBounds(223, 215, 201, 35);
		contentPane.add(btnRetour);
	}

}
