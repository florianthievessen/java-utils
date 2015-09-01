package de.florianthievessen.javautils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollectionUtils {

	private static Logger logger = LoggerFactory.getLogger("de.florianthievessen.javautils.CollectionUtils");

	/**
	 * Generates a List of values extracted from the items listtype
	 * <param>attributeName</params>()-method.
	 * 
	 * For example, for a given list of reports (List<Report>) the method will
	 * construct a list typed to <param>klass</param> with the same size as the
	 * list of reports and add every attribute value (call of report.
	 * <param>attributeName<param>()) to result list. So, for a list of reports
	 * and the attributeName "getId", you will receive a list of those reports
	 * ids.
	 * 
	 * @param items
	 *            the list of items whose attributes shall be extracted.
	 * @param attributeName
	 *            the name of the attribute or method that should be used to
	 *            extract the values
	 * @param klass
	 *            the return type of the call to <param>attributeName<param>().
	 *            This value also defines the return of this method!
	 * @return the list of extracted ids or an empty list, if the list of items
	 *         is emtpy.
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> extractListOfAttributeValues(List<?> items, String attributeName, Class<T> klass) {
		if (items.size() > 0) {
			// there is at least one item, so we start to extract the attribute
			// values
			try {
				List<T> attributeValues = new ArrayList<T>();
				// construct a method object from the listitems type method with
				// the name "attributeName" to later call on every item
				Method method = items.get(0).getClass().getMethod(attributeName);
				// for every item, call that method and add the result to the
				// result list
				for (Object item : items) {
					attributeValues.add((T) method.invoke(item));
				}
				return attributeValues;
			} catch (NoSuchMethodException e) {
				logger.error("unable to construct list of " + klass.getSimpleName() + "s", e);
			} catch (SecurityException e) {
				logger.error("unable to construct list of " + klass.getSimpleName() + "s", e);
			} catch (IllegalAccessException e) {
				logger.error("unable to construct list of " + klass.getSimpleName() + "s", e);
			} catch (IllegalArgumentException e) {
				logger.error("unable to construct list of " + klass.getSimpleName() + "s", e);
			} catch (InvocationTargetException e) {
				logger.error("unable to construct list of " + klass.getSimpleName() + "s", e);
			}
		}

		// return an empty list, if there are no items
		return new ArrayList<T>();
	}
}
