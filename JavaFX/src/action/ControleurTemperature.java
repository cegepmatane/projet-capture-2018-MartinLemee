package action;

import java.util.List;

import donnees.TemperatureDAO;
import modele.Temperature;
import vue.NavigateurDesVues;
import vue.VueAnnee;
import vue.VueJour;
import vue.VueMois;

public class ControleurTemperature {
	private NavigateurDesVues navigateur;
	private VueAnnee vueAnnee;
	private VueMois vueMois;
	private VueJour vueJour;
	private TemperatureDAO temperatureDAO;
	
	public ControleurTemperature() {
		
	}

	private static ControleurTemperature instance = null;
	public static ControleurTemperature getInstance() {
		if(null == instance) {
			instance = new ControleurTemperature();
		}
		return instance;
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
		this.vueAnnee = navigateur.getVueAnnee();
		this.vueMois = navigateur.getVueMois();
		this.vueJour = navigateur.getVueJour();
		
		//List<Temperature> listeTemperatures = temperatureDAO.montrerListeTemperature();
		//vueJour.afficherListeTemperatures(listeTemperatures);
		//this.navigateur.naviguerVersVueJour();
	}
}
