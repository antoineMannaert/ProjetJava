package be.mannaert.projet;

import java.sql.*;
import javax.swing.*;

public class ProjetConnection {
	
	private static Connection instance = null;
	
	private ProjetConnection() {
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://./database.accdb";
			instance = DriverManager.getConnection(url);
		}
		catch(ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Classe de driver introuvable" + e.getMessage());
			System.exit(0);
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur JDBC : " + e.getMessage());
			System.exit(0);
		}
		
		if(instance == null) {
			JOptionPane.showMessageDialog(null, "La base de données est inaccessible, fermeture du programme.");
            System.exit(0);
		}
	}
	
	public static Connection getInstance() {
		
		if(instance == null){
			new ProjetConnection();
		}
		return instance;
	}


}
