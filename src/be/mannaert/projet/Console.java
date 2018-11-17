package be.mannaert.projet;

import java.util.*;

public class Console {
	
	
	//attributs
	
	private int idConsole;
	private String nom;
	private String diminutif;
	private int annee;
	
	private Set<Jeu> listeJeux;
	
	//Constructeurs
	
	public Console() { }
	
	public Console(int idConsole, String nom, String dinimutif, int annee) {
		this.idConsole = idConsole;
		this.nom = nom;
		this.diminutif = diminutif;
		this.annee = annee;
		this.listeJeux = new HashSet<Jeu>();
	}
	
	//Getters
	
	public int getIdConsole() {
		return this.idConsole;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getDiminutif() {
		return this.diminutif;
	}
	
	public int getAnnee() {
		return this.annee;
	}
	
	//Setters
	
	public void setIdConsole(int idConsole) {
		this.idConsole = idConsole;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setDiminutif(String diminutif) {
		this.diminutif = diminutif;
	}
	
	public void setAnnee(int annee) {
		this.annee = annee;
	}

}
