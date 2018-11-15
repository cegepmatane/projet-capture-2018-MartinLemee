package vue;

import java.util.List;

import action.ControleurTemperature;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Temperature;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class VueJour extends Scene{
	
	protected GridPane grilleTemperature;
	private ControleurTemperature controleur = null;
	private Button boutonMois, boutonAnnee;
	
	public VueJour() {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		grilleTemperature = new GridPane();
		this.boutonMois = new Button("Mois");
		this.boutonAnnee = new Button("Annee");
	}
	
	public void afficherListeEquipes(List<Temperature> listeTemperatures) {
		this.grilleTemperature.getChildren().clear();
		this.grilleTemperature.add(new Label("Heure"),0,0);
		this.grilleTemperature.add(new Label("Temperature(°C)"),1,0);
		//this.grilleTemperature.add(new Label(""), 4, 0);
		int position=1;
		for(Temperature temperature:listeTemperatures) {
			position++;
			this.grilleTemperature.add(new Label(temperature.getDate().getHours()+":"+temperature.getDate().getMinutes()), 0, position);
			this.grilleTemperature.add(new Label(""+temperature.getTemperature()), 1, position);
		}
		this.boutonMois.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueMois();
			}
		});
		this.boutonAnnee.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueAnnee();
			}
		});
		this.grilleTemperature.add(this.boutonMois, 1, ++position);
		this.grilleTemperature.add(this.boutonAnnee, 2, ++position);
	}
	
	public void setControleur(ControleurTemperature controleur) {
		this.controleur = controleur;
	}
}
