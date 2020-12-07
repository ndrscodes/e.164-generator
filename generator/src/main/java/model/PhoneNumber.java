package model;

import verification.NumberVerificator;

/**
 * 
 * @author ndrscodes - Andreas Schmidt
 *
 */
public class PhoneNumber {
	
	private String countryCode;
	private String areaCode;
	private String subscriberNumber;
	
	public PhoneNumber(String countryCode, String areaCode, String subscriberNumber) {
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.subscriberNumber = subscriberNumber;
	}
	
	public PhoneNumber() {
	}

	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * 
	 * @param areaCode sets the area code part of the phone number
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode.trim();
	}

	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * 
	 * @param areaCode sets the area code part of the phone number
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode.trim();
	}

	public String getSubscriberNumber() {
		return subscriberNumber;
	}

	/**
	 * 
	 * @param number sets the subscriber number part of the phone number
	 */
	public void setSubscriberNumber(String number) {
		this.subscriberNumber = number.trim();
	}
	
	/**
	 * 
	 * @return the length of the number
	 */
	public int getLength() {
		return countryCode.length() + areaCode.length() + subscriberNumber.length();
	}
	
	/**
	 * calculates the number of Integer characters of the phone number
	 * @return number of Integer characters of the phone number
	 */
	public int getNumberOfDigits() {
		char[] asciiChars = this.toString().toCharArray();
		int result = 0;
		for(int i = 0; i < asciiChars.length; i++) {
			if(i >= 48 && i <= 57)
				result++;
		}
		return result;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if(countryCode != null)
			builder.append(countryCode);
		if(areaCode != null)
			builder.append(areaCode);
		if(subscriberNumber != null)
			builder.append(subscriberNumber);
		return builder.toString().trim();
	}
	
	/**
	 * more readable representation of the phone number
	 * @return a string with spaces in between each part of the number
	 */
	public String toReadableString() {
		StringBuilder builder = new StringBuilder();
		if(countryCode != null)
			builder.append(countryCode).append(" ");
		if(areaCode != null)
			builder.append(areaCode).append(" ");
		if(subscriberNumber != null)
			builder.append(subscriberNumber);
		return builder.toString().trim();
	}
	
	public boolean isValid() {
		return NumberVerificator.isValid(this);
	}
}
