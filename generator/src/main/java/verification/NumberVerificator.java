package verification;

import model.PhoneNumber;

/**
 * 
 * @author ndrscodes - Andreas Schmidt
 *
 */
public class NumberVerificator {
	
	/**
	 * Checks if a {@code PhoneNumber} object represents a valid E.164 formatted number
	 * @param number the {@code PhoneNumber} to check
	 * @return true if the number is a valid E.164 formatted number, false if not.
	 */
	public static boolean isValid(PhoneNumber number) {
		int limit = number.getCountryCode().length() + number.getAreaCode().length();

		return number.getCountryCode().matches("\\+?[1-9]\\d{0,2}")
				&& number.getAreaCode().matches("^\\d{2,6}")
				&& number.getSubscriberNumber().matches("^\\d{2," + Integer.toString(15 - limit) + "}");
	}
}
