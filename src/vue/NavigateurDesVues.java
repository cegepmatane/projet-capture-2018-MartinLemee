package vue;

import javafx.application.*;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application{

	private Stage stade;
	private VueAnnee vueAnnee;
	private VueMois vueMois;
	private VueJour vueJour;
	
	public void NavigateurDesVues() {
		this.vueAnnee = new VueAnnee();
		this.vueMois = new VueMois();
		this.vueJour = new VueJour();
	}
	
	@Override
	public void start(Stage stade) throws Exception {
		this.stade=stade;
		stade.setScene(null);
		stade.show();
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
