package vue;

import java.util.ArrayList;
import java.util.Calendar;

import action.ControleurTemperature;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class VueAccueil extends Scene {
	
	private ControleurTemperature controleur = null;

	protected GridPane grilleTemperature;
	private Button boutonRechercher;
	protected ComboBox<String> selectAnnee, selectMois, selectJour;
	
	public void setControleur(ControleurTemperature controleur) {
		this.controleur = controleur;
	}
	
	public VueAccueil() {
		super(new GridPane(),400,400);
		System.out.println("VueAccueil : VueAccueil()");
		
		grilleTemperature = (GridPane)this.getRoot();
		
// Select annee
		ArrayList<String> listeAnnees = new ArrayList<String>();
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for(int year=2018; currentYear>=year; year++) {
			listeAnnees.add(year+"");
		}
		selectAnnee = new ComboBox<String>();
		selectAnnee.setPromptText("Année");
		selectAnnee.getItems().addAll(listeAnnees);
		
		
//Select mois
		ArrayList<String> listeMois = new ArrayList<String>();
		for(int mois=1; mois<=12; mois++) {
			listeMois.add(mois+"");
		}
		selectMois = new ComboBox<String>();
		selectMois.setPromptText("mois");
		selectMois.getItems().addAll(listeMois);
		
		
//Select jour
		ArrayList<String> listeJours = new ArrayList<String>();
		for(int jour=1; jour<=31; jour++) {
			listeJours.add(jour+"");
		}
		selectJour = new ComboBox<String>();
		selectJour.setPromptText("Jour");
		selectJour.getItems().addAll(listeJours);
		
//Bouton recherche
		this.boutonRechercher = new Button("Rechercher");
		this.boutonRechercher.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueJour();
			}
		});
		
		
//allimentation de la grille

		this.grilleTemperature.getChildren().clear();
		this.grilleTemperature.add(new Label("Accueil"),0,0);

		this.grilleTemperature.add(this.selectAnnee, 0, 1);
		this.grilleTemperature.add(this.selectMois, 1, 1);
		this.grilleTemperature.add(this.selectJour, 2, 1);
		this.grilleTemperature.add(this.boutonRechercher, 3, 1);
		
	}
}
