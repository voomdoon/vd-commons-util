package de.voomdoon.util.commons;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.voomdoon.testing.tests.TestBase;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since DOCME add inception version number
 */
class FileUtilTest {

	/**
	 * DOCME add JavaDoc for FileUtilTest
	 *
	 * @author André Schulz
	 *
	 * @since DOCME add inception version number
	 */
	@Nested
	class ListFilesTest extends TestBase {

		/**
		 * DOCME add JavaDoc for method test_directoryAtRoot
		 * 
		 * @since DOCME add inception version number
		 */
		@Test
		void test_directoryAtRoot() throws Exception {
			logTestStart();

			new File(getTempDirectory() + "/directory").mkdir();

			List<File> actuals = FileUtil.listFiles(getTempDirectory(), null, null);

			assertThat(actuals).isEmpty();
		}

		/**
		 * DOCME add JavaDoc for method test_empty
		 * 
		 * @since DOCME add inception version number
		 */
		@Test
		void test_empty_isEmpty() throws Exception {
			logTestStart();

			List<File> actuals = FileUtil.listFiles(getTempDirectory(), null, null);

			assertThat(actuals).isEmpty();
		}

		/**
		 * DOCME add JavaDoc for method test_fileAtDirectory
		 * 
		 * @since DOCME add inception version number
		 */
		@Test
		void test_fileAtDirectory() throws Exception {
			logTestStart();

			File directory = new File(getTempDirectory() + "/directory");
			directory.mkdir();

			Path file = Path.of(directory.toString(), "file");
			Files.writeString(file, "content");

			List<File> actuals = FileUtil.listFiles(getTempDirectory(), null, null);

			assertThat(actuals).containsExactly(file.toFile());
		}

		/**
		 * DOCME add JavaDoc for method test_fileAtDirectory
		 * 
		 * @since DOCME add inception version number
		 */
		@Test
		void test_fileAtDirectory_maxDepthZero_isEmpty() throws Exception {
			logTestStart();

			File directory = new File(getTempDirectory() + "/directory");
			directory.mkdir();

			Path file = Path.of(directory.toString(), "file");
			Files.writeString(file, "content");

			List<File> actuals = FileUtil.listFiles(getTempDirectory(), 0, null);

			assertThat(actuals).isEmpty();
		}

		/**
		 * DOCME add JavaDoc for method test_file
		 * 
		 * @since DOCME add inception version number
		 */
		@Test
		void test_fileAtRoot() throws Exception {
			logTestStart();

			Path file = Path.of(getTempDirectory().toString(), "file");
			Files.writeString(file, "content");

			List<File> actuals = FileUtil.listFiles(getTempDirectory(), null, null);

			assertThat(actuals).containsExactly(file.toFile());
		}

		/**
		 * DOCME add JavaDoc for method test_fileFilter_accept
		 * 
		 * @since DOCME add inception version number
		 */
		@Test
		void test_fileFilter_accept() throws Exception {
			logTestStart();

			Path file = Path.of(getTempDirectory().toString(), "accept");
			Files.writeString(file, "content");

			List<File> actuals = FileUtil.listFiles(getTempDirectory(), null,
					pathname -> pathname.toString().contains("accept"));

			assertThat(actuals).containsExactly(file.toFile());
		}

		/**
		 * DOCME add JavaDoc for method test_fileFilter_reject
		 * 
		 * @since DOCME add inception version number
		 */
		@Test
		void test_fileFilter_reject() throws Exception {
			logTestStart();

			Path file = Path.of(getTempDirectory().toString(), "rejct");
			Files.writeString(file, "content");

			List<File> actuals = FileUtil.listFiles(getTempDirectory(), null,
					pathname -> pathname.toString().contains("accept"));

			assertThat(actuals).containsExactly(file.toFile());
		}

		/**
		 * DOCME add JavaDoc for method test_fileItself
		 * 
		 * @since DOCME add inception version number
		 */
		@Test
		void test_fileItself() throws Exception {
			logTestStart();

			Path file = Path.of(getTempDirectory().toString(), "file");
			Files.writeString(file, "content");

			List<File> actuals = FileUtil.listFiles(file, null, null);

			assertThat(actuals).containsExactly(file.toFile());
		}
	}
}
