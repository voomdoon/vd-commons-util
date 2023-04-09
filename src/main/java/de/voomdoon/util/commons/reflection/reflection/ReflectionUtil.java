package de.voomdoon.util.commons.reflection.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import lombok.experimental.UtilityClass;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since DOCME add inception version number
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
	 * @since DOCME add inception version number
	 */
	public static <T> T getStaticFieldValue(Class<?> clazz, String name, Class<T> resultType) {
		for (Field field : clazz.getFields()) {
			if (Modifier.isPublic(field.getModifiers()) && Modifier.isStatic(field.getModifiers())
					&& field.getName().equals(name)) {
				try {
					@SuppressWarnings("unchecked")
					T result = (T) field.get(null);

					return result;
				} catch (IllegalArgumentException | IllegalAccessException e) {
					throw new IllegalStateException("Error at 'getName': " + e.getMessage(), e);
				}
			}
		}

		return null;
	}
}
