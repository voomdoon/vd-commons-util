package de.voomdoon.util.commons;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.voomdoon.testing.tests.TestBase;

/**
 * Test class for {@link Output}.
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
@Nested
class OutputTest extends TestBase {

	/**
	 * Test class for {@link Output#run(Runnable)}.
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	static class RunTest extends TestBase {

		/**
		 * @param runnable
		 * @return
		 * @since 0.1.0
		 */
		protected Output run(Runnable runnable) {
			Output output = Output.run(runnable);
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

			Output actual = run(runnable);

			assertThat(actual).extracting(Output::getErr).asString().containsSubsequence("test", "\n");
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

			Output actual = run(runnable);

			assertThat(actual).extracting(Output::getOut).asString().containsSubsequence("test", "\n");
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

			Output actual = run(runnable);

			assertThat(actual).extracting(Output::getOut).asString().containsSubsequence("test1", "\n", "test2", "\n");
		}
	}

	/**
	 * Test class for {@link Output#runWithCatch(Runnable)}.
	 *
	 * @author André Schulz
	 *
	 * @since 0.1.0
	 */
	static class RunWithExceptionTest extends RunTest {

		/**
		 * @since 0.1.0
		 */
		@Override
		protected Output run(Runnable runnable) {
			Output output = Output.runWithCatch(runnable);
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

			Output actual = run(runnable);

			assertThat(actual).extracting(Output::getException).extracting(Exception::getMessage).isEqualTo("test");
		}
	}
}
