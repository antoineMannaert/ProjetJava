package be.mannaert.projet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsoleDAO extends DAO<Console> {
	
	public ConsoleDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Console c){	
		
		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Console (nomConsole, diminutif) VALUES ('" + c.getNom() + "', '" + c.getDiminutif() + "');");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean delete(Console c){
		
		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM Console WHERE idConsole = " + c.getIdConsole() + ");");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(Console c){

		try {
			this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Console SET nomConsole = '" + c.getNom() + "', diminutif = '" + c.getDiminutif() + "' WHERE idConsole = " + c.getIdConsole() + ");");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Console find(int id){
		
		Console c = new Console();
		
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Console WHERE idConsole = " + id + ";");
			if(result.first()) {
				c = new Console(id, result.getString("nomConsole"), result.getString("diminutif"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return c;
	}

}
