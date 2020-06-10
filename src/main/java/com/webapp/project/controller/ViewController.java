package com.webapp.project.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.webapp.project.response.StateDistrictAPIResponse;
import com.webapp.project.response.StateDistrictAPIResponse.District;
import com.webapp.project.response.StateDistrictAPIResponse.KarState.KarDistrictData;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ViewController {
	@Value("${app.data.uri}")
	private String uri;
	
	@GetMapping(value = "/userdistrict")
	public District userdistrict(@RequestParam("district") String district) {
		
		District d = new District();
		
		if(district.equalsIgnoreCase("Bidar")) {
			d =  getkardistrict().getBidar();
		}
		else if(district.equalsIgnoreCase("Mysuru")) {
			d =  getkardistrict().getMysuru();
		}
		else if(district.equalsIgnoreCase("Bangalore")) {
			d =  getkardistrict().getBglrU();
		}
		else {
			return new District();
		}
		return d;
		
	}
	
	public StateDistrictAPIResponse getresult() {
		RestTemplate restTemplate = new RestTemplate();
		StateDistrictAPIResponse result = restTemplate.getForObject(uri, StateDistrictAPIResponse.class);
		return result;
	}
	
	public KarDistrictData getkardistrict() {
		StateDistrictAPIResponse result = getresult();
		return result.getKstate().getDistrictData();
	}

}
