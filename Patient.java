package projet;

public class Patient extends Personne{
	private int matricule;
	private Symptomes symptomes;
	
	Patient(){}
	Patient(String nom, String prenom, int matricule,Symptomes symptomes, String numero){
		this.matricule = matricule;
		this.symptomes = symptomes;
		this.nom = super.nom;
		this.prenom = super.prenom;
		this.etatPatient = etatPatient;
		this.numero = super.numeroTelephone;
	}
	
	public EtatPatient getEtatPatient() {
		return this.etatPatient;
	}
	public void setEtatPatient(EtatPatient etatPatient) {
		this.etatPatient = etatPatient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	public Symptomes getSymptomes() {
		return this.symptomes;
	}
	
	public void setSymptomes(Symptomes symptomes) {
		this.symptomes = symptomes;
	}
}
	
