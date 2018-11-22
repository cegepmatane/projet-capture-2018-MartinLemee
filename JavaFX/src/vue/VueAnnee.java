package vue;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import action.ControleurTemperature;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
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
		valeurMeteo(urlXml("http://167.114.152.43/PHP/2018/"));
		
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
	
	
	private void valeurMeteo(String xml) {
		ArrayList<String> meteo = new ArrayList<>();
		String annee;
		ArrayList<String> mois = new ArrayList<>();
		ArrayList<String> temperature = new ArrayList<>();
		String max;
		String min;
		String moyenne;
		
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(xml));

			Document doc = builder.parse(src);
			
			annee = doc.getElementsByTagName("annee").item(0).getTextContent();
			max = doc.getElementsByTagName("max").item(0).getTextContent();
			
			System.out.println(annee);
			System.out.println(max);
			
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}

}
