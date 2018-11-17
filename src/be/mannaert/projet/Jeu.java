package be.mannaert.projet;

import java.util.*;

public class Jeu {
	
	//attributs
	
	private int idJeu;
	private String nom;
	private boolean dispo;
	private int tarif;
	
	private Set<Exemplaire> listeExemplaires;
	private Set<Reservation> listeReservation;
	
	//Constructeurs
	
	public Jeu() {}
	
	public Jeu(int idJeu, String nom, boolean dispo, int tarif) {
		this.idJeu = idJeu;
		this.nom = nom;
		this.dispo = dispo;
		this.tarif = tarif;
		this.listeExemplaires = new HashSet<Exemplaire>();
		this.listeReservation = new HashSet<Reservation>();
	}
	
	//Getters
	
	public int getIdJeu() {
		return this.idJeu;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public boolean getDispo() {
		return this.dispo;
	}
	
	public int getTarif() {
		return this.tarif;
	}
	
	//Setters
	
	public void setIdJeu(int idJeu) {
		this.idJeu = idJeu;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}
	
	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
}