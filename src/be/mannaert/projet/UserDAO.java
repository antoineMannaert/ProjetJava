package be.mannaert.projet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DAO<User> {
	
	public UserDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(User u){		
		return false;
	}
	
	public boolean delete(User u){
		return false;
	}
	
	public boolean update(User u){
		return false;
	}
	
	public User find(int id){
		
		User u = new User();
		
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM User WHERE idUser = " + id);
			if(result.first())
				u = new User(id, result.getString("pseudo"), result.getString("mdp"), result.getInt("solde"), result.getBoolean("admin"));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return u;
	}
}
