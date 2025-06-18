package com.ecommerce.Service.Impl;

import com.ecommerce.Model.Customer;
import com.ecommerce.Service.CustomerServices;
import com.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServicesImpl implements CustomerServices {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer register(Customer c) {
        //DO customer validations
        if (customerRepository.findByEmail(c.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email is already in use");
        }
        Customer saved = customerRepository.save(c);
        return saved;

    }
//update Phonenumber
    @Override
    public Customer updatePhoneNumber(Long id, String phoneNumber) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (customerOptional.isPresent()) {
            Customer existingCustomer = customerOptional.get();

            if (phoneNumber != null && !phoneNumber.isEmpty()) {
                existingCustomer.setPhoneNumber(phoneNumber);
            }
            return customerRepository.save(existingCustomer);
        }
        return null;
    }

}
