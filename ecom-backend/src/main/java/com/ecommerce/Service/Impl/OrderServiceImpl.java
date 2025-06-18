package com.ecommerce.Service.Impl;
import com.ecommerce.Exception.CustomerNotFoundException;
import com.ecommerce.Exception.OrderNotFoundException;
import com.ecommerce.Exception.ProductNotFoundException;
import com.ecommerce.Model.*;
import com.ecommerce.Model.dto.OrderItemDTO;
import com.ecommerce.Model.dto.OrderRequestDTO;
import com.ecommerce.Service.OrderService;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(OrderRequestDTO request) throws CustomerNotFoundException, ProductNotFoundException {
        Order order = new Order();
        order.setOrderedAt(LocalDateTime.now());
        order.setStatus(Status.CREATED);
        Optional<Customer> customerOptional = customerRepository.findById(request.getCustomerId());
        if (customerOptional.isEmpty()) {
            throw new CustomerNotFoundException("Customer with id" + request.getCustomerId() + "not found");
        }
        order.setCustomer(customerOptional.get());
        order.setAddress(request.getShippingAddress());

        Set<OrderItem> items = new HashSet<>();
        for (OrderItemDTO item : request.getItems()) {
            Optional<Product> productOptional = productRepository.findById(item.getProductId());
            //TODO
            if (productOptional.isEmpty()) {
                throw new ProductNotFoundException("Product with id" + item.getProductId() + "not found");
            }
            Product p = productOptional.get();
            OrderItem i = new OrderItem();
            i.setProduct(p);
            i.setRequestedQuantity(item.getRequestedQuantity());
            i.setOrder(order);

            items.add(i);

        }
        order.setItems(items);
        //TODO CALCULATE SUBTOTAL, TAX(8%), SHIPPING CHARGES(<35 THEN 5$), CALCULATE TOTAL
        //TODO adjust the avaliable quantity
        Payment finalPayment = makePayment(request.getPayment());
        order.setPayment(finalPayment);
        double subtotal = 0;
        double tax = 0;
        double shippingCharges = 0;
        double totalPrice;


        for (OrderItemDTO item : request.getItems()) {
            Optional<Product> productOptional = productRepository.findById(item.getProductId());
            if (productOptional.isEmpty()) {
                throw new ProductNotFoundException("No Product found");
            }
            Product product = productOptional.get();
            // Check the available quantity
            if (product.getAvailableQuantity() < item.getRequestedQuantity()) {
                throw new ProductNotFoundException("Insufficient quantity for product with id " + item.getProductId());
            }

            // Adjusting the available quantity
            product.setAvailableQuantity(product.getAvailableQuantity() - item.getRequestedQuantity());
            productRepository.save(product);
            double unitPrice = product.getUnitPrice();
            Long quantity = item.getRequestedQuantity();


            OrderItem i = new OrderItem();
            i.setProduct(product);
            i.setOrder(order);
            i.setRequestedQuantity(item.getRequestedQuantity());
            items.add(i);

            subtotal += product.getUnitPrice() * item.getRequestedQuantity();
        }
        tax = subtotal * 0.008;
        if (subtotal < 35) {
            shippingCharges = 5.0;
        } else {
            shippingCharges = 0.0;
        }

        // Calculate total price
        totalPrice = subtotal + tax + shippingCharges;


        order.setSubTotal(subtotal);
        order.setTax(tax);
        order.setDeliveryFee(shippingCharges);
        order.setTotal(totalPrice);
        order.setItems(items);
        Order saved = orderRepository.save(order);

        return saved;

    }

    private Payment makePayment(Payment input) {
        System.out.println("call the payment service");
        // assume calling third party api and getting confirmation code

        input.setconfirmationCode("XYZ123");
        return input;
    }


    @Override
    public void updateShippingAddress(Long orderId, Address address) throws OrderNotFoundException {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isEmpty()) {
            throw new OrderNotFoundException("Order not found");
        }
        Order order = optionalOrder.get();
        order.setAddress(address);
        orderRepository.save(order);
    }


    @Override
    public void cancelOrder(Long id) throws OrderNotFoundException {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty()) {
            throw new OrderNotFoundException("Order not Found");
        }
        Order order = optionalOrder.get();
        order.setStatus(Status.CANCELLED);
        orderRepository.save(order);
    }
}




