package be.mannaert.projet;

import java.util.*;

public class Reservation {
	
	//attributs
	
	private int idRes;
	private Date dateRes;
	private String etatRes;
	
	//Constructeurs
	
	public Reservation() { }
	
	public Reservation (int idRes, Date dateRes, String etatRes) {
		this.idRes = idRes;
		this.dateRes = dateRes;
		this.etatRes = etatRes;
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
	
	//Setters
	
	public void setIdRes(int idRes) {
		this.idRes = idRes;
	}
	
	public void setDateRes(Date dateRes) {
		this.dateRes = dateRes;
	}
	
	public void setEtatRes(String etatRes) {
		this.etatRes = etatRes;
	}

}
