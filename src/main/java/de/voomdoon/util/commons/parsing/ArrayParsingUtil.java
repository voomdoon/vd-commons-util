package de.voomdoon.util.commons.parsing;

import lombok.experimental.UtilityClass;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
@UtilityClass
public class ArrayParsingUtil {

	/**
	 * DOCME add JavaDoc for method parseBooleanArray2
	 * 
	 * @param string
	 * @return
	 * @since 0.1.0
	 */
	public static boolean[][] parseBooleanArray2(String string) {
		String[] lines = string.split("\n");
		boolean[][] result = new boolean[lines.length][];

		for (int iRow = 0; iRow < lines.length; iRow++) {
			result[iRow] = new boolean[lines[iRow].length()];

			for (int iCol = 0; iCol < lines[iRow].length(); iCol++) {
				result[iRow][iCol] = lines[iRow].charAt(iCol) == '1';
			}
		}

		return result;
	}
}
