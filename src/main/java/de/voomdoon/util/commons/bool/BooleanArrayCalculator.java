package de.voomdoon.util.commons.bool;

import java.util.List;

import lombok.experimental.UtilityClass;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
@UtilityClass
public class BooleanArrayCalculator {

	/**
	 * DOCME add JavaDoc for method or
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 0.1.0
	 */
	public static boolean[][] or(boolean[][] a, boolean[][] b) {
		boolean[][] result = new boolean[a.length][];

		for (int i = 0; i < a.length; i++) {
			result[i] = new boolean[a[i].length];

			for (int j = 0; j < a[i].length; j++) {
				result[i][j] = a[i][j] | b[i][j];
			}
		}

		return result;
		// TODO implement or
	}
}
