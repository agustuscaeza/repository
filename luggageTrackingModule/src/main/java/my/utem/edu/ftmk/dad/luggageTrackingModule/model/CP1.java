package my.utem.edu.ftmk.dad.luggageTrackingModule.model;



import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author MONALIZA
 *
 */
@Entity
@Table (name = "cp1")
public class CP1 {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "cp1ID")
	private int Cp1ID;
	
	@Column (name = "Date")
	private LocalDate cp1Date;
	
	@Column (name = "Time")
	private LocalTime cp1Time;

	@ManyToOne
	@JoinColumn (name = "AirportID")
	private Airport Airport;

	@ManyToOne
	@JoinColumn (name = "LuggageID")
	private Luggage Luggage;

	public int getCp1ID() {
		return Cp1ID;
	}

	public void setCp1ID(int cp1id) {
		Cp1ID = cp1id;
	}

	public LocalDate getCp1Date() {
		return cp1Date;
	}

	public void setCp1Date(LocalDate cp1Date) {
		this.cp1Date = cp1Date;
	}

	public LocalTime getCp1Time() {
		return cp1Time;
	}

	public void setCp1Time(LocalTime cp1Time) {
		this.cp1Time = cp1Time;
	}

	public Airport getAirport() {
		return Airport;
	}

	public void setAirport(Airport airport) {
		Airport = airport;
	}

	public Luggage getLuggage() {
		return Luggage;
	}

	public void setLuggage(Luggage luggage) {
		Luggage = luggage;
	}

	

	

	
	


}
