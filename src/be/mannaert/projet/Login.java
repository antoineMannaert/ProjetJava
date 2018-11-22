package be.mannaert.projet;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPseudo;
	private JPasswordField txtMDP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPseudo = new JLabel("Pseudo : ");
		lblPseudo.setBounds(10, 65, 172, 42);
		contentPane.add(lblPseudo);
		
		JLabel lblMDP = new JLabel("Mot de passe : ");
		lblMDP.setBounds(10, 116, 172, 42);
		contentPane.add(lblMDP);
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(215, 65, 172, 42);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		JButton btnCo = new JButton("Se connecter");
		btnCo.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				User u = new User();
				UserDAO dao = new UserDAO(ProjetConnection.getInstance());
				String pseudo = txtPseudo.getText().toString();
				String password = txtMDP.getText().toString();
				
				try {
					
					if(!pseudo.isEmpty() && !password.isEmpty()) {
						
						u = dao.findByPseudo(pseudo);
						
						System.out.println(password);
						System.out.println(u.getPassword());
						
						if(u != null && password.equals(u.getPassword())) {
							JOptionPane.showMessageDialog(null, "Bienvenue, " + u.getPseudo());
						}
						else {
							JOptionPane.showMessageDialog(null, "Veuillez utiliser un pseudo/mot de passe correct");
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
		btnCo.setBounds(10, 173, 172, 42);
		contentPane.add(btnCo);
		
		JButton btnInscrip = new JButton("S'inscrire");
		btnInscrip.setBounds(215, 173, 172, 42);
		contentPane.add(btnInscrip);
		
		txtMDP = new JPasswordField();
		txtMDP.setBounds(215, 116, 172, 42);
		contentPane.add(txtMDP);
	}
}
