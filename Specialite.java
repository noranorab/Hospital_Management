package Gestion;

public interface Specialite {

	public abstract void consulterPatient(int matricule);
	public abstract void affecterPatient(int matricule);
	public abstract void prescrireMedicament(int matricule);
	public abstract void programmerConsultation(int matricule);
	
}
