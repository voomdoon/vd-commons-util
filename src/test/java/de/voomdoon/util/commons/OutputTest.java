package de.voomdoon.util.commons;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.voomdoon.testing.tests.TestBase;

/**
 * Test class for {@link SystemOutput}.
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
@Nested
class OutputTest extends TestBase {

	/**
	 * Test class for {@link SystemOutput#run(Runnable)}.
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class RunTest extends TestBase {

		/**
		 * @param runnable
		 * @return
		 * @since 0.1.0
		 */
		protected SystemOutput run(Runnable runnable) {
			SystemOutput output = SystemOutput.run(runnable);
			output.log(logger);

			return output;
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_err_println() {
			logTestStart();

			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					System.err.println("test");
				}
			};

			SystemOutput actual = run(runnable);

			assertThat(actual).extracting(SystemOutput::getErr).asString().containsSubsequence("test", "\n");
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_Exception() {
			logTestStart();

			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					throw new RuntimeException("test");
				}
			};

			RuntimeException thrown = assertThrows(RuntimeException.class, () -> run(runnable));

			assertThat(thrown).hasMessage("test");
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_out_println() {
			logTestStart();

			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					System.out.println("test");
				}
			};

			SystemOutput actual = run(runnable);

			assertThat(actual).extracting(SystemOutput::getOut).asString().containsSubsequence("test", "\n");
		}

		/**
		 * @since 0.1.0
		 */
		@Test
		void test_out_println2() {
			logTestStart();

			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					System.out.println("test1");
					System.out.println("test2");
				}
			};

			SystemOutput actual = run(runnable);

			assertThat(actual).extracting(SystemOutput::getOut).asString().containsSubsequence("test1", "\n", "test2", "\n");
		}
	}

	/**
	 * Test class for {@link SystemOutput#runWithCatch(Runnable)}.
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	@Nested
	class RunWithExceptionTest extends RunTest {

		/**
		 * @since 0.1.0
		 */
		@Override
		protected SystemOutput run(Runnable runnable) {
			SystemOutput output = SystemOutput.runWithCatch(runnable);
			output.log(logger);

			return output;
		}

		/**
		 * @since 0.1.0
		 */
		@Override
		@Test
		void test_Exception() {
			logTestStart();

			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					throw new RuntimeException("test");
				}
			};

			SystemOutput actual = run(runnable);

			assertThat(actual).extracting(SystemOutput::getException).extracting(Exception::getMessage).isEqualTo("test");
		}
	}
}
