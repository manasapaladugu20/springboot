package com.ecommerce.repository;

import com.ecommerce.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Method to find a customer by email
    Optional<Customer> findByEmail(String email);




}
