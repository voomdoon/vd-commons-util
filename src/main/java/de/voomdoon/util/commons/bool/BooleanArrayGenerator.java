package de.voomdoon.util.commons.bool;

import java.util.Random;

/**
 * Generator for boolean arrays.
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class BooleanArrayGenerator {

	/**
	 * @since 0.1.0
	 */
	public static final BooleanArrayGenerator DEFAULT = new BooleanArrayGenerator();

	/**
	 * @since 0.1.0
	 */
	private static final Random RANDOM = new Random();

	/**
	 * @since 0.1.0
	 */
	private BooleanArrayGenerator() {
		// nothing to do
	}

	/**
	 * DOCME add JavaDoc for method generateRandomMatrix
	 * 
	 * @param rows
	 * @param columns
	 * @return
	 * @since 0.1.0
	 */
	public boolean[][] generateRandomMatrix(int rows, int columns) {
		boolean[][] result = new boolean[rows][columns];

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = RANDOM.nextBoolean();
			}
		}

		return result;
	}
}
