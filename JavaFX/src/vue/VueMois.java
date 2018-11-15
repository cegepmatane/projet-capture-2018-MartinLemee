package vue;

import action.ControleurTemperature;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class VueMois extends Scene{
	
	private ControleurTemperature controleur = null;
	private Label valeurJour, valeurTemperature;
	private Button boutonJour, boutonAnnee;
	
	public VueMois() {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleTemperature = new GridPane();
		this.boutonJour = new Button("Jour");
		this.boutonAnnee = new Button("Annee");
		
		valeurJour = new Label();
		grilleTemperature.add(new Label("Jour: "), 0, 0);
		grilleTemperature.add(valeurJour, 1, 0);
		
		valeurTemperature = new Label();
		grilleTemperature.add(new Label("Temperature: "),0,1);
		grilleTemperature.add(valeurTemperature, 1, 1);
	}
	
	public void setControleur(ControleurTemperature controleur) {
		this.controleur = controleur;
	}
}
