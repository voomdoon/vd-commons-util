package de.voomdoon.util.commons.string;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.experimental.UtilityClass;

/**
 * Utility methods for {@link String}s.
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
	private static final Pattern TRAILING_SPACES_PATTERN = Pattern.compile(" *$");

	/**
	 * Returns the amount of leading spaces ({@code ' '}) in the given {@link String}.
	 * 
	 * @param string
	 *            {@link String}
	 * @return amount of leading spaces
	 * @since 0.1.0
	 */
	public static int countLeadingSpaces(String string) {
		Objects.requireNonNull(string, "string");

		return countPattern(string, LEADING_SPACES_PATTERN);
	}

	/**
	 * Returns the amount of trailing spaces ({@code ' '}) in the given {@link String}.
	 * 
	 * @param string
	 *            {@link String}
	 * @return amount of trailing spaces
	 * @since 0.1.0
	 */
	public static int countTrailingSpaces(String string) {
		Objects.requireNonNull(string, "string");

		return countPattern(string, TRAILING_SPACES_PATTERN);
	}

	/**
	 * @param string
	 *            {@link String}
	 * @param pattern
	 *            {@link Pattern}
	 * @return amount of characters in the first match of the pattern in the string
	 * @since 0.1.0
	 */
	private static int countPattern(String string, Pattern pattern) {
		Matcher m = pattern.matcher(string);

		if (m.find()) {
			return m.group().length();
		}

		return 0;
	}
}
