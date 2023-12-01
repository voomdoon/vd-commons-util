package de.voomdoon.util.commons.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Generator for {@link String} from boolean matrix.
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class ToBlockStringGenerator {

	/**
	 * Default {@link ToBlockStringGenerator} generating half lines using ASCII blocks: █, ▄ and ▀. The result may
	 * contain an empty lower section of a line if input matrix has odd number of rows.
	 * 
	 * @since 0.1.0
	 */
	public static final ToBlockStringGenerator DEFAULT = new ToBlockStringGenerator();

	/**
	 * @since 0.1.0
	 */
	private static final String BOTH = "█";

	/**
	 * @since 0.1.0
	 */
	private static final String BOTTOM = "▄";

	/**
	 * @since 0.1.0
	 */
	private static final String EMPTY = " ";

	/**
	 * @since 0.1.0
	 */
	private static final String TOP = "▀";

	private static void addFirstPassElement(boolean[] row, List<String> output, int j) {
		if (row[j]) {
			output.add(TOP);
		} else {
			output.add(EMPTY);
		}
	}

	/**
	 * DOCME add JavaDoc for method apply
	 * 
	 * @param row
	 * @param output
	 * @param pass
	 * @since 0.1.0
	 */
	private static void apply(boolean[] row, List<String> output, int pass) {
		for (int j = 0; j < row.length; j++) {
			if (pass == 1) {
				addFirstPassElement(row, output, j);
			} else {
				updateSecondPassElement(row, output, j);
			}
		}
	}

	private static void updateSecondPassElement(boolean[] row, List<String> output, int j) {
		if (j > output.size() - 1) {
			if (row[j]) {
				output.add(BOTTOM);
			} else {
				output.add(EMPTY);
			}
		} else {
			if (row[j]) {
				if (output.get(j).equals(TOP)) {
					output.set(j, BOTH);
				} else {
					output.set(j, BOTTOM);
				}
			}
		}
	}

	/**
	 * @since 0.1.0
	 */
	private ToBlockStringGenerator() {
		// nothing to do
	}

	/**
	 * DOCME add JavaDoc for method toBlockString
	 * 
	 * @param array
	 * @return
	 * @since 0.1.0
	 */
	public String toString(boolean[][] array) {
		StringBuilder sb = new StringBuilder();

		List<String> output = new ArrayList<>();
		int pass = 0;

		for (int i = 0; i < array.length; i++) {
			pass++;

			apply(array[i], output, pass);

			if (pass == 2) {
				appenNewLine(sb, output);
				output.clear();
				pass = 0;
			}
		}

		if (!output.isEmpty()) {
			appenNewLine(sb, output);
		}

		// TODO implement toString
		return sb.toString();
	}

	private void appenNewLine(StringBuilder sb, List<String> output) {
		if (sb.length() > 0) {
			sb.append("\n");
		}

		output.forEach(sb::append);
	}
}
