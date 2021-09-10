package edu.awieclawski.jpa.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "persons")
@NamedQueries({

		@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),

		@NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.personId = :id"),

		@NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.lastName = :name"),

		@NamedQuery(name = "Person.findByDate", query = "SELECT p FROM Person p WHERE p.birthDate = :date"),

})

public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pers_id")
	private long personId;

	@Column(updatable = true, name = "gov_id", nullable = false, length = 10, unique = true)
	private String govermentId;

	@Column(updatable = true, name = "surname", nullable = false, length = 50)
	private String firstName;

	@Column(updatable = true, name = "name", nullable = false, length = 50)
	private String lastName;

	@Column(updatable = true, name = "birthdate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "addr_id", nullable = false)
	private Address address;

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getGovermentId() {
		return govermentId;
	}

	public void setGovermentId(String govermentId) {
		this.govermentId = govermentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [pers_id=" + personId + ", first_name=" + firstName + ", last_name=" + lastName
				+ ", date_of_birth=" + birthDate + ", address=" + address.toString() + "]";
	}

}
