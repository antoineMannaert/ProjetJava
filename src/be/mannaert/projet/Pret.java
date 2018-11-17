package be.mannaert.projet;

import java.util.*;

public class Pret {

	//attributs
	
	private int idPret;
	private Date dateDebut;
	private Date dateFin;
	private boolean conf;
	
	//Constructeurs
	
	public Pret() {	}
	
	public Pret(int idPret, Date dateDebut, Date dateFin, boolean conf) {
		this.idPret = idPret;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.conf = conf;
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
	
	//Setters
	
	public void setIdPret(int idPret) {
		this.idPret = idPret;
	}
	
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	public void setConf(boolean conf) {
		this.conf = conf;
	}
}
