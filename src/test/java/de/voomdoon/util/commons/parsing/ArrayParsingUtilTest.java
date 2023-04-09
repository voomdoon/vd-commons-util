package de.voomdoon.util.commons.parsing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import de.voomdoon.testing.tests.TestBase;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since DOCME add inception version number
 */
public class ArrayParsingUtilTest {

	/**
	 * Test class for {@link ArrayParsingUtil#parseBooleanArray2(String)}.
	 *
	 * @author André Schulz
	 *
	 * @since DOCME add inception version number
	 */
	static class ParseBooleanArray2Test extends TestBase {

		/**
		 * @since DOCME add inception version number
		 */
		@Test
		public void test_oneRow() {
			logTestStart();

			boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("101");
			assertThat(actual).isEqualTo(new boolean[][] { { true, false, true } });
		}

		/**
		 * @since DOCME add inception version number
		 */
		@Test
		void test_false_0() {
			logTestStart();

			boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("0");
			assertThat(actual).isEqualTo(new boolean[][] { { false } });
		}

		/**
		 * @since DOCME add inception version number
		 */
		@Test
		void test_true_1() {
			logTestStart();

			boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("1");
			assertThat(actual).isEqualTo(new boolean[][] { { true } });
		}

		/**
		 * @since DOCME add inception version number
		 */
		@Test
		void test_twoRows() {
			logTestStart();

			boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("101\n010");
			assertThat(actual).isEqualTo(new boolean[][] { { true, false, true }, { false, true, false } });
		}
	}
}
