package com.ecommerce.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String phoneNumber;


}
