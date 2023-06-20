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
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Trackingrecord;



@Controller
public class TrackingRecordMenuController {
	
	private String defaultURI = "http://localhost:8080/luggagehandling/api/trackingrecords";
	
	@GetMapping("/trackingrecord/list")
	public String getTrackingrecords (Model model)
	{
		// The URI for GET trackingrecord
		String uri = "http://localhost:8080/luggagehandling/api/trackingrecords";
		
		// Get a list checkpoint 2 from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Trackingrecord[]> response = restTemplate.getForEntity(uri, Trackingrecord[].class);
		
		// Parse JSON data to array of object
		Trackingrecord trackingrecords[] = response.getBody();
		
		
		// Parse an array to a list object
		List<Trackingrecord> trackingrecordslist = Arrays.asList(trackingrecords);
		
		// Attach list to model as attribute 
		model.addAttribute("trackingrecords", trackingrecordslist);
		
		
		// returning HTML file
		return "trackingrecords";
		
	}
}