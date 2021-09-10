package edu.awieclawski.jpa.utils;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Date;
import java.util.List;
import java.util.Map;

//import edu.awieclawski.jpa.base.BaseEntity;
import edu.awieclawski.jpa.model.Address;
import edu.awieclawski.jpa.model.Company;
import edu.awieclawski.jpa.model.JobContract;

public class EntityUtilTests {

	public static void main(String[] args) {

		Address post = new Address();
		post.setCountry("Poland");
		post.setCity("Warszawa");
		post.setPostalCode("23-213");
		post.setStreetName("Postowa");
		post.setStreetNumber("23D");
		Address obj = post;

		List<?> list = new ArrayList<>(Arrays.asList(Address.class, Company.class, JobContract.class));

		System.out.println("id=" + EntityUtils.getEntityTypeIdIdByBaseEntity(obj, list));
		System.out.println("mark=" + EntityUtils.getEntityTypeMarkByBaseEntity(obj, list));
		System.out.println("link=" + EntityUtils.getEntityLinkByBaseEntity(obj, list));
		System.out.println("head=" + EntityUtils.getEntityHeaderByBaseEntity(obj, list));
		Map<String, Object> labelsMap = EntityUtils.getMapOfFieldsAndValuesFromClass(obj);
		System.out.println("valuesmap=" + labelsMap.toString());
		System.out.println("labelsmap=" + EntityUtils.getMapOfFieldsAndLabelsFromClass(obj).toString());
		System.out.println("makeEntity=" + EntityUtils.getEntityFromMap(labelsMap, post));

	}

}
