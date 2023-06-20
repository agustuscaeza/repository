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

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Shuttletruck;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.CP3;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Luggage;



@Controller
public class Checkpoint3MenuController {
	
	private String defaultURI = "http://localhost:8080/luggagehandling/api/cp3";
	
	@GetMapping("/cp3/list")
	public String getCheckpoints3 (Model model)
	{
		// The URI for GET checkpoint
		String uri = "http://localhost:8080/luggagehandling/api/cp3";
		
		// Get a list checkpoint from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CP3[]> response = restTemplate.getForEntity(uri, CP3[].class);
		
		// Parse JSON data to array of object
		CP3 checkpoints3[] = response.getBody();
		
		
		// Parse an array to a list object
		List<CP3> checkpointList3 = Arrays.asList(checkpoints3);
		
		// Attach list to model as attribute 
		model.addAttribute("checkpoints3", checkpointList3);
		
		// returning HTML file
		return "checkpoints3";
		
	}
	@RequestMapping("/cp3/save")
	public String updateCeckpoint3 (@ModelAttribute CP3 cp3)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Create request body
		HttpEntity<CP3> request = new HttpEntity<CP3>(cp3);
		
		String checkpointResponse3 = "";
		
		if (cp3.getCp3ID() > 0)
		{
			// This block update an new luggage and send request as PUT
			restTemplate.put(defaultURI, request, CP3.class);
		}
		else 
		{
			// This block add a new luggage and send request as POST
			checkpointResponse3 = restTemplate.postForObject(defaultURI, request, String.class);
			
		}
		
		System.out.println(checkpointResponse3);
		
		// Redirect request to display a list of passenger
		return "redirect:/cp4/0";
	}
	
	@GetMapping("/cp3/{Cp3ID}")
	public String getCheckpoint3 (@PathVariable int Cp3ID, Model model) {
		
		String title = "Checkpoint 3";
		CP3 checkpoints3 = new CP3();
		
		// This block get an passenger to be updated
		if (Cp3ID > 0) {

			// Generate new URI and append Checkpoint1Id to it
			String uri = defaultURI + "/" + Cp3ID;
			
			// Get an order type from the web service
			RestTemplate restTemplate = new RestTemplate();
			checkpoints3 = restTemplate.getForObject(uri, CP3.class);
			
			//Give a new title to the page
			title = "Edit Checkpoint 3";
		}

		/*
		 * 
		 * The uri for get luggage unit
		 * List of all airport unit for drop down list menu
		 */
		
		RestTemplate restTemplateShuttletruck = new RestTemplate();
		ResponseEntity<Shuttletruck[]> responseShuttletruck = 
				restTemplateShuttletruck.getForEntity("http://localhost:8080/luggagehandling/api/shuttletrucks", Shuttletruck[].class);
		
		Shuttletruck shuttletruckArray[] = responseShuttletruck.getBody();	
		
		// Parse an array to a list object
		List<Shuttletruck> shuttletruckList = Arrays.asList(shuttletruckArray);
		
		/*
		 * 
		 * The uri for get luggage unit
		 * List of all luggage unit for drop down list menu
		 */
		
		RestTemplate restTemplateluggage = new RestTemplate();
		ResponseEntity<Luggage[]> responseLuggage = 
				restTemplateluggage.getForEntity("http://localhost:8080/luggagehandling/api/luggages", Luggage[].class);
		
		Luggage luggageArray[] = responseLuggage.getBody();	
		
		// Parse an array to a list object
		List<Luggage> luggageList = Arrays.asList(luggageArray);
		
		// Attach value to pass to front end
		model.addAttribute("checkpoint3", checkpoints3);
		model.addAttribute("shuttletrucks", shuttletruckList);
		model.addAttribute("luggages", luggageList);
		model.addAttribute("pageTitle", title);
		
		return "checkpoint3info";
			
	}
	
	/**
	 * This method deletes an passenger
	 * 
	 * @param CheckpointID
	 * @return
	 */
	@RequestMapping("cp3/delete/{Cp3ID}")
	public String deleteCheckpoint1(@PathVariable int Cp3ID)
	{
		// Generate new URI, similar to the mapping in Checkpoint1RESTController
		String uri = defaultURI + "/{Cp3ID}";
		
		// Send a DELETE request and attach the value of orderTypeId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("Cp3ID",(Cp3ID)));
		
		return "redirect:/cp3/list";
	}

}
