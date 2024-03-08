package com.example.skladiste.Service;

import com.example.skladiste.Model.CarBrand;
import com.example.skladiste.Repository.CarBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarBrandService {

    @Autowired
    CarBrandRepository carBrandRepository;

    public void save(CarBrand carBrand)
    {
        carBrandRepository.save(carBrand);
    }

    public void deleteCarBrand(Long id)
    {
        carBrandRepository.deleteById(id);
    }
}
