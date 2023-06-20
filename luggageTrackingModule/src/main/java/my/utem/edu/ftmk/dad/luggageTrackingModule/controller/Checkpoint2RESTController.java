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

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.CP2;
import my.utem.edu.ftmk.dad.luggageTrackingModule.repository.Checkpoint2Repository;

@RestController
@RequestMapping("/api/cp2")
public class Checkpoint2RESTController {
	
	@Autowired
	private Checkpoint2Repository checkpoint2Repository;
	
	@DeleteMapping("{Cp2ID}")
	public ResponseEntity<HttpStatus> deleteCheckpoint2(@PathVariable long Cp2ID)
	{
		checkpoint2Repository.deleteById(Cp2ID);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public List<CP2> getCheckpoint2()
	{
		return checkpoint2Repository.findAll();
	}
	
	@GetMapping ("{Cp2ID}")
	public CP2 getCheckpoint2(@PathVariable long Cp2ID )
	{
		CP2 checkpoint2 = checkpoint2Repository.findById(Cp2ID).get();
		
		return checkpoint2;
	}
	
	@PostMapping
	public CP2 insertCheckpoint2 (@RequestBody CP2 cp2)
	{
		LocalDate cp2Date = LocalDate.now();
	     LocalTime cp2Time = LocalTime.now();
	     cp2.setCp2Date(cp2Date);
	     cp2.setCp2Time(cp2Time);
		return checkpoint2Repository.save(cp2);
	}
	
	@PutMapping
	public CP2 updateCheckpoint2 (@RequestBody CP2 cp2)
	{
		return checkpoint2Repository.save(cp2);
	}

}
