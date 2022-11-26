package projet;
import java.util.*;


public class Patient extends Personne {
	private int  matricule;
	/*private maladie maladie;
	private medecin medecin;*/
	private EtatPatient
	private Date dateEntree ;
	private Date dateSortiePrevue;
	private Date dateSortieEffective;
	private int chambre;
    public patient(String nom,String prenom ,int matricule, Date dateEntree,int ch, Date dateSortiePrevue) {
    	super(nom,prenom);
    	this.matricule = matricule;
		/*this.maladie=maladie;
		this.medecin=medecin;*/
		this.chambre = ch;
		this.dateEntre = dateEntree;
		this.dateSortiePrevue = dateSortiePrevue;
		this.dateSortieEffective = null;
		
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
	public Date getDateEntree(Patient patient) {
		return getDateEntree;
	}
	@Override
	public String toString() {
		return this.getmatricule() + "_" + super.toString();
	}
	public EtatPatient etatPatient() {
		if(this.dateSortieEffective!=null) return EtatPatient.GUERI;
		else if(this.dateSortiePrevue.after(new Date())) return EtatPatient.HOSPITALISE;
		else return EtatPatient.NON_HOSPITALISE;
	}
}

