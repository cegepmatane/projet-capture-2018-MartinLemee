package vue;

import action.ControleurTemperature;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class VueAnnee extends Scene {
	
	private ControleurTemperature controleur = null;
	private Label valeurMois, valeurTemperature;
	private Button boutonJour, boutonMois;
	
	public VueAnnee() {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleTemperature = new GridPane();
		this.boutonMois = new Button("Mois");
		this.boutonJour = new Button("Jour");
		
		valeurMois = new Label();
		grilleTemperature.add(new Label("Mois: "), 0, 0);
		grilleTemperature.add(valeurMois, 1, 0);
		
		valeurTemperature = new Label();
		grilleTemperature.add(new Label("Temperature: "),0,1);
		grilleTemperature.add(valeurTemperature, 1, 1);
	}
	
	public void setControleur(ControleurTemperature controleur) {
		this.controleur = controleur;
	}
}
