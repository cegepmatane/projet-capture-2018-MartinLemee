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

public class VueMois extends Scene{
	
	protected GridPane grilleTemperature;
	private ControleurTemperature controleur = null;
	private Label valeurJour, valeurTemperature;
	private Button boutonJour, boutonAnnee;
	
	public VueMois() {
		super(new GridPane(),400,400);
		grilleTemperature = (GridPane)this.getRoot();
		this.boutonJour = new Button("Jour");
		this.boutonAnnee = new Button("Annee");
	
		this.grilleTemperature.getChildren().clear();
		this.grilleTemperature.add(new Label("Jour"),0,0);
		this.grilleTemperature.add(new Label("Temperature(°C)"),1,0);
		
		int position=1;
		this.boutonJour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueJour();
			}
		});
		this.boutonAnnee.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueAnnee();
			}
		});
		this.grilleTemperature.add(this.boutonJour, 1, ++position);
		this.grilleTemperature.add(this.boutonAnnee, 2, ++position);
	}
	
	public void afficherListeEquipes(List<Temperature> listeTemperatures) {
		/*this.grilleTemperature.getChildren().clear();
		this.grilleTemperature.add(new Label("Jour"),0,0);
		this.grilleTemperature.add(new Label("Temperature(°C)"),1,0);*/
		//this.grilleTemperature.add(new Label(""), 4, 0);
		int position=1;
		for(Temperature temperature:listeTemperatures) {
			position++;
			this.grilleTemperature.add(new Label(""+temperature.getDate().getDay()), 0, position);
			this.grilleTemperature.add(new Label(""+temperature.getTemperature()), 1, position);
		}
		/*this.boutonJour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueJour();
			}
		});
		this.boutonAnnee.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueAnnee();
			}
		});
		this.grilleTemperature.add(this.boutonJour, 1, ++position);
		this.grilleTemperature.add(this.boutonAnnee, 2, ++position);*/
	}
	
	public void setControleur(ControleurTemperature controleur) {
		this.controleur = controleur;
	}
}
