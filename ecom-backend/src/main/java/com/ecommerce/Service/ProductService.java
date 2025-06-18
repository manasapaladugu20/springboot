package com.ecommerce.Service;

import com.ecommerce.Model.Customer;
import com.ecommerce.Model.Product;

public interface ProductService {
    Product addProduct(Product p);
    Product updateStock(Long id, Long newQuantity);
    Product addRating(Long productId, Integer rating);


}
