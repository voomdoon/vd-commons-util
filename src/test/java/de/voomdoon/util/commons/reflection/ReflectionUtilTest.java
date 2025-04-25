package de.voomdoon.util.commons.reflection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Color;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.voomdoon.testing.tests.TestBase;

/**
 * Tests for {@link ReflectionUtil}.
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class ReflectionUtilTest {

	/**
	 * Tests for {@link ReflectionUtil#getStaticFieldValue(Class, String, Class)}.
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class GetStaticFieldValueTest extends TestBase {

		/**
		 * @throws Exception
		 * @since 0.1.0
		 */
		@Test
		void test_Color() throws Exception {
			logTestStart();

			Color actual = ReflectionUtil.getStaticFieldValue(Color.class, "RED", Color.class);
			assertThat(actual).isEqualTo(Color.RED);
		}

		/**
		 * @throws Exception
		 * @since 0.1.0
		 */
		@Test
		void test_NoSuchFieldException_unknownField() throws Exception {
			logTestStart();

			assertThrows(NoSuchFieldException.class,
					() -> ReflectionUtil.getStaticFieldValue(Color.class, "UNKNOWN_FIELD", Color.class));
		}
	}
}
