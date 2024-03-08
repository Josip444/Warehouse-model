package com.example.skladiste.Repository;

import com.example.skladiste.Controller.CarModelController;
import com.example.skladiste.Model.CarBrand;
import com.example.skladiste.Model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarModel,Long> {
}
