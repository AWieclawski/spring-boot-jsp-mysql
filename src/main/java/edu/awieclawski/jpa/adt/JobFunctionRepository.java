package edu.awieclawski.jpa.adt;

import org.springframework.data.repository.CrudRepository;

import edu.awieclawski.jpa.model.JobFunction;

public interface JobFunctionRepository extends CrudRepository<JobFunction, Long> {

}
