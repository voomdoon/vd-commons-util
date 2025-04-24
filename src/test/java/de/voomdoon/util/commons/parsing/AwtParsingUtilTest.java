package de.voomdoon.util.commons.parsing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Color;
import java.text.ParseException;

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
	 * Tests for {@link ArrayParsingUtil}.
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class ParseColorTest extends TestBase {

		/**
		 * @throws ParseException
		 * @since 0.1.0
		 */
		@Test
		void test_Color() throws ParseException {
			logTestStart();

			Color actual = AwtParsingUtil.parseColor("RED");
			assertThat(actual).isEqualTo(Color.RED);
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_ParseException_unknownColor() throws Exception {
			logTestStart();

			assertThrows(ParseException.class, () -> AwtParsingUtil.parseColor("UNKNOWN_COLOR"));
		}
	}
}
