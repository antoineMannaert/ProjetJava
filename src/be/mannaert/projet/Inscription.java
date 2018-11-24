package be.mannaert.projet;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inscription extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPseudo;
	private JPasswordField txtMDP;
	private JPasswordField txtConf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscription frame = new Inscription();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inscription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelPseudo = new JLabel("Pseudo : ");
		labelPseudo.setBounds(10, 36, 174, 30);
		contentPane.add(labelPseudo);
		
		JLabel labelMDP = new JLabel("Mot de passe : ");
		labelMDP.setBounds(10, 77, 174, 30);
		contentPane.add(labelMDP);
		
		JLabel lblConfMDP = new JLabel("Confirmation du mot de passe : ");
		lblConfMDP.setBounds(10, 118, 174, 30);
		contentPane.add(lblConfMDP);
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(194, 36, 230, 30);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		txtMDP = new JPasswordField();
		txtMDP.setBounds(194, 77, 230, 30);
		contentPane.add(txtMDP);
		
		txtConf = new JPasswordField();
		txtConf.setBounds(194, 119, 230, 30);
		contentPane.add(txtConf);
		
		JButton btnInscrip = new JButton("S'inscrire");
		btnInscrip.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				User u = new User();
				UserDAO dao = new UserDAO(ProjetConnection.getInstance());
				String pseudo = txtPseudo.getText().toString();
				String password = txtMDP.getText().toString();
				String conf = txtConf.getText().toString();
				
				try {
					
					if(!pseudo.isEmpty() && !password.isEmpty() && !conf.isEmpty() && password.equals(conf)) {
						
						u = new User(pseudo, password, 50, false);
						
						if(dao.create(u)) {
							JOptionPane.showMessageDialog(null, "Bienvenue, " + u.getPseudo());
							Menu m = new Menu(u);
							m.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Inscription non valide");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Remplir les champs");
					}
				}
				catch(Exception err)
				{
					System.out.println(err);
				}
			}
		});
		btnInscrip.setBounds(10, 159, 200, 53);
		contentPane.add(btnInscrip);
		
		JButton btnCo = new JButton("D\u00E9j\u00E0 inscrit? Se connecter");
		btnCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnCo.setBounds(220, 160, 204, 52);
		contentPane.add(btnCo);
	}
}
