package vue;

import java.util.List;

import action.ControleurTemperature;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class VueJour extends Scene{
	
	private ControleurTemperature controleur = null;
	private Label valeurHeure, valeurTemperature;
	private Button boutonMois, boutonAnnee;
	
	public VueJour() {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleTemperature = new GridPane();
		this.boutonMois = new Button("Mois");
		this.boutonAnnee = new Button("Annee");
		
		valeurHeure = new Label();
		grilleTemperature.add(new Label("Heure: "), 0, 0);
		grilleTemperature.add(valeurHeure, 1, 0);
		
		valeurTemperature = new Label();
		grilleTemperature.add(new Label("Temperature: "),0,1);
		grilleTemperature.add(valeurTemperature, 1, 1);
	}
	
	public void setControleur(ControleurTemperature controleur) {
		this.controleur = controleur;
	}
}
