package Gestion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Consultation1 implements Comparable{

    private int matricule = 0;
    private Patient patient;
    private Medecin medecin;
    private Date date;
    private List<Consultation> listConsultation = new ArrayList();
    private List listMedecin = new ArrayList<Medecin>();
    
    public Consultation() {}

    // exception si une consultation est faite à la meme heure
	private Consultation(Date date, Medecin medecin, Patient patient){
		this.matricule = matricule++;
		this.date = date;
		this.patient = patient;
		this.medecin = medecin;
	}
	
	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		try {
			if (!(this.dateIsValid(date))) {
				int min = date.getMinutes() + 30;
				date.setMinutes(min);
				this.date = date;
			}
		}catch(Exception e) {
			consultationException consul = new consultationException();
			System.out.println(consul);
		}
		this.date = date;
		
	}
	public Boolean dateIsValid(Date date) {
		for (Consultation1 consul : this.listConsultation) {
			if (consul.compareTo(this) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public Medecin rechercherMedecinParSpecialite(Specialite specialite) {
		for (Object medecin : this.listMedecin) {
			if (((Medecin) medecin).getSpecialite() == specialite) {
				return (Medecin) medecin;
			}
		}
		return null;
	}
	
	//affecter patient au medecin selon symptomes et planning
	public void programmerConsultation(Patient patient) throws consultationException{
		Medecin medecin = new Medecin();
		Date date = new Date();
		Consultation consultation = new Consultation();
		if (patient.getSymptomes() == Symptomes.DIABETE) {
			medecin = rechercherMedecinParSpecialite(Specialite.DIABETOLOGUE);
			consultation.setMedecin(medecin);
			consultation.setDate(date);
			
			consultation.setPatient(patient);
			if (medecin.rechercherConsultation(consultation) != null) {
				medecin.ajouterConsultation(consultation);
			}else{
				Date newDate = new Date();
				int min = newDate.getMinutes() + 30;
				newDate.setMinutes(min);
				consultation.setDate(date);//exception!!
			}	
		}
		if (patient.getSymptomes() == Symptomes.PROBLEMES_ARTICULATIONS) {
			medecin = rechercherMedecinParSpecialite(Specialite.RHUMATOLOGUE);
			consultation.setMedecin(medecin);
			consultation.setDate(date);
			consultation.setPatient(patient);
			if (medecin.rechercherConsultation(consultation) != null) {
				medecin.ajouterConsultation(consultation);
			}else{
				Date newDate = new Date();
				int min = newDate.getMinutes() + 30;
				newDate.setMinutes(min);
				consultation.setDate(date);//exception!!
			}
		}
		if (patient.getSymptomes() == Symptomes.PROBLEMES_VENTRES) {
			medecin = rechercherMedecinParSpecialite(Specialite.GYNECOLOGUE);
			consultation.setMedecin(medecin);
			consultation.setDate(date);
			consultation.setPatient(patient);
			if (medecin.rechercherConsultation(consultation) != null) {
				medecin.ajouterConsultation(consultation);
			}else{
				Date newDate = new Date();
				int min = newDate.getMinutes() + 30;
				newDate.setMinutes(min);
				consultation.setDate(date);//exception!!
				}
			}
		if (patient.getSymptomes() == Symptomes.PROBLEMES_COEUR) {
			medecin = rechercherMedecinParSpecialite(Specialite.CARDIOLOGUE);
			consultation.setMedecin(medecin);
			consultation.setDate(date);
			consultation.setPatient(patient);
			if (medecin.rechercherConsultation(consultation) != null) {
				medecin.ajouterConsultation(consultation);
			}else{
				Date newDate = new Date();
				int min = newDate.getMinutes() + 30;
				newDate.setMinutes(min);
				consultation.setDate(date);//exception!!
			}
		}	
		
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(date, matricule);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consultation other = (Consultation) obj;
		return Objects.equals(date, other.date) && matricule == other.matricule;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "numero de consultation : "+this.matricule+ '\n'
				+ "à " + this.date +'\n'+ "medecin : " + this.medecin.getNom() +
				'\n' + "patient : " + this.patient.getNom();
		}

	@Override 
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if (date == ((Consultation) o).getDate() && getMedecin() == ((Consultation) o).getMedecin()) {
			return 0;
		}else {
			if (date.compareTo(((Consultation) o).getDate()) > 0){
				return 1;	
			}else {
				return -1;
			}
		}
	}


