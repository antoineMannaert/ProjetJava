package be.mannaert.projet;

public class Exemplaire {
	
	//attributs
	
	private int idExemplaire;
	private boolean dispo;
	private Jeu j;
	
	//Constructeurs
	
	public Exemplaire() { }
	
	public Exemplaire(int idExemplaire, boolean dispo, Jeu j) {
		this.idExemplaire = idExemplaire;
		this.dispo = dispo;
		this.j = j;
	}
	
	//Getters
	
	public int getIdExemplaire() {
		return this.idExemplaire;
	}
	
	public boolean getDispo() {
		return this.dispo;
	}
	
	public Jeu getJeu() {
		return this.j;
	}
	
	//Setters
	
	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

	public void setJeu(Jeu j) {
		this.j = j;
	}
}
