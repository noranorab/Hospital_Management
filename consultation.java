package projet;
import java.util.*;
import java.text.SimpleDateFormat;
public class consultation  {
	
    /*private medecin medecin;*/
    private patient patient;
	private int codeconsultation;
	private Date dateconsultation;
	private static int nbreconsultation=0;
	public consultation(patient patient, Date dateconsultation) {
		this.patient = patient;
		/*this.medecin=medecin:*/
		this.dateconsultation=dateconsultation;
		this.nbreconsultation=++consultation.nbreconsultation;
	}
	public consultation(patient patient,medecin medecin) {
		this(patient,medecin,new Date());
	}
	
	public int getCodeconsultation() {
		return codeconsultation;
	}
	public void setCodeAffectation(int codeAffectation) {
		this.codeconsultation = codeconsultation;
}
	public Date getdateconsultation() {
		return dateconsultation;
	}
	public void setDateAffectation(Date dateaffectation) {
		this.dateconsultation = dateconsultation;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
		return super.toString()+"_"+this.getdateconsultation()+" "+sdf.format(this.getdateconsultation());
	}
	@Override
	public int hashCode() {
		return Objects.hash(codeconsultation, dateconsultation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		consultation other = (consultation) obj;
		return codeconsultation == other.codeconsultation && Objects.equals(dateconsultation, other.dateconsultation);
	}

}
