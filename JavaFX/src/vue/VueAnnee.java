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

public class VueAnnee extends Scene {
	
	protected GridPane grilleTemperature;
	private ControleurTemperature controleur = null;
	private Label valeurMois, valeurTemperature;
	private Button boutonJour, boutonMois;
	
	public VueAnnee() {
		super(new GridPane(),400,400);
		grilleTemperature = (GridPane)this.getRoot();
		this.boutonMois = new Button("Mois");
		this.boutonJour = new Button("Jour");
		
		this.grilleTemperature.getChildren().clear();
		this.grilleTemperature.add(new Label("Mois"),0,0);
		this.grilleTemperature.add(new Label("Temperature(°C)"),1,0);
		
		int position = 1;
		this.boutonJour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueJour();
			}
		});
		this.boutonMois.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueMois();
			}
		});
		this.grilleTemperature.add(this.boutonJour, 1, ++position);
		this.grilleTemperature.add(this.boutonMois, 2, ++position);
	}
	
	public void afficherListeEquipes(List<Temperature> listeTemperatures) {
		/*this.grilleTemperature.getChildren().clear();
		this.grilleTemperature.add(new Label("Mois"),0,0);
		this.grilleTemperature.add(new Label("Temperature(°C)"),1,0);*/
		//this.grilleTemperature.add(new Label(""), 4, 0);
		int position=1;
		for(Temperature temperature:listeTemperatures) {
			position++;
			this.grilleTemperature.add(new Label(""+temperature.getDate().getMonth()), 0, position);
			this.grilleTemperature.add(new Label(""+temperature.getTemperature()), 1, position);
		}
		/*this.boutonJour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueJour();
			}
		});
		this.boutonMois.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueMois();
			}
		});
		this.grilleTemperature.add(this.boutonJour, 1, ++position);
		this.grilleTemperature.add(this.boutonMois, 2, ++position);*/
	}
	
	public void setControleur(ControleurTemperature controleur) {
		this.controleur = controleur;
	}
}
