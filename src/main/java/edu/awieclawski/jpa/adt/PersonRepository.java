package edu.awieclawski.jpa.adt;

import org.springframework.data.repository.CrudRepository;

import edu.awieclawski.jpa.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
