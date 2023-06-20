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
@Table (name = "cp4")
public class CP4 {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "cp4ID")
	private int Cp4ID;
	
	@Column (name = "Date")
	private LocalDate cp4Date;
	
	@Column (name = "Time")
	private LocalTime cp4Time;

	@ManyToOne
	@JoinColumn (name = "FlightID")
	private Flight flight;

	@ManyToOne
	@JoinColumn (name = "LuggageID")
	private Luggage Luggage;

	public int getCp4ID() {
		return Cp4ID;
	}

	public void setCp4ID(int cp4id) {
		Cp4ID = cp4id;
	}

	public LocalDate getCp4Date() {
		return cp4Date;
	}

	public void setCp4Date(LocalDate cp4Date) {
		this.cp4Date = cp4Date;
	}

	public LocalTime getCp4Time() {
		return cp4Time;
	}

	public void setCp4Time(LocalTime cp4Time) {
		this.cp4Time = cp4Time;
	}

	public Luggage getLuggage() {
		return Luggage;
	}

	public void setLuggage(Luggage luggage) {
		Luggage = luggage;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
