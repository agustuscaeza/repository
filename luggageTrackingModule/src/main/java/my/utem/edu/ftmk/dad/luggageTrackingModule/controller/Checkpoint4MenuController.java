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

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Flight;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.CP4;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Luggage;



@Controller
public class Checkpoint4MenuController {
	
	private String defaultURI = "http://localhost:8080/luggagehandling/api/cp4";
	
	@GetMapping("/cp4/list")
	public String getCheckpoints4 (Model model)
	{
		// The URI for GET checkpoint
		String uri = "http://localhost:8080/luggagehandling/api/cp4";
		
		// Get a list checkpoint from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CP4[]> response = restTemplate.getForEntity(uri, CP4[].class);
		
		// Parse JSON data to array of object
		CP4 checkpoints4[] = response.getBody();
		
		
		// Parse an array to a list object
		List<CP4> checkpointList4 = Arrays.asList(checkpoints4);
		
		// Attach list to model as attribute 
		model.addAttribute("checkpoints4", checkpointList4);
		
		// returning HTML file
		return "checkpoint4";
		
	}
	@RequestMapping("/checkpoint4/save")
	public String updateCeckpoint4 (@ModelAttribute CP4 cp4)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Create request body
		HttpEntity<CP4> request = new HttpEntity<CP4>(cp4);
		
		String checkpointResponse4 = "";
		
		if (cp4.getCp4ID() > 0)
		{
			// This block update an new luggage and send request as PUT
			restTemplate.put(defaultURI, request, CP4.class);
		}
		else 
		{
			// This block add a new luggage and send request as POST
			checkpointResponse4 = restTemplate.postForObject(defaultURI, request, String.class);
			
		}
		
		System.out.println(checkpointResponse4);
		
		// Redirect request to display a list of passenger
		return "redirect:/menu/list";
	}
	
	@GetMapping("/cp4/{Cp4ID}")
	public String getCheckpoint1 (@PathVariable int Cp4ID, Model model) {
		
		String title = "Checkpoint 4";
		CP4 checkpoints4 = new CP4();
		
		// This block get an passenger to be updated
		if (Cp4ID > 0) {

			// Generate new URI and append Checkpoint1Id to it
			String uri = defaultURI + "/" + Cp4ID;
			
			// Get an order type from the web service
			RestTemplate restTemplate = new RestTemplate();
			checkpoints4 = restTemplate.getForObject(uri, CP4.class);
			
			//Give a new title to the page
			title = "Edit Checkpoint 4";
		}

		/*
		 * 
		 * The uri for get luggage unit
		 * List of all flight unit for drop down list menu
		 */
		
		RestTemplate restTemplateAirport = new RestTemplate();
		ResponseEntity<Flight[]> responseFlight = 
				restTemplateAirport.getForEntity("http://localhost:8080/luggagehandling/api/flights", Flight[].class);
		
		Flight flightArray[] = responseFlight.getBody();
		
		// Parse an array to a list object
		List<Flight> flightList = Arrays.asList(flightArray);
		
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
		model.addAttribute("checkpoint4", checkpoints4);
		model.addAttribute("flights", flightList);
		model.addAttribute("luggages", luggageList);
		model.addAttribute("pageTitle", title);
		
		return "checkpoint4info";
			
	}
	
	/**
	 * This method deletes an passenger
	 * 
	 * @param CheckpointID
	 * @return
	 */
	@RequestMapping("cp4/delete/{Cp4ID}")
	public String deleteCheckpoint4(@PathVariable int Cp4ID)
	{
		// Generate new URI, similar to the mapping in Checkpoint1RESTController
		String uri = defaultURI + "/{Cp4ID}";
		
		// Send a DELETE request and attach the value of Cp4ID into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("Cp4ID",(Cp4ID)));
		
		return "redirect:/cp4/list";
	}
	
	@GetMapping("/menu/list")
	public String getMenu (Model model)
	{
	
		return "Menu";
		
	}

}
