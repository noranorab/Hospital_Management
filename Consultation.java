package projet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

import Gestion.Consultation1;
import Gestion.Medecin;
import Gestion.Patient;
import Gestion.Specialite;
import Gestion.Symptomes;

public class Consultation implements Comparable{
	private int matricule = 0;
    private Patient patient;
    private Medecin medecin;
    private Date date;
    private List<Consultation> listConsultation = new ArrayList();
    private List listMedecin = new ArrayList<Medecin>();
    /*
    private ArrayList<Chambre> m_t;
    private int m_nLits;
    private int m_nLitsOcc;
    private int m_nChVides;
    private int m_nChPleines;
    */
    public Consultation() {}

    // exception si une consultation est faite à la meme heure
	public Consultation(Date date, Medecin medecin, Patient patient){
		this.matricule = matricule++;
		this.date = date;
		this.patient = patient;
		this.medecin = medecin;
	}
	
	
		
	/*   m_nom = new String(nom);
	   m_t = new ArrayList<Chambre>();
	   m_nLits = (nCh*nlitsCh);
	   m_nLitsOcc = 0;
	   m_nChVides = nCh;
	   m_nChPleines = 0;
	   
	   for (int k = 0; k < nCh; ++k){
	      m_t.add(new Chambre(k, nlitsCh));
	   }
	*/
	

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
		this.date = date;
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
	public void affecterMedecin(Patient patient) {
		if (patient.getSymptomes() == Symptomes.DIABETE) {
			Medecin medecin = rechercherMedecinParSpecialite(Specialite.DIABETOLOGUE);
			medecin.ajouterPatient(patient);
		}
		if (patient.getSymptomes() == Symptomes.PROBLEMES_ARTICULATIONS) {
			Medecin medecin = rechercherMedecinParSpecialite(Specialite.RHUMATOLOGUE);
			medecin.ajouterPatient(patient);
		}
		if (patient.getSymptomes() == Symptomes.PROBLEMES_VENTRES) {
			Medecin medecin = rechercherMedecinParSpecialite(Specialite.GYNECOLOGUE);
			medecin.ajouterPatient(patient);
		}
		if (patient.getSymptomes() == Symptomes.PROBLEMES_COEUR) {
			Medecin medecin = rechercherMedecinParSpecialite(Specialite.CARDIOLOGUE);
			medecin.ajouterPatient(patient);
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
		Consultation1 other = (Consultation1) obj;
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
		if (date == ((Consultation1) o).getDate() && matricule == ((Consultation1) o).getMatricule()) {
			return 0;
		}else {
			if (date.compareTo(((Consultation1) o).getDate()) > 0){
				return 1;	
			}else {
				return -1;
			}
		}
	}

	
	
	//programmer consultation

    /*
	public boolean chambreDispo(int nCh){
	  return (0 < nCh && nCh < getNbChambres() && !m_t.get(nCh).estPleine());
	}

	public int getChambreDispo(){
	  int maxNonPlein = -1;
	  int rs = -1;
	  for (int k = 0; k < m_t.size(); ++k){
	    if (!m_t.get(k).estPleine() && m_t.get(k).getOccupation() > maxNonPlein){
	      rs = k;
	      maxNonPlein = m_t.get(k).getOccupation();
	    }
	  }
	  return rs;
	}

	private boolean ajouterpatient(patient p, int nCh){
	  if (!chambreDispo(nCh)){
	    return false;
	  }
	  else{
	    boolean b = m_t.get(nCh).ajouterPatient(p);
	    if (m_t.get(nCh).getOccupation() == 1){
	      --m_nChVides;
	    }
	    if (m_t.get(nCh).estPleine()){
	      ++m_nChPleines;
	    }
	    ++m_nLitsOcc;
	    return true;
	  }
	}

	
	

	public String int2str(int n){
	  return ""+n;
	}

	public void initialiserAvecTableau(int[] t, int n){
	  String nom = "p";
	  int ns = 1;
	  boolean b;
	  for (int k = 0; k < n; ++k){
	    for (int j = 0; j < t[k]; ++j, ++ns){
	      patient p = new patient(nom+int2str(ns), ns);
	      b = ajouterpatient(p, k);
	      if (!b){
	        System.out.println("*** Pas de place dans la chambre "+int2str(k)
	            +" pour le patient "+nom+int2str(ns));
	      }
	    }
	  }
	}

	public double tauxOccup(){
	  return 1.0 * m_nLitsOcc / m_nLits;
	}

	public void afficher(){
	  System.out.println("Hopital "+m_nom);
	  System.out.println("  Nb de chambres = "+m_t.size());
	  System.out.println("  Capacite en lits = "+m_nLits);
	}

	public void afficherStats(){
	  System.out.println("  Nb lits occupes     = "+m_nLitsOcc);
	  System.out.println("  Nb chambres vides   = "+m_nChVides);
	  System.out.println("  Nb chambres pleines = "+m_nChPleines);
	  System.out.println("  Taux d'occupation   = "+tauxOccup());
	}

	public void afficherOccupation(){
	  System.out.println("Nombre patients par chambre");
	  for (int k = 0; k < m_t.size(); ++k){
	    System.out.println(" Chambre "+k+" : "+m_t.get(k).getOccupation());
	  }
	}

	public void afficherPatientsParChambre(){
	  System.out.println("Patients par chambre");
	  for (int k = 0; k < m_t.size(); ++k){
	    System.out.print(" Chambre "+k+" : ");
	    m_t.get(k).afficher();
	    System.out.println();
	  }
	}

	public void afficherTout(){
	  afficher();
	  afficherOccupation();
	  afficherStats();
	  afficherPatientsParChambre();
	}
	*/	
}
