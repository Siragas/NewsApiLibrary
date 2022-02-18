package model;

public class IPInfo {
	
	private   String country;

	public IPInfo(String country) {
		super();
		this.country = country;
	}

	public IPInfo(IPResult result) {
		
		this.country=result.getCountryCode();		// TODO Auto-generated constructor stub
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
