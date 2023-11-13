package de.voomdoon.util.commons.string;

import static de.voomdoon.util.commons.string.ToBlockStringGenerator.DEFAULT;
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
class ToBlockStringGeneratorTest {

	@Nested
	class BooleanPrimitiveTest extends TestBase {

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_2Rows_falseFalse() throws Exception {
			logTestStart();

			String actual = DEFAULT.toString(new boolean[][] { { false }, { false } });

			assertThat(actual).isEqualTo(" ");
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_2Rows_falseTrue() throws Exception {
			logTestStart();

			String actual = DEFAULT.toString(new boolean[][] { { false }, { true } });

			assertThat(actual).isEqualTo("▄");
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_2Rows_trueFalse() throws Exception {
			logTestStart();

			String actual = DEFAULT.toString(new boolean[][] { { true }, { false } });

			assertThat(actual).isEqualTo("▀");
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_2Rows_trueTrue() throws Exception {
			logTestStart();

			String actual = DEFAULT.toString(new boolean[][] { { true }, { true } });

			assertThat(actual).isEqualTo("█");
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_2RowsWithDifferentLength_false_falsefalse() throws Exception {
			logTestStart();

			String actual = DEFAULT.toString(new boolean[][] { { false }, { false, false } });

			assertThat(actual).isEqualTo("  ");
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_2RowsWithDifferentLength_false_trueTrue() throws Exception {
			logTestStart();

			String actual = DEFAULT.toString(new boolean[][] { { false }, { true, true } });

			assertThat(actual).isEqualTo("▄▄");
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_3Rows() throws Exception {
			logTestStart();

			String actual = DEFAULT.toString(new boolean[][] { { true }, { true }, { true } });

			assertThat(actual).isEqualTo("█\n▀");
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_empty() throws Exception {
			logTestStart();

			String actual = DEFAULT.toString(new boolean[0][0]);

			assertThat(actual).isEmpty();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_false() throws Exception {
			logTestStart();

			String actual = DEFAULT.toString(new boolean[][] { { false } });

			assertThat(actual).isEqualTo(" ");
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_false2Columns() throws Exception {
			logTestStart();

			String actual = DEFAULT.toString(new boolean[][] { { false, false } });

			assertThat(actual).isEqualTo("  ");
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_true() throws Exception {
			logTestStart();

			String actual = DEFAULT.toString(new boolean[][] { { true } });

			assertThat(actual).isEqualTo("▀");
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_true2Columns() throws Exception {
			logTestStart();

			String actual = DEFAULT.toString(new boolean[][] { { true, true } });

			assertThat(actual).isEqualTo("▀▀");
		}
	}
}
