package modele;

import java.util.ArrayList;

public class Annee {

	protected String annee;
	protected ArrayList<Mois> lesMois;
	
	
	public Annee() {
		super();
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public ArrayList<Mois> getLesMois() {
		return lesMois;
	}
	public void setLesMois(ArrayList<Mois> lesMois) {
		this.lesMois = lesMois;
	}
	public void addUnMois(Mois unMois){
        if (lesMois == null){
            lesMois = new ArrayList<Mois>();
        }
        lesMois.add(unMois);
    }
}