package com.example.skladiste.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CarBrand {

    @Id
    @GeneratedValue

    @Column(name = "brand_id")
    private Long id;

    @Column(name = "Brand_name")
    private String name;

    public CarBrand()
    {

    }

    public CarBrand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
