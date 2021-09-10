package edu.awieclawski.jpa.model;

import java.math.BigDecimal;
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
@Table(name = "contracts")
@NamedQueries({

		@NamedQuery(name = "JobContract.finAll", query = "SELECT j FROM JobContract j"),

		@NamedQuery(name = "JobContract.finById", query = "SELECT j FROM JobContract j WHERE j.contractId = :id"),

})
public class JobContract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contr_id")
	private long contractId;

	@Column(updatable = true, name = "contr_name", nullable = true, length = 50)
	private String contractName;

	@Column(updatable = true, name = "startdate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date contractStarts;

	@Column(updatable = true, name = "enddate", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date contractEnds;

	@Column(updatable = true, name = "salary", nullable = false, length = 22)
	private BigDecimal salary;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "comp_id", nullable = false)
	private Company company;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "pers_id", nullable = false)
	private Person person;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "job_id", nullable = false)
	private JobFunction jobFunction;

	public JobFunction getJobFunction() {
		return jobFunction;
	}

	public void setJobFunction(JobFunction jobFunction) {
		this.jobFunction = jobFunction;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public long getContractId() {
		return contractId;
	}

	public void setContractId(long contractId) {
		this.contractId = contractId;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public Date getContractStarts() {
		return contractStarts;
	}

	public void setContractStarts(Date contractStarts) {
		this.contractStarts = contractStarts;
	}

	public Date getContractEnds() {
		return contractEnds;
	}

	public void setContractEnds(Date contractEnds) {
		this.contractEnds = contractEnds;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "JobContract [contractId=" + contractId + ", contractName=" + contractName + ", contractStarts="
				+ contractStarts + ", contractEnds=" + contractEnds + ", salary=" + salary + ", company="
				+ company.toString() + ", employee=" + person.toString() + ", job=" + jobFunction.toString() + "]";
	}

}
