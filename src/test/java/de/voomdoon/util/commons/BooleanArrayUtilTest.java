package de.voomdoon.util.commons;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import de.voomdoon.testing.tests.TestBase;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
class BooleanArrayUtilTest {

	/**
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class CountTrue_booleanArray_Test extends TestBase {

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_empty_result0() throws Exception {
			logTestStart();

			boolean[] array = {};

			int actual = BooleanArrayUtil.countTrue(array);

			assertThat(actual).isZero();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_false_result0() throws Exception {
			logTestStart();

			boolean[] array = { false };

			int actual = BooleanArrayUtil.countTrue(array);

			assertThat(actual).isZero();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_true1_result1() throws Exception {
			logTestStart();

			boolean[] array = { true };

			int actual = BooleanArrayUtil.countTrue(array);

			assertThat(actual).isEqualTo(1);
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_true2_result2() throws Exception {
			logTestStart();

			boolean[] array = { true, true };

			int actual = BooleanArrayUtil.countTrue(array);

			assertThat(actual).isEqualTo(2);
		}
	}

	/**
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class CountTrue_booleanMatrix_Test extends TestBase {

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_empty_result0() throws Exception {
			logTestStart();

			boolean[][] matrix = {};

			int actual = BooleanArrayUtil.countTrue(matrix);

			assertThat(actual).isZero();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_false_result0() throws Exception {
			logTestStart();

			boolean[][] matrix = { { false } };

			int actual = BooleanArrayUtil.countTrue(matrix);

			assertThat(actual).isZero();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_true1_result1() throws Exception {
			logTestStart();

			boolean[][] matrix = { { true } };

			int actual = BooleanArrayUtil.countTrue(matrix);

			assertThat(actual).isEqualTo(1);
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_true2at1row_result2() throws Exception {
			logTestStart();

			boolean[][] matrix = { { true, true } };

			int actual = BooleanArrayUtil.countTrue(matrix);

			assertThat(actual).isEqualTo(2);
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_true2at2rows_result2() throws Exception {
			logTestStart();

			boolean[][] matrix = { { true }, { true } };

			int actual = BooleanArrayUtil.countTrue(matrix);

			assertThat(actual).isEqualTo(2);
		}
	}

	/**
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class GetTrimmedTest extends TestBase {

		/**
		 * @return
		 * @since 0.1.0
		 */
		private static Stream<Arguments> getFalseMatrices() {
			return Stream.of(Arguments.of((Object) new boolean[][] { { false } }),
					Arguments.of((Object) new boolean[][] { { false, false } }),
					Arguments.of((Object) new boolean[][] { { false }, { false } }),
					Arguments.of((Object) new boolean[][] { { false, false }, { false, false } }));
		}

		/**
		 * @return
		 * @since 0.1.0
		 */
		private static Stream<Arguments> getMatricesWithFalseColumnsInBetween() {
			return Stream.of(Arguments.of((Object) new boolean[][] { { true, false, true } }),
					Arguments.of((Object) new boolean[][] { { true, false, false, true } }));
		}

		/**
		 * @return
		 * @since 0.1.0
		 */
		private static Stream<Arguments> getMatricesWithFalseLeft() {
			return Stream.of(Arguments.of((Object) new boolean[][] { { false, true } }),
					Arguments.of((Object) new boolean[][] { { false, false, true } }));
		}

		/**
		 * @return
		 * @since 0.1.0
		 */
		private static Stream<Arguments> getMatricesWithFalseRight() {
			return Stream.of(Arguments.of((Object) new boolean[][] { { true, false } }),
					Arguments.of((Object) new boolean[][] { { true, false, false } }));
		}

		/**
		 * @return
		 * @since 0.1.0
		 */
		private static Stream<Arguments> getMatricesWithFalseRowsAtBottom() {
			return Stream.of(Arguments.of((Object) new boolean[][] { { true }, { false } }),
					Arguments.of((Object) new boolean[][] { { true }, { false }, { false } }));
		}

		/**
		 * @return
		 * @since 0.1.0
		 */
		private static Stream<Arguments> getMatricesWithFalseRowsAtTop() {
			return Stream.of(Arguments.of((Object) new boolean[][] { { false }, { true } }),
					Arguments.of((Object) new boolean[][] { { false }, { false }, { true } }));
		}

		/**
		 * @return
		 * @since 0.1.0
		 */
		private static Stream<Arguments> getMatricesWithFalseRowsInBetween() {
			return Stream.of(Arguments.of((Object) new boolean[][] { { true }, { false }, { true } }),
					Arguments.of((Object) new boolean[][] { { true }, { false }, { false }, { true } }));
		}

		/**
		 * @return
		 * @since 0.1.0
		 */
		private static Stream<Arguments> getTrueMatrices() {
			return Stream.of(Arguments.of((Object) new boolean[][] { { true } }),
					Arguments.of((Object) new boolean[][] { { true, true } }),
					Arguments.of((Object) new boolean[][] { { true }, { true } }),
					Arguments.of((Object) new boolean[][] { { true, true }, { true, true } }));
		}

		/**
		 * @since 0.1.0
		 */
		@ParameterizedTest
		@MethodSource(value = "getMatricesWithFalseColumnsInBetween")
		void test_columns_omitFalseInBetween(boolean[][] matrix) throws Exception {
			logTestStart();

			boolean[][] actual = BooleanArrayUtil.getTrimmed(matrix);

			assertThat(actual).isEqualTo(matrix);
		}

