package projet;

public class Chambre {
	
		private int m_numCh; // numero de la chambre
		private int m_nbLits; // capacite en lits
		private patient[] m_tab; // tableau des patients
		private int m_litsOcc; // nombre de lits occupes

		public Chambre(){
		   m_numCh = 0;
		   m_nbLits = 0;
		   m_tab = null;
		   m_litsOcc = 0;
		}

		public Chambre(int num, int nlits){
		   m_numCh = num;
		   m_nbLits = nlits;
		   m_tab = new patient[nlits];
		   m_litsOcc = 0;
		}

		public int getNumeroCh(){
		  return m_numCh;
		}

		public int getCapacite(){
		  return m_nbLits;
		}

		public int getOccupation(){
		  return m_litsOcc;
		}

		public boolean estVide(){
		  return (getOccupation() == 0);
		}

		public boolean estPleine(){
		  return (getOccupation() == getCapacite());
		}

		public boolean ajouterPatient(patient p){
		  if (estPleine()){
		    return false;
		  }
		  else{
		    m_tab[m_litsOcc] = p;
		    ++m_litsOcc;
		    return true;
		  }
		}

		public void afficher(){
		  if (estVide()){
		    System.out.print("Aucun patient");
		  }
		  else{
		    System.out.println();
		    for (int k = 0; k < m_litsOcc; ++k){
		      m_tab[k].toString();
		    }
		  }
		}

		}


