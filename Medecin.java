package Gestion;

import java.util.ArrayList;
import java.util.List;

public class Medecin {
	private int matricule;
	private String nom;
	private String contact;
	private String specialite;
	private List<Patient> patients = new ArrayList();
	//private
	
	Medecin(){}
	Medecin(int matricule){
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

	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public Patient rechercherPatient(int matricule) {
		return null;
	}
	
	//permet de voir informations sur patient par son matricule
	public void consulterPatient(int matricule) {
		System.out.println("Nom du patient : " + rechercherPatient(matricule).getNom());
		System.out.println("Matricule du patient : " + rechercherPatient(matricule).getMatricule());
		System.out.println("Etat du patient : " + rechercherPatient(matricule).getEtatPatient());
	}
	//toString
	@Override
	public String toString() {
		return "Médecin : " + this.matricule + ", " + this.nom + ", "
				+ this.contact;
	}
	
	//methode pour affecter medicin à patient
	public void ajouterPatient(Patient patient) {
		if (!(patients.contains(patient))) {
			patients.add(patient);
		}else {
			System.out.println("patient existe");
		}
		
	}
	
	
	
	
	
	
	

}
