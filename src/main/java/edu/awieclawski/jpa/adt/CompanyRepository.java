package edu.awieclawski.jpa.adt;

import org.springframework.data.repository.CrudRepository;

import edu.awieclawski.jpa.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

}
