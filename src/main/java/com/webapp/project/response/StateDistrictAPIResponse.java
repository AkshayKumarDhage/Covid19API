package com.webapp.project.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateDistrictAPIResponse {
	@JsonProperty("Andhra Pradesh")
	private APState apstate;
	
	@JsonProperty("Karnataka")
	private KarState kstate;
	
	@Getter
	@Setter
	public static class APState{
		@JsonProperty("districtDate")
		private APDistrictData districtData;
		
		private String statecode;
		
		public static class APDistrictData{
			@JsonProperty("Anantpur")
			private District anantpur;
		}
	}
	
	@Getter
	@Setter
	public static class KarState{
		@JsonProperty("districtData")
		private KarDistrictData districtData;
		
		private String statecode;
		
		@Getter
		@Setter
		public static class KarDistrictData{
			@JsonProperty("Bidar")
			private District bidar;
			
			@JsonProperty("Bengaluru Urban")
			private District bglrU;
			
			@JsonProperty("Mysuru")
			private District mysuru;
		}
	}
	
	@Getter
	@Setter
	public static class District{
		private int active;
		private int confirmed;
		private int deceased;
		private int recovered;
	}
}


