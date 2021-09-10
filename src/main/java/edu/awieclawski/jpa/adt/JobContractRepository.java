package edu.awieclawski.jpa.adt;

import org.springframework.data.repository.CrudRepository;

import edu.awieclawski.jpa.model.JobContract;

public interface JobContractRepository extends CrudRepository<JobContract, Long> {

}
