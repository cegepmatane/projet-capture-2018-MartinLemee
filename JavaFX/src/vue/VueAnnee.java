package vue;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

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
import modele.Annee;
import modele.Mois;
import modele.Temperature;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class VueAnnee extends Scene {
	
	private ControleurTemperature controleur = null;

	protected GridPane grilleTemperature;
	private Label valeurMois, valeurTemperature;
	private Button retour;
	
	public void setControleur(ControleurTemperature controleur) {
		this.controleur = controleur;
	}
	
	public VueAnnee() {
		super(new GridPane(),400,400);
		System.out.println("VueAnnee : VueAnnee()");
		
		grilleTemperature = (GridPane)this.getRoot();
		
		this.retour = new Button("Retour");
		this.retour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controleur.notifierNaviguerVueAccueil();
			}
		});
		
		Annee annee = valeurMeteo(urlXml("http://167.114.152.43/PHP/2018/"));
		
		this.grilleTemperature.getChildren().clear();
		this.grilleTemperature.add(new Label("Mois"),0,0);
		this.grilleTemperature.add(new Label("Temperature(°C)"),0,1);
		this.grilleTemperature.add(this.retour, 0, 2);
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
			   //System.out.println(fileXml);
			   
			   return xml;
			   
		} catch (Exception e) {
		    e.printStackTrace();
		    return "erreur lecture";
		}
	}
	
	private Annee valeurMeteo(String xml) {
		Annee uneAnne = new Annee();
		
		String moisTrouve;
		String max;
		String min;
		String moyenne;
		
		
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(xml));

			Document doc = builder.parse(src);

			uneAnne.setAnnee(doc.getElementsByTagName("annee").item(0).getTextContent());
			
			NodeList listeMois = doc.getElementsByTagName("mois");

			for (int i=0; listeMois.getLength()>i; i++) {
				Mois unMois = new Mois();
				Temperature uneTemperature = new Temperature();
				
	            moisTrouve = doc.getElementsByTagName("mois").item(i).getTextContent();
	            System.out.println("mois trouve: " + moisTrouve);
	            unMois.setMois(moisTrouve);
	            
	            max = doc.getElementsByTagName("max").item(i).getTextContent();
	            //System.out.println("max: " + max);
	            uneTemperature.setMax(max);
	            
	            min = doc.getElementsByTagName("min").item(i).getTextContent();
	            //System.out.println("min: " + min);
	            uneTemperature.setMin(min);
	            
	            moyenne = doc.getElementsByTagName("moyenne").item(i).getTextContent();
	            //System.out.println("moy: " + moyenne);
	            uneTemperature.setMoyenne(moyenne);
	            
	            unMois.addUneTemperature(uneTemperature);
	            uneAnne.addUnMois(unMois);
		               
	        }
			
		} catch (Exception e) {
		    e.printStackTrace();
		}
		System.out.println("mois choisi: " + uneAnne.getLesMois().get(0).getMois());
		return uneAnne;
	}

}
