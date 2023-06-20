package my.utem.edu.ftmk.dad.luggageTrackingModule.controller;

import java.time.LocalDate;
import java.time.LocalTime;
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

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.CP1;
import my.utem.edu.ftmk.dad.luggageTrackingModule.repository.Checkpoint1Repository;


@RestController
@RequestMapping("/api/cp1")
public class Checkpoint1RESTController {
	
	@Autowired
	private Checkpoint1Repository checkpoint1Repository;
	
	@DeleteMapping("{Cp1ID}")
	public ResponseEntity<HttpStatus> deleteCheckpoint1(@PathVariable long Cp1ID)
	{
		checkpoint1Repository.deleteById(Cp1ID);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public List<CP1> getCheckpoint1()
	{
		return checkpoint1Repository.findAll();
	}
	
	@GetMapping ("{Cp1ID}")
	public CP1 getCheckpoint1(@PathVariable long Cp1ID )
	{
		CP1 checkpoint1 = checkpoint1Repository.findById(Cp1ID).get();
		
		return checkpoint1;
	}
	
	@PostMapping
	public CP1 insertCheckpoint1 (@RequestBody CP1 cp1)
	{
		 LocalDate cp1Date = LocalDate.now();
	     LocalTime cp1Time = LocalTime.now();
	     cp1.setCp1Date(cp1Date);
	     cp1.setCp1Time(cp1Time);
		return checkpoint1Repository.save(cp1);
	}
	
	@PutMapping
	public CP1 updateCheckpoint1 (@RequestBody CP1 cp1)
	{
		return checkpoint1Repository.save(cp1);
	}
	
	@GetMapping("/checkpoint1/{Cp1ID}")
	public CP1 findCp1ById (@PathVariable int Cp1ID)
	{
		return checkpoint1Repository.findCp1ById(Cp1ID);
	}

	
}
