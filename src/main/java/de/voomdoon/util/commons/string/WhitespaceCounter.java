package de.voomdoon.util.commons.string;

import java.util.Objects;

/**
 * Counts leading and trailing characters classified by a {@link CharMatcher}.
 *
 * @since 0.2.0
 */
public final class WhitespaceCounter {

	/**
	 * Convenience counter for spaces (' ').
	 *
	 * @since 0.2.0
	 */
	public static final WhitespaceCounter SPACE = new WhitespaceCounter(CharMatcher.SPACE);

	/**
	 * Matcher used for counting.
	 *
	 * @since 0.2.0
	 */
	private final CharMatcher matcher;

	/**
	 * Creates a new counter using the given matcher.
	 *
	 * @param matcher
	 *            matcher to use
	 * @since 0.2.0
	 */
	public WhitespaceCounter(CharMatcher matcher) {
		this.matcher = Objects.requireNonNull(matcher, "matcher");
	}

	/**
	 * Counts leading classified characters.
	 *
	 * @param string
	 *            input string
	 * @return count of leading characters matching the classifier
	 * @since 0.2.0
	 */
	public int countLeading(String string) {
		Objects.requireNonNull(string, "string");
		int count = 0;

		for (int i = 0; i < string.length(); i++) {
			if (matcher.matches(string.charAt(i))) {
				count++;
			} else {
				break;
			}
		}

		return count;
	}

	/**
	 * Counts trailing classified characters.
	 *
	 * @param string
	 *            input string
	 * @return count of trailing characters matching the classifier
	 * @since 0.2.0
	 */
	public int countTrailing(String string) {
		Objects.requireNonNull(string, "string");
		int count = 0;

		for (int i = string.length() - 1; i >= 0; i--) {
			if (matcher.matches(string.charAt(i))) {
				count++;
			} else {
				break;
			}
		}

		return count;
	}
}
