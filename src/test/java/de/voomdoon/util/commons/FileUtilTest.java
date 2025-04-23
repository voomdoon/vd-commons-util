package de.voomdoon.util.commons;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import de.voomdoon.testing.file.TempFileExtension;
import de.voomdoon.testing.file.TempInputDirectory;
import de.voomdoon.testing.file.WithTempInputDirectories;
import de.voomdoon.testing.tests.TestBase;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
class FileUtilTest {

	/**
	 * DOCME add JavaDoc for FileUtilTest
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	@ExtendWith(TempFileExtension.class)
	@WithTempInputDirectories(create = true)
	class ListFilesTest extends TestBase {

		/**
		 * @since 0.2.0
		 */
		@Test
		void test_directoriesAreExcluded(@TempInputDirectory File directory) throws Exception {
			logTestStart();

			new File(directory, "subDir").mkdirs();

			List<File> actuals = FileUtil.listFiles(directory.toPath(), 1, null);

			assertThat(actuals).isEmpty();
		}

		/**
		 * @since 0.1.0
		 */
		@Deprecated
		@Test
		void test_directoryAtRoot(@TempInputDirectory File directory) throws Exception {
			logTestStart();

			List<File> actuals = FileUtil.listFiles(directory.toPath(), null, null);

			assertThat(actuals).isEmpty();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_empty_isEmpty(@TempInputDirectory File directory) throws Exception {
			logTestStart();

			List<File> actuals = FileUtil.listFiles(directory.toPath(), null, null);

			assertThat(actuals).isEmpty();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_fileAtDirectory(@TempInputDirectory File directory) throws Exception {
			logTestStart();

			Path file = Path.of(directory.toString(), "file");
			Files.writeString(file, "content");

			List<File> actuals = FileUtil.listFiles(directory.toPath(), null, null);

			assertThat(actuals).containsExactly(file.toFile());
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_fileAtDirectory_maxDepthOne_hasFile(@TempInputDirectory File directory) throws Exception {
			logTestStart();

			Path file = Path.of(directory.toString(), "file");
			Files.writeString(file, "content");

			List<File> actuals = FileUtil.listFiles(directory.toPath(), 1, null);

			assertThat(actuals).containsExactly(file.toFile());
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_fileAtDirectory_maxDepthZero_isEmpty(@TempInputDirectory File directory) throws Exception {
			logTestStart();

			Path file = Path.of(directory.toString(), "file");
			Files.writeString(file, "content");

			List<File> actuals = FileUtil.listFiles(directory.toPath(), 0, null);

			assertThat(actuals).isEmpty();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_fileAtRoot(@TempInputDirectory File directory) throws Exception {
			logTestStart();

			Path file = Path.of(directory.toString(), "file");
			Files.writeString(file, "content");

			List<File> actuals = FileUtil.listFiles(directory.toPath(), null, null);

			assertThat(actuals).containsExactly(file.toFile());
		}

		/**
		 * @since 0.2.0
		 */
		@Test
		void test_fileAtSubDirectory_maxDepthOne_isEmpty(@TempInputDirectory File directory) throws Exception {
			logTestStart();

			File subDir = new File(directory, "sub");
			subDir.mkdirs();
			Path nestedFile = subDir.toPath().resolve("file.txt");
			Files.writeString(nestedFile, "nested");

			List<File> actuals = FileUtil.listFiles(directory.toPath(), 1, null);

			assertThat(actuals).isEmpty();
		}

		/**
		 * @since 0.2.0
		 */
		@Test
		void test_fileAtSubDirectory_maxDepthTwo_hasFile(@TempInputDirectory File directory) throws Exception {
			logTestStart();

			File subDir = new File(directory, "sub");
			subDir.mkdirs();
			Path nestedFile = subDir.toPath().resolve("file.txt");
			Files.writeString(nestedFile, "nested");

			List<File> actuals = FileUtil.listFiles(directory.toPath(), 2, null);

			assertThat(actuals).containsExactly(nestedFile.toFile());
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_fileFilter_accept(@TempInputDirectory File directory) throws Exception {
			logTestStart();

			Path file = Path.of(directory.toString(), "accept");
			Files.writeString(file, "content");

			List<File> actuals = FileUtil.listFiles(directory.toPath(), null,
					pathname -> pathname.toString().contains("accept"));

			assertThat(actuals).containsExactly(file.toFile());
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_fileFilter_reject(@TempInputDirectory File directory) throws Exception {
			logTestStart();

			Path file = Path.of(directory.toString(), "rejct");
			Files.writeString(file, "content");

			List<File> actuals = FileUtil.listFiles(directory.toPath(), null,
					pathname -> pathname.toString().contains("accept"));

			assertThat(actuals).isEmpty();
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_fileItself(@TempInputDirectory File directory) throws Exception {
			logTestStart();

			Path file = Path.of(directory.toString(), "file");
			Files.writeString(file, "content");

			List<File> actuals = FileUtil.listFiles(file, null, null);

			assertThat(actuals).containsExactly(file.toFile());
		}
	}
}
