package be.mannaert.projet;

import java.sql.*;

public class Pret {

	//attributs
	
	private int idPret;
	private Date dateDebut;
	private Date dateFin;
	private Exemplaire ex;
	private User u;
	
	//Constructeurs
	
	public Pret() {	}
	
	public Pret(int idPret, Date dateDebut, Date dateFin, Exemplaire ex, User u) {
		this.idPret = idPret;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
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
	
	public Date getDateFin() {
		return this.dateFin;
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
	
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
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
		return "Votre emprunt de " + this.ex.getJeu().getNom() + "a commencé le " + this.dateDebut;
	}
}
