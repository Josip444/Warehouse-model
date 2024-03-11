package com.example.skladiste.Service;

import com.example.skladiste.Repository.CarModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarModelService {

    @Autowired
    CarModelRepository carModelRepository;

    public void deleteCarModel(Long id)
        {
            carModelRepository.deleteById(id);
        }
}
