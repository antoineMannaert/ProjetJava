package be.mannaert.projet;

public class Exemplaire {
	
	//attributs
	
	private int idExemplaire;
	private boolean dispo;
	private Jeu j;
	private User u;
	
	//Constructeurs
	
	public Exemplaire() { }
	
	public Exemplaire(int idExemplaire, boolean dispo, Jeu j, User u) {
		this.idExemplaire = idExemplaire;
		this.dispo = dispo;
		this.j = j;
		this.u = u;
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
	
	public User getUser() {
		return this.u;
	}
	
	//Setters
	
	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

	public void setJeu(Jeu j) {
		this.j = j;
	}
	
	public void setUser(User u) {
		this.u = u;
	}
}
