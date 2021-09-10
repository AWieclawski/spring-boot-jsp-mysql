package edu.awieclawski.jpa.sppt;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Customized, dedicated control during data conversion to BigDecimal format
 * 
 * @author AWieclawski
 *
 */
public class BigDecimalEditor extends PropertyEditorSupport {

	private final static Logger LOGGER = Logger.getLogger(BigDecimalEditor.class.getName());
	private final String DOT = ".";
	private final String COMMA = ",";

	public void setAsText(String text) throws NumberFormatException {
		String number = "0";
		if (text.isEmpty() || text == null) {
			setValue(null);
		} else

		{
			if (text.contains(COMMA))
				text = text.replaceAll(COMMA, DOT);

			number = text;

			// catch exception if number has more comma than one, or other "trash-chars"
			// and returns exception with customized error message
			try {
				BigDecimal bigDecimal = new BigDecimal(number);
				setValue(bigDecimal);
			} catch (NumberFormatException e) {
				LOGGER.log(Level.SEVERE, e.getMessage() + "|" + number);
				throw new NumberFormatException("The Number not recognised! ");
			}
		}
	}
}
