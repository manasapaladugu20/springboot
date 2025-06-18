package org.example.springboot;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Course {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
}
