package de.voomdoon.util.commons.bool;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

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
	 * Converts a list of boolean arrays into a matrix.
	 * 
	 * @param rows
	 *            {@link List}
	 * @return 2d boolean array
	 * @since 0.1.0
	 */
	private static boolean[][] toMatrix(List<boolean[]> rows) {
		boolean[][] result = new boolean[rows.size()][];

		int iRow = 0;

		for (boolean[] row : rows) {
			result[iRow++] = row;
		}

		return result;
	}

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
