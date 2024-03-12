package com.example.skladiste.Service;

import com.example.skladiste.Model.CarBrand;
import com.example.skladiste.Model.CarModel;
import com.example.skladiste.Model.Category;
import com.example.skladiste.Model.Parts;
import com.example.skladiste.Repository.CarBrandRepository;
import com.example.skladiste.Repository.CarModelRepository;
import com.example.skladiste.Repository.CategoryRepository;
import com.example.skladiste.Repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class PartService {

    @Autowired
    PartRepository partRepository;

    @Autowired
    CarBrandRepository carBrandRepository;

    @Autowired
    CarModelRepository carModelRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public void deletePart(Long id)
    {
        partRepository.deleteById(id);
    }
    public Page<Parts> findPartsBySearch(Long brandId,Long modelId,Long categoryId,Pageable pageable){

        Optional<CarBrand> brand = this.carBrandRepository.findById(brandId);
        Optional<CarModel> model = this.carModelRepository.findById(modelId);
        Optional<Category> category = this.categoryRepository.findById(categoryId);

        if(brand.isPresent() && model.isPresent() && category.isPresent()){

            return this.partRepository.findPartsBySearch(brand.get(),model.get(),category.get(),pageable);
        }

        return null;
    }

    public Page<Parts> searchPartsByName(String search,Pageable pageable){

        return this.partRepository.searchByName(search,pageable);
    }
}
