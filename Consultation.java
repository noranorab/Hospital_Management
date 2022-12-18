package Gestion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Medecin {
	private int matricule;
	private String nom;
	private String contact;
	private Specialite specialite;
	private List<Patient> patients = new ArrayList<Patient>();
	private List<Consultation> consultation = new ArrayList<Consultation>();
	//private
	
	
	Medecin(){}
	Medecin(int matricule, String nom, String contact,Boolean estDispo, Specialite specialite){
		this.matricule = matricule;
		this.nom = nom;
		this.contact = contact;
		this.specialite = specialite;
		
	}
	//setters & getters (penser à exception pour matricule)
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public int getMatricule() {
		return this.matricule;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getContact() {
		return this.contact;
	}

	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	
	public Patient rechercherPatient(int matricule) {
		int a = 0;
		for (Patient m: this.patients) {
			if (m.getMatricule() == matricule) {
				return m;
			}
		}
		return null;
	}
	
	public Consultation rechercherConsultation(Consultation consul) {
		for (Consultation consultation: this.consultation) {
			if (consultation.compareTo(consul) == 0) {
				return consultation;
			}
		}
		return null;
	}
	
	//permet de voir informations sur patient par son matricule
	public void consulterPatient(int matricule) {
		System.out.println("Nom du patient : " + rechercherPatient(matricule).getNom() + '\n' +
		                   "Matricule du patient : " + rechercherPatient(matricule).getMatricule()
		                   );
	}
	//toString
	@Override
	public String toString() {
		return "Médecin : " + this.matricule + ", " + this.nom + ", "
				+ this.contact;
	}
	
	//methode pour affecter medicin à patient selon maladie patient
	public void ajouterPatient(Patient patient) {
		if (!(patients.contains(patient))) {
			patients.add(patient);
		}else {
			System.out.println("patient existe");
		}
		
	}
	public void ajouterConsultation(Consultation consul) {
		if (!(this.consultation.contains(consul))) {
			this.consultation.add(consul);
		}else {
			System.out.println("consultation déjà programmée");
		}
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	

}
