package be.mannaert.projet;

import java.util.*;

public class Reservation {
	
	//attributs
	
	private int idRes;
	private Date dateRes;
	private String etatRes;
	private Jeu j;
	
	//Constructeurs
	
	public Reservation() { }
	
	public Reservation (int idRes, Date dateRes, String etatRes, Jeu j) {
		this.idRes = idRes;
		this.dateRes = dateRes;
		this.etatRes = etatRes;
		this.j = j;
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
}
