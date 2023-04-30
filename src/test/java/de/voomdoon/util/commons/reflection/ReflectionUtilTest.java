package de.voomdoon.util.commons;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import de.voomdoon.testing.tests.TestBase;
import de.voomdoon.util.commons.reflection.reflection.ReflectionUtil;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since DOCME add inception version number
 */
public class ReflectionUtilTest {

	/**
	 * Test class for {@link ReflectionUtil#getStaticFieldValue(Class, String, Class)}.
	 *
	 * @author André Schulz
	 *
	 * @since DOCME add inception version number
	 */
	static class GetStaticFieldValueTest extends TestBase {

		/**
		 * @throws Exception
		 * @since DOCME add inception version number
		 */
		@Test
		void test_Color() throws Exception {
			logTestStart();

			Color actual = ReflectionUtil.getStaticFieldValue(Color.class, "RED", Color.class);
			assertThat(actual).isEqualTo(Color.RED);
		}
	}
}
