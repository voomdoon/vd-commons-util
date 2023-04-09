package de.voomdoon.util.commons.parsing;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import de.voomdoon.testing.tests.TestBase;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since DOCME add inception version number
 */
public class AwtParsingUtilTest {

	/**
	 * Test class for {@link ArrayParsingUtil}.
	 *
	 * @author André Schulz
	 *
	 * @since DOCME add inception version number
	 */
	static class ParseColorTest extends TestBase {

		/**
		 * @since DOCME add inception version number
		 */
		@Test
		void test_Color() {
			logTestStart();

			Color actual = AwtParsingUtil.parseColor("RED");
			assertThat(actual).isEqualTo(Color.RED);
		}
	}
}
