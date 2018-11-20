package vue;

import action.ControleurTemperature;
import javafx.application.*;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application{

	private ControleurTemperature controleur;
	private Stage stade;
	
	private VueAccueil vueAccueil;
	private VueAnnee vueAnnee;
	private VueMois vueMois;
	private VueJour vueJour;
	
	public NavigateurDesVues() {
		System.out.println("NavigateurDesVues : NavigateurDesVues()");
		
		this.vueAccueil = new VueAccueil(); 
		this.vueAnnee = new VueAnnee();
		this.vueMois = new VueMois();
		this.vueJour = new VueJour();
	}
	
	@Override
	public void start(Stage stade) throws Exception {
		System.out.println("NavigateurDesVues : start");
		
		this.stade=stade;
		stade.setTitle("Station météo");
		
		this.controleur = ControleurTemperature.getInstance();
		controleur.afficherVues(this);
		
		this.vueAnnee.setControleur(controleur);
		this.vueMois.setControleur(controleur);
		this.vueJour.setControleur(controleur);
		stade.setScene(this.vueAccueil);
		//stade.setScene(null);
		//stade.show();
	}

	public VueAccueil getVueAccueil() {
		return vueAccueil;
	}
	
	public VueAnnee getVueAnnee() {
		return vueAnnee;
	}

	public VueMois getVueMois() {
		return vueMois;
	}

	public VueJour getVueJour() {
		return vueJour;
	}
	
	public void naviguerVersVueAccueil() {
		stade.setScene(this.vueAccueil);
		stade.show();
	}
	
	public void naviguerVersVueAnnee() {
		stade.setScene(this.vueAnnee);
		stade.show();
	}
	
	public void naviguerVersVueMois() {
		stade.setScene(this.vueMois);
		stade.show();
	}
	
	public void naviguerVersVueJour() {
		stade.setScene(this.vueJour);
		stade.show();
	}
	
	
}
