package de.voomdoon.util.commons.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import lombok.experimental.UtilityClass;

/**
 * Utility class for reflection.
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
@UtilityClass
public class ReflectionUtil {

	/**
	 * DOCME add JavaDoc for method getStaticFieldValue
	 * 
	 * @param <T>
	 * @param clazz
	 * @param name
	 * @param resultType
	 * @return
	 * @throws NoSuchFieldException
	 * @since 0.1.0
	 */
	public static <T> T getStaticFieldValue(Class<?> clazz, String name, Class<T> resultType)
			throws NoSuchFieldException {
		for (Field field : clazz.getFields()) {
			if (Modifier.isPublic(field.getModifiers()) && Modifier.isStatic(field.getModifiers())
					&& field.getName().equals(name)) {
				try {
					@SuppressWarnings("unchecked")
					T result = (T) field.get(null);

					return result;
				} catch (IllegalArgumentException | IllegalAccessException e) {
					throw new RuntimeException(
							"Unexpected error while getting value from " + field + ": " + e.getMessage(), e);
				}
			}
		}

		throw new NoSuchFieldException(name);
	}
}
