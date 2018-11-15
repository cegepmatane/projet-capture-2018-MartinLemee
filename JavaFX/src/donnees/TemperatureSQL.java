package donnees;

public interface TemperatureSQL {
	public static final String SQL_LISTER_TEMPERATURES = "SELECT * FROM temeratures";
	public static final String SQL_RAPPORTER_TEMPERATURES = "SELECT * FROM temperatures WHERE date > ?";
}
