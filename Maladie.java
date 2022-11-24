package Gestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Maladie {
	private String nomMaladie;
	private Map dictMaladie = new HashMap();
	private List maladies = new ArrayList();
	private List medicaments = new ArrayList();
	
	Maladie(){}
	Maladie(String nom){
		this.nomMaladie = nom;
	}
	
	//dosage du medicament selon etat du patient --> consultation
	public int dosage(int idMedicament, Patient patient) {
		//dosage selon maladie
		Medicament medicament = rechercherMedicament(idMedicament);
		Maladie maladie = (Maladie) this.dictMaladie.get(idMedicament);
		if (EtatPatient.GUERI != null) return 500;
		if (EtatPatient.MALADE != null) return 1000;
		if (EtatPatient.SOUFFRANT != null) return 1500;
		return 0;
		
	}
	
	public Maladie rechercherMaladie(int matricule) {
		return null;
	}
	
	public Medicament rechercherMedicament(int matricule) {
		return null;
	}
	public void ajouterMaladie(String nomMaladie) {
		List listMaladie = this.maladies;
		Iterator it = listMaladie.iterator();
		Boolean contientMaladie = false;
		while (it.hasNext()) {
			if (((Maladie) it.next()).nomMaladie.equals(nomMaladie)) {
				contientMaladie = true;
				break;
			}
		}
		if (contientMaladie == false) {
			listMaladie.add(nomMaladie);
		}else {
			System.out.println("Maladie existante!");
		}
		
	}
	
	
	

}
