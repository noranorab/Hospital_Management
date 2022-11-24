package Gestion;

import java.util.ArrayList;
import java.util.List;

public class Specialiste extends Medecin{
	private String specialite;
	private List patients = new ArrayList();
	
	Specialiste(){}
	
	Specialiste(int matricule, String specialite){
		super(matricule);
		this.specialite = specialite;
	}
	
	

}
