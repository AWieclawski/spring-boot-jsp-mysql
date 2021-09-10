package edu.awieclawski.jpa.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.awieclawski.jpa.base.BaseEntity;

public class EntityUtils {
	private final static Logger LOGGER = Logger.getLogger(EntityUtils.class.getName());

	public static BaseEntity getEntityFromMap(Map<String, Object> map, BaseEntity entity) {

		Object value = null;
		Method[] methods = entity.getClass().getMethods();
		for (Method m : methods) {
			String nameMeth = m.getName();
			if (nameMeth.startsWith("set") && !nameMeth.contains("Id")) {
				String field = nameMeth.substring(3);
				field = firstLetterToLowerCase(field); // if Class Fields are "lower case named"
				try {
					value = map.get(field);
					m.invoke(entity, value);
				} catch (IllegalAccessException e) {
					LOGGER.log(Level.SEVERE, "IllegalAccessException: " + e.getMessage());
//					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					LOGGER.log(Level.SEVERE, "IllegalArgumentException : " + e.getMessage());
//					e.printStackTrace();
				} catch (InvocationTargetException e) {
					LOGGER.log(Level.SEVERE, "InvocationTargetException: " + e.getMessage());
//					e.printStackTrace();
				}

			}
		}
//		LOGGER.log(Level.WARNING, "entity: " + entity.toString());

		return entity;
	}

	public static Map<String, Object> getMapOfFieldsAndValuesFromClass(Object entity) {
		Map<String, Object> map = new HashMap<>();
		Object value = null;
		Method[] methods = entity.getClass().getMethods();
		for (Method m : methods) {
			String nameMeth = m.getName();
			if (nameMeth.startsWith("get")) {
				try {
					value = (Object) m.invoke(entity);
				} catch (IllegalAccessException e) {
					LOGGER.log(Level.SEVERE, "IllegalAccessException: " + e.getMessage());
//					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					LOGGER.log(Level.SEVERE, "IllegalArgumentException : " + e.getMessage());
//					e.printStackTrace();
				} catch (InvocationTargetException e) {
					LOGGER.log(Level.SEVERE, "InvocationTargetException: " + e.getMessage());
//					e.printStackTrace();
				}
				// usually 'get' takes 3 first letters
				String input = nameMeth.substring(3);
				input = firstLetterToLowerCase(input); // if Class Fields are "lower case named"
				if (!input.equals("class") && !input.contains("entity") && !input.contains("Label")
						&& !input.contains("Id"))
					if (input != null)
						map.put(input, value);
			}
		}
//		LOGGER.log(Level.WARNING, "map: " + map.toString());

		return map;
	}

	public static Map<String, String> getMapOfFieldsAndLabelsFromClass(Object entity) {
		Map<String, String> map = new HashMap<>();
		Object value = null;
		Method[] methods = entity.getClass().getMethods();
		for (Method m : methods) {
			String nameMeth = m.getName();
			if (nameMeth.startsWith("get")) {
				try {
					value = (Object) m.invoke(entity);
				} catch (IllegalAccessException e) {
					LOGGER.log(Level.SEVERE, "IllegalAccessException: " + e.getMessage());
//					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					LOGGER.log(Level.SEVERE, "IllegalArgumentException : " + e.getMessage());
//					e.printStackTrace();
				} catch (InvocationTargetException e) {
					LOGGER.log(Level.SEVERE, "InvocationTargetException: " + e.getMessage());
//					e.printStackTrace();
				}
				// usually 'get' takes 3 first letters
				String input = nameMeth.substring(3);
				input = firstLetterToLowerCase(input); // if Class Fields are "lower case named"
				if (!input.equals("class") && !input.contains("entity") && !input.contains("Id"))
					if (input != null && input.contains("Label")) {
						input = input.replaceAll("Label", "");
						try {
							map.put(input, (String) value);
						} catch (ClassCastException e) {
							LOGGER.log(Level.SEVERE, value + " ClassCastException : " + e.getMessage());
//							e.printStackTrace();
						}
					}
			}
		}
//		LOGGER.log(Level.WARNING, "map: " + map.toString());

		return map;
	}

	// usually after 'get' comes Capital letter - it must be lower case
	private static String firstLetterToLowerCase(String input) {
		if (StringUtils.notNullNorEmpty(input))
			return input.substring(0, 1).toLowerCase() + input.substring(1);

		return null;
	}

	@SuppressWarnings("unused")
	public static int getEntityTypeIdIdByBaseEntity(Object obj, List<?> list) {
		Integer id = (Integer) list.stream().filter(c -> ((Class<?>) c).isInstance(obj))
				.map(c -> (Integer) ((BaseEntity) ((Class<?>) c).cast(obj)).getEntityTypeId()).findFirst().orElse(null);

		return id;
	}

	@SuppressWarnings("unused")
	public static String getEntityTypeMarkByBaseEntity(Object obj, List<?> list) {
		String mark = (String) list.stream().filter(c -> ((Class<?>) c).isInstance(obj))
				.map(c -> (String) ((BaseEntity) ((Class<?>) c).cast(obj)).getEntityTypeMark()).findFirst()
				.orElse(null);

		return mark;
	}

	@SuppressWarnings("unused")
	public static String getEntityHeaderNameByBaseEntity(Object obj, List<?> list) {
		String name = (String) list.stream().filter(c -> ((Class<?>) c).isInstance(obj))
				.map(c -> (String) ((BaseEntity) ((Class<?>) c).cast(obj)).getEntityHeaderName()).findFirst()
				.orElse(null);

		return name;
	}

	@SuppressWarnings("unused")
	public static String getEntityLinkByBaseEntity(Object obj, List<?> list) {
		String name = (String) list.stream().filter(c -> ((Class<?>) c).isInstance(obj))
				.map(c -> (String) ((BaseEntity) ((Class<?>) c).cast(obj)).getEntityLink()).findFirst().orElse(null);

		return name;
	}

	@SuppressWarnings("unused")
	public static String getEntityHeaderByBaseEntity(Object obj, List<?> list) {
		String header = (String) list.stream().filter(c -> ((Class<?>) c).isInstance(obj))
				.map(c -> (String) ((BaseEntity) ((Class<?>) c).cast(obj)).getEntityHeaderName()).findFirst()
				.orElse(null);

		return header;
	}

	@SuppressWarnings("unused")
	public static String getObjectNameByObjectClass(Object obj, List<?> list) {
		String classname = (String) list.stream().filter(c -> ((Class<?>) c).isInstance(obj))
				.map(c -> (String) (((Class<?>) c).cast(obj)).getClass().getSimpleName()).findFirst().orElse(null);

		return classname;
	}

}
