package modele;

import java.sql.Date;

public class Temperature {
	
	protected int id;
	protected double temperature;
	protected Date date;
	
	public Temperature(double temperature, Date date) {
		super();
		this.temperature = temperature;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
