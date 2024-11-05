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
 * @since 0.1.0
 */
@UtilityClass
public class FileUtil {

	/**
	 * DOCME add JavaDoc for method listFiles
	 * 
	 * @param fileOrDirectory
	 * @param maxDepth
	 * @param fileFilter
	 * @throws IOException
	 * @since 0.1.0
	 */
	public static List<File> listFiles(Path fileOrDirectory, Integer maxDepth, FileFilter fileFilter)
			throws IOException {
		if (fileOrDirectory.toFile().isFile()) {
			return List.of(fileOrDirectory.toFile());
		}

		try (Stream<Path> filesStream = Files.walk(fileOrDirectory)) {
			return filesStream//
					.map(Path::toFile)//
					.filter(File::isFile)//
					.filter(file -> acceptDepth(file, maxDepth, fileOrDirectory))//
					.filter(file -> fileFilter == null || fileFilter.accept(file))//
					.toList();
		}
	}

	/**
	 * DOCME add JavaDoc for method acceptDepth
	 * 
	 * @param file
	 * @param maxDepth
	 * @param root
	 * @return
	 * @since 0.1.0
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
	 * @since 0.1.0
	 */
	private static Integer getDepth(File file, Path root) {
		return file.toString().split(Pattern.quote(File.separator)).length
				- root.toFile().toString().split(Pattern.quote(File.separator)).length - 1;
	}
}
