package edu.awieclawski.jpa.dctr;

import java.text.DecimalFormat;

public interface I_UOMs {

	public final static DecimalFormat DEC_FORMAT = new DecimalFormat("#.00");
	public final static int DEC_COMMA = 2;
	public final static String MTR_WGHT = "[kg]";
	public final static String MTR_HGHT = "[m]";
	public final static String MTR_AGE = "[years]";
	public final static String MTR_CURRENCY = "[PLN]";

}
