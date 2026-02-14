package de.voomdoon.util.commons.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link CharMatcher}.
 *
 * @author André Schulz
 *
 * @since 0.2.0
 */
class CharMatcherTest {

	/**
	 * Tests for {@link CharMatcher#SPACE}.
	 *
	 * @author André Schulz
	 *
	 * @since 0.2.0
	 */
	@Nested
	class SpaceTest {

		/**
		 * @since 0.2.0
		 */
		@Test
		void testMatchesSpace() {
			boolean actual = CharMatcher.SPACE.matches(' ');

			assertThat(actual).isTrue();
		}

		/**
		 * @since 0.2.0
		 */
		@Test
		void testDoesNotMatchNonSpace() {
			boolean actual = CharMatcher.SPACE.matches('x');

			assertThat(actual).isFalse();
		}
	}
}
