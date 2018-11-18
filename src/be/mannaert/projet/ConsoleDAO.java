package be.mannaert.projet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsoleDAO extends DAO<Console> {
	
	public ConsoleDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Console c){		
		return false;
	}
	
	public boolean delete(Console c){
		return false;
	}
	
	public boolean update(Console c){
		return false;
	}
	
	public Console find(int id){
		
		Console c = new Console();
		
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Console WHERE idJeu = " + id);
			if(result.first())
				c = new Console(id, result.getString("nomConsole"), result.getString("diminutif"), result.getInt("anneeSortie"), result.getInt("idJeu"));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return c;
	}

}
