package com.example.skladiste.Controller;

import com.example.skladiste.Model.CarModel;
import com.example.skladiste.Service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestCarModelsController {

    @Autowired
    CarModelService carModelService;

    @GetMapping("/getModelsByBrand/{brandId}")
    public List<CarModel> findModelsByBrand(@PathVariable Long brandId){
        return this.carModelService.findModelsByBrand(brandId);
    }
}
