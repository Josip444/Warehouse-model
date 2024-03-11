package com.example.skladiste.Model;

import jakarta.persistence.*;

@Entity
public class Parts {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="model_id")
    private CarModel carModel;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    private String name;

    private Boolean available;

    public Parts()
    {

    }

    public Parts(Long id, CarModel carModel, Category category, String name,Boolean available) {
        this.id = id;
        this.carModel = carModel;
        this.category = category;
        this.name = name;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
