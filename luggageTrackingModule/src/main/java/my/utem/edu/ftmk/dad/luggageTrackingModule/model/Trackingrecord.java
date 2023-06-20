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
@Table (name = "trackingrecord")
public class Trackingrecord {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "TrackingRecordID")
	private int TrackingRecordID;
	
	@Column (name = "RecordedBy")
	private String RecordedBy;
	
	@ManyToOne
	@JoinColumn (name = "Cp1ID")
	private CP1 Cp1;
	
	@ManyToOne
	@JoinColumn (name = "Cp2ID")
	private CP2 Cp2;
	
	@ManyToOne
	@JoinColumn (name = "Cp3ID")
	private CP3 Cp3;
	
	@ManyToOne
	@JoinColumn (name = "Cp4ID")
	private CP4 Cp4;
	
	@ManyToOne
	@JoinColumn (name = "LuggageID")
	private Luggage luggage;

	public int getTrackingRecordID() {
		return TrackingRecordID;
	}

	public void setTrackingRecordID(int trackingRecordID) {
		TrackingRecordID = trackingRecordID;
	}

	public String getRecordedBy() {
		return RecordedBy;
	}

	public void setRecordedBy(String recordedBy) {
		RecordedBy = recordedBy;
	}

	public CP1 getCp1() {
		return Cp1;
	}

	public void setCp1(CP1 cp1) {
		Cp1 = cp1;
	}

	public CP2 getCp2() {
		return Cp2;
	}

	public void setCp2(CP2 cp2) {
		Cp2 = cp2;
	}

	public CP3 getCp3() {
		return Cp3;
	}

	public void setCp3(CP3 cp3) {
		Cp3 = cp3;
	}

	public CP4 getCp4() {
		return Cp4;
	}

	public void setCp4(CP4 cp4) {
		Cp4 = cp4;
	}

	public Luggage getLuggage() {
		return luggage;
	}

	public void setLuggage(Luggage luggage) {
		this.luggage = luggage;
	}

	
}
