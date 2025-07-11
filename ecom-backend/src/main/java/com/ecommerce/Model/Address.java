package com.ecommerce.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String lineOne;
    private String lineTwo;
    private String city;
    private String state;
    @Column(nullable = false)
    private String zipCode;


}
