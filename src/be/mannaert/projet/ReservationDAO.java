package be.mannaert.projet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationDAO extends DAO<Reservation> {
	
	public ReservationDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Reservation j){		
		return false;
	}
	
	public boolean delete(Reservation j){
		return false;
	}
	
	public boolean update(Reservation j){
		return false;
	}
	
	public Reservation find(int id){
		
		Reservation r = new Reservation();
		
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservation WHERE idRes = " + id);
			if(result.first())
				r = new Reservation(id, result.getDate("dateRes"), result.getString("etat"), result.getInt("idJeu"), result.getInt("idUser"));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return r;
	}

}
