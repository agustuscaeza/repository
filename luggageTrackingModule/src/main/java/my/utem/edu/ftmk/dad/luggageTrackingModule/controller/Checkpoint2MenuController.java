package my.utem.edu.ftmk.dad.luggageTrackingModule.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Conveyorlane;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Luggage;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.CP2;



@Controller
public class Checkpoint2MenuController {
	
	private String defaultURI = "http://localhost:8080/luggagehandling/api/cp2";
	
	@GetMapping("/cp2/list")
	public String getCheckpoints2 (Model model)
	{
		// The URI for GET checkpoint
		String uri = "http://localhost:8080/luggagehandling/api/cp2";
		
		// Get a list checkpoint 2 from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CP2[]> response = restTemplate.getForEntity(uri, CP2[].class);
		
		// Parse JSON data to array of object
		CP2 checkpoints2[] = response.getBody();
		
		
		// Parse an array to a list object
		List<CP2> checkpointList2 = Arrays.asList(checkpoints2);
		
		// Attach list to model as attribute 
		model.addAttribute("checkpoints2", checkpointList2);
		
		
		// returning HTML file
		return "checkpoint2";
		
	}
	
	@RequestMapping("/cp2/save")
	public String updateCeckpoint2 (@ModelAttribute CP2 cp2)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Create request body
		HttpEntity<CP2> request = new HttpEntity<CP2>(cp2);
		
		String checkpointResponse2 = "";
		
		if (cp2.getCp2ID() > 0)
		{
			// This block update an new luggage and send request as PUT
			restTemplate.put(defaultURI, request, CP2.class);
		}
		else 
		{
			// This block add a new luggage and send request as POST
			checkpointResponse2 = restTemplate.postForObject(defaultURI, request, String.class);
			
		}
		
		System.out.println(checkpointResponse2);
		
		// Redirect request to display a list of passenger
		return "redirect:/cp3/0";
	}
	
	@GetMapping("/cp2/{Cp2ID}")
	public String getCheckpoint2 (@PathVariable int Cp2ID, Model model) {
		
		String title = "Checkpoint 2";
		CP2 checkpoints2 = new CP2();
		
	
		if (Cp2ID > 0) {
			
			// Generate new URI and append passengerID to it
			String uri = defaultURI + "/" + Cp2ID;
						
			// Get an order type from the web service
			RestTemplate restTemplate = new RestTemplate();
			checkpoints2 = restTemplate.getForObject(uri, CP2.class);
			
			//Give a new title to the page
			title = "Edit Checkpoint 2";
		
		}
	
		/*
		 * 
		 * The uri for get luggage unit
		 * List of all airport unit for drop down list menu
		 */
		
		RestTemplate restTemplateLane = new RestTemplate();
		ResponseEntity<Conveyorlane[]> responseLane = 
				restTemplateLane.getForEntity("http://localhost:8080/luggagehandling/api/conveyorlanes", Conveyorlane[].class);
		
		Conveyorlane laneArray[] = responseLane.getBody();	
		
		// Parse an array to a list object
		List<Conveyorlane> laneList = Arrays.asList(laneArray);
		
		RestTemplate restTemplateLuggage = new RestTemplate();
		ResponseEntity<Luggage[]> responseLuggage = 
				restTemplateLuggage.getForEntity("http://localhost:8080/luggagehandling/api/luggages", Luggage[].class);
		
		Luggage luggageArray[] = responseLuggage.getBody();	
		
		// Parse an array to a list object
		List<Luggage> luggageList = Arrays.asList(luggageArray);
		
		
		
		// Attach value to pass to front end
		model.addAttribute("checkpoint2", checkpoints2);
		model.addAttribute("lanes", laneList);
		model.addAttribute("luggages", luggageList);
		model.addAttribute("pageTitle", title);
		
		return "checkpoint2info";
			
	}
	
	/**
	 * This method deletes an passenger
	 * 
	 * @param CheckpointID
	 * @return
	 */
	@RequestMapping("cp2/delete/{Cp2ID}")
	public String deleteCheckpoint2(@PathVariable int Cp2ID)
	{
		// Generate new URI, similar to the mapping in Checkpoint2RESTController
		String uri = defaultURI + "/{Cp2ID}";
		
		// Send a DELETE request and attach the value of orderTypeId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("Cp2ID",(Cp2ID)));
		
		return "redirect:/cp2/list";
	}

}
