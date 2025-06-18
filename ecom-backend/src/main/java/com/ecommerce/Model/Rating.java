package com.ecommerce.Model;

import jakarta.persistence.*;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double ratingvalues;
    private String description;

    @ManyToOne
    @JoinColumn("product_id")
    private Product product;

    @ManyToOne
    @JoinColumn("customer_id")
    private Customer customer;


}
