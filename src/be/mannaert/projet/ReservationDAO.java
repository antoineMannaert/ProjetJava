package be.mannaert.projet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;

public class ReservationDAO extends DAO<Reservation> {
	
	public ReservationDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Reservation r){		
		
		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Reservation (etat, idJeu, idUser) VALUES ('" + r.getEtatRes() + "', " + r.getJeu().getIdJeu() + ", " + r.getUser().getIdUser() + ");");
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
					ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM Reservation WHERE idReservation = " + r.getIdRes() + ";");
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
					ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Reservation SET dateRes = Date'" + r.getDateRes() + "', etat  = '" + r.getEtatRes() + "', idJeu = " + r.getJeu().getIdJeu() + ", idUser = " + r.getUser().getIdUser() + " WHERE idRes = " + r.getIdRes() + ";");
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
		User u = new User();
		DAO<Jeu> jdao = new JeuDAO(this.connect);
		DAO<User> udao = new UserDAO(this.connect);
		
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservation WHERE idRes = " + id);
			if(result.first()) {
				j = jdao.find(result.getInt("idJeu"));
				u = udao.find(result.getInt("idUser"));
				r = new Reservation(id, result.getDate("dateRes"), result.getString("etat"), j, u);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return r;
	}

	public boolean find(int idJeu, int idUser){
		
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservation WHERE idJeu = " + idJeu + " AND idUser = " + idUser + " AND etat = 'en cours';");
			
			if(result.first()) {
				return true;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public DefaultListModel<Reservation> findAll(int idJeu, int idUser) {
		
		DefaultListModel<Reservation> lRes = new DefaultListModel<>();
		DAO<Jeu> jdao = new JeuDAO(this.connect);
		DAO<User> udao = new UserDAO(this.connect);
		
		try {				
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservation WHERE idJeu = " + idJeu + " AND idUser = " + idUser + ";");
			
			while(result.next()) {
				lRes.addElement(new Reservation(result.getInt("idRes"), result.getDate("dateRes"), result.getString("etat"), jdao.find(idJeu), udao.find(idUser)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lRes;
	}

}
