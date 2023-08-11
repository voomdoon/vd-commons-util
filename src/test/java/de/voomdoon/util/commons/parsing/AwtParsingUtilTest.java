package de.voomdoon.util.commons.parsing;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.Color;

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
public class AwtParsingUtilTest {

	/**
	 * Test class for {@link ArrayParsingUtil}.
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class ParseColorTest extends TestBase {

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_Color() {
			logTestStart();

			Color actual = AwtParsingUtil.parseColor("RED");
			assertThat(actual).isEqualTo(Color.RED);
		}
	}
}
