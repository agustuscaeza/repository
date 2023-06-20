package my.utem.edu.ftmk.dad.luggageTrackingModule.controller;

import java.util.Arrays;
import java.util.List;

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

@Controller
public class AirportMenuController {

	private String defaultURI = "http://localhost:8080/luggagehandling/api/airports";

	@GetMapping("/airport/list")
	public String getAirport(Model model) {

		// The URI for GET airport types
		String uri = "http://localhost:8080/luggagehandling/api/airports";

		// Get a list of airport types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Airport[]> response = restTemplate.getForEntity(uri, Airport[].class);

		// Parse JSON data to an array of objects
		Airport airports[] = response.getBody();

		// Convert the array to a list
		List<Airport> airportList = Arrays.asList(airports);

		// Attach the list to the model as an attribute
		model.addAttribute("airports", airportList);

		return "airports";
	}
	
}