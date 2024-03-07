package com.example.skladiste.Model;

import jakarta.persistence.*;

@Entity
public class Parts {
    @Id
    @GeneratedValue
    @Column(name="part_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="model_id")
    private CarModel carModel;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @Column(name="Part_Name")
    private String partName;

    public Parts()
    {

    }

    public Parts(Long id, CarModel carModel, Category category, String partName) {
        this.id = id;
        this.carModel = carModel;
        this.category = category;
        this.partName = partName;
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

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }
}
