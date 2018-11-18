package be.mannaert.projet;

import java.sql.*;

public class JeuDAO extends DAO<Jeu>{

	public JeuDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Jeu j){		
		return false;
	}
	
	public boolean delete(Jeu j){
		return false;
	}
	
	public boolean update(Jeu j){
		return false;
	}
	
	public Jeu find(int id){
		
		Jeu j = new Jeu();
		
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Jeu WHERE idJeu = " + id);
			if(result.first())
				j = new Jeu(id, result.getString("nomJeu"), result.getInt("tarif"), result.getBoolean("disponible"));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return j;
	}
	
}
