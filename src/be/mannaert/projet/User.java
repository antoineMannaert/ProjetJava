package be.mannaert.projet;

import java.util.*;

public class User {
	
	//attributs
	
	private int idUser;
	private String pseudo;
	private String password;
	private int solde;
	private boolean admin;
	
	private Set<Exemplaire> listeExemplaires;
	private Set<Reservation> listeRes;

	//Constructeurs
	
	public User() {}
	
	public User(String pseudo, String password, int solde, boolean admin) {
		this.pseudo = pseudo;
		this.password = password;
		this.solde = solde;
		this.admin = admin;
		this.listeExemplaires = new HashSet<Exemplaire>();
		this.listeRes = new HashSet<Reservation>();
	}
	
	public User(int idUser, String pseudo, String password, int solde, boolean admin) {
		this.idUser = idUser;
		this.pseudo = pseudo;
		this.password = password;
		this.solde = solde;
		this.admin = admin;
		this.listeExemplaires = new HashSet<Exemplaire>();
		this.listeRes = new HashSet<Reservation>();
		
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
	
	public Set<Exemplaire> getListeEx(){
		return this.listeExemplaires;
	}
	
	public Set<Reservation> getListeRes(){
		return this.listeRes;
	}
	
	//Setters
	
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
	
	//Méthodes d'ajout dans les ensembles
	
	public void AjouterExemplaire(Exemplaire ex) {
		this.listeExemplaires.add(ex);
	}
	
	public void AjouterRes(Reservation res) {
		this.listeRes.add(res);
	}
	
	//Méthodes de suppression dans la liste des exemplaires
	
	public void RetirerExemplaire(Exemplaire ex) {
		this.listeExemplaires.remove(ex);
	}
}
