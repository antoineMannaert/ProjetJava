package be.mannaert.projet;

import java.util.*;

public class Pret {

	//attributs
	
	private int idPret;
	private Date dateDebut;
	private Date dateFin;
	private boolean conf;
	private Exemplaire ex;
	
	//Constructeurs
	
	public Pret() {	}
	
	public Pret(int idPret, Date dateDebut, Date dateFin, boolean conf, Exemplaire ex) {
		this.idPret = idPret;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.conf = conf;
		this.ex = ex;
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
	
	public boolean getConf() {
		return this.conf;
	}
	
	public Exemplaire getExemplaire() {
		return this.ex;
	}
	
	//Setters
	
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	public void setConf(boolean conf) {
		this.conf = conf;
	}
	
	public void setExemplaire(Exemplaire ex) {
		this.ex = ex;
	}
}
