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
					ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Exemplaire (disponible, idJeu, idUser) SET (" + ex.getDisponible() + "");");
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
					ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM Exemplaire WHERE idExemplaire = " + ex.getIdExemplaire() + ");");
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
					ResultSet.CONCUR_READ_ONLY).executeQuery("UPDATE Exemplaire SET disponibilité = " + ex.getDisponible + ");");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Exemplaire find(int id){
		
		Exemplaire ex = new Exemplaire();
		
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM ExemplaireJeu WHERE idExemplaire = " + id);
			if(result.first())
				ex = new Exemplaire(id, result.getBoolean("disponible"), result.getInt("idJeu"), result.getInt("idUser"));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return ex;
	}

}
