package com.ecommerce.Model.dto;

import com.ecommerce.Model.Address;
import com.ecommerce.Model.Payment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class OrderRequestDTO {
    private Long customerId;
    private Address shippingAddress;
    private Payment payment;
    private List<OrderItemDTO> items;

}
