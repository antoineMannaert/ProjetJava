package be.mannaert.projet;

import java.sql.*;

public class Pret {

	//attributs
	
	private int idPret;
	private Date dateDebut;
	private boolean fin;
	private Exemplaire ex;
	private User u;
	
	//Constructeurs
	
	public Pret() {	}
	
	public Pret(int idPret, Date dateDebut, boolean fin, Exemplaire ex, User u) {
		this.idPret = idPret;
		this.dateDebut = dateDebut;
		this.fin = fin;
		this.ex = ex;
		this.u = u;
	}
	
	//Getters
	
	public int getIdPret() {
		return this.idPret;
	}
	
	public Date getDateDebut() {
		return this.dateDebut;
	}
	
	public Boolean getFin() {
		return this.fin;
	}
		
	public Exemplaire getExemplaire() {
		return this.ex;
	}
	
	public User getUser() {
		return this.u;
	}
	
	//Setters
	
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	public void setFin(boolean fin) {
		this.fin = fin;
	}
	
	public void setExemplaire(Exemplaire ex) {
		this.ex = ex;
	}
	
	public void setUser(User u) {
		this.u = u;
	}
	
	//Surcharge du toString()
	
	@Override
	public String toString() {
		if(!this.fin) {
			return "Votre emprunt de " + this.ex.getJeu().getNom() + " a commencé le " + this.dateDebut;
		}
		
		return "Votre emprunt de" + this.ex.getJeu().getNom() + " s'est terminé.";
	}
}
