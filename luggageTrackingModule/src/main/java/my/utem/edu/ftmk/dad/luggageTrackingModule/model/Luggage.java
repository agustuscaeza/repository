package my.utem.edu.ftmk.dad.luggageTrackingModule.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "luggage")
public class Luggage {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "LuggageID")
	private int LuggageID;
		 
	
	@ManyToOne
	@JoinColumn (name = "passengerID")
	private Passenger passenger; 	
	
	
	public int getLuggageID() {
		return LuggageID;
	}
	public void setLuggageID(int luggageID) {
		LuggageID = luggageID;
	}
	
	
	public Passenger getPassenger() {
		return passenger;
	}
	
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	
	
	
	
	
	
}