package be.mannaert.projet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExemplaireDAO extends DAO<Exemplaire>{
	
	public ExemplaireDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Exemplaire ex){		
		
		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Exemplaire (disponible, idJeu, idUser) VALUES ('" + ex.getDispo() + "', " + ex.getJeu().getIdJeu() + ", " + ex.getUser().getIdUser() + ");");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean delete(Exemplaire ex){

		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM Exemplaire WHERE idEx = " + ex.getIdExemplaire() + ";");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(Exemplaire ex){
		
		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Exemplaire SET disponibilité = '" + ex.getDispo() + "', idJeu = " + ex.getJeu().getIdJeu() + ", idUser = " + ex.getUser().getIdUser() + ";");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Exemplaire find(int id){
		
		Exemplaire ex = new Exemplaire();
		Jeu j = new Jeu();
		User u = new User();
		DAO<Jeu> jdao = new JeuDAO(this.connect);
		DAO<User> udao = new UserDAO(this.connect);
		
		try{
			
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Exemplaire WHERE idEx = " + id + ";");
			
			if(result.first()) {
				
				j = jdao.find(result.getInt("idJeu"));
				u = udao.find(result.getInt("idUser"));
							
				ex = new Exemplaire(id, result.getBoolean("disponible"), j, u);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return ex;
	}

}
