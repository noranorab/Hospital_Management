package projet;

import java.util.ArrayList;

public class Consultation1 {
	   private String m_nom;
	   private ArrayList<Chambre> m_t;
	   private int m_nLits;
	   private int m_nLitsOcc;
	   private int m_nChVides;
	   private int m_nChPleines;

	public Consultation1 (String nom, int nCh, int nlitsCh){
	   m_nom = new String(nom);
	   m_t = new ArrayList<Chambre>();
	   m_nLits = (nCh*nlitsCh);
	   m_nLitsOcc = 0;
	   m_nChVides = nCh;
	   m_nChPleines = 0;
	   // Initialise avec des chambres de capacite nlitsCh
	   for (int k = 0; k < nCh; ++k){
	      m_t.add(new Chambre(k, nlitsCh));
	   }
	}

	public String getNom(){
	  return m_nom;
	}

	public int getNbChambres(){
	  return m_t.size();
	}

	public int getNbChPleines(){
	  return m_nChPleines;
	}

	public int getNbChVides(){
	  return m_nChVides;
	}

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
}
}
