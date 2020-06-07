package com.webapp.project.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.webapp.project.response.StateDistrictAPIResponse;


@Controller
public class ViewController {
	final String uri = "https://api.covid19india.org/state_district_wise.json";
	
	public StateDistrictAPIResponse getresult() {
		RestTemplate restTemplate = new RestTemplate();
		StateDistrictAPIResponse result = restTemplate.getForObject(uri, StateDistrictAPIResponse.class);
		return result;
	}
	
	@RequestMapping("/view")
	@ResponseBody
	public List<String> view() {
		
		String url = "http://localhost:8080/api/tutorials";
		RestTemplate rt = new RestTemplate();
		String objects = rt.getForObject(url, String.class);
		
		return Arrays.asList(objects);
	}
	
	@RequestMapping("/data")
	@ResponseBody
	public void getdata(){
		/*
	    final String uri = "https://api.covid19india.org/state_district_wise.json";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    StateDistrictAPIResponse result = restTemplate.getForObject(uri, StateDistrictAPIResponse.class);
	    */
		StateDistrictAPIResponse result = getresult();
	    System.out.println(result.getKstate().getDistrictData().getBidar().getConfirmed()); 
	}
	
	@GetMapping("/home")
	public String home() {
		return "home.html";
	}
	
	@GetMapping("/userdistrict")
	@ResponseBody
	public String userdistrict(@RequestParam("district") String district) {
		StateDistrictAPIResponse result = getresult();
		if(district.equals("Bidar")) {
			int confirmed = result.getKstate().getDistrictData().getBidar().getConfirmed();
			int recovered = result.getKstate().getDistrictData().getBidar().getRecovered();
			return "Confirmed: "+ Integer.toString(confirmed) + " Recovered: " + Integer.toString(recovered);
			
		}
		else if(district.equals("Bengaluru Urban")) {
			int confirmed = result.getKstate().getDistrictData().getBglrU().getConfirmed();
			int recovered = result.getKstate().getDistrictData().getBglrU().getRecovered();
			return "Confirmed: "+ Integer.toString(confirmed) + " Recovered: " + Integer.toString(recovered);
			
		}
		else if(district.equals("Mysuru")) {
			int confirmed = result.getKstate().getDistrictData().getMysuru().getConfirmed();
			int recovered = result.getKstate().getDistrictData().getMysuru().getRecovered();
			return "Confirmed: "+ Integer.toString(confirmed) + " Recovered: " + Integer.toString(recovered);
			
		}
		else
			return "None";
	}
	
}
