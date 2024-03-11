package com.example.skladiste.Repository;

import com.example.skladiste.Controller.CarModelController;
import com.example.skladiste.Model.CarBrand;
import com.example.skladiste.Model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarModelRepository extends JpaRepository<CarModel,Long> {

    @Query("SELECT m FROM CarModel m LEFT JOIN m.carBrand b WHERE b = :brand")
    public List<CarModel> findModelsByBrand(@Param("brand") CarBrand brand);
}
