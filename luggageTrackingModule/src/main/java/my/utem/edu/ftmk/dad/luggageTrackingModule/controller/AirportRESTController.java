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

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Airport;
import my.utem.edu.ftmk.dad.luggageTrackingModule.repository.AirportRepository;


@RestController
@RequestMapping("/api/airports")
public class AirportRESTController {
	
	@Autowired
	private AirportRepository airportRepository;
	
	@DeleteMapping("{AirportID}")
	public ResponseEntity<HttpStatus> deleteAirport(@PathVariable long airportId)
	{
		airportRepository.deleteById(airportId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public List<Airport> getAirport()
	{
		return airportRepository.findAll();
	}
	
	@GetMapping ("{AirportID}")
	public Airport getAirport(@PathVariable long airportId )
	{
		Airport airport = airportRepository.findById(airportId).get();
		
		return airport;
	}
	
	@PostMapping
	public Airport insertAirport (@RequestBody Airport airport)
	{
		return airportRepository.save(airport);
	}
	
	@PutMapping
	public Airport updateAirport (@RequestBody Airport airport)
	{
		return airportRepository.save(airport);
	}

}
