package generators;

import java.util.Random;

import model.Country;
import model.PhoneNumber;

/**
 * 
 * @author ndrscodes - Andreas Schmidt
 *
 */
public class NumberGenerator {
	
	private Country country;
	private final Random randomSource = new Random();
	
	/**
	 * creates a NumberGenerator using the specified {@code country}'s country code
	 * @param country the country who's country code to use when generating the number
	 */
	public NumberGenerator(Country country) {
		this.country = country;
	}
	
	/**
	 * generates a random phone number
	 * @return the generated phone number represented by a {@code PhoneNumber} object
	 */
	public static PhoneNumber generate() {
		NumberGenerator generator = new NumberGenerator(getRandomCountry());
		PhoneNumber number = new PhoneNumber();
		generator.getCountryCode(number);
		generator.generateLocalNumber(number);
		generator.generateNumber(number);
		return number;
	}
	
	
	
	private static Country getRandomCountry() {
		Random r = new Random();
		return Country.values()[r.nextInt(Country.values().length)];
	}
	
	private void getCountryCode(PhoneNumber number) {
		number.setCountryCode(country.getNumberingPrefix());
	}
	
	private void generateLocalNumber(PhoneNumber number) {
		number.setAreaCode(Integer.toString((randomSource.nextInt(99999) + 10)));
	}
	
	private void generateNumber(PhoneNumber number) {
		int numberLength = number.getAreaCode().length()
				+ number.getCountryCode().length();
		long limit = (long) Math.pow(10, (15 - numberLength) - 1);
		number.setSubscriberNumber(Integer.toString(randomSource.nextInt(10))
				+ Long.toString(((randomSource.nextLong() & Long.MAX_VALUE) + 1) % limit));
	}
	
}
