package de.voomdoon.util.commons.string;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.experimental.UtilityClass;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
@UtilityClass
public class StringUtil {

	/**
	 * @since 0.1.0
	 */
	private static final Pattern LEADING_SPACES_PATTERN = Pattern.compile("^ *");

	/**
	 * @since 0.1.0
	 */
	private static final Pattern TRALING_SPACES_PATTERN = Pattern.compile(" *$");

	/**
	 * DOCME add JavaDoc for method countLeadingSpaces
	 * 
	 * @param string
	 * @return
	 * @since 0.1.0
	 */
	public static int countLeadingSpaces(String string) {
		Objects.requireNonNull(string, "string");

		return countPattern(string, LEADING_SPACES_PATTERN);
	}

	/**
	 * DOCME add JavaDoc for method countTrailingSpaces
	 * 
	 * @param string
	 * @return
	 * @since 0.1.0
	 */
	public static int countTrailingSpaces(String string) {
		Objects.requireNonNull(string, "string");

		return countPattern(string, TRALING_SPACES_PATTERN);
	}

	/**
	 * DOCME add JavaDoc for method countPattern
	 * 
	 * @param string
	 * @param pattern
	 * @return
	 * @since 0.1.0
	 */
	private static int countPattern(String string, Pattern pattern) {
		int count = 0;
		Matcher m = pattern.matcher(string);

		if (m.find()) {
			count = m.group().length();
		}

		return count;
	}
}
