package my.utem.edu.ftmk.dad.luggageTrackingModule.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Luggage;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Passenger;



@Controller
public class LuggageMenuController {
	
	private String defaultURI = "http://localhost:8080/luggagehandling/api/luggages";
	
	@GetMapping("/luggage/list")
	public String getLuggage (Model model)
	{
		// The URI for GET luggage
		String uri = "http://localhost:8080/luggagehandling/api/luggages";
		
		// Get a list checkpoint from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Luggage[]> response = restTemplate.getForEntity(uri, Luggage[].class);
		
		// Parse JSON data to array of object
		Luggage luggages[] = response.getBody();
		
		
		// Parse an array to a list object
		List<Luggage> luggageList = Arrays.asList(luggages);
		
		// Attach list to model as attribute 
		model.addAttribute("luggages", luggageList);
		
		
		// returning HTML file
		return "luggages";
		
	}
	@RequestMapping("/luggage/save")
	public String updateLuggage (@ModelAttribute Luggage luggage)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Create request body
		HttpEntity<Luggage> request = new HttpEntity<Luggage>(luggage);
		
		String luggageResponse1 = "";
		
		if (luggage.getLuggageID() > 0)
		{
			// This block update an new luggage and send request as PUT
			restTemplate.put(defaultURI, request, Luggage.class);
		}
		else 
		{
			// This block add a new luggage and send request as POST
			luggageResponse1 = restTemplate.postForObject(defaultURI, request, String.class);
			
		}
		
		System.out.println(luggageResponse1);
		
		// Redirect request to display a list of passenger
		return "redirect:/cp1/0";
	}
	
	@GetMapping("/luggage/{LuggageID}")
	public String getLuggage (@PathVariable int LuggageID, Model model,
			@RequestParam (name = "IcNum", required = false) String IcNum) {
		
		String title = "Luggage Registration";
		Luggage luggage = new Luggage();
		
		//System.out.println("test");
		Passenger icPassenger = new Passenger();
		if (!Strings.isBlank(IcNum)) {
			
			RestTemplate passengerREST = new RestTemplate();
			icPassenger = passengerREST.getForObject("http://localhost:8080/luggagehandling/api/passengers/passenger/"+IcNum ,Passenger.class);
			luggage.setPassenger(icPassenger);
		}
		
		
		// This block get an passenger to be updated
//		if (LuggageID > 0) {
//
//			// Generate new URI and append passengerID to it
//			String uri = defaultURI + "/" + LuggageID;
//			
//			// Get an order type from the web service
//			RestTemplate restTemplate = new RestTemplate();
//			luggage = restTemplate.getForObject(uri, Luggage.class);
//			
//			//Give a new title to the page
//			title = "Edit Luggage Information";
//		}
		
		System.out.println("test" + icPassenger.getPassengerID());
		
		// Attach value to pass to front end
		model.addAttribute("luggages", luggage);
		model.addAttribute("pageTitle", title);
		model.addAttribute("IcNum", icPassenger);
		
		return "luggageinfo";
			
	}
	
	/**
	 * This method deletes an passenger
	 * 
	 * @param LuggageId
	 * @return
	 */
	@RequestMapping("luggage/delete/{LuggageID}")
	public String deleteLuggage(@PathVariable int LuggageID)
	{
		// Generate new URI, similar to the mapping in LuggageRESTController
		String uri = defaultURI + "/{LuggageID}";
		
		// Send a DELETE request and attach the value of LuggageId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("LuggageID",(LuggageID)));
		
		return "redirect:/luggage/list";
	}

}
