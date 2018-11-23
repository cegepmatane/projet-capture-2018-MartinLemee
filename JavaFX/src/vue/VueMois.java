package vue;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import action.ControleurTemperature;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import modele.Jour;
import modele.Mois;
import modele.Temperature;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class VueMois extends Scene{
	
	private ControleurTemperature controleur = null;

	protected GridPane grilleTemperature;
	private Button retour;
	
	public void setControleur(ControleurTemperature controleur) {
		this.controleur = controleur;
	}
	
	public VueMois() {
		super(new GridPane(),400,400);
		System.out.println("VueMois : VueMois()");
		
		grilleTemperature = (GridPane)this.getRoot();
		
		this.retour = new Button("Retour");
		this.retour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueAccueil();
			}
		});
		
		Mois mois = valeurMeteo(urlXml("http://167.114.152.43/PHP/2018/11"));
		
		this.grilleTemperature.getChildren().clear();
		this.grilleTemperature.add(new Label("Date :  "),0,0);
		this.grilleTemperature.add(new Label(mois.getMois() + " / " + mois.getAnnee()),1,0);
		
		int rand = 1;
		for (Jour unJour : mois.getLesJours()) {
			this.grilleTemperature.add(new Label("Jour : " + unJour.getJour()),0,rand);
			for (Temperature uneTemperature : unJour.getLesTemperatures()) {
				this.grilleTemperature.add(new Label("Max: " + uneTemperature.getMax()),1,rand+1);
				this.grilleTemperature.add(new Label("Min: " + uneTemperature.getMin()),1,rand+2);
				this.grilleTemperature.add(new Label("Moyenne: " + uneTemperature.getMoyenne()),1,rand+3);
			}
			rand += 4;
		}
		
		this.grilleTemperature.add(this.retour, 0, rand);
		
	}
	
	public String urlXml(String urlXml) {
		String xml = "";
		
		try {
			   URL url = new URL(urlXml);
			   HttpURLConnection request1 = (HttpURLConnection) url.openConnection();
			   request1.setRequestMethod("GET");
			   		
			   //String code = String.valueOf(request1.getResponseCode());
			   //System.out.println("Error code "+code);
			   
			   InputStream is = request1.getInputStream();

			   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
			   String line;
			   while ((line = bufferedReader.readLine()) != null) {
				   xml += line + "\n";
			   }
			   //System.out.println(xml);
			   
			   return xml;
			   
		} catch (Exception e) {
		    e.printStackTrace();
		    return "erreur lecture";
		}
	}
	
	private Mois valeurMeteo(String xml) {
		Mois unMois = new Mois();
		
		String jourTrouve;
		String max;
		String min;
		String moyenne;
		
		
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(xml));

			Document doc = builder.parse(src);

			unMois.setAnnee(doc.getElementsByTagName("annee").item(0).getTextContent());
			unMois.setMois(doc.getElementsByTagName("mois").item(0).getTextContent());
			
			NodeList listeJours = doc.getElementsByTagName("jour");

			for (int i=0; listeJours.getLength()>i; i++) {
				Jour unJour = new Jour();
				Temperature uneTemperature = new Temperature();
				
				jourTrouve = doc.getElementsByTagName("jour").item(i).getTextContent();
	            //System.out.println("mois trouve: " + moisTrouve);
				unJour.setJour(jourTrouve);
	            
	            max = doc.getElementsByTagName("max").item(i).getTextContent();
	            //System.out.println("max: " + max);
	            uneTemperature.setMax(max);
	            
	            min = doc.getElementsByTagName("min").item(i).getTextContent();
	            //System.out.println("min: " + min);
	            uneTemperature.setMin(min);
	            
	            moyenne = doc.getElementsByTagName("moyenne").item(i).getTextContent();
	            //System.out.println("moy: " + moyenne);
	            uneTemperature.setMoyenne(moyenne);
	            
	            unJour.addUneTemperature(uneTemperature);
	            unMois.addUnJour(unJour);
		               
	        }
			
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return unMois;
	}
	
	

}
