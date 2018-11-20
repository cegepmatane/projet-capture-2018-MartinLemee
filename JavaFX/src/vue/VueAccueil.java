package vue;

import action.ControleurTemperature;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class VueAccueil extends Scene {
	
	private ControleurTemperature controleur = null;

	protected GridPane grilleTemperature;
	private Button boutonJour, boutonMois, boutonAnnee;
	
	public void setControleur(ControleurTemperature controleur) {
		this.controleur = controleur;
	}
	
	public VueAccueil() {
		super(new GridPane(),400,400);
		System.out.println("VueAccueil : VueAccueil()");
		
		grilleTemperature = (GridPane)this.getRoot();
		
		this.boutonJour = new Button("Jour");
		this.boutonJour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueJour();
			}
		});
		this.boutonMois = new Button("Mois");
		this.boutonMois.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueMois();
			}
		});
		this.boutonAnnee = new Button("Années");
		this.boutonAnnee.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueAnnee();
			}
		});
		
		this.grilleTemperature.getChildren().clear();
		this.grilleTemperature.add(new Label("Accueil"),0,0);
		this.grilleTemperature.add(this.boutonJour, 0, 1);
		this.grilleTemperature.add(this.boutonMois, 0, 2);
		this.grilleTemperature.add(this.boutonAnnee, 0, 3);
	}
	
	/*public void afficherListeEquipes(List<Temperature> listeTemperatures) {
		/*this.grilleTemperature.getChildren().clear();
		this.grilleTemperature.add(new Label("Mois"),0,0);
		this.grilleTemperature.add(new Label("Temperature(°C)"),1,0);*/
		//this.grilleTemperature.add(new Label(""), 4, 0);
		/*int position=1;
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
		this.grilleTemperature.add(this.boutonMois, 2, ++position);
	}*/
	
	
}
