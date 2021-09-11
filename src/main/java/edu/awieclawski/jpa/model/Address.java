package edu.awieclawski.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.validation.constraints.Pattern;

import edu.awieclawski.jpa.base.BaseEntity;
import edu.awieclawski.jpa.label.AddressLabels;

@Entity
@Table(name = "addresses")

@NamedQueries({

		@NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.addressId = :id"),

		@NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"),

		@NamedQuery(name = "Address.findByCode", query = "SELECT a FROM Address a WHERE a.postalCode = :code"),

		@NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country"),

})

public class Address extends BaseEntity implements Serializable, AddressLabels {
	private static final long serialVersionUID = 3474997745800946776L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addr_id")
	private long addressId;

	@Column(updatable = true, name = "addr_name", nullable = true, length = 50)
	private String addressName;

	@Column(updatable = true, name = "city", nullable = false, length = 50)
	private String city;

	@Pattern(regexp = "[0-9]{2}(-[0-9]{3})?", message = "not a valid zipcode")
	@Column(updatable = true, name = "post_cod", nullable = false, length = 6)
	private String postalCode;

	@Column(updatable = true, name = "street", nullable = false, length = 50)
	private String streetName;

	@Column(updatable = true, name = "str_no", nullable = false, length = 6)
	private String streetNumber;

	@Column(updatable = true, name = "flat_no", nullable = true, length = 6)
	private String flatNumber;

	@Column(updatable = true, name = "country", nullable = false, length = 50)
	private String country = "Poland";

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressName=" + addressName + ", country=" + country + ", city="
				+ city + ", postalCode=" + postalCode + ", streetName=" + streetName + ", streetNumber=" + streetNumber
				+ ", flatNumber=" + flatNumber + "]";
	}

	// transient base entity fields
	@Override
	public int getEntityTypeId() {
		return entityTypeId;
	}

	@Override
	public String getEntityTypeMark() {
		return entityTypeMark;
	}

	@Override
	public String getEntityHeaderName() {
		return entityHeaderName;
	}

	@Override
	public String getEntityLink() {
		return entityLink;
	}

	// Labels
	@Override
	public String getAddressNameLabel() {
		return addressNameLabel;
	}

	@Override
	public String getCountryLabel() {
		return countryLabel;
	}

	@Override
	public String getCityLabel() {
		return cityLabel;
	}

	@Override
	public String getPostalCodeLabel() {
		return postalCodeLabel;
	}

	@Override
	public String getStreetNameLabel() {
		return streetNameLabel;
	}

	@Override
	public String getStreetNumberLabel() {
		return streetNumberLabel;
	}

	@Override
	public String getFlatNumberLabel() {
		return flatNumberLabel;
	}

}
