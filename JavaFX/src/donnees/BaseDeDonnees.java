package donnees;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDonnees {
private Connection connection = null;
	
	private BaseDeDonnees()
	{
		/*try {
			Class.forName(Acces.BASEDEDONNEES_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(Acces.BASEDEDONNEES_URL, Acces.BASEDEDONNEES_USAGER, Acces.BASEDEDONNEES_MOTDEPASSE);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}
	
	private static BaseDeDonnees instance = null;
	public static BaseDeDonnees getInstance()
	{
		if(null == instance) instance = new BaseDeDonnees();
		return instance;
	}

	public Connection getConnection()
	{
		return this.connection;
	}
}
