package de.voomdoon.util.commons.bool;

import lombok.experimental.UtilityClass;

/**
 * Utility for boolean arrays.
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
@UtilityClass
public class BooleanArrayUtil {

	/**
	 * DOCME add JavaDoc for method countTrue
	 * 
	 * @param array
	 * @return
	 * @since 0.1.0
	 */
	public int countTrue(boolean[] array) {
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i]) {
				count++;
			}
		}

		return count;
	}
}
