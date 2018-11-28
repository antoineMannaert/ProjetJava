package be.mannaert.projet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
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
		btnRetour.setBounds(140, 215, 151, 35);
		contentPane.add(btnRetour);
	}

}
