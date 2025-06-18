package com.ecommerce.Service;

import com.ecommerce.Exception.CustomerNotFoundException;
import com.ecommerce.Exception.OrderNotFoundException;
import com.ecommerce.Exception.ProductNotFoundException;
import com.ecommerce.Model.Address;
import com.ecommerce.Model.Order;
import com.ecommerce.Model.dto.OrderRequestDTO;

public interface OrderService {
    Order createOrder(OrderRequestDTO request) throws CustomerNotFoundException, ProductNotFoundException;
    void updateShippingAddress(Long orderId, Address address) throws OrderNotFoundException;
    void cancelOrder(Long id) throws OrderNotFoundException;
}
