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
@Table (name = "cp3")
public class CP3 {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "cp3ID")
	private int Cp3ID;
	
	@Column (name = "Date")
	private LocalDate cp3Date;
	
	@Column (name = "Time")
	private LocalTime cp3Time;

	@ManyToOne
	@JoinColumn (name = "TruckID")
	private Shuttletruck truck;

	@ManyToOne
	@JoinColumn (name = "LuggageID")
	private Luggage Luggage;

	public int getCp3ID() {
		return Cp3ID;
	}

	public void setCp3ID(int cp3id) {
		Cp3ID = cp3id;
	}

	public LocalDate getCp3Date() {
		return cp3Date;
	}

	public void setCp3Date(LocalDate cp3Date) {
		this.cp3Date = cp3Date;
	}

	public LocalTime getCp3Time() {
		return cp3Time;
	}

	public void setCp3Time(LocalTime cp3Time) {
		this.cp3Time = cp3Time;
	}

	public Luggage getLuggage() {
		return Luggage;
	}

	public void setLuggage(Luggage luggage) {
		Luggage = luggage;
	}

	public Shuttletruck getTruck() {
		return truck;
	}

	public void setTruck(Shuttletruck truck) {
		this.truck = truck;
	}

}
