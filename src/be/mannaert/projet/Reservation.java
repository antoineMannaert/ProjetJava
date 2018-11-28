package be.mannaert.projet;

import java.util.*;

public class Reservation {
	
	//attributs
	
	private int idRes;
	private Date dateRes;
	private String etatRes;
	private Jeu j;
	private User u;
	
	//Constructeurs
	
	public Reservation() { }
	
	public Reservation (int idRes, Date dateRes, String etatRes, Jeu j, User u) {
		this.idRes = idRes;
		this.dateRes = dateRes;
		this.etatRes = etatRes;
		this.j = j;
		this.u = u;
	}
	
	//Getters
	
	public int getIdRes() {
		return this.idRes;
	}
	
	public Date getDateRes() {
		return this.dateRes;
	}
	
	public String getEtatRes() {
		return this.etatRes;
	}
	
	public Jeu getJeu() {
		return this.j;
	}
	
	public User getUser() {
		return this.u;
	}
	
	//Setters
	
	public void setDateRes(Date dateRes) {
		this.dateRes = dateRes;
	}
	
	public void setEtatRes(String etatRes) {
		this.etatRes = etatRes;
	}
	
	public void setJeu(Jeu j) {
		this.j = j;
	}
	
	public void setUser(User u) {
		this.u = u;
	}
}
