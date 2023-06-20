package my.utem.edu.ftmk.dad.luggageTrackingModule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Trackingrecord;
import my.utem.edu.ftmk.dad.luggageTrackingModule.repository.TrackingrecordRepository;


@RestController
@RequestMapping("/api/trackingrecords")
public class TrackingrecordRESTController {
	
	@Autowired
	private TrackingrecordRepository trackingrecordRepository;
	
	@DeleteMapping("{TrackingRecordID}")
	public ResponseEntity<HttpStatus> deleteTrackingrecord(@PathVariable long TrackingRecordID)
	{
		trackingrecordRepository.deleteById(TrackingRecordID);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public List<Trackingrecord> getTrackingrecord()
	{
		return trackingrecordRepository.findAll();
	}
	
	@GetMapping ("{TrackingRecordID}")
	public Trackingrecord getTrackingrecord(@PathVariable long TrackingRecordID )
	{
		Trackingrecord trackingrecord = trackingrecordRepository.findById(TrackingRecordID).get();
		
		return trackingrecord;
	}
	
	@PostMapping
	public Trackingrecord insertTrackingrecord (@RequestBody Trackingrecord trackingrecord)
	{
		return trackingrecordRepository.save(trackingrecord);
	}
	
	@PutMapping
	public Trackingrecord updateTrackingrecord (@RequestBody Trackingrecord trackingrecord)
	{
		return trackingrecordRepository.save(trackingrecord);
	}


}
