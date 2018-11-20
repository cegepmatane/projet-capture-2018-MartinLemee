package action;

import java.util.List;

import donnees.TemperatureDAO;
import modele.Temperature;
import vue.NavigateurDesVues;
import vue.VueAccueil;
import vue.VueAnnee;
import vue.VueJour;
import vue.VueMois;

public class ControleurTemperature {
	private NavigateurDesVues navigateur;
	private VueAccueil vueAccueil;
	private VueAnnee vueAnnee;
	private VueMois vueMois;
	private VueJour vueJour;
	private TemperatureDAO temperatureDAO;
	
	public ControleurTemperature() {
		temperatureDAO = new TemperatureDAO();
	}

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
	
	public void notifierNaviguerVueJour(){
		this.navigateur.naviguerVersVueJour();
	}
	
	public void notifierNaviguerVueMois(){
		this.navigateur.naviguerVersVueMois();
	}
	
	public void notifierNaviguerVueAnnee(){
		this.navigateur.naviguerVersVueAnnee();
	}
	
	public void afficherVues(NavigateurDesVues navigateur) {
		this.navigateur = navigateur;
		this.vueAccueil = navigateur.getVueAccueil();
		this.vueAnnee = navigateur.getVueAnnee();
		this.vueMois = navigateur.getVueMois();
		this.vueJour = navigateur.getVueJour();
		
		this.navigateur.naviguerVersVueAccueil();
		
		/*List<Temperature> listeTemperatures = temperatureDAO.montrerListeTemperature();
		vueJour.afficherListeTemperature(listeTemperatures);
		this.navigateur.naviguerVersVueJour();*/
	}
}
