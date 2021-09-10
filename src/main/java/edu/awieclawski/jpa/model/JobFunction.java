package edu.awieclawski.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
@NamedQueries({

		@NamedQuery(name = "JobFunction.finById", query = "SELECT j FROM JobFunction j WHERE j.jobId = :id"),

		@NamedQuery(name = "JobFunction.finByName", query = "SELECT j FROM JobFunction j WHERE j.jobName = :name"),

		@NamedQuery(name = "JobFunction.finBySup", query = "SELECT j FROM JobFunction j WHERE j.isSupervisor = :sup"),

})
public class JobFunction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private long jobId;

	@Column(updatable = true, name = "name", nullable = false, length = 50)
	private String jobName;

	@Column(updatable = true, name = "is_sup", nullable = false)
	private Boolean isSupervisor;

	// default constructor MUST BE
	public JobFunction() {
	}

	public JobFunction(String jobName, Boolean isSupervisor) {
		this.jobName = jobName;
		this.isSupervisor = isSupervisor;
	}

	// getters & setters

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Boolean getIsSupervisor() {
		return isSupervisor;
	}

	public void setIsSupervisor(Boolean isSupervisor) {
		this.isSupervisor = isSupervisor;
	}

	@Override
	public String toString() {
		return "JobFunction [jobId=" + jobId + ", jobName=" + jobName + ", isSupervisor=" + isSupervisor + "]";
	}

}