		/**
		 * @since 0.1.0
		 */
		@ParameterizedTest
		@MethodSource(value = "getMatricesWithFalseLeft")
		void test_columns_omitFalseLeft(boolean[][] matrix) throws Exception {
			logTestStart();

			boolean[][] expected = new boolean[][] { { true } };

			boolean[][] actual = BooleanArrayUtil.getTrimmed(matrix);

			assertThat(actual).isEqualTo(expected);
		}

		/**
		 * @since 0.1.0
		 */
		@ParameterizedTest
		@MethodSource(value = "getMatricesWithFalseRight")
		void test_columns_omitFalseRight(boolean[][] matrix) throws Exception {
			logTestStart();

			boolean[][] expected = new boolean[][] { { true } };

			boolean[][] actual = BooleanArrayUtil.getTrimmed(matrix);

			assertThat(actual).isEqualTo(expected);
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_empty_resultEmpty() throws Exception {
			logTestStart();

			boolean[][] actual = BooleanArrayUtil.getTrimmed(new boolean[0][0]);

			assertThat(actual).isEmpty();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_empty_resultNotSame() throws Exception {
			logTestStart();

			boolean[][] input = new boolean[0][0];

			boolean[][] actual = BooleanArrayUtil.getTrimmed(input);

			assertThat(actual).isNotSameAs(input);
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_emptyRowAndColumnInBetween_resultEqual() throws Exception {
			logTestStart();

			boolean[][] matrix = new boolean[][] { { true, false, true }, { false, false, false },
					{ true, false, true } };

			boolean[][] actual = BooleanArrayUtil.getTrimmed(matrix);

			assertThat(actual).isEqualTo(matrix);
		}

		/**
		 * @since 0.1.0
		 */
		@ParameterizedTest
		@MethodSource(value = "getFalseMatrices")
		void test_falseOnly_resultEmpty(boolean[][] matrix) throws Exception {
			logTestStart();

			boolean[][] actual = BooleanArrayUtil.getTrimmed(matrix);

			assertThat(actual).isEmpty();
		}

		@Test
		void test_rows_keep2FalseSectionsInBetween() throws Exception {
			logTestStart();

			boolean[][] matrix = new boolean[][] { { true }, { false }, { true }, { false }, { true } };

			boolean[][] actual = BooleanArrayUtil.getTrimmed(matrix);

			assertThat(actual).isEqualTo(matrix);
		}

		/**
		 * @since 0.1.0
		 */
		@ParameterizedTest
		@MethodSource(value = "getMatricesWithFalseRowsInBetween")
		void test_rows_keepFalseInBetween(boolean[][] matrix) throws Exception {
			logTestStart();

			boolean[][] actual = BooleanArrayUtil.getTrimmed(matrix);

			assertThat(actual).isEqualTo(matrix);
		}

		/**
		 * @since 0.1.0
		 */
		@ParameterizedTest
		@MethodSource(value = "getMatricesWithFalseRowsAtBottom")
		void test_rows_omitFalseAtBottom(boolean[][] matrix) throws Exception {
			logTestStart();

			boolean[][] expected = new boolean[][] { { true } };

			boolean[][] actual = BooleanArrayUtil.getTrimmed(matrix);

			assertThat(actual).isEqualTo(expected);
		}

		/**
		 * @since 0.1.0
		 */
		@ParameterizedTest
		@MethodSource(value = "getMatricesWithFalseRowsAtTop")
		void test_rows_omitFalseAtTop(boolean[][] matrix) throws Exception {
			logTestStart();

			boolean[][] expected = new boolean[][] { { true } };

			boolean[][] actual = BooleanArrayUtil.getTrimmed(matrix);

			assertThat(actual).isEqualTo(expected);
		}

		/**
		 * @since 0.1.0
		 */
		@ParameterizedTest
		@MethodSource(value = "getTrueMatrices")
		void test_trueOnly_resultEqual(boolean[][] matrix) throws Exception {
			logTestStart();

			boolean[][] actual = BooleanArrayUtil.getTrimmed(matrix);

			assertThat(actual).isEqualTo(matrix);
		}
	}

	// /**
	// * @author André Schulz
	// *
	// * @since 0.1.0
	// */
	// class GetMaxWidthTest extends TestBase {
	//
	// /**
	// * @since 0.1.0
	// */
	// @Test
	// void test_empty() throws Exception {
	// logTestStart();
	//
	// int actual = BooleanArrayUtil.getMaxWidth(List.of());
	//
	// assertThat(actual).isEqualTo(-1);
	//
	// // TODO implement test_runProgram_called
	// throw new UnsupportedOperationException("Method 'test_empty' not implemented yet!");
	// }
	// }

	/**
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class IsEmptyTest extends TestBase {

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_false_1True() throws Exception {
			logTestStart();

			boolean[][] matix = { { true } };

			boolean actual = BooleanArrayUtil.isEmpty(matix);

			assertThat(actual).isFalse();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_true_1False() throws Exception {
			logTestStart();

			boolean[][] matix = { { false } };

			boolean actual = BooleanArrayUtil.isEmpty(matix);

			assertThat(actual).isTrue();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_true_empty() throws Exception {
			logTestStart();

			boolean[][] matix = {};

			boolean actual = BooleanArrayUtil.isEmpty(matix);

			assertThat(actual).isTrue();
		}
	}
}
