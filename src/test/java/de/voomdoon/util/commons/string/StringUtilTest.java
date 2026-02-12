package de.voomdoon.util.commons.string;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Tests for {@link StringUtil}.
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
class StringUtilTest {

	/**
	 * Tests for {@link StringUtil#countLeadingSpaces(String)}.
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class CountLeadingSpacesTest {

		/**
		 * @since 0.1.0
		 */
		static Stream<Arguments> noLeadingSpacesTestProvider() {
			return Stream.of(//
					Arguments.of("empty", ""), //
					Arguments.of("noSpace", "test"), //
					Arguments.of("trailingSpace", "test "));
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_error_null_NPE() {
			NullPointerException actual = assertThrows(NullPointerException.class,
					() -> StringUtil.countLeadingSpaces(null));

			assertThat(actual).hasMessage("string");
		}

		/**
		 * @since 0.1.0
		 */
		@ParameterizedTest(name = "{0}")
		@MethodSource("noLeadingSpacesTestProvider")
		void test_noLeadingSpaces(String label, String string) {
			int actual = StringUtil.countLeadingSpaces(string);

			assertThat(actual).isZero();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test1() {
			String string = " test";

			int actual = StringUtil.countLeadingSpaces(string);

			assertThat(actual).isEqualTo(1);
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test2() {
			String string = "  test";

			int actual = StringUtil.countLeadingSpaces(string);

			assertThat(actual).isEqualTo(2);
		}
	}

	/**
	 * Tests for {@link StringUtil#countTrailingSpaces(String)}.
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class CountTrailingSpacesTest {

		/**
		 * @since 0.1.0
		 */
		static Stream<Arguments> noTrailingSpacesTestProvider() {
			return Stream.of(//
					Arguments.of("empty", ""), //
					Arguments.of("noSpace", "test"), //
					Arguments.of("leadingSpace", " test"));
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_error_null_NPE() {
			NullPointerException actual = assertThrows(NullPointerException.class,
					() -> StringUtil.countTrailingSpaces(null));

			assertThat(actual).hasMessage("string");
		}

		/**
		 * @since 0.1.0
		 */
		@ParameterizedTest(name = "{0}")
		@MethodSource("noTrailingSpacesTestProvider")
		void test_noTrailingSpaces(String label, String string) {
			int actual = StringUtil.countTrailingSpaces(string);

			assertThat(actual).isZero();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test1() {
			String string = "test ";

			int actual = StringUtil.countTrailingSpaces(string);

			assertThat(actual).isEqualTo(1);
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test2() {
			String string = "test  ";

			int actual = StringUtil.countTrailingSpaces(string);

			assertThat(actual).isEqualTo(2);
		}
	}
}
