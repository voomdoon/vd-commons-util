package de.voomdoon.util.commons.parsing;

import de.voomdoon.util.commons.string.ToBlockStringGenerator;
import lombok.experimental.UtilityClass;

/**
 * Utility to parse arrays with one or more dimensions.
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
	 * @see ToBlockStringGenerator
	 */
	public static boolean[][] parseBooleanArray2(String string) {
		if (string.startsWith("full line\n")) {
			return parseBooleanArray2WithFullLineBlocks(string);
		} else if (string.contains("0") || string.contains("1")) {
			return parseBooleanArray2WithOneAndZero(string);
		} else if (string.contains(" ") || string.contains("█") || string.contains("▀") || string.contains("▄")) {
			return parseBooleanArray2WithHalfLineBlocks(string);
		} else {
			throw new UnsupportedOperationException("Method 'parseBooleanArray2' not implemented for\n" + string);
		}
	}

	/**
	 * DOCME add JavaDoc for method parseBlockRow
	 * 
	 * @param line
	 * @param result
	 * @param iLine
	 * @since 0.1.0
	 */
	private static void parseBlockLine(String line, boolean[][] result, int iLine) {
		for (int iCol = 0; iCol < line.length(); iCol++) {
			char c = line.charAt(iCol);

			if (c == ' ') {
				// ignore
			} else if (c == '█') {
				result[iLine * 2][iCol] = true;
				result[iLine * 2 + 1][iCol] = true;
			} else if (c == '▀') {
				result[iLine * 2][iCol] = true;
				result[iLine * 2 + 1][iCol] = false;
			} else if (c == '▄') {
				result[iLine * 2][iCol] = false;
				result[iLine * 2 + 1][iCol] = true;
			} else {
				throw new IllegalArgumentException("Unrecognized character: '" + c + "' (" + ((int) c) + ")!");
			}
		}
	}

	/**
	 * DOCME add JavaDoc for method parseBooleanArray2WithFullLineBlocks
	 * 
	 * @param string
	 * @return
	 * @since DOCME add inception version number
	 */
	private static boolean[][] parseBooleanArray2WithFullLineBlocks(String string) {
		String[] lines = string.split("\n");
		boolean[][] result = new boolean[lines.length - 1][];

		for (int i = 0; i < result.length; i++) {
			result[i] = parseBooleanArrayWithFullLineBlocks(lines[i + 1]);
		}

		return result;
	}

	/**
	 * DOCME add JavaDoc for method parseBooleanArray2WithBlocks
	 * 
	 * @param string
	 * @return
	 * @since 0.1.0
	 */
	private static boolean[][] parseBooleanArray2WithHalfLineBlocks(String string) {
		String[] lines = string.split("\n");
		boolean[][] result = new boolean[lines.length * 2][];

		for (int iLine = 0; iLine < lines.length; iLine++) {
			result[iLine * 2] = new boolean[lines[iLine].length()];
			result[iLine * 2 + 1] = new boolean[lines[iLine].length()];
			parseBlockLine(lines[iLine], result, iLine);
		}

		return result;
	}

	/**
	 * DOCME add JavaDoc for method parseBooleanArray2WithOneAndZero
	 * 
	 * @param string
	 * @return
	 * @since 0.1.0
	 */
	private static boolean[][] parseBooleanArray2WithOneAndZero(String string) {
		String[] lines = string.split("\n");
		boolean[][] result = new boolean[lines.length][];

		for (int iRow = 0; iRow < lines.length; iRow++) {
			result[iRow] = new boolean[lines[iRow].length()];

			for (int iCol = 0; iCol < lines[iRow].length(); iCol++) {
				char c = lines[iRow].charAt(iCol);

				if (c == '1') {
					result[iRow][iCol] = true;
				} else if (c == '0') {
					result[iRow][iCol] = false;
				} else if (c == '\r') {
					// ignore
				} else {
					throw new IllegalArgumentException("Unrecognized character: '" + c + "' (" + ((int) c) + ")!");
				}
			}
		}

		return result;
	}

	/**
	 * DOCME add JavaDoc for method parseBooleanArrayWithFullLineBlocks
	 * 
	 * @param string
	 * @return
	 * @since DOCME add inception version number
	 */
	private static boolean[] parseBooleanArrayWithFullLineBlocks(String string) {
		boolean[] result = new boolean[string.length() / 2];

		for (int i = 0; i < result.length; i++) {
			result[i] = string.charAt(i * 2) == '█';
		}

		return result;
	}
}
