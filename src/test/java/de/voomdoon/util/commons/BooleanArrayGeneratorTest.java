package de.voomdoon.util.commons;

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
class BooleanArrayGeneratorTest {

	/**
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class GenerateRandomMatrixTest extends TestBase {

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_0_0_resultEmpty() throws Exception {
			logTestStart();

			boolean[][] actual = BooleanArrayGenerator.DEFAULT.generateRandomMatrix(0, 0);

			assertThat(actual).isEmpty();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_1_0_resultHasOneRow() throws Exception {
			logTestStart();

			boolean[][] actual = BooleanArrayGenerator.DEFAULT.generateRandomMatrix(1, 0);

			assertThat(actual).hasNumberOfRows(1);
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_1_0_resultRowIsEmpty() throws Exception {
			logTestStart();

			boolean[][] actual = BooleanArrayGenerator.DEFAULT.generateRandomMatrix(1, 0);

			assertThat(actual[0]).isEmpty();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_1_1_resultCanContainTrueOrFalse() throws Exception {
			logTestStart();

			int count = 0;
			boolean foundTrue = false;
			boolean foundFalse = false;

			while (count++ < 10000 && (!foundTrue || !foundFalse)) {
				boolean[][] actual = BooleanArrayGenerator.DEFAULT.generateRandomMatrix(1, 1);

				foundTrue |= actual[0][0];
				foundFalse |= !actual[0][0];
			}

			assertThat(foundTrue).as("found 'true'").isTrue();
			assertThat(foundFalse).as("found 'false'").isTrue();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_1_1_resultRowHasSize1() throws Exception {
			logTestStart();

			boolean[][] actual = BooleanArrayGenerator.DEFAULT.generateRandomMatrix(1, 1);

			assertThat(actual[0]).hasSize(1);
		}
	}
}
