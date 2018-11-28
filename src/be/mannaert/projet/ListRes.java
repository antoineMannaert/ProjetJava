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
import java.awt.event.ActionEvent;

public class ListRes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ReservationDAO rdao = new ReservationDAO(ProjetConnection.getInstance());

	/**
	 * Create the frame.
	 */
	public ListRes(User u) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVotreListeDe = new JLabel("Votre liste de r\u00E9servations encore en cours :");
		lblVotreListeDe.setBounds(10, 11, 414, 25);
		contentPane.add(lblVotreListeDe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 414, 170);
		contentPane.add(scrollPane);
		
		JList<Reservation> listRes = new JList<>(rdao.findAll(u.getIdUser()));
		scrollPane.setViewportView(listRes);
		
		JButton btnRetour = new JButton("Revenir au menu");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu(u);
				m.setVisible(true);
				dispose();
			}
		});
		btnRetour.setBounds(223, 215, 201, 35);
		contentPane.add(btnRetour);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Reservation r = listRes.getSelectedValue();
				
				if(r != null) {

					try {
						
						r.setEtatRes("annule");
						if(rdao.update(r)) {
							JOptionPane.showMessageDialog(null, "Annulation effectuée");
							Menu m = new Menu(u);
							m.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Annulation non valide");
						}
					}
							
					catch(Exception err) {
						System.out.println(err);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Choisissez une réservation à annuler.");
				}
			}
		});
		btnAnnuler.setBounds(10, 215, 203, 35);
		contentPane.add(btnAnnuler);
	}

}
