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

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Flight;
import my.utem.edu.ftmk.dad.luggageTrackingModule.repository.FlightRepository;


@RestController
@RequestMapping("/api/flights")
public class FlightRESTController {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@DeleteMapping("{FlightID}")
	public ResponseEntity<HttpStatus> deleteFlight(@PathVariable long FlightID)
	{
		flightRepository.deleteById(FlightID);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public List<Flight> getFlight()
	{
		return flightRepository.findAll();
	}
	
	@GetMapping ("{FlightID}")
	public Flight getFlight(@PathVariable long FlightID )
	{
		Flight flight = flightRepository.findById(FlightID).get();
		
		return flight;
	}
	
	@PostMapping
	public Flight insertFlight (@RequestBody Flight flight)
	{
		return flightRepository.save(flight);
	}
	
	@PutMapping
	public Flight updateFlight (@RequestBody Flight flight)
	{
		return flightRepository.save(flight);
	}
	
	

}
