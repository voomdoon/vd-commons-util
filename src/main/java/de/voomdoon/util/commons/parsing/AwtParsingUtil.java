package de.voomdoon.util.commons.parsing;

import java.awt.Color;

import de.voomdoon.util.commons.reflection.reflection.ReflectionUtil;
import lombok.experimental.UtilityClass;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since DOCME add inception version number
 */
@UtilityClass
public class AwtParsingUtil {

	/**
	 * DOCME add JavaDoc for method parseColor
	 * 
	 * @param value
	 *            {@link String}
	 * @return {@link Color}
	 * @since DOCME add inception version number
	 */
	public static Color parseColor(final String value) {
		return ReflectionUtil.getStaticFieldValue(Color.class, value, Color.class);
	}
}
