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

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Airport;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.CP1;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Luggage;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Passenger;



@Controller
public class Checkpoint1MenuController {
	
	private String defaultURI = "http://localhost:8080/luggagehandling/api/cp1";
	
	@GetMapping("/cp1/list")
	public String getCheckpoints1 (Model model)
	{
		// The URI for GET checkpoint
		String uri = "http://localhost:8080/luggagehandling/api/cp1";
		
		// Get a list checkpoint from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CP1[]> response = restTemplate.getForEntity(uri, CP1[].class);
		
		// Parse JSON data to array of object
		CP1 checkpoints1[] = response.getBody();
		
		
		// Parse an array to a list object
		List<CP1> checkpointList1 = Arrays.asList(checkpoints1);
		
		// Attach list to model as attribute 
		model.addAttribute("checkpoints1", checkpointList1);
		
		// returning HTML file
		return "checkpoint1";
		
	}
	@RequestMapping("/cp1/save")
	public String updateCeckpoint1 (@ModelAttribute CP1 cp1)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Create request body
		HttpEntity<CP1> request = new HttpEntity<CP1>(cp1);
		
		String checkpointResponse1 = "";
		
		if (cp1.getCp1ID() > 0)
		{
			// This block update an new luggage and send request as PUT
			restTemplate.put(defaultURI, request, CP1.class);
		}
		else 
		{
			// This block add a new luggage and send request as POST
			checkpointResponse1 = restTemplate.postForObject(defaultURI, request, String.class);
			
		}
		
		System.out.println(checkpointResponse1);
		
		// Redirect request to display a list of passenger
		return "redirect:/cp2/0";
	}
	
	@GetMapping("/cp1/{Cp1ID}")
	public String getCheckpoint1 (@PathVariable int Cp1ID, Model model) {
		
		String title = "Checkpoint 1";
		CP1 checkpoints1 = new CP1();
		
		// This block get an passenger to be updated
		if (Cp1ID > 0) {

			// Generate new URI and append Checkpoint1Id to it
			String uri = defaultURI + "/" + Cp1ID;
			
			// Get an order type from the web service
			RestTemplate restTemplate = new RestTemplate();
			checkpoints1 = restTemplate.getForObject(uri, CP1.class);
			
			//Give a new title to the page
			title = "Edit Checkpoint 1";
		}

		/*
		 * 
		 * The uri for get luggage unit
		 * List of all airport unit for drop down list menu
		 */
		
		RestTemplate restTemplateAirport = new RestTemplate();
		ResponseEntity<Airport[]> responseAirport = 
				restTemplateAirport.getForEntity("http://localhost:8080/luggagehandling/api/airports", Airport[].class);
		
		Airport airportArray[] = responseAirport.getBody();	
		
		// Parse an array to a list object
		List<Airport> airportList = Arrays.asList(airportArray);
		
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
		model.addAttribute("checkpoint1", checkpoints1);
		model.addAttribute("airports", airportList);
		model.addAttribute("luggages", luggageList);
		model.addAttribute("pageTitle", title);
		
		return "checkpoint1info";
			
	}
	
	/**
	 * This method deletes an passenger
	 * 
	 * @param CheckpointID
	 * @return
	 */
	@RequestMapping("cp1/delete/{Cp1ID}")
	public String deleteCheckpoint1(@PathVariable int Cp1ID)
	{
		// Generate new URI, similar to the mapping in Checkpoint1RESTController
		String uri = defaultURI + "/{Cp1ID}";
		
		// Send a DELETE request and attach the value of orderTypeId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("Cp1ID",(Cp1ID)));
		
		return "redirect:/cp1/list";
	}

}
