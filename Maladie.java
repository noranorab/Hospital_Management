package Gestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Maladie {
	private String nomMaladie;
	private int matriculeMedicament;
	private String EtatMaladie;
	private Map dictMaladie = new HashMap();

	
	Maladie(){}
	Maladie(String nom){
		this.nomMaladie = nom;
	}
	public String getNomMaladie() {
		return this.nomMaladie;
	}
	
	public String getEtatMaladie() {
		return EtatMaladie;
	}
	public void setEtatMaladie(String etatMaladie) {
		EtatMaladie = etatMaladie;
	}
	public void setNomMaladie(String nomMaladie) {
		this.nomMaladie = nomMaladie;
	}
	
	//avoir le médicmanet qui soigne la maladie 
	public Medicament getMedicament(Maladie maladie) {
		return (Medicament) dictMaladie.get(maladie);
	}
	
	public String consulterMaladie(Maladie maladie) {
		return "nom de la maladie :" + this.nomMaladie + '\n' +
				"medicament : " + this.matriculeMedicament + '\n' +
				"EtatMaladie : " + this.EtatMaladie;
	}
	
	public void ajouteMaladie(Maladie maladie) {
		if (!(this.dictMaladie.containsKey(maladie))) {
			this.dictMaladie.put(maladie, this.matriculeMedicament);
		}else {
			System.out.println("cette maladie existe");
		}
		
	}
	
	
	

	
	
	

}
