package projet;
import java.util.*;


public class patient extends Personne {
	private int  matricule;
	/*private maladie maladie;
	private medecin medecin;*/
	private Date dateEntre ;
	private Date dateSortieprévue;
	private Date dateSortieEffective;
	private int chambre;
    public patient(String nom,String prenom ,int matricule, Date dateEentre,int ch) {
    	super(nom,prenom);
    	this.matricule=matricule;
		/*this.maladie=maladie;
		this.medecin=medecin;*/
		this.chambre=ch;
		this.dateEntre=dateEntre;
		this.dateSortieprévue=dateSortieprévue;
		this.dateSortieEffective=null;
		
	
	
}
    public int getmatricule() {
		return matricule;
	}

	public void setmatricule(int matricule) {
		this.matricule = matricule;
	}
	 public int getchambre() {
			return chambre ;
		}

		public void setchambre(int chambre) {
			this.chambre = chambre;
		}
	@Override
	public String toString() {
		return this.getmatricule()+"_"+super.toString();
	}
	public Etat_patient Etatpatient() {
		if(this.dateSortieEffective!=null) return Etat_patient.Guéri;
		else if(this.dateSortieprévue.after(new Date())) return Etat_patient.ENCOURS_hospitalisation;
		else return Etat_patient.non_hospitalisé;
}}

