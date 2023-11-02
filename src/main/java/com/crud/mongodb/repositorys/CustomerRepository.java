package com.crud.mongodb.repositorys;

import com.crud.mongodb.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {

}
