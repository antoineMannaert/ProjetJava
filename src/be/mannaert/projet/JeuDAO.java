package be.mannaert.projet;

import java.sql.*;

public class JeuDAO extends DAO<Jeu>{

	public JeuDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Jeu j){		
		
		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Jeu (nomJeu, tarif, idConsole) VALUES ('" + j.getNom() + "', " + j.getTarif() + ", " + j.getConsole().getIdConsole() + ");");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean delete(Jeu j){
		
		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM Jeu WHERE idJeu = " + j.getIdJeu() + ";");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(Jeu j){
		
		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Jeu SET nomJeu = '" + j.getNom() + "', tarif = " + j.getTarif() + ", idConsole = " + j.getConsole().getIdConsole() + " WHERE idJeu = " + j.getIdJeu() + ";");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Jeu find(int id){
		
		Jeu j = new Jeu();
		Console c = new Console();
		DAO<Console> cdao = new ConsoleDAO(this.connect);
		
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Jeu WHERE idJeu = " + id);
			if(result.first()) {
				c = cdao.find(result.getInt("idConsole"));
				j = new Jeu(id, result.getString("nomJeu"), result.getInt("tarif"), c);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return j;
	}
	
}
