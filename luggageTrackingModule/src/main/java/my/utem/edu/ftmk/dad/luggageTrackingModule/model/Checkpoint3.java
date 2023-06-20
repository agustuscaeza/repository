package my.utem.edu.ftmk.dad.luggageTrackingModule.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "cp3")
public class Checkpoint3 {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "CP3ID")
	private int cp3ID;
	
	public int getcp3ID() {
		return cp3ID;
	}

	public void setCP3ID(int cp3id) {
		cp3ID = cp3id;
	}	
	
    @Column(name = "Date")
    private LocalDate Date;
	
	@Column (name = "Time")
	private LocalTime Time;
	
	@Column (name = "TruckID")
	private String TruckID;
	
	@Column (name = "LuggageID")
	private String LuggageID;

	public LocalDate getDate() {
		return Date;
	}

	public void setDate(LocalDate date) {
		Date = date;
	}

	public LocalTime getTime() {
		return Time;
	}

	public void setTime(LocalTime time) {
		Time = time;
	}

	public String getTruckID() {
		return TruckID;
	}

	public void setTruckID(String truckID) {
		TruckID = truckID;
	}

	public String getLuggageID() {
		return LuggageID;
	}

	public void setLuggageID(String luggageID) {
		LuggageID = luggageID;
	}
	
}
