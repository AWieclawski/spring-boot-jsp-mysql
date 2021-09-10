package edu.awieclawski.jpa.adt;

import org.springframework.data.repository.CrudRepository;

import edu.awieclawski.jpa.model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
