package de.voomdoon.util.commons.parsing;

import java.awt.Color;
import java.text.ParseException;

import de.voomdoon.util.commons.reflection.ReflectionUtil;
import lombok.experimental.UtilityClass;

//TODO move to vd-awt-from-string-parsers

/**
 * Utility to parse {@code java.awt} classes.
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
@UtilityClass
public class AwtParsingUtil {

	/**
	 * DOCME add JavaDoc for method parseColor
	 * 
	 * @param value
	 *            {@link String}
	 * @return {@link Color}
	 * @throws ParseException
	 * @since 0.1.0
	 */
	public static Color parseColor(final String value) throws ParseException {
		try {
			return ReflectionUtil.getStaticFieldValue(Color.class, value, Color.class);
		} catch (NoSuchFieldException e) {
			throw new ParseException("Failed to parse Color from '" + value + "'!", -1);
		}
	}
}
