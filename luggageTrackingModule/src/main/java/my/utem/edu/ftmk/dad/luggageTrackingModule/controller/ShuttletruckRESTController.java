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

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Shuttletruck;
import my.utem.edu.ftmk.dad.luggageTrackingModule.repository.ShuttletruckRepository;


@RestController
@RequestMapping("/api/shuttletrucks")
public class ShuttletruckRESTController {
	
	@Autowired
	private ShuttletruckRepository shuttletruckRepository;
	
	@DeleteMapping("{TruckID}")
	public ResponseEntity<HttpStatus> deleteShuttletruck(@PathVariable long TruckID)
	{
		shuttletruckRepository.deleteById(TruckID);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public List<Shuttletruck> getShuttletruck()
	{
		return shuttletruckRepository.findAll();
	}
	
	@GetMapping ("{TruckID}")
	public Shuttletruck getShuttletruck(@PathVariable long TruckID )
	{
		Shuttletruck shuttletruck = shuttletruckRepository.findById(TruckID).get();
		
		return shuttletruck;
	}
	
	@PostMapping
	public Shuttletruck insertShuttletruck (@RequestBody Shuttletruck shuttletruck)
	{
		return shuttletruckRepository.save(shuttletruck);
	}
	
	@PutMapping
	public Shuttletruck updateShuttletruck (@RequestBody Shuttletruck shuttletruck)
	{
		return shuttletruckRepository.save(shuttletruck);
	}

}
