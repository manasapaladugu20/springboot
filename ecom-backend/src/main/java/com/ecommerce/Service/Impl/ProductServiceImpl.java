package com.ecommerce.Service.Impl;

import com.ecommerce.Model.Customer;
import com.ecommerce.Model.Product;
import com.ecommerce.Service.ProductService;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product p) {
        Product saved = productRepository.save(p);
        return saved;
    }

    @Override
    public Product updateStock(Long id, Long newQuantity) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            System.out.println("Product not found");
        }
        Product product = productOptional.get();
        product.setAvailableQuantity(newQuantity + product.getAvailableQuantity());
        return productRepository.save(product);
    }
    @Override
    public Product addRating(Long productId, Integer rating) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.getRatings().add(rating);
            double averageRating = product.getRatings().stream().mapToInt(Integer::intValue).average().orElse(0.0);
            product.setAverageRating(averageRating);
            return productRepository.save(product);
            }
            return null;
    }
}
