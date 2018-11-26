package be.mannaert.projet;

public class Jeu {
	
	//attributs
	
	private int idJeu;
	private String nom;
	private int tarif;
	private Console c;
	
	//Constructeurs
	
	public Jeu() {}
	
	public Jeu(int idJeu, String nom, int tarif, Console c) {
		this.idJeu = idJeu;
		this.nom = nom;
		this.tarif = tarif;
		this.c = c;
	}
	
	//Getters
	
	public int getIdJeu() {
		return this.idJeu;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getTarif() {
		return this.tarif;
	}
	
	public Console getConsole() {
		return this.c;
	}
	
	//Setters
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	
	public void setConsole(Console c) {
		this.c = c;
	}
	
	//Surcharge de la méthode toString()
	
	@Override
	public String toString() {
		return this.getNom() + " au tarif de " + this.getTarif() + " unité(s). Console : " + this.getConsole().getDiminutif() + ".";
	}
}
