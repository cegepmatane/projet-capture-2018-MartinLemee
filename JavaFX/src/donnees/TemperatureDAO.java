package donnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import modele.Temperature;

public class TemperatureDAO implements TemperatureSQL{
	Connection connexion = null;
	
	public TemperatureDAO(){
		this.connexion = BaseDeDonnees.getInstance().getConnection();		
	}
	
	public List<Temperature> montrerListeTemperature(){
		
		List<Temperature> listeTemperature =  new ArrayList<Temperature>();
		try {
 			Statement requeteListeTemperature = connexion.createStatement();
 			ResultSet curseurListeTemperature = requeteListeTemperature.executeQuery(SQL_LISTER_TEMPERATURES);
 			while(curseurListeTemperature.next()) {
 				int id = curseurListeTemperature.getInt("id");
 	 			String date = curseurListeTemperature.getString("date");
 	 			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
 	 			Date d;
 	 			try {
 	 				double valeur = curseurListeTemperature.getDouble("temperature");
 	 				d = formatter.parse(date);
 	 				Temperature temperature = new Temperature(valeur,d);
 	 				temperature.setId(id);
 	 	 			listeTemperature.add(temperature);
 	 			}catch(ParseException e) {
 	 				e.printStackTrace();
 	 			}
 			}
 		}catch(SQLException e) {
 			e.printStackTrace();
 		}
		return listeTemperature;
	}
}
