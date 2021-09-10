package edu.awieclawski.jpa.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateUtility {
	private final Logger LOGGER = Logger.getLogger(DateUtility.class.getName());
	private String[] slashPatterns = { "/", "dd/MM/yyyy", "yyyy/MM/dd" };
	private String[] dashPatterns = { "-", "dd-MM-yyyy", "yyyy-MM-dd" };
	private Date parsedDate;

	public Date parse(String date) {
		parsedDate = null; // reset at start
		if (date.contains(slashPatterns[0])) // "/"
			return selectPatternToParse(date, slashPatterns, slashPatterns[0]);
		if (date.contains(dashPatterns[0])) // "-"
			return selectPatternToParse(date, dashPatterns, dashPatterns[0]);
		return null;
	}

	private Date selectPatternToParse(String date, String[] patterns, String delimter) {
		String pattern = patterns[1];
		String[] section = date.split(delimter);
		if (section[0].length() == 2)
			return safeParse(pattern, date);
		pattern = patterns[2];
		if (section[0].length() == 4)
			return safeParse(pattern, date);
		LOGGER.log(Level.SEVERE, "Any pattern not recognised in date " + date);
		return parsedDate;
	}

	private Date parsePatternToDate(String pattern, String date) throws ParseException {
		SimpleDateFormat formattedDate = new SimpleDateFormat(pattern);
		parsedDate = formattedDate.parse(date);
		return parsedDate;
	}

	private Date safeParse(String pattern, String date) {
		try {
			parsedDate = parsePatternToDate(pattern, date);
			return parsedDate;
		} catch (ParseException e) {
			LOGGER.log(Level.SEVERE, e.getMessage() + ",pattern: " + pattern);
		}
		return parsedDate;
	}

}
