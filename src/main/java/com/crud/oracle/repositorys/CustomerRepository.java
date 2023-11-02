package com.crud.oracle.repositorys;

import com.crud.oracle.models.Customer;
import com.crud.oracle.models.CustomerTemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT customer_id, customer_full_name, customer_email, customer_username FROM customer",
                   nativeQuery = true)
    List<CustomerTemp> findGetAll();
    @Query(value = "SELECT customer_id, customer_full_name, customer_email, customer_username FROM customer " +
                   "WHERE customer_username = :customerUserName", nativeQuery = true)
    CustomerTemp findGetCostumerUserName(String customerUserName);
    Customer findByCustomerUserName(String customerUserName);
    Optional<Customer> findById(Integer customerId);

}
