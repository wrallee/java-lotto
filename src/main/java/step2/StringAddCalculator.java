package step2;

import static java.lang.Integer.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	public static final String DEFAULT_DELIM_REGEX = ",|:";
	public static final String CUSTOM_DELIM_REGEX = "//(.)\n(.*)";
	public static final int DELIM_INDEX = 1;
	public static final int CONTENTS_INDEX = 2;

	public static int splitAndSum(String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}

		String[] tokens = getStringArray(text);

		return sumStringArray(tokens);
	}

	private static String[] getStringArray(String text) {
		Matcher m = Pattern.compile(CUSTOM_DELIM_REGEX).matcher(text);

		if (m.find()) {
			String customDelimiter = m.group(DELIM_INDEX);
			return m.group(CONTENTS_INDEX).split(customDelimiter);
		}

		return text.split(DEFAULT_DELIM_REGEX);
	}

	private static int sumStringArray(String[] numbers) {
		int sum = 0;

		for (String number : numbers) {
			sum += convertToInteger(number);
		}

		return sum;
	}

	private static int convertToInteger(String number) {
		int convertNumber = parseInt(number);

		if (convertNumber < 0) {
			throw new IllegalArgumentException("Negative number is invalid!");
		}

		return convertNumber;
	}
}