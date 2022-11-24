package Gestion;

public class Medicament {
	private int matricule;
	private Maladie maladie;
	private int quantite;
	
	Medicament(){}
	Medicament(int matricule){
		this.matricule = matricule;
	}
	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	public Maladie getMaladie() {
		return maladie;
	}
	public void setMaladie(Maladie maladie) {
		this.maladie = maladie;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	//dosage
	
	
	

}
