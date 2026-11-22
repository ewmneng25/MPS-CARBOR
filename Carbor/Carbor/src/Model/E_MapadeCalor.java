package Model;

import java.util.ArrayList;
import java.util.List;

public class E_MapadeCalor {
	
	private String bairro;
	private double latitude;
	private double longitude;
	
	public E_MapadeCalor(String bairro, double latitude, double longitude) {
		this.bairro = bairro;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


}
