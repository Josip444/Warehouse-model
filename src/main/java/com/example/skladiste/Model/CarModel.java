package com.example.skladiste.Model;


import jakarta.persistence.*;

@Entity
public class CarModel {
    @Id
    @GeneratedValue
    @Column(name="model_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private CarBrand carBrand;
    @Column(name="Model_Name")
    private String modelName;

    public CarModel()
    {

    }

    public CarModel(Long id, CarBrand carBrand, String modelName) {
        this.id = id;
        this.carBrand = carBrand;
        this.modelName = modelName;
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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
