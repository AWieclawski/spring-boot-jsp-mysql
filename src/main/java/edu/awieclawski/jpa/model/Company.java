package edu.awieclawski.jpa.model;

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

@Entity
@Table(name = "companies")
@NamedQueries({

		@NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.companyName = :name"),

		@NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.companyId = :id"),

})

public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comp_id")
	private long companyId;

	@Column(updatable = true, name = "tax_id", nullable = false, length = 10, unique = true)
	private String taxId;

	@Column(updatable = true, name = "comp_name", nullable = false, length = 50)
	private String companyName;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "addr_id", nullable = false)
	private Address address;

	// must be
	public Company() {
	}

	public Company(String taxId, String companyName, Address address) {
		this.taxId = taxId;
		this.companyName = companyName;
		this.address = address;
	}

	// getters & setters

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", taxId=" + taxId + ", companyName=" + companyName + ", address="
				+ address.toString() + "]";
	}

}
