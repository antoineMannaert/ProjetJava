package be.mannaert.projet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationDAO extends DAO<Reservation> {
	
	public ReservationDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Reservation r){		
		
		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Reservation (dateRes, etat, idJeu) VALUES (" + r.getDateRes() + ", " + r.getEtatRes() + ", " + r.getJeu().getIdJeu() + ");");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean delete(Reservation r){
		
		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM Reservation WHERE idReservation = " + r.getIdRes() + ");");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(Reservation r){
		
		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Reservation SET dateRes = " + r.getDateRes() + ", etat  = " + r.getEtatRes() + ", idJeu = " + r.getJeu().getIdJeu() +  " WHERE idRes = " + r.getIdRes() + ");");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Reservation find(int id){
		
		Reservation r = new Reservation();
		Jeu j = new Jeu();
		DAO<Jeu> jdao = new JeuDAO(this.connect);
		
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservation WHERE idRes = " + id);
			if(result.first()) {
				j = jdao.find(result.getInt("idJeu"));
				r = new Reservation(id, result.getDate("dateRes"), result.getString("etat"), j);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return r;
	}

}
