package de.voomdoon.util.commons;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import lombok.experimental.UtilityClass;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since DOCME add inception version number
 */
@UtilityClass
public class FileUtil {

	/**
	 * DOCME add JavaDoc for method listFiles
	 * 
	 * @param fileOrDirectory
	 * @param maxDepth
	 * @param fileFilter
	 * @since DOCME add inception version number
	 */
	public static List<File> listFiles(Path fileOrDirectory, Integer maxDepth, FileFilter fileFilter) {
		if (fileOrDirectory.toFile().isFile()) {
			return List.of(fileOrDirectory.toFile());
		}

		try (Stream<Path> filesStream = Files.walk(fileOrDirectory)) {
			return filesStream//
					.filter(Files::isRegularFile)//
					.map(Path::toFile)//
					.filter(File::isFile)//
					.filter(f -> acceptDepth(f, maxDepth, fileOrDirectory))//
					.toList();
		} catch (IOException e) {
			// TODO implement error handling
			throw new RuntimeException("Error at 'listFiles': " + e.getMessage(), e);
		}
	}

	/**
	 * DOCME add JavaDoc for method acceptDepth
	 * 
	 * @param file
	 * @param maxDepth
	 * @param root
	 * @return
	 * @since DOCME add inception version number
	 */
	private static boolean acceptDepth(File file, Integer maxDepth, Path root) {
		return maxDepth == null //
				|| getDepth(file, root) <= maxDepth;
	}

	/**
	 * DOCME add JavaDoc for method getDepth
	 * 
	 * @param file
	 * @param root
	 * @return
	 * @since DOCME add inception version number
	 */
	private static Integer getDepth(File file, Path root) {
		return file.toString().split(Pattern.quote(File.separator)).length
				- root.toFile().toString().split(Pattern.quote(File.separator)).length - 1;
	}
}
