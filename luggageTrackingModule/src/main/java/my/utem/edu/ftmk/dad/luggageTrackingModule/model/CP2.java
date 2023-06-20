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

@Entity
@Table (name = "cp2")
public class CP2 {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "cp2ID")
	private int cp2ID;
	
	@Column (name = "Date")
	private LocalDate cp2Date;
	
	@Column (name = "Time")
	private LocalTime cp2Time;

	
	@ManyToOne
	@JoinColumn (name = "ConveyorLaneID")
	private Conveyorlane conveyorlane;

	@ManyToOne
	@JoinColumn (name = "LuggageID")
	private Luggage luggage;

	public int getCp2ID() {
		return cp2ID;
	}

	public void setCp2ID(int cp2ID) {
		this.cp2ID = cp2ID;
	}

	public LocalDate getCp2Date() {
		return cp2Date;
	}

	public void setCp2Date(LocalDate cp2Date) {
		this.cp2Date = cp2Date;
	}

	public LocalTime getCp2Time() {
		return cp2Time;
	}

	public void setCp2Time(LocalTime cp2Time) {
		this.cp2Time = cp2Time;
	}

	public Conveyorlane getConveyorlane() {
		return conveyorlane;
	}

	public void setConveyorlane(Conveyorlane conveyorlane) {
		this.conveyorlane = conveyorlane;
	}


	public Luggage getLuggage() {
		return luggage;
	}

	public void setLuggage(Luggage luggage) {
		this.luggage = luggage;
	}


	

	

}
