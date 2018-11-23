package modele;

import java.util.ArrayList;

public class Mois {

	protected String mois;
	protected ArrayList<Temperature> lesTemperatures;
	
	public Mois() {
		super();
	}

	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
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
