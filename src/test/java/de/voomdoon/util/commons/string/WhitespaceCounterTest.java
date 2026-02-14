package de.voomdoon.util.commons.string;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link WhitespaceCounter}.
 *
 * @author André Schulz
 *
 * @since 0.2.0
 */
class WhitespaceCounterTest {

	/**
	 * Tests for {@link WhitespaceCounter#countLeading(String)}.
	 *
	 * @author André Schulz
	 *
	 * @since 0.2.0
	 */
	@Nested
	class CountLeadingTest {

		/**
		 * @since 0.2.0
		 */
		@Test
		void testCountsLeadingSingleX() {
			WhitespaceCounter counter = new WhitespaceCounter(X_CLASSIFIER);

			int actual = counter.countLeading("x");

			assertThat(actual).isEqualTo(1);
		}

		/**
		 * @since 0.2.0
		 */
		@Test
		void testCountsLeadingXs() {
			WhitespaceCounter counter = new WhitespaceCounter(X_CLASSIFIER);

			int actual = counter.countLeading("xxxabc");

			assertThat(actual).isEqualTo(3);
		}

		/**
		 * @since 0.2.0
		 */
		@Test
		void testEmptyStringIsZero() {
			WhitespaceCounter counter = new WhitespaceCounter(X_CLASSIFIER);

			int actual = counter.countLeading("");

			assertThat(actual).isZero();
		}

		/**
		 * @since 0.2.0
		 */
		@Test
		void testNullStringThrows() {
			WhitespaceCounter counter = new WhitespaceCounter(X_CLASSIFIER);

			ThrowingCallable action = () -> counter.countLeading(null);

			assertThatThrownBy(action).isInstanceOf(NullPointerException.class);
		}

		/**
		 * @since 0.2.0
		 */
		@Test
		void testZeroForSingleNonMatching() {
			WhitespaceCounter counter = new WhitespaceCounter(X_CLASSIFIER);

			int actual = counter.countLeading("a");

			assertThat(actual).isZero();
		}

		/**
		 * @since 0.2.0
		 */
		@Test
		void testZeroWhenNoLeading() {
			WhitespaceCounter counter = new WhitespaceCounter(X_CLASSIFIER);

			int actual = counter.countLeading("abcxxx");

			assertThat(actual).isZero();
		}
	}

	/**
	 * Tests for {@link WhitespaceCounter#countTrailing(String)}.
	 *
	 * @author André Schulz
	 *
	 * @since 0.2.0
	 */
	@Nested
	class CountTrailingTest {

		/**
		 * @since 0.2.0
		 */
		@Test
		void testCountsTrailingSingleX() {
			WhitespaceCounter counter = new WhitespaceCounter(X_CLASSIFIER);

			int actual = counter.countTrailing("x");

			assertThat(actual).isEqualTo(1);
		}

		/**
		 * @since 0.2.0
		 */
		@Test
		void testCountsTrailingXs() {
			WhitespaceCounter counter = new WhitespaceCounter(X_CLASSIFIER);

			int actual = counter.countTrailing("abcxxx");

			assertThat(actual).isEqualTo(3);
		}

		/**
		 * @since 0.2.0
		 */
		@Test
		void testEmptyStringIsZero() {
			WhitespaceCounter counter = new WhitespaceCounter(X_CLASSIFIER);

			int actual = counter.countTrailing("");

			assertThat(actual).isZero();
		}

		/**
		 * @since 0.2.0
		 */
		@Test
		void testNullStringThrows() {
			WhitespaceCounter counter = new WhitespaceCounter(X_CLASSIFIER);

			ThrowingCallable action = () -> counter.countTrailing(null);

			assertThatThrownBy(action).isInstanceOf(NullPointerException.class);
		}

		/**
		 * @since 0.2.0
		 */
		@Test
		void testZeroForSingleNonMatching() {
			WhitespaceCounter counter = new WhitespaceCounter(X_CLASSIFIER);

			int actual = counter.countTrailing("a");

			assertThat(actual).isZero();
		}

		/**
		 * @since 0.2.0
		 */
		@Test
		void testZeroWhenNoTrailing() {
			WhitespaceCounter counter = new WhitespaceCounter(X_CLASSIFIER);

			int actual = counter.countTrailing("xxxabc");

			assertThat(actual).isZero();
		}
	}

	/**
	 * @since 0.2.0
	 */
	private static final CharMatcher X_CLASSIFIER = c -> c == 'x';
}
