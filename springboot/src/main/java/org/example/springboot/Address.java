package org.example.springboot;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String lineone;
    private String linetwo;
    private String city;
    private String state;
    private String zipcode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLineone() {
        return lineone;
    }

    public void setLineone(String lineone) {
        this.lineone = lineone;
    }

    public String getLinetwo() {
        return linetwo;
    }

    public void setLinetwo(String linetwo) {
        this.linetwo = linetwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
