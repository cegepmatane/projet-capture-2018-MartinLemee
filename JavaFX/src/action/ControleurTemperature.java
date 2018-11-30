package action;

import vue.NavigateurDesVues;
import vue.VueAccueil;
import vue.VueAnnee;
import vue.VueJour;
import vue.VueMois;

public class ControleurTemperature {
	
	private NavigateurDesVues navigateur;
	
	private VueAccueil vueAccueil = null;
	private VueAnnee vueAnnee = null;
	private VueMois vueMois = null;
	private VueJour vueJour = null;
	

	private static ControleurTemperature instance = null;
	public static ControleurTemperature getInstance() {
		if(null == instance) {
			instance = new ControleurTemperature();
		}
		return instance;
	}
	
	public void notifierNaviguerVueAccueil(){
		this.navigateur.naviguerVersVueAccueil();
	}
	
	public void notifierNaviguerVueJour(String annee, String mois, String jour){
		this.vueJour.getDate(annee, mois, jour);
		this.navigateur.naviguerVersVueJour();
	}
	
	public void notifierNaviguerVueMois(String annee, String mois){
		this.vueMois.getDate(annee, mois);
		this.navigateur.naviguerVersVueMois();
	}
	
	public void notifierNaviguerVueAnnee(String annee){
		this.vueAnnee.getDate(annee);
		this.navigateur.naviguerVersVueAnnee();
	}
	
	public void afficherVues(NavigateurDesVues navigateur) {
		this.navigateur = navigateur;
		this.navigateur.naviguerVersVueAccueil();

		this.vueAccueil = navigateur.getVueAccueil();
		this.vueAnnee = navigateur.getVueAnnee();
		this.vueMois = navigateur.getVueMois();
		this.vueJour = navigateur.getVueJour();
		
		
		/*List<Temperature> listeTemperatures = temperatureDAO.montrerListeTemperature();
		vueJour.afficherListeTemperature(listeTemperatures);
		this.navigateur.naviguerVersVueJour();*/
	}
}
