package model;

/**
 * 
 * @author ndrscodes - Andreas Schmidt
 *
 */
public enum Country {
	Germany("+49");
	
	private String prefix;
	
	Country(String countryCode) {
		this.prefix = countryCode;
	}
	
	public String getNumberingPrefix() {
		return prefix;
	}
}
