package com.ecommerce.Controller;


import com.ecommerce.Model.Customer;
import com.ecommerce.Service.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        Customer saved = customerServices.register(customer);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
//update phone number
    @PutMapping("/update/phone")
    public ResponseEntity<Customer> updatePhoneNumber(@RequestParam Long id, @RequestParam String phoneNumber) {
        Customer updatedCustomer = customerServices.updatePhoneNumber(id, phoneNumber);

        if (updatedCustomer != null) {
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
