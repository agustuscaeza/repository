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

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.CP3;
import my.utem.edu.ftmk.dad.luggageTrackingModule.repository.Checkpoint3Repository;


@RestController
@RequestMapping("/api/cp3")
public class Checkpoint3RESTController {
	
	@Autowired
	private Checkpoint3Repository checkpoint3Repository;
	
	@DeleteMapping("{Cp3ID}")
	public ResponseEntity<HttpStatus> deleteCheckpoint3(@PathVariable long Cp3ID)
	{
		checkpoint3Repository.deleteById(Cp3ID);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public List<CP3> getCheckpoint3()
	{
		return checkpoint3Repository.findAll();
	}
	
	@GetMapping ("{Cp3ID}")
	public CP3 getCheckpoint3(@PathVariable long Cp3ID )
	{
		CP3 checkpoint3 = checkpoint3Repository.findById(Cp3ID).get();
		
		return checkpoint3;
	}
	
	@PostMapping
	public CP3 insertCheckpoint3 (@RequestBody CP3 cp3)
	{
		 LocalDate cp3Date = LocalDate.now();
	     LocalTime cp3Time = LocalTime.now();
	     cp3.setCp3Date(cp3Date);
	     cp3.setCp3Time(cp3Time);
		return checkpoint3Repository.save(cp3);
	}
	
	@PutMapping
	public CP3 updateCheckpoint3 (@RequestBody CP3 cp3)
	{
		return checkpoint3Repository.save(cp3);
	}
	
	@GetMapping("/checkpoint3/{Cp3ID}")
	public CP3 findCp1ById (@PathVariable int Cp3ID)
	{
		return checkpoint3Repository.findCp3ById(Cp3ID);
	}

	
}
