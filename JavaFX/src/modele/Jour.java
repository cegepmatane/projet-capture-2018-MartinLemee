package modele;

import java.util.ArrayList;

public class Jour {

	protected String jour;
	protected String mois;
	protected String annee;
	protected ArrayList<Heure> lesHeures;
	protected ArrayList<Temperature> lesTemperatures;
	
	public Jour() {
		super();
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}
	
	public ArrayList<Heure> getLesHeures() {
		return lesHeures;
	}

	public void setLesHeures(ArrayList<Heure> lesHeures) {
		this.lesHeures = lesHeures;
	}
	
	public void addUneHeure(Heure uneHeure){
        if (lesHeures == null){
            lesHeures = new ArrayList<Heure>();
        }
        lesHeures.add(uneHeure);
    }

	public ArrayList<Temperature> getLesTemperatures() {
		return lesTemperatures;
	}

	public void setLesTemperatures(ArrayList<Temperature> lesTemperatures) {
		this.lesTemperatures = lesTemperatures;
	}
	
	public void addUneTemperature(Temperature uneTemperature){
        if (lesTemperatures == null){
            lesTemperatures = new ArrayList<Temperature>();
        }
        lesTemperatures.add(uneTemperature);
    }
}
