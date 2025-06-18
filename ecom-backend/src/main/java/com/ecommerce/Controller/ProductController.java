package com.ecommerce.Controller;

import com.ecommerce.Model.Customer;
import com.ecommerce.Model.Product;
import com.ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product p) {
        Product saved = productService.addProduct(p);
        return saved;
    }

    //To update stock
//    @PutMapping("/stock")
//    public Product updateStock(@RequestParam Long id, @RequestParam Long newQuantity) {
//        Product updatedStock = productService.updateStock(id, newQuantity);
//        return updatedStock;
//    }
    @PostMapping("/stock")
    public ResponseEntity<Product> updateStock(@RequestParam Long id, @RequestParam Long newQuantity) {
        Product updatedStock = productService.updateStock(id, newQuantity);
        if (updatedStock != null) {
            return new ResponseEntity<>(updatedStock, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

