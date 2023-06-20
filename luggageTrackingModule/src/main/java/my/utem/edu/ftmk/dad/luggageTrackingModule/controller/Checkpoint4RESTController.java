package my.utem.edu.ftmk.dad.luggageTrackingModule.controller;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.CP4;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Checkpoint4;
import my.utem.edu.ftmk.dad.luggageTrackingModule.repository.Checkpoint4Repository;

@RestController
@RequestMapping("/api/cp4")
public class Checkpoint4RESTController {
	
	@Autowired
	private Checkpoint4Repository checkpoint4Repository;
	
	@DeleteMapping("{Cp4ID}")
	public ResponseEntity<HttpStatus> deleteCheckpoint1(@PathVariable long Cp4ID)
	{
		checkpoint4Repository.deleteById(Cp4ID);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public List<CP4> getCheckpoint4()
	{
		return checkpoint4Repository.findAll();
	}
	
	@GetMapping ("{Cp4ID}")
	public CP4 getCheckpoint4(@PathVariable long Cp4ID )
	{
		CP4 checkpoint4 = checkpoint4Repository.findById(Cp4ID).get();
		
		return checkpoint4;
	}
	
	@PostMapping
	public CP4 insertCheckpoint4 (@RequestBody CP4 cp4)
	{
		 LocalDate cp4Date = LocalDate.now();
	     LocalTime cp4Time = LocalTime.now();
	     cp4.setCp4Date(cp4Date);
	     cp4.setCp4Time(cp4Time);
		return checkpoint4Repository.save(cp4);
	}
	
	@PutMapping
	public CP4 updateCheckpoint4 (@RequestBody CP4 cp4)
	{
		return checkpoint4Repository.save(cp4);
	}
	
	@GetMapping("/checkpoint4/{Cp4ID}")
	public CP4 findCp4ById (@PathVariable int Cp4ID)
	{
		return checkpoint4Repository.findCp4ById(Cp4ID);
	}

	
}
