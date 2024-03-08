package com.example.skladiste.Model;


import jakarta.persistence.*;

@Entity
public class CarModel {
    @Id
    @GeneratedValue
    @Column(name = "model_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private CarBrand carBrand;

    private String name;

    public CarModel() {

    }

    public CarModel(Long id, CarBrand carBrand, String name) {
        this.id = id;
        this.carBrand = carBrand;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
