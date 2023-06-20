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

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Passenger;
import my.utem.edu.ftmk.dad.luggageTrackingModule.repository.PassengerRepository;

@RestController
@RequestMapping("/api/passengers")
public class PassengerRESTController {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@DeleteMapping("{PassengerID}")
	public ResponseEntity<HttpStatus> deletePassenger(@PathVariable long PassengerID)
	{
		passengerRepository.deleteById(PassengerID);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public List<Passenger> getPassenger()
	{
		return passengerRepository.findAll();
	}
	
	@GetMapping ("{PassengerID}")
	public Passenger getPassenger(@PathVariable long PassengerID )
	{
		Passenger passenger = passengerRepository.findById(PassengerID).get();
		
		return passenger;
	}
	
	@PostMapping
	public Passenger insertPassenger (@RequestBody Passenger passenger)
	{
		return passengerRepository.save(passenger);
	}
	
	@PutMapping
	public Passenger updatePassenger (@RequestBody Passenger passenger)
	{
		return passengerRepository.save(passenger);
	}
	
	@GetMapping("/passenger/{PassengerIC}")
	public Passenger findPassengerByIC (@PathVariable String PassengerIC)
	{
		return passengerRepository.findPassengerByIC(PassengerIC);
	}
	

}
