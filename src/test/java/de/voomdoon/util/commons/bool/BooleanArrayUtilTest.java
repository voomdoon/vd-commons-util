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

}
