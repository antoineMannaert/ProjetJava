package be.mannaert.projet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DAO<User> {
	
	public UserDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(User u){		
		
		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO User (pseudo, mdp, solde, admin) VALUES ('" + u.getPseudo() + "', '" + u.getPassword() + "', " + u.getSolde() + ", '" + u.getAdmin() + "');");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean delete(User u){
		
		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM User WHERE idUser = " + u.getIdUser() + ";");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(User u){

		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE User SET pseudo = '" + u.getPseudo() + "', mdp = '" + u.getPassword() + "', solde = " + u.getSolde() + ", admin = '" + u.getAdmin() + "' WHERE idUser = " + u.getIdUser() + ";");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public User find(int id){
		
		User u = new User();
		DAO<Jeu> jdao = new JeuDAO(this.connect);
		
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM User WHERE idUser = " + id);
			if(result.first())
				u = new User(id, result.getString("pseudo"), result.getString("mdp"), result.getInt("solde"), result.getBoolean("admin"));
		
			result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Exemplaire where idUser = " + id + ";");
			
			while(result.next())
				u.AjouterExemplaire(new Exemplaire(result.getInt("idEx"), result.getBoolean("disponible"), jdao.find(result.getInt("idJeu")), u));
			
			result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservation where idUser = " + id + ";");
			
			while(result.next())
				u.AjouterRes(new Reservation(result.getInt("idRes"), result.getDate("dateRes"), result.getString("etat"), jdao.find(result.getInt("idJeu")), u));
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return u;
	}
	
	public User findByPseudo(String nom){
		
		User u = new User();
		DAO<Reservation> rdao = new ReservationDAO(this.connect);
		DAO<Jeu> jdao = new JeuDAO(this.connect);
		
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM User WHERE pseudo = '" + nom + "';");
			if(result.first())
				u = new User(result.getInt("idUser"), nom, result.getString("mdp"), result.getInt("solde"), result.getBoolean("admin"));
		
			result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Exemplaire where idUser = " + u.getIdUser() + ";");
			
			while(result.next())
				
				u.AjouterExemplaire(new Exemplaire(result.getInt("idEx"), result.getBoolean("disponible"), jdao.find(result.getInt("idJeu")), u));
			
			result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservation where idUser = " + u.getIdUser() + ";");
			
			while(result.next())
				u.AjouterRes(rdao.find(result.getInt("idRes")));
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return u;
	}
}
