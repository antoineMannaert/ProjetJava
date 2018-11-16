package be.mannaert.projet;

import java.util.*;

public class User {
	
	//attributs
	
	private int idUser;
	private String pseudo;
	private String password;
	private int solde;
	private boolean admin;
	
	private HashSet<Jeu> listeJeux;
	private HashSet<Reservation> listeRes;
	private HashSet<Pret> listePret;

	//Constructeurs
	
	public User() {}
	
	public User(int idUser, String pseudo, String password, int solde, boolean admin) {
		this.idUser = idUser;
		this.pseudo = pseudo;
		this.password = password;
		this.solde = solde;
		this.admin = admin;
		this.listeJeux = new HashSet<Jeu>;
		this.listeRes = new HashSet<Reservation>;
		this.listePret = new HashSet<Pret>;
		
	}
	
	//Getters
	
	public int getIdUser() {
		return this.idUser;
	}
	
	public String getPseudo() {
		return this.pseudo;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public int getSolde() {
		return this.solde;
	}
	
	public boolean getAdmin() {
		return this.admin;
	}
	
	//Setters
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setSolde(int solde) {
		this.solde= solde;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
