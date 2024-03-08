package com.example.skladiste.Controller;

import com.example.skladiste.Model.CarModel;
import com.example.skladiste.Model.Category;
import com.example.skladiste.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/showCategoryForm")
    public String addCategory(Model model){

        model.addAttribute("category",new Category());
        return "Category/createCategory";
    }
    @PostMapping("/createCategory")
    public String createCategory(Category category){

        this.categoryRepository.save(category);
        return "redirect:/showCategoryForm";
    }

}
