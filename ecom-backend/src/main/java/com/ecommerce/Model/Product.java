package com.ecommerce.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long availableQuantity;
    private Double unitPrice;
    private String description;
    //Rating for product
    @ElementCollection
    private List<Integer> ratings = new ArrayList<>();
    private Double averageRating;
}
