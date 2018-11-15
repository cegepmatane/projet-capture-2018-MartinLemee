package vue;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
		super(new GridPane(),400,400);
		grilleTemperature = (GridPane)this.getRoot();
		this.boutonMois = new Button("Mois");
		this.boutonAnnee = new Button("Annee");
		
		this.grilleTemperature.getChildren().clear();
		this.grilleTemperature.add(new Label("Heure"),0,0);
		this.grilleTemperature.add(new Label("Temperature(°C)"),1,0);
		
		int position = 1;
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
	
	public void afficherListeTemperature(List<Temperature> listeTemperatures) {
		int position=1;
		for(Temperature temperature:listeTemperatures) {
			position++;
			//this.grilleTemperature.add(new Label(temperature.getDate().getHours()+":"+temperature.getDate().getMinutes()), 0, position);
			//this.grilleTemperature.add(new Label(""+temperature.getTemperature()), 1, position);
			try {
				File xml = new File("167.114.152.43:80/PHP/2018/11/23.php");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(xml);
				doc.getDocumentElement().normalize();
				NodeList nList = doc.getElementsByTagName("meteo");
				for(int temp=0; temp<nList.getLength();temp++) {
					Node nNode = nList.item(temp);
					Element element = (Element)nNode;
					this.grilleTemperature.add(new Label(element.getElementsByTagName("heure").item(0).getTextContent()),0,position);
					this.grilleTemperature.add(new Label(element.getElementsByTagName("temperature").item(0).getTextContent()),1,position);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setControleur(ControleurTemperature controleur) {
		this.controleur = controleur;
	}
}
