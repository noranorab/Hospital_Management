package Gestion;

import java.util.HashMap;
import java.util.Map;

public class Medicament {
	private int matricule;
	private Maladie maladie;
	private Map dictMedicament = new HashMap();
	private int nbMedicament = 0;
	
	Medicament(int matricule){
		this.matricule = matricule;
		this.nbMedicament = nbMedicament++;
	}
	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	public Maladie getMaladie() {
		return maladie;
	}
	public void setMaladie(Maladie maladie) {
		this.maladie = maladie;
	}

	public String consulterMedicament(Medicament medicament) {
		return "matricule du medicament :" +this.matricule + '\n' +
				"maladie : " + this.maladie + '\n';
	}

	//retourner la maladie soignée par le medicament identifie par matricule
	public Maladie getMaladie(int matricule) {
		return (Maladie) dictMedicament.get(matricule);
	}
	
	public void ajouterMedicament(int matricule) {
		if (this.dictMedicament.containsKey(matricule)) {
			this.dictMedicament.put(matricule, this.maladie);
		}else {
			System.out.println("medicament existe");
		}
		
	}