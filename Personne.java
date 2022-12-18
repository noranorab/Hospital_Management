package projet;

public class Personne {
	String nom;
	String prenom;
	String numeroTelephone;
	
	public Personne() {}
	public Personne(String nom, String prenom, String numero) {
		this.nom=nom;
		this.prenom=prenom;
		this.numeroTelephone = numero;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setNumeroTelephone(String num) {
		this.numeroTelephone = num;
	}
		
	public void getNumeroTelephone() {
		return this.numeroTelephone;
	}
		
	@Override
	public String toString() {
		return this.getNom()+" "+this.getPrenom();
	}
		
	@Override
	public boolean equals(Object o){
		try {
			Personne p = (Personne) o;
			return this.getNom().equals(p.getNom()) && this.getPrenom().equals(p.getPrenom());
		}
		catch (ClassCastException e) {
			return false;
		}
			
	}
		
	
}
