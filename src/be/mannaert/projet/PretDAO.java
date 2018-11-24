package be.mannaert.projet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PretDAO extends DAO<Pret>{
	
	public PretDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Pret p){	
		
		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Pret (dateDebut, dateFin, confirmation, idUser, idEx) VALUES (Date'" + p.getDateDebut() + "', Date'" + p.getDateFin() + "', '" + p.getConf() + "', " + p.getExemplaire().getIdExemplaire() + ", " + p.getUser().getIdUser() + ");");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean delete(Pret p){
		
		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM Pret WHERE idPret = " + p.getIdPret() + ";");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(Pret p){

		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Pret SET dateDebut = Date'" + p.getDateDebut() + "', dateFin = Date'" + p.getDateFin() + "', confirmation = '" + p.getConf() + "', idEx = " + p.getExemplaire().getIdExemplaire() + ", idUser = " + p.getUser().getIdUser() + " WHERE idPret = " + p.getIdPret() + ");");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Pret find(int id){
		
		Pret p = new Pret();
		Exemplaire ex = new Exemplaire();
		User u = new User();
		DAO<Exemplaire> edao = new ExemplaireDAO(this.connect);
		DAO<User> udao = new UserDAO(this.connect);
		
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Pret WHERE idPret = " + id);
			if(result.first()) {
				
				ex = edao.find(result.getInt("idEx"));
				u = udao.find(result.getInt("idUser"));
				p = new Pret(id, result.getDate("dateDebut"), result.getDate("dateFin"), result.getBoolean("confirmation"), ex, u);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return p;
	}

}
