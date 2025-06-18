package com.ecommerce.Service;

import com.ecommerce.Model.Customer;

public interface CustomerServices {
    Customer register(Customer c);
    Customer updatePhoneNumber(Long id, String phoneNumber);

}
