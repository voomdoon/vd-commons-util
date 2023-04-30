package de.voomdoon.util.commons.parsing;

import java.awt.Color;

import de.voomdoon.util.commons.reflection.reflection.ReflectionUtil;
import lombok.experimental.UtilityClass;

/**
 * DOCME add JavaDoc for
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
	 * @since 0.1.0
	 */
	public static Color parseColor(final String value) {
		return ReflectionUtil.getStaticFieldValue(Color.class, value, Color.class);
	}
}
