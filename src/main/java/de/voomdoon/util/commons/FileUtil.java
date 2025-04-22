package de.voomdoon.util.commons;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import lombok.experimental.UtilityClass;

//TODO refactor: convert listFiles to handler with builder

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

		try (Stream<Path> filesStream = getStream(fileOrDirectory, maxDepth)) {
			return filesStream//
					.map(Path::toFile)//
					.filter(File::isFile)//
					.filter(file -> fileFilter == null || fileFilter.accept(file))//
					.toList();
		}
	}

	/**
	 * DOCME add JavaDoc for method getStream
	 * 
	 * @param fileOrDirectory
	 * @param maxDepth
	 * @return
	 * @throws IOException
	 * @since 0.2.0
	 */
	private static Stream<Path> getStream(Path fileOrDirectory, Integer maxDepth) throws IOException {
		if (maxDepth != null) {
			return Files.walk(fileOrDirectory, maxDepth);
		}

		return Files.walk(fileOrDirectory);
	}
}
