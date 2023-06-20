package my.utem.edu.ftmk.dad.luggageTrackingModule.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "shuttletruck")
public class Shuttletruck {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "TruckID")
	private int TruckID;
	
	@Column (name = "OperatorName")
	private String OperatorName;
	
	@Column (name = "Location")
	private String Location;
	
	
	public int getTruckID() {
		return TruckID;
	}
	public void setTruckID(int truckID) {
		TruckID = truckID;
	}
	
	public String getOperatorName() {
		return OperatorName;
	}
	public void setOperatorName(String operatorName) {
		OperatorName = operatorName;
	}
	
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	

	
	
}
