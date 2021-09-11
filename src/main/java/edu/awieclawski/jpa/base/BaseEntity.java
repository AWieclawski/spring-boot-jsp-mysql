package edu.awieclawski.jpa.base;

/**
 * getters for transient fields to be inherited by heirs - entities
 * 
 * @author AWieclawski
 *
 */
public abstract class BaseEntity {

	// Common entity getters,
	// which values are assigned in interfaces dedicated to individual entities
	public abstract int getEntityTypeId();

	public abstract String getEntityLink();

	public abstract String getEntityHeaderName();

	public abstract String getEntityTypeMark();

}
