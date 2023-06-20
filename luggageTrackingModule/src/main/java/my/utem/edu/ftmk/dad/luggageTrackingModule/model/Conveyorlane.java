package my.utem.edu.ftmk.dad.luggageTrackingModule.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "conveyorlane")
public class Conveyorlane {
	
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name = "ConveyorLaneID")
	private int ConveyorLaneID;
	
	@Column (name = "LaneNumber")
	private String LaneNumber;
	
	public int getConveyorLaneID() {
		return ConveyorLaneID;
	}
	public void setConveyorLaneID(int conveyorLaneID) {
		ConveyorLaneID = conveyorLaneID;
	}
	
	public String getLaneNumber() {
		return LaneNumber;
	}
	public void setLaneNumber(String laneNumber) {
		LaneNumber = laneNumber;
	}
	
	
	
	

}
