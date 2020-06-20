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
			
			@JsonProperty("Bagalkote")
			private District bagalkote;
			
			@JsonProperty("Ballari")
			private District ballari;
			
			@JsonProperty("Belagavi")
			private District belagavi;
			
			@JsonProperty("Bengaluru Rural")
			private District bnglrRural;
			
			@JsonProperty("Bengaluru Urban")
			private District bnglrUrban;
			
			@JsonProperty("Bidar")
			private District bidar;
			
			@JsonProperty("Chamarajanagara")
			private District chamarajanagara;
			
			@JsonProperty("Chikkaballapura")
			private District chikkaballapura;
			
			@JsonProperty("Chikkamagaluru")
			private District chikkamagaluru;
			
			@JsonProperty("Chitradurga")
			private District chitradurga;
			
			@JsonProperty("Dakshina Kannada")
			private District dakshinaKannada;
			
			@JsonProperty("Davanagere")
			private District davanagere;
			
			@JsonProperty("Dharwad")
			private District dharwad;
			
			@JsonProperty("Gadag")
			private District gadag;
			
			@JsonProperty("Hassan")
			private District hassan;

			@JsonProperty("Haveri")
			private District haveri;
			
			@JsonProperty("Kalaburagi")
			private District kalaburagi;
			
			@JsonProperty("Kodagu")
			private District kodagu;
			
			@JsonProperty("Kolar")
			private District kolar;
			
			@JsonProperty("Koppal")
			private District koppal;
			
			@JsonProperty("Mandya")
			private District mandya;
			
			@JsonProperty("Mysuru")
			private District mysuru;
			
			@JsonProperty("Raichur")
			private District raichur;
			
			@JsonProperty("Ramanagara")
			private District ramanagara;
			
			@JsonProperty("Shivamogga")
			private District shivamogga;
			
			@JsonProperty("Tumakuru")
			private District tumakuru;
			
			@JsonProperty("Udupi")
			private District udupi;
			
			@JsonProperty("Uttara Kannada")
			private District uttaraKannada;
			
			@JsonProperty("Vijayapura")
			private District vijayapura;
			
			@JsonProperty("Yadgir")
			private District yadgir;
			
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


