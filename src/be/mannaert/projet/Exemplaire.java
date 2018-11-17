package be.mannaert.projet;

import java.util.*;

public class Exemplaire {
	
	//attributs
	
	private int idExemplaire;
	private boolean dispo;
	
	private Set<Pret> listePrets;
	
	//Constructeurs
	
	public Exemplaire() { }
	
	public Exemplaire(int idExemplaire, boolean dispo) {
		this.idExemplaire = idExemplaire;
		this.dispo = dispo;
		listePrets = new HashSet<Pret>();
	}
	
	//Getters
	
	public int getIdExemplaire() {
		return this.idExemplaire;
	}
	
	public boolean getDispo() {
		return this.dispo;
	}
	
	//Setters
	
	public void setIdExemplaire(int idExemplaire) {
		this.idExemplaire = idExemplaire;
	}
	
	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

}
