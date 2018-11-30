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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Heure;
import modele.Jour;

public class VueJour extends Scene{
	
	protected GridPane grilleTemperature;
	private String monAnnee = "2018";
	private String monMois = "11";
	private String monJour = "19";
	private Button retour;
	
	private ControleurTemperature controleur = null;
	
	public void setControleur(ControleurTemperature controleur) {
		this.controleur = controleur;
	}
	
	public VueJour() {
		super(new GridPane(),400,400);
		System.out.println("VueJour : VueJour()");
		
		grilleTemperature = (GridPane)this.getRoot();
		
		this.retour = new Button("Retour");
		this.retour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueAccueil();
			}
		});
		
		Jour jour = valeurMeteo(urlXml("http://167.114.152.43/PHP/" + monAnnee + "/" + monMois + "/" + monJour));
		
		this.grilleTemperature.getChildren().clear();
		this.grilleTemperature.add(new Label("Date :  "),0,0);
		this.grilleTemperature.add(new Label(jour.getJour()+ " / " + jour.getMois() + " / " + jour.getAnnee()),1,0);
		
		int rand = 1;
		for (Heure uneHeure : jour.getLesHeures()) {
			this.grilleTemperature.add(new Label("Heure : " + uneHeure.getHeure()),0,rand);
			rand++;
			this.grilleTemperature.add(new Label("Tempéarture : " + uneHeure.getTemperatures()),1,rand);
			rand++;
		}
		
		this.grilleTemperature.add(this.retour, 0, rand);	
	}
	
	
	public void getDate(String annee, String mois, String jour) {
		monAnnee = annee;
		monMois = mois;
		monJour = jour;
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
	
	private Jour valeurMeteo(String xml) {
		Jour unJour = new Jour();
		
		String heureTrouve;
		String temperatureTrouve;
		
		
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(xml));

			Document doc = builder.parse(src);

			unJour.setAnnee(doc.getElementsByTagName("annee").item(0).getTextContent());
			unJour.setMois(doc.getElementsByTagName("mois").item(0).getTextContent());
			unJour.setJour(doc.getElementsByTagName("jour").item(0).getTextContent());
			
			NodeList listeHeures = doc.getElementsByTagName("heure");

			for (int i=0; listeHeures.getLength()>i; i++) {
				Heure uneHeure = new Heure();
				
				heureTrouve = doc.getElementsByTagName("heure").item(i).getTextContent();
	            //System.out.println("mois trouve: " + moisTrouve);
	            uneHeure.setHeure(heureTrouve);
				
				temperatureTrouve = doc.getElementsByTagName("temperature").item(i).getTextContent();
	            //System.out.println("mois trouve: " + moisTrouve);
				uneHeure.setTemperatures(temperatureTrouve);
				
	            unJour.addUneHeure(uneHeure);
		               
	        }
			
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return unJour;
	}
}
