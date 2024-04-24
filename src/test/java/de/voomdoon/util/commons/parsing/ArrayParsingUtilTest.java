package de.voomdoon.util.commons.parsing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.voomdoon.testing.tests.TestBase;

/**
 * Test class for {@link ArrayParsingUtil}.
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class ArrayParsingUtilTest {

	/**
	 * Test method for {@link ArrayParsingUtil#parseBooleanArray2(String)}.
	 * 
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class ParseBooleanArray2Test extends TestBase {

		/**
		 * DOCME add JavaDoc for ArrayParsingUtilTest.ParseBooleanArray2Test
		 *
		 * @author André Schulz
		 *
		 * @since 0.1.0
		 */
		@Nested
		class Block_fullLine_Test extends TestBase {

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_columns_trueFalse() throws Exception {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("full line\n" //
						+ "██" + "  ");

				assertThat(actual).isEqualTo(new boolean[][] { { true, false } });
			}

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_false() throws Exception {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("full line\n" //
						+ "  ");

				assertThat(actual).isEqualTo(new boolean[][] { { false } });
			}

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_true() throws Exception {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("full line\n" //
						+ "██");

				assertThat(actual).isEqualTo(new boolean[][] { { true } });
			}

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_true_columns2() throws Exception {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("full line\n" //
						+ "██" + "██");

				assertThat(actual).isEqualTo(new boolean[][] { { true, true } });
			}

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_true_rows2() throws Exception {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("full line\n" //
						+ "██" + "\n"//
						+ "██");

				assertThat(actual).isEqualTo(new boolean[][] { { true }, { true } });
			}
		}

		/**
		 * DOCME add JavaDoc for ArrayParsingUtilTest.ParseBooleanArray2Test
		 *
		 * @author André Schulz
		 *
		 * @since 0.1.0
		 */
		@Nested
		class Block_halfLine_Test extends TestBase {

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_false() throws Exception {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2(" ");

				assertThat(actual).isEqualTo(new boolean[][] { { false }, { false } });
			}

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_rows_falseTrue() throws Exception {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("▄");

				assertThat(actual).isEqualTo(new boolean[][] { { false }, { true } });
			}

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_rows_falseTrueFalseTrue() throws Exception {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("▄\n▄");

				assertThat(actual).isEqualTo(new boolean[][] { { false }, { true }, { false }, { true } });
			}

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_rows_trueFalse() throws Exception {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("▀");

				assertThat(actual).isEqualTo(new boolean[][] { { true }, { false } });
			}

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_rows_trueTrue() throws Exception {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("█");

				assertThat(actual).isEqualTo(new boolean[][] { { true }, { true } });
			}

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_rows_trueTrueTrue() throws Exception {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("█\n▀");

				assertThat(actual).isEqualTo(new boolean[][] { { true }, { true }, { true }, { false } });
			}

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_rows4_true() throws Exception {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("█\n█");

				assertThat(actual).isEqualTo(new boolean[][] { { true }, { true }, { true }, { true } });
			}
		}

		/**
		 * Test class using {@code 0} and {@code 1}.
		 * 
		 * @author André Schulz
		 *
		 * @since 0.1.0
		 */
		@Nested
		class OneAndZeroTest extends TestBase {

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_false_0() {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("0");

				assertThat(actual).isEqualTo(new boolean[][] { { false } });
			}

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_oneRow() {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("101");

				assertThat(actual).isEqualTo(new boolean[][] { { true, false, true } });
			}

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_true_1() {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("1");

				assertThat(actual).isEqualTo(new boolean[][] { { true } });
			}

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_twoRows() {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("101\n010");

				assertThat(actual).isEqualTo(new boolean[][] { { true, false, true }, { false, true, false } });
			}

			/**
			 * @since 0.1.0
			 */
			@Test
			void test_twoRowsWithCarriageReturn() {
				logTestStart();

				boolean[][] actual = ArrayParsingUtil.parseBooleanArray2("101\r\n010");

				assertThat(actual).isEqualTo(new boolean[][] { { true, false, true }, { false, true, false } });
			}
		}
	}
}
