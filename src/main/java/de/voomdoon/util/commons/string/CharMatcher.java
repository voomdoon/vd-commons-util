package de.voomdoon.util.commons.string;

/**
 * Matches characters for whitespace counting.
 *
 * @since 0.2.0
 */
@FunctionalInterface
public interface CharMatcher {

	/**
	 * Anonymous implementation matching a single space character ({@code ' '}).
	 *
	 * @since 0.2.0
	 */
	CharMatcher SPACE = c -> c == ' ';

	/**
	 * Returns true if the given character matches this matcher.
	 *
	 * @since 0.2.0
	 */
	boolean matches(char c);
}
