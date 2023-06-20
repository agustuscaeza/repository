package my.utem.edu.ftmk.dad.luggageTrackingModule.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "airport")
public class Airport {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "AirportID")
	private int AirportID;
	
	@Column (name = "DepartingAirport")
	private String DepartingAirport;
	
	@Column (name = "ArrivalAirport")
	private String ArrivalAirport;

	public int getAirportID() {
		return AirportID;
	}

	public void setAirportID(int airportID) {
		AirportID = airportID;
	}

	public String getDepartingAirport() {
		return DepartingAirport;
	}

	public void setDepartingAirport(String departingAirport) {
		DepartingAirport = departingAirport;
	}

	public String getArrivalAirport() {
		return ArrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		ArrivalAirport = arrivalAirport;
	}
	
	
	
	
	

	
	

}
