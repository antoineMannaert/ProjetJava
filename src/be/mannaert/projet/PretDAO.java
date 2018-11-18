package be.mannaert.projet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PretDAO extends DAO<Pret>{
	
	public PretDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Pret p){		
		return false;
	}
	
	public boolean delete(Pret p){
		return false;
	}
	
	public boolean update(Pret p){
		return false;
	}
	
	public Pret find(int id){
		
		Pret p = new Pret();
		
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Pret WHERE idPret = " + id);
			if(result.first())
				p = new Pret(id, result.getString("nomPret"), result.getDate("dateDebut"), result.getDate("dateFin"), result.getBoolean("confirmation"), result.getInt("idUser"), result.getInt("idEx"));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return p;
	}

}
