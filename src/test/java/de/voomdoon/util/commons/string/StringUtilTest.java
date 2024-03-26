package de.voomdoon.util.commons.string;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
class StringUtilTest {

	/**
	 * DOCME add JavaDoc for StringUtilTest
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class CountLeadingSpacesTest extends TestBase {

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_empty() {
			logTestStart();

			String string = "";

			int actual = StringUtil.countLeadingSpaces(string);

			assertThat(actual).isZero();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_error_null_NPE() throws Exception {
			logTestStart();

			NullPointerException actual = assertThrows(NullPointerException.class,
					() -> StringUtil.countLeadingSpaces(null));

			assertThat(actual).hasMessage("string");
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_noSpace() throws Exception {
			logTestStart();

			String string = "test";

			int actual = StringUtil.countLeadingSpaces(string);

			assertThat(actual).isZero();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_traling() throws Exception {
			logTestStart();

			String string = "test ";

			int actual = StringUtil.countLeadingSpaces(string);

			assertThat(actual).isZero();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test1() throws Exception {
			logTestStart();

			String string = " test";

			int actual = StringUtil.countLeadingSpaces(string);

			assertThat(actual).isEqualTo(1);
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test2() throws Exception {
			logTestStart();

			String string = "  test";

			int actual = StringUtil.countLeadingSpaces(string);

			assertThat(actual).isEqualTo(2);
		}
	}

	/**
	 * DOCME add JavaDoc for StringUtilTest
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class CountTrailingSpacesTest extends TestBase {

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_empty() {
			logTestStart();

			String string = "";

			int actual = StringUtil.countTrailingSpaces(string);

			assertThat(actual).isZero();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_error_null_NPE() throws Exception {
			logTestStart();

			NullPointerException actual = assertThrows(NullPointerException.class,
					() -> StringUtil.countTrailingSpaces(null));

			assertThat(actual).hasMessage("string");
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_leading() throws Exception {
			logTestStart();

			String string = " test";

			int actual = StringUtil.countTrailingSpaces(string);

			assertThat(actual).isZero();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_noSpace() throws Exception {
			logTestStart();

			String string = "test";

			int actual = StringUtil.countTrailingSpaces(string);

			assertThat(actual).isZero();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test1() throws Exception {
			logTestStart();

			String string = "test ";

			int actual = StringUtil.countTrailingSpaces(string);

			assertThat(actual).isEqualTo(1);
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test2() throws Exception {
			logTestStart();

			String string = "test  ";

			int actual = StringUtil.countTrailingSpaces(string);

			assertThat(actual).isEqualTo(2);
		}
	}
}
