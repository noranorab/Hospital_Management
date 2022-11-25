package projet;

import java.util.ArrayList;
import java.util.Date;

public class Hopital {
	  private ArrayList<consultation> consultation;
	  private ArrayList<patient> patient;
	   private ArrayList<Chambre> chambre;
	   private int nbrLits;
	   private int nbrLitsOcc;
	   private int nbChambreVides;
	   private int nbreChambrePleines;
	   private String nom;

	public Hopital (){
	 
	}
	public String getnomhopital() {
		return this.nom;
	}
	public void setnomHopital(String nom) {
		this.nom= nom;
	}
	public int nbrpatient(){
	  return patient.size();
	}

	public int getNbChambres(){
	  return chambre.size();
	}

	public int nbreChambrePleines(){
	  return nbreChambrePleines;
	}

	public int getNbChVides(){
	  return nbChambreVides;
	}

	public boolean chambreDispo(int nCh){
	  return (0 < nCh && nCh < getNbChambres() && !chambre.get(nCh).estPleine());
	}

	public int getChambreDispo(){
	  int maxNonPlein = -1;
	  int rs = -1;
	  for (int k = 0; k < chambre.size(); ++k){
	    if (!chambre.get(k).estPleine() && chambre.get(k).getOccupation() > maxNonPlein){
	      rs = k;
	      maxNonPlein = chambre.get(k).getOccupation();
	    }
	  }
	  return rs;
	}

	private void ajouterpatient(int nCh ,String nom,String prenom ,int matricule, Date dateEentre){

		patient p=this.recherchepatient(matricule);
		if(p!=null) {
		          System.out.println("ce patient existe déja dans l'hopital")	;	}
	  else{
		  if (!chambreDispo(nCh)){
			    System.out.println("il n ya pas de chambre disponible");
			  }
			  else{
				p = new patient(nom, prenom, matricule, dateEentre,nCh);
			    if (chambre.get(nCh).getOccupation() == 1){
			      --nbChambreVides;
			    }
			    if (chambre.get(nCh).estPleine()){
			    	++nbreChambrePleines;
			    }
			    ++nbrLitsOcc;
			  }
		  }
	  
	}
	
	

	public consultation rechercheconsultation(int codeconsultation) {
		for(int i=0;i<this.consultation.size();i++) {
			if( consultation.get(i).getCodeconsultation()==codeconsultation) {
				return consultation.get(i);
			}
		}
		return null;
	}
	public patient recherchepatient(int matricule) {
		for(int i=0;i<this.patient.size();i++) {
			if( patient.get(i).getmatricule()==matricule) {
				return patient.get(i);
			}
		}
		return null;
	}

	
	

	public double tauxOccup(){
	  return 1.0 * nbrLitsOcc / nbrLits;
	}

	public void afficher(){
	  System.out.println("Hopital "+ nom);
	  System.out.println("  Nb de chambres = "+chambre.size());
	  System.out.println("  Capacite en lits = "+nbrLits);
	}

	public void afficherStats(){
	  System.out.println("  Nb lits occupes     = "+nbrLitsOcc);
	  System.out.println("  Nb chambres vides   = "+nbChambreVides);
	  System.out.println("  Nb chambres pleines = "+nbreChambrePleines);
	  System.out.println("  Taux d'occupation   = "+tauxOccup());
	}

	public void afficherOccupation(){
	  System.out.println("Nombre patients par chambre");
	  for (int k = 0; k < chambre.size(); ++k){
	    System.out.println(" Chambre "+k+" : "+chambre.get(k).getOccupation());
	  }
	}

	public void afficherPatientsParChambre(){
	  System.out.println("Patients par chambre");
	  for (int k = 0; k < chambre.size(); ++k){
	    System.out.print(" Chambre "+k+" : ");
	    chambre.get(k).afficher();
	    System.out.println();
	  }
	}

	public void afficherTout(){
	  afficher();
	  afficherOccupation();
	  afficherStats();
	  afficherPatientsParChambre();
	}

}



