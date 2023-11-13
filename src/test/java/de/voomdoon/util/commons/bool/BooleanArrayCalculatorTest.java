package de.voomdoon.util.commons.bool;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.voomdoon.testing.tests.TestBase;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
class BooleanArrayCalculatorTest {

	/**
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class OrTest extends TestBase {

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_empty() throws Exception {
			logTestStart();

			boolean[][] actual = BooleanArrayCalculator.or(new boolean[0][0], new boolean[0][0]);

			assertThat(actual).isEqualTo(new boolean[0][0]);
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_true_left() throws Exception {
			logTestStart();

			boolean[][] actual = BooleanArrayCalculator.or(new boolean[][] { { true } }, new boolean[][] { { false } });

			assertThat(actual).isEqualTo(new boolean[][] { { true } });
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_true_right() throws Exception {
			logTestStart();

			boolean[][] actual = BooleanArrayCalculator.or(new boolean[][] { { false } }, new boolean[][] { { true } });

			assertThat(actual).isEqualTo(new boolean[][] { { true } });
		}
	}
}
