package com.ecommerce.Controller;

import com.ecommerce.Exception.CustomerNotFoundException;
import com.ecommerce.Exception.OrderNotFoundException;
import com.ecommerce.Exception.ProductNotFoundException;
import com.ecommerce.Model.Address;
import com.ecommerce.Model.Order;
import com.ecommerce.Model.Product;
import com.ecommerce.Model.dto.OrderRequestDTO;
import com.ecommerce.Service.OrderService;
import com.ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;


    @PostMapping("/create")
    public Order createOrder(@RequestBody OrderRequestDTO requestDTO) throws CustomerNotFoundException, ProductNotFoundException {
        Order created = orderService.createOrder(requestDTO);
        return created;
    }
    @DeleteMapping("/cancel")
    public void cancelOrder(@RequestParam Long orderId) throws OrderNotFoundException {
        orderService.cancelOrder(orderId);
    }

    @PutMapping("/updateshippingaddress")
    public void updateShippingAddress(@RequestParam Long orderId, @RequestBody Address address) throws OrderNotFoundException {
        orderService.updateShippingAddress(orderId,address);
    }
    @PutMapping("/rating")
    public ResponseEntity<Product> addRating(@RequestParam Long productId, @RequestParam Integer rating) {
        Product updatedProduct = productService.addRating(productId, rating);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

