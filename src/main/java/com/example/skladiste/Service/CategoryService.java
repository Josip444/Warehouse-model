package com.example.skladiste.Service;

import com.example.skladiste.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public void deleteCarCategory(Long id)
    {
        this.categoryRepository.deleteById(id);
    }
}
