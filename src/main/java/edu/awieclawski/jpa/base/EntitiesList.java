package edu.awieclawski.jpa.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.awieclawski.jpa.model.Address;
import edu.awieclawski.jpa.model.Company;
import edu.awieclawski.jpa.model.JobContract;
import edu.awieclawski.jpa.model.JobFunction;
import edu.awieclawski.jpa.model.Person;

/**
 * builds list of classes used by servlets
 * 
 * @author AWieclawski
 *
 */
public class EntitiesList {

	public static List<?> get() {
		return new ArrayList<>(
				Arrays.asList(Address.class, Company.class, JobContract.class, JobFunction.class, Person.class));
	}

}
