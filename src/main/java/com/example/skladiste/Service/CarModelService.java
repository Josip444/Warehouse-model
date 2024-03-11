package com.example.skladiste.Service;

import com.example.skladiste.Model.CarBrand;
import com.example.skladiste.Model.CarModel;
import com.example.skladiste.Repository.CarBrandRepository;
import com.example.skladiste.Repository.CarModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarModelService
{
    @Autowired
    CarBrandRepository carBrandRepository;

    @Autowired
    CarModelRepository carModelRepository;

    public void deleteCarModel(Long id)
    {
        carModelRepository.deleteById(id);
    }

    public List<CarModel> findModelsByBrand(Long brandId){
        Optional<CarBrand>brand =this.carBrandRepository.findById(brandId);

        if (brand.isPresent()){
            return this.carModelRepository.findModelsByBrand(brand.get());
        }
        return null;
    }

}
