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
	 * Method trims an matrix so that at any border will be a {@code true} value.
	 *
	 * @param matrix
	 *            the array to trim
	 * @return
	 *         <ul>
	 *         <li>Empty array if given array is empty or contains no {@code true} value.</li>
	 *         </ul>
	 * @since 0.1.0
	 */
	public static boolean[][] getTrimmed(boolean[][] matrix) {
		// OPTIMIZE speed: search for boundaries first and copy over then

		List<boolean[]> rows = new ArrayList<>();
		List<boolean[]> rowsEmpty = new ArrayList<>();

		boolean foundTrue = false;

		for (int iRow = 0; iRow < matrix.length; iRow++) {
			int countTrue = countTrue(matrix[iRow]);

			if (foundTrue || countTrue > 0) {
				foundTrue = true;

				if (countTrue == 0) {
					rowsEmpty.add(matrix[iRow]);
				} else {
					rows.addAll(rowsEmpty);
					rowsEmpty.clear();
					rows.add(matrix[iRow]);
				}
			}
		}

		int firstTrue = Integer.MAX_VALUE;
		int lastTrue = Integer.MIN_VALUE;

		for (boolean[] row : rows) {
			int index = ArrayUtils.indexOf(row, true);

			if (index > -1) {
				firstTrue = Math.min(firstTrue, index);
			}

			lastTrue = Math.max(lastTrue, ArrayUtils.lastIndexOf(row, true));
		}

		for (int iRow = 0; iRow < rows.size(); iRow++) {
			boolean[] rowResult = new boolean[lastTrue - firstTrue + 1];
			System.arraycopy(rows.get(iRow), firstTrue, rowResult, 0, lastTrue - firstTrue + 1);
			rows.set(iRow, rowResult);
		}

		return toMatrix(rows);
	}

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

	/**
	 * DOCME add JavaDoc for method countTue
	 * 
	 * @param matrix
	 * @return
	 * @since 0.1.0
	 */
	public int countTrue(boolean[][] matrix) {
		int count = 0;

		for (int i = 0; i < matrix.length; i++) {
			// not using countTrue(boolean[]) for better performance
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j]) {
					count++;
				}
			}
		}

		return count;
	}
}
