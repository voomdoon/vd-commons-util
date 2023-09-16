package de.voomdoon.util.commons;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import de.voomdoon.logging.Logger;

//FEATURE support Runnable with Exception
//TODO rename (too generic)

/**
 * Wrapper for the output at the console.
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class SystemOutput {

	/**
	 * Runs a {@link Runnable} and tracks the output.
	 *
	 * @param runnable
	 * @return The tracked {@link SystemOutput}.
	 * @since 0.1.0
	 */
	public static SystemOutput run(Runnable runnable) {
		return run(runnable, false);
	}

	/**
	 * Runs a {@link Runnable} and tracks the output. Catches {@link Exception}.
	 *
	 * @param runnable
	 * @return {@link SystemOutput}
	 * @since 0.1.0
	 * @see SystemOutput#getException()
	 */
	public static SystemOutput runWithCatch(Runnable runnable) {
		return run(runnable, true);
	}

	/**
	 * DOCME add JavaDoc for method run
	 *
	 * @param runnable
	 * @param catchException
	 * @return {@link SystemOutput}
	 * @since 0.1.0
	 */
	private static SystemOutput run(Runnable runnable, boolean catchException) {
		PrintStream out = System.out;
		PrintStream err = System.err;

		try {
			ByteArrayOutputStream baosOut = new ByteArrayOutputStream();
			PrintStream outputStreamOut = new PrintStream(baosOut);
			System.setOut(outputStreamOut);

			ByteArrayOutputStream baosErr = new ByteArrayOutputStream();
			PrintStream outputStreamErr = new PrintStream(baosErr);
			System.setErr(outputStreamErr);

			return run(runnable, catchException, baosOut, baosErr);
		} finally {
			System.setOut(out);
			System.setErr(err);
		}
	}

	/**
	 * DOCME add JavaDoc for method run
	 * 
	 * @param runnable
	 * @param catchException
	 * @param out
	 * @param err
	 * @return {@link SystemOutput}
	 * @since 0.1.0
	 */
	private static SystemOutput run(Runnable runnable, boolean catchException, ByteArrayOutputStream out,
			ByteArrayOutputStream err) {
		try {
			runnable.run();
		} catch (RuntimeException e) {
			if (catchException) {
				return new SystemOutput(new String(out.toByteArray()), new String(err.toByteArray()), e);
			}

			throw e;
		}

		return new SystemOutput(new String(out.toByteArray()), new String(err.toByteArray()));
	}

	/**
	 * @since 0.1.0
	 */
	private final String err;

	/**
	 * @since 0.1.0
	 */
	private Exception exception;

	/**
	 * @since 0.1.0
	 */
	private final String out;

	/**
	 * DOCME add JavaDoc for constructor ConsoleLogEventHandlerTest.Output
	 *
	 * @param out
	 * @param err
	 *
	 * @since 0.1.0
	 */
	private SystemOutput(String out, String err) {
		this.out = out;
		this.err = err;
	}

	/**
	 * @param out
	 * @param err
	 * @param exception
	 * @since 0.1.0
	 */
	private SystemOutput(String out, String err, Exception exception) {
		this(out, err);

		this.exception = exception;
	}

	/**
	 * DOCME add JavaDoc for method getErr
	 *
	 * @return
	 * @since 0.1.0
	 */
	public String getErr() {
		return err;
	}

	/**
	 * @return exception
	 * @since 0.1.0
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * DOCME add JavaDoc for method getOut
	 *
	 * @return
	 * @since 0.1.0
	 */
	public String getOut() {
		return out;
	}

	/**
	 * Logs the contend of the {@link PrintStream}s.
	 *
	 * @param logger
	 * @since 0.1.0
	 */
	public void log(Logger logger) {
		if (logger == null) {
			throw new IllegalArgumentException("Argument 'logger' must not be null in method 'log'!");
		}

		log(logger, err, "err: ");
		log(logger, out, "out: ");
	}

	/**
	 * DOCME add JavaDoc for method log
	 *
	 * @param logger
	 * @param message
	 * @param name
	 * @since 0.1.0
	 */
	private void log(Logger logger, String message, String name) {
		if (!message.isEmpty()) {
			logger.debug(name + "\n" + message);
		}
	}
}