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
		
		if(district.equalsIgnoreCase("Bagalkote")) {
			d =  getkardistrict().getBagalkote();
		}
		else if(district.equalsIgnoreCase("Ballari")) {
			d =  getkardistrict().getBallari();
		}
		else if(district.equalsIgnoreCase("Belagavi")) {
			d =  getkardistrict().getBelagavi();
		}
		else if(district.equalsIgnoreCase("Bengaluru Rural")) {
			d =  getkardistrict().getBnglrRural();
		}
		else if(district.equalsIgnoreCase("Bengaluru Urban")) {
			d =  getkardistrict().getBnglrUrban();
		}
		else if(district.equalsIgnoreCase("Bidar")) {
			d =  getkardistrict().getBidar();
		}
		else if(district.equalsIgnoreCase("Chamarajanagara")) {
			d =  getkardistrict().getChamarajanagara();
		}
		else if(district.equalsIgnoreCase("Chikkaballapura")) {
			d =  getkardistrict().getChikkaballapura();
		}
		else if(district.equalsIgnoreCase("Chikkamagaluru")) {
			d =  getkardistrict().getChikkamagaluru();
		}
		else if(district.equalsIgnoreCase("Chitradurga")) {
			d =  getkardistrict().getChitradurga();
		}
		else if(district.equalsIgnoreCase("Dakshina Kannada")) {
			d =  getkardistrict().getDakshinaKannada();
		}
		else if(district.equalsIgnoreCase("Davanagere")) {
			d =  getkardistrict().getDavanagere();
		}
		else if(district.equalsIgnoreCase("Dharwad")) {
			d =  getkardistrict().getDharwad();
		}
		else if(district.equalsIgnoreCase("Gadag")) {
			d =  getkardistrict().getGadag();
		}
		else if(district.equalsIgnoreCase("Hassan")) {
			d =  getkardistrict().getHassan();
		}
		else if(district.equalsIgnoreCase("Haveri")) {
			d =  getkardistrict().getHaveri();
		}
		else if(district.equalsIgnoreCase("Kalaburagi")) {
			d =  getkardistrict().getKalaburagi();
		}
		else if(district.equalsIgnoreCase("Kodagu")) {
			d =  getkardistrict().getKodagu();
		}
		else if(district.equalsIgnoreCase("Kolar")) {
			d =  getkardistrict().getKolar();
		}
		else if(district.equalsIgnoreCase("Koppal")) {
			d =  getkardistrict().getKoppal();
		}
		else if(district.equalsIgnoreCase("Mandya")) {
			d =  getkardistrict().getMandya();
		}
		else if(district.equalsIgnoreCase("Mysuru")) {
			d =  getkardistrict().getMysuru();
		}
		else if(district.equalsIgnoreCase("Raichur")) {
			d =  getkardistrict().getRaichur();
		}
		else if(district.equalsIgnoreCase("Ramanagara")) {
			d =  getkardistrict().getRamanagara();
		}
		else if(district.equalsIgnoreCase("Shivamogga")) {
			d =  getkardistrict().getShivamogga();
		}
		else if(district.equalsIgnoreCase("Tumakuru")) {
			d =  getkardistrict().getTumakuru();
		}
		else if(district.equalsIgnoreCase("Udupi")) {
			d =  getkardistrict().getUdupi();
		}
		else if(district.equalsIgnoreCase("Uttara Kannada")) {
			d =  getkardistrict().getUttaraKannada();
		}
		else if(district.equalsIgnoreCase("Vijayapura")) {
			d =  getkardistrict().getVijayapura();
		}
		else if(district.equalsIgnoreCase("Yadgir")) {
			d =  getkardistrict().getYadgir();
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
