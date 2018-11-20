package be.mannaert.projet;

public class Console {
	
	
	//attributs
	
	private int idConsole;
	private String nom;
	private String diminutif;
	
	//Constructeurs
	
	public Console() { }
	
	public Console(int idConsole, String nom, String diminutif) {
		this.idConsole = idConsole;
		this.nom = nom;
		this.diminutif = diminutif;
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
	
	//Setters
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setDiminutif(String diminutif) {
		this.diminutif = diminutif;
	}

}
