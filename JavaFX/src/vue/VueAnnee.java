package vue;

import action.ControleurTemperature;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class VueAnnee extends Scene {
	
	private ControleurTemperature controleur;
	
	public VueAnnee() {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleTemperature = new GridPane();
	}
	
	public void setControleur(ControleurTemperature controleur) {
		this.controleur = controleur;
	}
}
